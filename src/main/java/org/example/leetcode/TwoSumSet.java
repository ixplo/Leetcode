package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;

class TwoSumSet {

    public static void main(String[] args) {
//        int[] input = {2,7,11,15};
//        int target = 9;
        int[] input = {3, 2, 4};
        int target = 6;
        int[] result = new TwoSumSet().twoSum(input, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> checked = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int numberToFind = target - nums[i];
            if (checked.containsKey(numberToFind)) {
                return new int[]{checked.get(numberToFind), i};
            }
            checked.put(nums[i], i);
        }
        return new int[0];
    }
}