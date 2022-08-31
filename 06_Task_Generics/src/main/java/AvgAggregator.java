/*
 * Copyright (c) 2022
 * For Nix
 */

import java.util.Objects;

/**
 * The AvgAggregator class returning of the arithmetic mean of elements.
 *
 * @author Alexander Tuleninov
 * @version 01
 */
public class AvgAggregator<T extends Number> implements Aggregator<Number, T> {

    /**
     * The method returning of the arithmetic mean of elements.
     *
     * @param items array of what is passed to the method
     */
    @Override
    public Double aggregate(T[] items) {
        if (items == null) {
            return 0.0;
        }

        double averageDouble = 0.0;
        for (T d : items) {
            averageDouble += d.doubleValue();
        }
        return averageDouble / items.length;
    }

}

