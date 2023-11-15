package org.example.leetcode;

import java.util.Arrays;

public class Duplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    /**
     * 1 1 2
     * 0 1 2
     */
    public static int removeDuplicates(int[] nums) {
        int previous = -1000;
        int offset = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current == previous) {
                offset++;
            } else {
                nums[i-offset] = current;
            }
            previous = current;
        }
        return nums.length - offset;
    }
}
