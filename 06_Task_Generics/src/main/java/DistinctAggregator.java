/*
 * Copyright (c) 2022
 * For Nix
 */

import java.util.Objects;

/**
 * The DistinctAggregator class returning number of unique elements.
 *
 * @author Alexander Tuleninov
 * @version 01
 * */
public class DistinctAggregator<A, T> implements Aggregator<A, T> {

    /**
     * The method to perform aggregation operations on an array of objects.
     * @param items             array of what is passed to the method
     * */
    @Override
    public A aggregate(T[] items) {
        return (A) items;
    }

}
