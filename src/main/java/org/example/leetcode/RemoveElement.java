package org.example.leetcode;

public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int offset = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current == val) {
                offset++;
            } else {
                nums[i-offset] = current;
            }
        }
        return nums.length - offset;
    }
}
