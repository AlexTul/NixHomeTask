/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.task2;

/**
 * The Iron implements the Substance.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
public class Iron implements Substance {
    private double temperature = 20;

    /**
     * This method changes the temperature of a substance.
     *
     * @param temperature           temperature set by the user
     * @return                      temperature set by the user
     * */
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
        if (temperature >= 1300 && temperature < 2862) {
            return State.LIQUID;
        } else if (temperature >= 2862) {
            return State.GAS;
        } else {
            return State.SOLID;
        }
    }
}
