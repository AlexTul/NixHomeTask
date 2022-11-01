package com.nixsolutions.alextuleninov.threadsconcurrency.alextuleninov.eleven.task1;

import static java.lang.System.out;

public class PrintedResult {

    public void printedResult(char[][] mat) {
        for (char[] chars : mat) {
            for (char ss : chars) {
                out.print(ss);
            }
            out.println();
        }
    }

}
