/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.fourtask.task2;

/**
 * The Oxygen implements the Substance.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
public class Oxygen extends com.nixsolutions.alextuleninov.fourtask.task2.Default implements com.nixsolutions.alextuleninov.fourtask.task2.Substance {
    /**
     * This method gets the state of aggregation of substance.
     *
     * @param temperature           temperature set by the user
     * @return                      the state of aggregation of substance
     * */
    @Override
    public com.nixsolutions.alextuleninov.fourtask.task2.State getAggregateStateOfSubstance(double temperature) {
        if (temperature <= -218.4) {
            return com.nixsolutions.alextuleninov.fourtask.task2.State.LIQUID;
        } else if (temperature > -218.4  && temperature <= -191.8) {
            return com.nixsolutions.alextuleninov.fourtask.task2.State.SOLID;
        } else {
            return com.nixsolutions.alextuleninov.fourtask.task2.State.GAS;
        }
    }
}
