/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.task2;

import lombok.extern.log4j.Log4j;

/**
 * The Water implements the Substance.
 *
 * @author Alexander Tuleninov
 * @version 01
 */
@Log4j
public class Water implements Substance {
    private double temperature = 20;

    /**
     * This method changes the temperature of a substance.
     *
     * @param                       temperature temperature set by the user
     * @return                      temperature set by the user
     */
    @Override
    public double stateHeatUp(double temperature) {
        return this.temperature = temperature;
    }

    /**
     * This method gets the temperature of a substance set by the user.
     *
     * @param temperature           temperature set by the user
     * @return                      temperature set by the user
     * */
    @Override
    public double getTemperature(double temperature) {
        return stateHeatUp(temperature);
    }

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
