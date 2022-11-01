/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.twotask.task2;

import lombok.extern.log4j.Log4j;

/**
 * The Water implements the Substance.
 *
 * @author Alexander Tuleninov
 * @version 01
 */
@Log4j
public class Water extends Default implements Substance {
    /**
     * This method gets the state of aggregation of substance.
     *
     * @param temperature           temperature set by the user
     * @return                      the state of aggregation of substance
     * */
    @Override
    public State getAggregateStateOfSubstance(double temperature) {
        if (temperature < 0) {
            return State.SOLID;
        } else if (temperature >= 100) {
            return State.GAS;
        } else {
            return State.LIQUID;
        }
    }
}
