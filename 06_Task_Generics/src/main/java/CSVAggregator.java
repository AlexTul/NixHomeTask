/*
 * Copyright (c) 2022
 * For Nix
 */

/**
 * The CSVAggregator class returning a row that is formed from line forms (toString) of elements separated by coma.
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

        String str = "";
        for (T s : items) {
            str = s.toString() + ", ";
        }
        return str;
    }

}
