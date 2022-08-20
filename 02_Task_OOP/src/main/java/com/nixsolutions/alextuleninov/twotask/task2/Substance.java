/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.fourtask.task2;

/**
 * The Substance declares methods that operate on the characteristics of a substance.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
public interface Substance {
    double stateHeatUp(double temperature);
    double getTemperature(double temperature);
    com.nixsolutions.alextuleninov.fourtask.task2.State getAggregateStateOfSubstance(double temperature);
}
