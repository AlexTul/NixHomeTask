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
public class MaxAggregator<T> implements Aggregator<Comparable, T>, Comparable {

    /**
     * The method returning is the highest value of the middle elements.
     *
     * @param items array of what is passed to the method
     */
    @Override
    public Comparable aggregate(T[] items) {
        if (items == null || items.length == 0) {
            return null;
        }

        Comparable max = (Comparable) items[0];
        for (int i = 0; i < items.length; i++) {
            if (max.compareTo(items[i]) < 0) {
                max = (Comparable) items[i];
            }
        }
        return max;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
