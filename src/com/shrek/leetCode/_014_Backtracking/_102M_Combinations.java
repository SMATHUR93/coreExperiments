package com.shrek.leetCode._014_Backtracking;

import java.util.*;

/**
 *
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 */

public class _102M_Combinations {

    public static void main(String[] args) {

        int n,k;

        n = 3;
        k = 2;
        System.out.println("combine for n = "+n+" , k = "+k+" , equals "+ combine(n, k).toString());
        // [[1,2],[1,3],[2,3]]
        System.out.println();

        n = 4;
        k = 2;
        System.out.println("combine for n = "+n+" , k = "+k+" , equals "+ combine(n, k).toString());
        // [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        System.out.println();

        n = 1;
        k = 1;
        System.out.println("combine for n = "+n+" , k = "+k+" , equals "+ combine(n, k).toString());
        // [[1]]
        System.out.println();
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> op = new ArrayList<>();
        genrateCombinations(1, new ArrayList(), op, n, k);
        return new ArrayList<>(op);
    }

    public static void genrateCombinations(int startNumber, List<Integer> combination,  List<List<Integer>> op, int n, int k){
        System.out.println("Debugging the params for rec, startNumber = "+startNumber+" , combination = "+combination.toString());
        if(combination.size()==k){
            System.out.println("        ADDED combination in List");
            op.add(new ArrayList<>(combination));
            return;
        }
        for(int i=startNumber;i<=n;i++){
            combination.add(i);
            genrateCombinations(i+1, combination, op, n, k);
            combination.remove(combination.size() - 1);
        }
    }

}
