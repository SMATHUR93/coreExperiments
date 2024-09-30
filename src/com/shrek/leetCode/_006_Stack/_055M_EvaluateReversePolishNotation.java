package com.shrek.leetCode._006_Stack;

import java.util.Stack;

/**
 *
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 *
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * Constraints:
 *
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 *
 */

public class _055M_EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = new String[]{"2","1","+","3","*"};
        System.out.println("evalRPN for tokens = " + tokens + " is " + evalRPN(tokens));
        // 9
        System.out.println("-------------- BREAK -----------------");

        tokens = new String[]{"4","13","5","/","+"};
        System.out.println("evalRPN for tokens = " + tokens + " is " + evalRPN(tokens));
        // 6
        System.out.println("-------------- BREAK -----------------");

        tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("evalRPN for tokens = " + tokens + " is " + evalRPN(tokens));
        // 22
        System.out.println("-------------- BREAK -----------------");

    }

    public static int evalRPN(String[] tokens) {
        Stack<String> stack =  new Stack<String>();
        int lEl, rEl, val = 0;
        for(String s: tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                if(!stack.isEmpty()){
                    rEl = Integer.parseInt(stack.pop());
                } else{
                    return 0;
                }
                if(!stack.isEmpty()){
                    lEl = Integer.parseInt(stack.pop());
                } else{
                    return 0;
                }
                if(s.equals("+")){
                    val = lEl + rEl;
                }
                if(s.equals("-")){
                    val = lEl - rEl;
                }
                if(s.equals("/")){
                    val = lEl / rEl;
                }
                if(s.equals("*")){
                    val = lEl * rEl;
                }
                stack.push(String.valueOf(val));
            } else{
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.peek());
    }

}
