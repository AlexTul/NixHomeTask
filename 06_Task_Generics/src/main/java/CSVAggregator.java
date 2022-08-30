/*
 * Copyright (c) 2022
 * For Nix
 */

import java.util.Objects;

/**
 * The CSVAggregator class returning a row that is formed from line forms (toString) of elements separated by coma.
 *
 * @author Alexander Tuleninov
 * @version 01
 */
public class CSVAggregator<A, T> implements Aggregator<A, T> {

    /**
     * The method returning a row that is formed from line forms (toString) of elements separated by coma.
     *
     * @param items array of what is passed to the method
     */
    @Override
    public A aggregate(T[] items) {
        if (items != null) {
            String str = "";
            for (T s : items) {
                str = s.toString() + ", ";

            }
            return (A) str;
        }
        return null;
    }

}
