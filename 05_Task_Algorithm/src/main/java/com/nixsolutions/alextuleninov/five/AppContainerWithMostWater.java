/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.five;

import static java.lang.System.out;

/**
 * The class shows how the maxArea() method works.
 */
public class AppContainerWithMostWater {
    public static void main(String[] args) {
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        out.println("maxArea: " + MaxArea.maxArea(input));
        out.println("O(n); O(1)");
    }
}
