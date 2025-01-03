package com.shrek.leetCode._014_Backtracking;

import java.util.*;

/**
 *
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations
 * that sum up to target is less than 150 combinations for the given input.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 *  Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 *  Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 *
 */

public class _104M_CombinationSum {

    public static void main(String[] args) {

        int[] candidates;
        int target;

        candidates = new int[]{1,2};
        target = 4;
        System.out.println("combinationSum for nums = "+ Arrays.toString(candidates)+" , target = "+target+" , equals "+ combinationSum(candidates, target).toString());
        // [[1,1,1,1],[1,1,2],[2,2]]
        System.out.println();

        candidates = new int[]{2,3,6,7};
        target = 7;
        System.out.println("combinationSum for nums = "+ Arrays.toString(candidates)+" , target = "+target+" , equals "+ combinationSum(candidates, target).toString());
        // [[2,2,3],[7]]
        System.out.println();

        candidates = new int[]{2,3,5};
        target = 8;
        System.out.println("combinationSum for nums = "+ Arrays.toString(candidates)+" , target = "+target+" , equals "+ combinationSum(candidates, target).toString());
        // [[2,2,2,2],[2,3,3],[3,5]]
        System.out.println();

        candidates = new int[]{2};
        target = 1;
        System.out.println("combinationSum for nums = "+ Arrays.toString(candidates)+" , target = "+target+" , equals "+ combinationSum(candidates, target).toString());
        // []
        System.out.println();
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> op = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), candidates, target, op, 0);
        return new ArrayList<>(op);
    }
    public static void backtrack(List<Integer> current, int[] candidates, int target, List<List<Integer>> op, int index){
        // System.out.println("START:: Debugging the params for rec, index = "+index+" , target = "+target+" and current list = "+current.toString());
        if(target<=0){
            if(target==0){
                System.out.println("                  Adding this current = "+current.toString());
                op.add(new ArrayList<>(current));
            }
            return;
        }
        for(int i=index;i<candidates.length;i++){
            current.add(candidates[i]);
            backtrack(current, candidates, target - candidates[i], op, i);
            current.remove(current.size() - 1);
        }
    }

}
