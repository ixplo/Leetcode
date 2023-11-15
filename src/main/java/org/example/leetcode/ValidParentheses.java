package org.example.leetcode;

import java.util.Stack;

class ValidParentheses {
    public static final String SQUARE = "[";
    public static final String BRACES = "{";
    public static final String REGULAR = "(";
    public static final String SQUARE_CLOSE = "]";
    public static final String BRACES_CLOSE = "}";
    public static final String REGULAR_CLOSE = ")";
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("(){}[]"));
        System.out.println(isValid("{()}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("(]{}[)"));
        System.out.println(isValid("([{}[)"));
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        Stack<String> currentTypes = new Stack<>();
        for (String current : s.split("")) {
            switch (current) {
                case SQUARE:
                    currentTypes.push(SQUARE);
                    break;
                case BRACES:
                    currentTypes.push(BRACES);
                    break;
                case REGULAR:
                    currentTypes.push(REGULAR);
                    break;
                case SQUARE_CLOSE:
                    if (currentTypes.empty() || !SQUARE.equals(currentTypes.pop())) {
                        return false;
                    }
                    break;
                case BRACES_CLOSE:
                    if (currentTypes.empty() || !BRACES.equals(currentTypes.pop())) {
                        return false;
                    }
                    break;
                case REGULAR_CLOSE:
                    if (currentTypes.empty() || !REGULAR.equals(currentTypes.pop())) {
                        return false;
                    }
                    break;
                default: throw new IllegalArgumentException("Wrong symbol");
            }
        }
        return currentTypes.empty();
    }
}