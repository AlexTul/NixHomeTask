/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.thirteen.task1.parsing;

import java.nio.file.Path;

/**
 * The Parser interface is a contract fo to build a CSVTable data structure
 * from the .csv file that allows you to access the table elements:
 * a) by row and column number (rows do not include headings)
 * b) by line number and title text.
 * And also allows you to get a list of titles.
 * */
public interface Parser {

    CSVTable parse(Path path);
    //CSVTable parse(Reader source);

}
