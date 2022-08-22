/*
 * Copyright (c) 2022
 * For Nix
 */
package com.nixsolutions.alextuleninov.fourtask;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * The Retry class performs Block.
 *
 * @author Alexander Tuleninov
 * @version 01
 */
public class Retry implements Block {
    private static int number = 0;

    @Override
    public void run() throws Exception {
        number++;
        out.println("Number of times the method is triggered: " + number);
    }

    public static void main(String[] args) {
        // specified number of times the method is executed run()
        int n = 4;
        int count = 0;

        Block bl = new Retry();

        for (int i = 0; i < n; i++) {
            try {
                bl.run();
                count = i == 0 ? 0 : count + 1;
                Thread.sleep(100 * i);
                if (count == n - 1) {
                    throw new RuntimeException("Run out of trials");
                }
            } catch (RuntimeException e) {
                err.println("Catch the RuntimeException for run out of trials");
                e.printStackTrace();
            } catch (Exception e) {
                err.println("Catch the InterruptedException for '.sleep()' and Exception for '.run()'");
                e.printStackTrace();
            }
        }
        out.println("Block the specified number of times was executed correctly");
    }

}
