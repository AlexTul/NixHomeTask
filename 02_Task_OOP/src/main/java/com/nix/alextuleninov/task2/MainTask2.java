/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nix.alextuleninov.task2;

import lombok.extern.log4j.Log4j;
import java.util.Scanner;

/**
 * The MainTask2 class implements: the user selects one of the substances and then can enter the values
 * by which he changes its temperature. Each time he does this, output a new temperature of the substance
 * and its state of aggregation at that temperature. If you enter 0 - terminate the program execution.
 * Initial temperature = 20 C for all substances.
 * @version 01
 *
 * @author Alexander Tuleninov
 */
@Log4j
public class MainTask2 {
    public static void main(String[] args) {
        Substance sub;
        Scanner in = new Scanner(System.in);

        log.info("Enter the substance (water or iron, or oxygen): ");
        String substance = in.nextLine();
        log.info("Enter the temperature in the format '0,0': ");
        double temp = in.nextDouble();
        if (temp != 0) {
            switch (substance) {
                case "water" -> {
                    sub = new Water();
                    sub.stateHeatUp(temp);
                    if (temp < 0) {
                        log.info("Temperature: " + sub.getTemperature() + " degrees, aggregate states: " + State.SOLID);
                    } else if (temp > 100) {
                        log.info("Temperature: " + sub.getTemperature() + " degrees, aggregate states: " + State.GAS);
                    } else {
                        log.info("Temperature: " + sub.getTemperature() + " degrees, aggregate states: " + State.LIQUID);
                    }
                }
                case "iron" -> {
                    sub = new Iron();
                    sub.stateHeatUp(temp);
                    log.info("Temperature: " + sub.getTemperature() + " degrees, aggregate states: " + State.SOLID);
                }
                case "oxygen" -> {
                    sub = new Oxygen();
                    sub.stateHeatUp(temp);
                    log.info("Temperature: " + sub.getTemperature() + " degrees, aggregate states: " + State.GAS);
                }
                default -> log.info("You entered incorrect data!");
            }
        }
    }
}
