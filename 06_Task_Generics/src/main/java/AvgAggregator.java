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
public class AvgAggregator<A extends Number, T extends Number> implements Aggregator<A, T> {

    /**
     * The method returning of the arithmetic mean of elements.
     *
     * @param items array of what is passed to the method
     */
    @Override
    public A aggregate(T[] items) {
        if (items != null) {
            Long averageLong = 0L;
            Double averageDouble = 0.0;
            for (T d : items) {
                if (d instanceof Byte) {
                    averageLong += d.byteValue();
                } else if (d instanceof Short) {
                    averageLong += d.shortValue();
                } else if (d instanceof Integer) {
                    averageLong += d.intValue();
                } else if (d instanceof Long) {
                    averageLong += d.longValue();
                } else if (d instanceof Float) {
                    averageDouble += d.floatValue();
                } else {
                    averageDouble += d.doubleValue();
                }
            }
            averageLong = averageLong / items.length;
            averageDouble = averageDouble / items.length;

            if (averageLong != 0) {
                return (A) (averageLong);
            } else {
                return (A) averageDouble;
            }
        }
        return null;
    }

}