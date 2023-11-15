package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

class UniqueOccur {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(uniqueOccurrences(new int[]{1, 2}));
        System.out.println(uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }

    public static boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Long> counter = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        return counter.size() == new HashSet<>(counter.values()).size();
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int next : arr) {
            counter.put(next, counter.getOrDefault(next, 0) + 1);
        }
        return counter.size() == new HashSet<>(counter.values()).size();
    }

    int K = 1000;
    public boolean uniqueOccurrences3(int[] arr) {
        int freq[] = new int[2 * K + 1];

        // Store the frequency of elements in the unordered map.
        for (int num : arr) {
            freq[num + K]++;
        }

        // Sort the frequency count.
        Arrays.sort(freq);

        // If the adjacent freq count is equal, then the freq count isn't unique.
        for (int i = 0; i < 2 * K; i++) {
            if (freq[i] != 0 && freq[i] == freq[i + 1]) {
                return false;
            }
        }
        return true;
    }
}