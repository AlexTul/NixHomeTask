/*
 * Copyright (c) 2022
 * For Nix
 */

/**
 * The DistinctAggregator class returning number of unique elements.
 *
 * @author Alexander Tuleninov
 * @version 01
 * */
public class DistinctAggregator<Object> implements Aggregator<Integer,Object> {

    /**
     * The method returns the number of unique elements.
     *
     * @param items             array of what is passed to the method
     * */
    @Override
    public Integer aggregate(Object[] items) {
        if (items == null) {
            return 0;
        }

        int countUnique = 0;
        int count = 0;

        for (int i = 0; i < items.length; i++) {
            countUnique++;
            for (int j = i + 1; j < items.length; j++) {
                if (items[j].equals(items[i])) {
                    count++;
                    break;
                }
            }
        }
        return (countUnique - count);
    }

}
