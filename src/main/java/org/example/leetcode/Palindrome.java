package org.example.leetcode;

class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(100));
        System.out.println(isPalindrome(1001));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0, j = chars.length - 1; i < chars.length / 2; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
}