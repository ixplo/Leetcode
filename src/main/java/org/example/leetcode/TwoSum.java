package org.example.leetcode;

import java.util.Arrays;

class TwoSum {

    public static void main(String[] args) {
//        int[] input = {2,7,11,15};
//        int target = 9;
        int[] input = {3,2,4};
        int target = 6;
        int[] result = new TwoSum().twoSum(input, target);
        System.out.println(Arrays.toString(result));
    }
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int numberToFind = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == numberToFind) {
                    return new int[]{i,mid};
                }
                if (numberToFind < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        };
        return new int[0];
    }
}