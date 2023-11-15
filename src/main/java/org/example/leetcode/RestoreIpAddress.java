package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RestoreIpAddress {
    static int[] a = new int[100];
    static int[] sum = new int[100];
    static int n = 6;

    /**
     * 4..12
     * 0.0.0.0 = length 4
     * 255.255.255.255 = length 12
     * split any possible variants -> filter invalid
     * possible variants for 5: 1 2 3 symbols -> 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1
     * possible variants for 6: 1 2 3 -> 1+1+1+3, 1+1+2+2, 1+
     */
    public static void main(String[] args) {
        System.out.println(getPossibleVariants(7));
        System.out.println(Arrays.toString(restoreIpAddresses("255255111135").toArray()));
        System.out.println(Arrays.toString(restoreIpAddresses("2552111035").toArray()));
        System.out.println(Arrays.toString(restoreIpAddresses("255255111035").toArray()));
        System.out.println(Arrays.toString(restoreIpAddresses("255255111335").toArray()));
        System.out.println(Arrays.toString(restoreIpAddresses("0000").toArray()));
        System.out.println(Arrays.toString(restoreIpAddresses("25525511135").toArray()));
        System.out.println(Arrays.toString(restoreIpAddresses("101023").toArray()));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        for (int len1 = Math.max(1, s.length() - 9);
             len1 <= 3 && len1 <= s.length() - 3; ++len1) {
            if (!isValid(s, 0, len1)) {
                continue;
            }

            for (int len2 = Math.max(1, s.length() - len1 - 6);
                 len2 <= 3 && len2 <= s.length() - len1 - 2; ++len2) {
                if (!isValid(s, len1, len2)) {
                    continue;
                }
                for (int len3 = Math.max(1, s.length() - len1 - len2 - 3);
                     len3 <= 3 && len3 <= s.length() - len1 - len2 - 1; ++len3) {
                    if (isValid(s, len1 + len2, len3) &&
                            isValid(s, len1 + len2 + len3,
                                    s.length() - len1 - len2 - len3)) {
                        ans.add(String.join(".", s.
                                        substring(0, len1),
                                s.substring(len1, len1 + len2),
                                s.substring(len1 + len2, len1 + len2 + len3),
                                s.substring(len1 + len2 + len3)));
                    }
                }
            }

        }
        return ans;
    }

    public static List<String> restoreIpAddresses1(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return Collections.emptyList();
        }
        if (s.length() == 4) {
            String[] address = fixedLength(s, 1);
            if (isValid(address)) {
                return Collections.emptyList();
            }
            return Arrays.asList(join(address));
        }
        if (s.length() == 12) {
            String[] address = fixedLength(s, 3);
            if (isValid(address)) {
                return Collections.emptyList();
            }
            return Arrays.asList(join(address));
        }
        List<String> addresses = new ArrayList<>();

        return addresses;
    }

    /**
     * 3 1 1 1
     * 2 2 1 1
     * 2 1 2 1
     * 2 1 1 2
     * 1 3 1 1
     * 1 2 2 1
     * 1 2 1 2
     * 1 1 2 2
     * 1 1 1 3
     */
    public static List<List<Integer>> getPossibleVariants(int sum) {
        List<List<Integer>> variants = new ArrayList<>();
        int forth = 1;
        int third = 1;
        int second = 1;
        int first = sum - second - third - forth;
        variants.add(new ArrayList<>(Arrays.asList(first, second, third, forth)));
        while (first > 1) {
            first--;
            second++;
            variants.add(new ArrayList<>(Arrays.asList(first, second, third, forth)));
            while (second > 1) {
                second--;
                third++;
                variants.add(new ArrayList<>(Arrays.asList(first, second, third, forth)));
                while (third > 1) {
                    third--;
                    forth++;
                    variants.add(new ArrayList<>(Arrays.asList(first, second, third, forth)));
                }
            }
        }
        return variants;
    }

    public static void printTerms(int left, int min, int i) {
        if (left < 0 || min == n)
            return;
        sum[i] = min;
        if (min != 0) {
            printTerms(left - min, min, i + 1);
        }
        printTerms(left - 1, min + 1, i);
        if (left == 0) {
            for (int j = 0; j <= i; ++j) {
                System.out.print(sum[j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    public static void partition(int n, int high, int pos) {
        int i;
        if (n > 0) {
            for (i = 1; i <= high; i++) {
                a[pos] = i;
                partition(n - i, Math.min(i, n - i), pos + 1);
            }
        } else {
            for (i = 0; i < pos; i++) {
                System.out.print(a[i]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static String[] fixedLength(String s, int length) {
        return length == 1 ? s.split("(?<=\\G.)") : s.split("(?<=\\G...)");
    }

    public static String join(String[] s) {
        return String.join(".", s);
    }

    public static boolean isValid(String[] s) {
        return Arrays.stream(s).allMatch(string -> string.length() == 1
                || (!string.startsWith("0") && string.length() < 3 || string.compareTo("255") <=0));
    }

    private static boolean isValid(String s, int start, int length) {
        return length == 1 ||
                (s.charAt(start) != '0' &&
                        (length < 3 ||
                                s.substring(start, start + length).compareTo("255") <= 0));
    }
}
