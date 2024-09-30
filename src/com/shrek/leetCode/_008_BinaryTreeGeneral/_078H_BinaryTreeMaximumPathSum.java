package com.shrek.leetCode._008_BinaryTreeGeneral;

import java.util.*;

/**
 * 
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * Example 2:
 *
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 * 
 */

public class _078H_BinaryTreeMaximumPathSum {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{1,2,3};
        TreeNode root = makeTree(arr1);
        System.out.println("maxPathSum for Tree l1 = " + Arrays.toString(arr1) + " is " + maxPathSum(root));
        // printLevelOrder(root);
        // 6
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{-10,9,20,null,null,15,7};
        root = makeTree(arr1);
        System.out.println("maxPathSum for Tree l1 = " + Arrays.toString(arr1) + " is " + maxPathSum(root));
        // printLevelOrder(root);
        // 42
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1,-2,-3,1,3,-2,null,-1};
        root = makeTree(arr1);
        System.out.println("maxPathSum for Tree l1 = " + Arrays.toString(arr1) + " is " + maxPathSum(root));
        // printLevelOrder(root);
        // 3
        System.out.println("-------------- BREAK -----------------");

    }

    // Arrays is in level order so use queue to implement BFS traversal
    public static TreeNode makeTree(Integer[] arr){
        if(arr.length==0 || arr[0]==null){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i=1;
        TreeNode left, right;
        while(!queue.isEmpty() && i<arr.length){
            TreeNode current = queue.poll();

            if(arr[i]!=null){
                left = new TreeNode(arr[i]);
                current.left = left;
                queue.add(left);
            }
            i++;
            if(i<=arr.length-1 && arr[i]!=null){
                right = new TreeNode(arr[i]);
                current.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }

    public static void printLevelOrder(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode temp;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.val+", ");
            if(temp.left!=null) {
                queue.add(temp.left);
            }
            if(temp.right!=null) {
                queue.add(temp.right);
            }
        }
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

    public static int maxSum = 0;
    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        sumFromSubTree(root);
        return maxSum;
    }
    public static int sumFromSubTree(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftSum = Math.max(sumFromSubTree(root.left), 0);

        int rightSum = Math.max(sumFromSubTree(root.right), 0);

        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);

        return Math.max(leftSum + root.val, rightSum + root.val);
    }
    
}
