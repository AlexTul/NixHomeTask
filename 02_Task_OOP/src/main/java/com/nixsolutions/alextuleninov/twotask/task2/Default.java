package com.nixsolutions.alextuleninov.twotask.task2;

public abstract class Default implements Substance {
    double temperature = 20;

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
}
