package org.example.leetcode;

class CommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (String str : strs) {
            for (int i = prefix.length(); i >= 0; i--) {
                String subPrefix = prefix.substring(0, i);
                if (str.startsWith(subPrefix)) {
                    prefix = subPrefix;
                    break;
                }
            }
        }
        return prefix;
    }
}