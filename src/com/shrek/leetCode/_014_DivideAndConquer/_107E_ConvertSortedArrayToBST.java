package com.shrek.leetCode._014_DivideAndConquer;

import java.util.Arrays;

/**
 *
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced
 *  binary search tree.
 *
 * Example 1:
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 *
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 *
 */

public class _107E_ConvertSortedArrayToBST {

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{-10,-3,0,5,9};
        System.out.println("sortedArrayToBST for nums = "+ Arrays.toString(nums) +" equals " + sortedArrayToBST(nums) );
        // true
        System.out.println();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums, 0, nums.length-1);
    }

    public static TreeNode makeTree(int[] nums, int start, int end){
        if(start>end){
            // System.out.println(" Break condition, start = "+ start+" , end = "+end);
            return null;
        }
        int mid = (end+start)/2;
        if ((start + end) % 2 == 1){
            mid++;
        }
        // System.out.println("Debugging, start = "+ start+" , end = "+end+" , mid = "+mid);
        TreeNode root =  new TreeNode(nums[mid]);
        root.left = makeTree(nums, start, mid-1);
        root.right = makeTree(nums, mid+1, end);
        return root;
    }

}
