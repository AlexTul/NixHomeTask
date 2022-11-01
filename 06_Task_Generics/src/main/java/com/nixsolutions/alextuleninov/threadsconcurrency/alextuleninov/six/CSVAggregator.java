/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.six;

import java.util.StringJoiner;

/**
 * The com.nixsolutions.alextuleninov.six.CSVAggregator class returning a row that is formed from line forms (toString) of elements separated by coma.
 *
 * @author Alexander Tuleninov
 * @version 01
 */
public class CSVAggregator<T> implements Aggregator<String, T> {

    /**
     * The method returning a row that is formed from line forms (toString) of elements separated by coma.
     *
     * @param items array of what is passed to the method
     */
    @Override
    public String aggregate(T[] items) {
        if (items == null) {
            return null;
        }

        StringJoiner stringJoiner = new StringJoiner(", ");
        for (T s : items) {
            stringJoiner.add(s.toString());
        }
        return stringJoiner.toString();
    }

}
