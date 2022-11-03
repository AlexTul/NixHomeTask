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
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "servletapi", urlPatterns = "/servlet")
public class ServletApp extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(ServletApp.class);

    private final Set<String> ips = ConcurrentHashMap.newKeySet();
    private final Set<String> headers = ConcurrentHashMap.newKeySet();

    @Override
    public void init() throws ServletException {
        log.info(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String remoteHost = req.getRemoteHost();
        String headerUserAgent = req.getHeader("User-Agent");

        ips.add(remoteHost);
        headers.add(headerUserAgent);

        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");

        for (String s : ips) {
            if (s.equals(req.getRemoteHost())) {
                responseBody.printf("""
                <h3 align="center"><b>%s</b> :: <b>%s</b></h3>%n
                """, req.getRemoteHost(), req.getHeader("User-Agent"));
            } else {
                responseBody.printf("""
                <h3 align="center">%s :: %s</h3>%n
                """, ips, headers);
            }
        }
    }

    @Override
    public void destroy() {
        log.info(getServletName() + " destroyed");
    }
}
