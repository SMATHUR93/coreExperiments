package com.shrek.leetCode._014_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 * Constraints:
 * 1 <= n <= 8
 *
 */

public class _106M_GenerateParentheses {

    public static void main(String[] args) {
        int n;

        n=3;
        System.out.println("generateParenthesis for n = "+n+" equals "+generateParenthesis(n).toString());
        // ["((()))","(()())","(())()","()(())","()()()"]
        System.out.println();

        n=1;
        System.out.println("generateParenthesis for n = "+n+" equals "+generateParenthesis(n).toString());
        // ["()"]
        System.out.println();
    }

    public static List<String> generateParenthesis(int n) {
        List<String> op =  new ArrayList<>();
        recCall("", 0, 0, n, op);
        return op;
    }


    public static void recCall(String currString, int leftCount, int rightCount, int n, List<String> op){
        if(currString.length()== 2*n){
            op.add(currString);
            return;
        }
        if(leftCount<n){
            recCall(currString.concat("("), leftCount+1, rightCount, n, op);
        }
        if(leftCount>rightCount){
            recCall(currString.concat(")"), leftCount, rightCount+1, n, op);
        }
    }

}
