package com.shrek.leetCode._010_BinarySearchTree;

import java.util.*;

/**
 *
 * Given the root of a Binary Search Tree (BST),
 * return the minimum absolute difference between the values of any two different nodes in the tree.
 *
 * Example 1:
 * Input: root = [4,2,6,1,3]
 * Output: 1
 *
 * Example 2:
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 * Constraints:
 * The number of nodes in the tree is in the range [2, 104].
 * 0 <= Node.val <= 105
 *
 * Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 *
 */

public class _086E_MinimumAbsoluteDifferenceInBST {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{4,2,6,1,3};
        TreeNode root = makeTree(arr1);
        System.out.println("getMinimumDifference for Tree l1 = " + Arrays.toString(arr1) + " is " + getMinimumDifference(root));
        // printLevelOrder(root);
        // 1
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1,0,48,null,null,12,49};
        root = makeTree(arr1);
        System.out.println("getMinimumDifference for Tree l1 = " + Arrays.toString(arr1) + " is " + getMinimumDifference(root));
        // printLevelOrder(root);
        // 1
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{};
        root = makeTree(arr1);
        System.out.println("getMinimumDifference for Tree l1 = " + Arrays.toString(arr1) + " is " + getMinimumDifference(root));
        // printLevelOrder(root);
        // 0
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

    static int minDiff = Integer.MAX_VALUE;
    static TreeNode prev;
    public static int getMinimumDifference(TreeNode root) {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        inOrder(root);
        return minDiff;
    }

    public static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        if(prev!=null){
            minDiff = Math.min(minDiff, root.val - prev.val);
        }
        prev = root;
        inOrder(root.right);
    }

    /*public static List<Integer> ll;
    public static int getMinimumDifference(TreeNode root) {
        if(root==null){
            return 0;
        }
        int minDiff = Integer.MAX_VALUE;
        ll = new ArrayList<>();
        inOrder(root);
        System.out.println(ll.toString());
        for(int i=1;i<ll.size();i++){
            System.out.println("Debugging, ll.get(i) - ll.get(i-1) = "+(ll.get(i) - ll.get(i-1))+" , minDiff = " + minDiff);
            minDiff =  Math.min(minDiff, ll.get(i) - ll.get(i-1));
        }
        return minDiff;
    }

    public static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        ll.add(root.val);
        inOrder(root.right);
    }*/

}
