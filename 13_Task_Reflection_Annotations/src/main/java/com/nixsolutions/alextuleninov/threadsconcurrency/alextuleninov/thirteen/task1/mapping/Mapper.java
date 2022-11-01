/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.thirteen.task1.mapping;

import com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.thirteen.task1.parsing.CSVTable;

import java.util.List;

/**
 * The Mapper interface is a contract fo to create a list
 * of objects of a given type from the table CSV data.
 * */
public interface Mapper {

    <T> List<T> map(CSVTable table, Class<T> resultType);

}
