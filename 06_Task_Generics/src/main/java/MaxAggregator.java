/*
 * Copyright (c) 2022
 * For Nix
 */

/**
 * The MaxAggregator class of returning is the highest value of the middle elements.
 *
 * @author Alexander Tuleninov
 * @version 01
 */
public class MaxAggregator<T extends Comparable<? super T>> implements Aggregator<T, T> {

    /**
     * The method returning is the highest value of the middle elements.
     *
     * @param items array of what is passed to the method
     */
    @Override
    public T aggregate(T[] items) {
        if (items == null || items.length == 0) {
            return null;
        }

        T max = items[0];
        for (int i = 0; i < items.length; i++) {
            if (max.compareTo(items[i]) < 0) {
                max = items[i];
            }
        }
        return max;
    }

}
