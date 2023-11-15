package org.example.leetcode;

import java.util.Arrays;

class TwoSumArray {

    public static void main(String[] args) {
//        int[] input = {2,7,11,15};
//        int target = 9;
        int[] input = {3, 2, 4};
        int target = 6;
        int[] result = new TwoSumArray().twoSum(input, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] comp = new int[1000000000];
        for (int i = 0; i < nums.length; i++) {
            if (comp[nums[i]] > 0) {
                return new int[]{comp[nums[i]], i};
            }
            comp[target - nums[i]] = i;
        }
        return new int[0];
    }
}