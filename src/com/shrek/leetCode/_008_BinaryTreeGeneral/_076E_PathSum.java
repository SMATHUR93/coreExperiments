package com.shrek.leetCode._008_BinaryTreeGeneral;

/**
 *
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 * Example 3:
 *
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _076E_PathSum {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = makeTree(arr1);
        int targetSum = 22;
        System.out.println("hasPathSum for Tree l1 = " + Arrays.toString(arr1) + " is " + hasPathSum(root, targetSum));
        // printLevelOrder(root);
        // true
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1,2,3};
        root = makeTree(arr1);
        targetSum = 5;
        System.out.println("hasPathSum for Tree l1 = " + Arrays.toString(arr1) + " is " + hasPathSum(root, targetSum));
        // printLevelOrder(root);
        // false
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{};
        root = makeTree(arr1);
        targetSum = 0;
        System.out.println("hasPathSum for Tree l1 = " + Arrays.toString(arr1) + " is " + hasPathSum(root, targetSum));
        // printLevelOrder(root);
        // false
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1,2};
        root = makeTree(arr1);
        targetSum = 1;
        System.out.println("hasPathSum for Tree l1 = " + Arrays.toString(arr1) + " is " + hasPathSum(root, targetSum));
        // printLevelOrder(root);
        // false
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1};
        root = makeTree(arr1);
        targetSum = 1;
        System.out.println("hasPathSum for Tree l1 = " + Arrays.toString(arr1) + " is " + hasPathSum(root, targetSum));
        // printLevelOrder(root);
        // true
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1,2,null,3,null,4,null,5};
        root = makeTree(arr1);
        printLevelOrder(root);
        targetSum = 6;
        System.out.println("hasPathSum for Tree l1 = " + Arrays.toString(arr1) + " is " + hasPathSum(root, targetSum));
        // false
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

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        boolean leftSum = hasPathSum(root.left, targetSum - root.val);
        boolean rightSum = hasPathSum(root.right, targetSum - root.val);

        return leftSum || rightSum;
    }

    /*public static int sum = 0;
    public static boolean bool = false;
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.val==targetSum){
            if(root.left==null && root.right==null){
                return true;
            }
            if(root.left==null || root.right==null){
                return false;
            }
        }

        bool = false;
        pre(root, 0, targetSum);
        return bool;
    }
    public static void pre(TreeNode root, int sum, int targetSum){
        if(root!=null){
            sum+=root.val;
            pre(root.left, sum, targetSum);
            pre(root.right, sum, targetSum);
        } else if(sum==targetSum){
            bool = true;
            return;
        }
    }*/

}
