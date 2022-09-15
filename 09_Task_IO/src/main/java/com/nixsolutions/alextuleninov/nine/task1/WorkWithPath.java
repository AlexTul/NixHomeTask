/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.nine.task1;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
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
public final class WorkWithPath {
    static Path path;
    static Pattern pattern;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        out.println("Please, enter the path to a file or directory: ");
        path = Path.of(scanner.nextLine());
        out.println("Please, enter the regular expression (regEx): ");
        pattern = Pattern.compile(scanner.nextLine());
        scanner.close();

        try {
            Files.walkFileTree(path, new MyFileVisitor());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}

/**
 * A class that provides the ability to know the root directory, we must go through it,
 * look into the folders of all levels and find files with the content we need in them.
 * */
final class MyFileVisitor extends SimpleFileVisitor<Path> {

    /**
     * This method to converts path to Absolute path to the file or directory.
     * This method to prints to the console all lines in file that contain groups of characters
     * that match the given regular expression (RX), highlight this group with [ ].
     *
     * @param path              the path to the file or directory
     * */
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {

        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        for (String s: lines) {
            Matcher matcher = WorkWithPath.pattern.matcher(s);
            if (matcher.find()) {
                out.println("[" + s + "]");
            }
        }
        out.println(path.toAbsolutePath());

        return FileVisitResult.CONTINUE;
    }

}
