/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.six;

/**
 * Interface to perform aggregation operations on an array of objects.
 *
 * @author Alexander Tuleninov
 * @version 01
 * */
public interface Aggregator<A, T> {

    /**
     * The method to perform aggregation operations on an array of objects.
     * @param items             array of what is passed to the method
     * */
    A aggregate(T[] items);

}
