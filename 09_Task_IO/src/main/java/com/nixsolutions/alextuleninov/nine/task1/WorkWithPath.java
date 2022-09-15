/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.nine.task1;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

/**
 * The user enters the path to a file or directory, as well as a regular expression (regEx).
 * For this file or for all files in the directory and its subdirectories, output to the console:
 * 1. Absolute path to the file
 * 2. All lines in this file where there are groups of characters that match the given regEx (RX),
 * highlight that group with [ ].
 */
public class WorkWithPath {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        out.println("Please, enter the path to a file or directory: ");
        Path path = Path.of(scanner.nextLine());
        out.println("Please, enter the regular expression (regEx): ");
        Pattern pattern = Pattern.compile(scanner.nextLine());
        scanner.close();

        Path absolute = new WorkWithPath().pathToAbsolute(path);
        out.print("Absolute path to the file or directory: " + absolute);

        List<String> resultLines = new WorkWithPath().findAllLinesWithRegex(path, pattern);
        out.println(resultLines);

    }

    /**
     * This method to converts path to Absolute path to the file or directory.
     *
     * @param path              the path to the file or directory
     * */
    public Path pathToAbsolute(Path path) {
        return path.toAbsolutePath();
    }

    /**
     * This method to prints to the console all lines in file that contain groups of characters
     * that match the given regular expression (RX), highlight this group with [ ].
     *
     * @param path              the path to the file or directory
     * @param pattern           the regular expression (regEx)
     * */
    public List<String> findAllLinesWithRegex(Path path, Pattern pattern) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        List<String> result = new ArrayList<>();
        for (String s : lines) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                result.add(s);
            }
        }

        return result;
    }

}
