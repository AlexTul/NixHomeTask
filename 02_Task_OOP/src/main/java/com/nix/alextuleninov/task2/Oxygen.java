/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nix.alextuleninov.task2;

/**
 * The Oxygen implements the Substance.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
public class Oxygen implements Substance {
    double t = 20;

    /**
     * This method changes the temperature of a substance.
     *
     * @param t         temperature set by the user
     * @return          temperature set by the user
     * */
    @Override
    public double stateHeatUp(double t) {
        return this.t = t;
    }

    /**
     * This method gets the temperature of a substance set by the user.
     *
     * @return          temperature set by the user
     * */
    @Override
    public double getTemperature() {
        return this.t;
    }
}
