package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

class Roman {
    public static final int I = 1;
    public static final int V = 5;
    public static final int X = 10;
    public static final int L = 50;
    public static final int C = 100;
    public static final int D = 500;
    public static final int M = 1000;
    private static final Map<String, Integer> ROMAN = new HashMap<>() {{
        put("I", I);
        put("V", V);
        put("X", X);
        put("L", L);
        put("C", C);
        put("D", D);
        put("M", M);
    }};

    private static HashMap<Character, Integer> m = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt2(String s) {
        Integer result = 0;
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            String ch = split[i];
            if (i != split.length - 1) {
                if (ch.equals("I")) {
                    if (split[i + 1].equals("V")) {
                        result += 4;
                        i++;
                        continue;
                    } else if (split[i + 1].equals("X")) {
                        result += 9;
                        i++;
                        continue;
                    }
                } else if (ch.equals("X")) {
                    if (split[i + 1].equals("L")) {
                        result += 40;
                        i++;
                        continue;
                    } else if (split[i + 1].equals("C")) {
                        result += 90;
                        i++;
                        continue;
                    }
                } else if (ch.equals("C")) {
                    if (split[i + 1].equals("D")) {
                        result += 400;
                        i++;
                        continue;
                    } else if (split[i + 1].equals("M")) {
                        result += 900;
                        i++;
                        continue;
                    }
                }

            }
            Integer next = ROMAN.get(ch);
            result += next;
        }
        return result;
    }

    public static int romanToInt(String s) {

        char[] c = s.toCharArray();
        int[] n = new int[c.length];
        for (int i = 0; i < n.length; i++) n[i] = m.get(c[i]);
        int sum = 0;
        for (int i = 0; i < n.length; i++) sum = i == c.length - 1 || n[i] >= n[i + 1] ? sum + n[i] : sum - n[i];
        return sum;

    }
}