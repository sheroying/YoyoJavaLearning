package com.yoyo.test.algorithm.problem;

import java.util.Stack;

public class ValidBracketTest {

    public static void main(String[] args) {
        String str = "{{{[(ads)]}}}";
        System.out.println(isValidBracketStr3(str));

    }

    /**
     * 字符串中只有这三种括号() [] {}
     */
    public static boolean isValidBracketStr(String str) {
        if (str.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        for (Character character : str.toCharArray()) {
            if (character == '(') {
                stack.push(')');
            } else if (character == '[') {
                stack.push(']');
            } else if (character == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || character != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 字符串中不只有这三种括号() [] {}，还有其他的字符
     *
     * @param str
     * @return
     */
    public static boolean isValidBracketStr2(String str) {

        Stack<Character> stack = new Stack<Character>();
        for (Character character : str.toCharArray()) {
            if (character == '(') {
                stack.push(')');
            } else if (character == '[') {
                stack.push(']');
            } else if (character == '{') {
                stack.push('}');
            } else if (character.toString().matches("[^(){}\\[\\]]")) {
                System.out.println(character);
            } else if (stack.isEmpty() || character != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    /**
     * 字符串中不只有这三种括号() [] {}，还有其他的字符
     *
     * @param str
     * @return
     */
    public static boolean isValidBracketStr3(String str) {
        String aaa = str.replaceAll("[^(){}\\[\\]]", "");

        Stack<Character> stack = new Stack<>();
        for (Character character : aaa.toCharArray()) {
            if (character == '(') {
                stack.push(')');
            } else if (character == '[') {
                stack.push(']');
            } else if (character == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || character != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
