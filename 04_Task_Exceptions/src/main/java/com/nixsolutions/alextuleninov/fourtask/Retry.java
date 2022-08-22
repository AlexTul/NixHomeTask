/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.fourtask;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * Class Retry which contains a method that allows you to execute code in case of an error.
 *
 * @author Alexander Tuleninov
 * @version 01
 */
public class Retry {

    /**
     * The method that allows you to execute code in case of an error.
     *
     * @param method    interface with a method that contains an exception
     * @param n         user-specified number of times the interface method containing the exception is executed
     */
    protected void repeat(Block method, int n) {
        // the auxiliary counter
        int count = 0;

        for (int i = 0; i <= n; i++) {
            try {
                if (count == n - 1) {
                    throw new RuntimeException("Run out of trials");
                }
                count = i == 0 ? 0 : count + 1;
                method.run();
                Thread.sleep(100 * i);
            } catch (ArithmeticException e) {
                err.println("Catch ArithmeticException before exhaustion of tests");
                e.printStackTrace();
            } catch (RuntimeException e) {
                err.println("Catch the RuntimeException after exhaustion of tests");
                e.printStackTrace();
            } catch (Exception e) {
                err.println("Catch the InterruptedException for '.sleep()' and Exception for '.run()'");
                e.printStackTrace();
            }
        }
        out.println("Block the specified number of times was executed correctly");
    }

}
