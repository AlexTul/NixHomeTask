/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.twotask.task2;

/**
 * The Oxygen implements the Substance.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
public class Oxygen extends Default implements Substance {
    /**
     * This method gets the state of aggregation of substance.
     *
     * @param temperature           temperature set by the user
     * @return                      the state of aggregation of substance
     * */
    @Override
    public State getAggregateStateOfSubstance(double temperature) {
        if (temperature <= -218.4) {
            return State.LIQUID;
        } else if (temperature > -218.4  && temperature <= -191.8) {
            return State.SOLID;
        } else {
            return State.GAS;
        }
    }
}
