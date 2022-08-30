/*
 * Copyright (c) 2022
 * For Nix
 */

import java.util.Objects;

/**
 * The MaxAggregator class of returning is the highest value of the middle elements.
 *
 * @author Alexander Tuleninov
 * @version 01
 * */
public class MaxAggregator<A, T> implements Aggregator<A, T> {

    /**
     * The method returning is the highest value of the middle elements.
     * @param items             array of what is passed to the method
     * */
    @Override
    public A aggregate(T[] items) {
        if (items != null) {
            Double maxNumber = Double.MIN_VALUE;
            String maxString = "";
            for (T s : items) {
                if (s instanceof Number) {
                    if (((Double) s).compareTo(maxNumber) > 0) {
                        maxNumber = (Double) s;
                    }
                } else if (s instanceof String) {
                    if (((String) s).compareTo(maxString) > 0) {
                        maxString = (String) s;
                    }
                }
            }

            if (maxNumber != Double.MIN_VALUE) {
                return (A) maxNumber;
            } else {
                return (A) maxString;
            }
        }
        return null;
    }

}
