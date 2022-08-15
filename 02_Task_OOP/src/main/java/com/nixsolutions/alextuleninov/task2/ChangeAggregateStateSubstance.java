/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.task2;

import lombok.extern.log4j.Log4j;
import java.util.Scanner;

/**
 * The ChangeAggregateStateSubstance class implements a program that simulates the change in the state of aggregation
 * of substances depending on temperature.
 * The user selects one of the substances and then can enter the values
 * by which he changes its temperature. Each time he does this, output a new temperature of the substance
 * and its state of aggregation at that temperature. If you enter 0 - terminate the program execution.
 * Initial temperature = 20 C for all substances.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
@Log4j
public class ChangeAggregateStateSubstance {
    public static void main(String[] args) {
        Substance sub;
        Scanner in = new Scanner(System.in);

        log.info("Enter the substance (water or iron, or oxygen): ");
        String substance = in.nextLine();
        log.info("Enter the temperature in the format '0,0': ");
        double temp = in.nextDouble();
        in.close();
        if (temp != 0) {
            switch (substance) {
                case "water" -> {
                    sub = new Water();
                    log.info(getMessage(sub, temp));
                }
                case "iron" -> {
                    sub = new Iron();
                    log.info(getMessage(sub, temp));
                }
                case "oxygen" -> {
                    sub = new Oxygen();
                    log.info(getMessage(sub, temp));
                }
                default -> log.info("You entered incorrect data!");
            }
        }
    }

    /**
     * This method display the new temperature of the substance and its state of aggregation at this temperature.
     *
     * @param sub                   the substances
     * @param temperature           temperature set by the user
     * @return                      the state of aggregation of substance
     * */
    private static String getMessage(Substance sub, double temperature) {
        return "Temperature: " + sub.getTemperature(temperature)
                + " degrees, aggregate states: " + sub.getAggregateStateOfSubstance(temperature);
    }
}
