package com.shrek.leetCode._014_Backtracking;

/**
 *
 * Given an array nums of distinct integers, return all the possible
 * permutations
 * . You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *  Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 *  Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _102M_Permutations {

    public static void main(String[] args) {

        int[] nums;

        nums = new int[]{1,2,3};
        System.out.println("permute for nums = "+Arrays.toString(nums)+" , equals "+ permute(nums).toString());
        // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        System.out.println();

        nums = new int[]{0,1};
        System.out.println("permute for nums = "+Arrays.toString(nums)+" , equals "+ permute(nums).toString());
        // [[0,1],[1,0]]
        System.out.println();

        nums = new int[]{1};
        System.out.println("permute for nums = "+Arrays.toString(nums)+" , equals "+ permute(nums).toString());
        // [[1]]
        System.out.println();

        nums = new int[]{0,-1,1};
        System.out.println("permute for nums = "+Arrays.toString(nums)+" , equals "+ permute(nums).toString());
        // [[0,-1,1],[0,1,-1],[-1,0,1],[-1,1,0],[1,0,-1],[1,-1,0]]
        System.out.println();
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        generatePermutations(new ArrayList<>(), nums, op);
        return op;
    }

    public static void generatePermutations(List<Integer> permutation, int[] numbers, List<List<Integer>> op){
        System.out.println("Debugging the params for rec, permutation = "+permutation.toString());
        if(permutation.size()==numbers.length){
            System.out.println("                  Adding this permutation = "+permutation.toString());
            op.add(new ArrayList<>(permutation));
            return;
        }
        for(int num:numbers){
            if(!permutation.contains(num)){
                permutation.add(num);
                generatePermutations(permutation, numbers, op);
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    // Previous Attempt , qworks but not exact
    /*public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            numbers.add(nums[i]);
        }
        generatePermutations(new ArrayList<>(), numbers, op, nums.length);
        return op;
    }

    public static void generatePermutations(List<Integer> permutation, List<Integer> numbers, List<List<Integer>> op, int n){
        // System.out.println("Debugging the params for rec, permutation = "+permutation.toString()+" , nums = "+numbers.toString());
        if(permutation.size()==n){
            // System.out.println("                 ADDED permutation in List");
            op.add(new ArrayList<>(permutation));
            return;
        }
        for(int i=0;i<numbers.size();i++){
            permutation.add(numbers.get(i));

            List<Integer> ll = new ArrayList<Integer>(numbers.subList(0,i));
            ll.addAll(numbers.subList(i+1, numbers.size()));

            generatePermutations(permutation, ll, op, n);
            permutation.remove(permutation.size() - 1);
        }
    }*/
}
