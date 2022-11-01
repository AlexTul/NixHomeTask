/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.thirteen.task1.parsing;

import com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.thirteen.task1.io.FileInputReader;

import java.nio.file.Path;
import java.util.*;

import static java.lang.System.out;

/**
 * The CSVParser class is a class fo to build a CSVTable data structure
 * from the .csv file that allows you to access the table elements:
 * a) by row and column number (rows do not include headings)
 * b) by line number and title text.
 * And also allows you to get a list of titles.
 * */
public class CSVParser implements Parser {

    /**
     * The method for running all methods.
     * */
    public CSVTable run() {

        var scanner = new Scanner(System.in);

        Path path = getPath(scanner);

        return parse(path);

    }

    /**
     * The method for receive the path.
     *
     * @param scanner       the object of Scanner
     * */
    private static Path getPath(Scanner scanner) {
        out.println("Input path to input file: ");
        return Path.of(scanner.nextLine());
    }

    /**
     * The method fo to build a CSVTable data structure
     * from the .csv file
     *
     * @param path      the path of the csv file
     * */
    @Override
    public CSVTable parse(Path path) {

        List<String> lines = new FileInputReader(path).read();

        List<List<String>> csvTable = new ArrayList<>();
        for (String s : lines) {
            csvTable.add(List.of(s.split(",")));
        }

        return new CSVTable(csvTable);
    }


}
