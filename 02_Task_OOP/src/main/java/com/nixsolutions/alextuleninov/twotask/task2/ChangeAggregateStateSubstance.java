/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.fourtask.task2;

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
        com.nixsolutions.alextuleninov.fourtask.task2.Substance sub;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the substance (water or iron, or oxygen): ");
        String substance = in.nextLine();
        System.out.println("Enter the temperature in the format '0,0': ");
        double temp = in.nextDouble();
        in.close();
        if (temp != 0) {
            switch (substance) {
                case "water" -> {
                    sub = new com.nixsolutions.alextuleninov.fourtask.task2.Water();
                    System.out.println(getMessage(sub, temp));
                }
                case "iron" -> {
                    sub = new com.nixsolutions.alextuleninov.fourtask.task2.Iron();
                    System.out.println(getMessage(sub, temp));
                }
                case "oxygen" -> {
                    sub = new com.nixsolutions.alextuleninov.fourtask.task2.Oxygen();
                    System.out.println(getMessage(sub, temp));
                }
                default -> System.out.println("You entered incorrect data!");
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
    private static String getMessage(com.nixsolutions.alextuleninov.fourtask.task2.Substance sub, double temperature) {
        return "Temperature: " + sub.getTemperature(temperature)
                + " degrees, aggregate states: " + sub.getAggregateStateOfSubstance(temperature);
    }
}
