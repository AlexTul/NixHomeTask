package com.nixsolutions.alextuleninov.servletapi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "servletapi", urlPatterns = "/servlet")
public class ServletApp extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(ServletApp.class);

    private final Map<String , String> metaData = new ConcurrentHashMap<>();;

    @Override
    public void init() throws ServletException {
        log.info(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String remoteHost = req.getRemoteHost();
        String headerUserAgent = req.getHeader("User-Agent");

        metaData.put(remoteHost, headerUserAgent);

        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");

        for (String s : metaData.keySet()) {
            if (s.equals(remoteHost)) {
                responseBody.printf("""
                <p align="center"><b>%s</b> :: <b>%s</b></p>%n
                """, s, metaData.get(s));
            } else {
                responseBody.printf("""
                <p align="center">%s :: %s</p>%n
                """, s, metaData.get(s));
            }
        }
    }

    @Override
    public void destroy() {
        log.info(getServletName() + " destroyed");
    }
}
