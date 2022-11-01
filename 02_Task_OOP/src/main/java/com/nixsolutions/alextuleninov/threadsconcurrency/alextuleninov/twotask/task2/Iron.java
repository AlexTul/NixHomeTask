/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.twotask.task2;

/**
 * The Iron implements the Substance.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
public class Iron extends Default implements Substance {
    /**
     * This method gets the state of aggregation of substance.
     *
     * @param temperature           temperature set by the user
     * @return                      the state of aggregation of substance
     * */
    @Override
    public State getAggregateStateOfSubstance(double temperature) {
        if (temperature >= 1300 && temperature < 2862) {
            return State.LIQUID;
        } else if (temperature >= 2862) {
            return State.GAS;
        } else {
            return State.SOLID;
        }
    }
}
