package com.shrek.leetCode._008_BinaryTreeGeneral;

/**
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Example 1:
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *
 *
 * Example 2:
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 *
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _070E_InvertBinaryTree {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{4,2,7,1,3,6,9};
        TreeNode root1 = makeTree(arr1);
        // printLevelOrder(root);
        System.out.println("invertTree for Tree l1 = "+ Arrays.toString(arr1)+" is " + invertTree(root1));
        // [4,7,2,9,6,3,1]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{2,1,3};
        root1 = makeTree(arr1);
        // printLevelOrder(root);
        System.out.println("invertTree for Tree l1 = "+ Arrays.toString(arr1)+" is " + invertTree(root1));
        // [2,3,1]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{};
        root1 = makeTree(arr1);
        // printLevelOrder(root);
        System.out.println("invertTree for Tree l1 = "+ Arrays.toString(arr1)+" is " + invertTree(root1));
        // []
        System.out.println("-------------- BREAK -----------------");

    }

    // Arrays is in level order so use queue to implement BFS traversal
    public static TreeNode makeTree(Integer[] arr){
        System.out.println("makeTree for arr = "+ Arrays.toString(arr));
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

            if(i<=arr.length-1 && arr[i]!=null){
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
    
    public static TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root!=null && root.left==null && root.right==null){
            return new TreeNode(root.val);
        }
        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);
        root.left = rightTree;
        root.right = leftTree;
        return root;
    }

}
