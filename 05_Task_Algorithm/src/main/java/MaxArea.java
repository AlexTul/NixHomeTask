/*
 * Copyright (c) 2022
 * For Nix
 */

/**
 * Task from LeetCode.
 * 11. Container With Most Water
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
 * of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * @author Alexander Tuleninov
 * @version 01
 */
public class MaxArea {
    /**
     *
     */
    public static int maxArea(int[] height) {
        int water = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            water = Math.max(water, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return water;
    }

}
