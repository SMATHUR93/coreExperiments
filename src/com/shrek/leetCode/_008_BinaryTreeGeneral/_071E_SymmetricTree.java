package com.shrek.leetCode._008_BinaryTreeGeneral;

/**
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 * Follow up: Could you solve it both recursively and iteratively?
 *
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _071E_SymmetricTree {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{1,2,2,3,4,4,3};
        TreeNode root1 = makeTree(arr1);
        // printLevelOrder(root);
        System.out.println("isSymmetric for Tree l1 = "+ Arrays.toString(arr1)+" is " + isSymmetric(root1));
        // true
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1,2,2,null,3,null,3};
        root1 = makeTree(arr1);
        // printLevelOrder(root);
        System.out.println("isSymmetric for Tree l1 = "+ Arrays.toString(arr1)+" is " + isSymmetric(root1));
        // false
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
    
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null || rightTree == null) {
            return false;
        }
        return (
                (leftTree.val == rightTree.val) &&
                        isMirror(leftTree.right, rightTree.left) &&
                        isMirror(leftTree.left, rightTree.right)
        );
    }
    
}
