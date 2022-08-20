/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.fourtask.task2;

/**
 * The Iron implements the Substance.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
public class Iron extends com.nixsolutions.alextuleninov.fourtask.task2.Default implements com.nixsolutions.alextuleninov.fourtask.task2.Substance {
    /**
     * This method gets the state of aggregation of substance.
     *
     * @param temperature           temperature set by the user
     * @return                      the state of aggregation of substance
     * */
    @Override
    public com.nixsolutions.alextuleninov.fourtask.task2.State getAggregateStateOfSubstance(double temperature) {
        if (temperature >= 1300 && temperature < 2862) {
            return com.nixsolutions.alextuleninov.fourtask.task2.State.LIQUID;
        } else if (temperature >= 2862) {
            return com.nixsolutions.alextuleninov.fourtask.task2.State.GAS;
        } else {
            return com.nixsolutions.alextuleninov.fourtask.task2.State.SOLID;
        }
    }
}
