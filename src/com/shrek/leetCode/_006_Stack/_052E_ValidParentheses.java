package com.shrek.leetCode._006_Stack;

import java.util.Stack;

/**
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 *
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 *
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "([])"
 *
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 *
 * Hint 1
 * Use a stack of characters.
 *
 * Hint 2
 * When you encounter an opening bracket, push it to the top of the stack.
 *
 * Hint 3
 * When you encounter a closing bracket,
 * check if the top of the stack was the opening for it.
 * If yes, pop it from the stack. Otherwise, return false.
 *
 */

public class _052E_ValidParentheses {

    public static void main(String[] args) {
        String s = "()";
        System.out.println("ValidParentheses for string = " + s + " is " + isValid(s));
        // true
        System.out.println("-------------- BREAK -----------------");

        s = "()[]{}";
        System.out.println("ValidParentheses for string = " + s + " is " + isValid(s));
        // true
        System.out.println("-------------- BREAK -----------------");

        s = "(]";
        System.out.println("ValidParentheses for string = " + s + " is " + isValid(s));
        // false
        System.out.println("-------------- BREAK -----------------");

        s = "([])";
        System.out.println("ValidParentheses for string = " + s + " is " + isValid(s));
        // true
        System.out.println("-------------- BREAK -----------------");

    }

    public static boolean isValid(String s) {
        char[] arr = s.toCharArray();
        if(arr.length<=1 || arr.length%2!=0){
            return false;
        }
        Stack<Character> stack  = new Stack<Character>();
        for(int i=0;i<arr.length;i++){
            char ch = arr[i];
            //'(', ')', '{', '}', '[' and ']',
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            } else if(ch==')'){
                if(stack.isEmpty()!=true && '('==stack.peek()) {
                    stack.pop();
                } else{
                    return false;
                }
            } else if(ch=='}'){
                if(stack.isEmpty()!=true && '{'==stack.peek()) {
                    stack.pop();
                } else{
                    return false;
                }
            } else if(ch==']'){
                if(stack.isEmpty()!=true && '['==stack.peek()) {
                    stack.pop();
                } else{
                    return false;
                }
            }
        }
        return stack.isEmpty()==true ? true: false;
    }

}
