/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.fourtask.task2;

import lombok.extern.log4j.Log4j;

/**
 * The Water implements the Substance.
 *
 * @author Alexander Tuleninov
 * @version 01
 */
@Log4j
public class Water extends com.nixsolutions.alextuleninov.fourtask.task2.Default implements com.nixsolutions.alextuleninov.fourtask.task2.Substance {
    /**
     * This method gets the state of aggregation of substance.
     *
     * @param temperature           temperature set by the user
     * @return                      the state of aggregation of substance
     * */
    @Override
    public com.nixsolutions.alextuleninov.fourtask.task2.State getAggregateStateOfSubstance(double temperature) {
        if (temperature < 0) {
            return com.nixsolutions.alextuleninov.fourtask.task2.State.SOLID;
        } else if (temperature >= 100) {
            return com.nixsolutions.alextuleninov.fourtask.task2.State.GAS;
        } else {
            return com.nixsolutions.alextuleninov.fourtask.task2.State.LIQUID;
        }
    }
}
