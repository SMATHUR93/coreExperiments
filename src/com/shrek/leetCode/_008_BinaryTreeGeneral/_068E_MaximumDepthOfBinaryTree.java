package com.shrek.leetCode._008_BinaryTreeGeneral;

import com.shrek.dsa.tree.BinaryTreeNode;
import com.shrek.dsa.tree.HelperDynamicQueue;
import com.shrek.leetCode._007_LinkedList._066M_PartitionList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *       3
 *   9      20
 *        15  7
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 *
 */

public class _068E_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = makeTree(arr1);
        // printLevelOrder(root);
        System.out.println("maxDepth for Tree l1 = "+ Arrays.toString(arr1)+" is " + maxDepth(root));
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
            if(arr[i]!=null){
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

    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return traverse(root, 0);
    }

    public static int traverse(TreeNode root, int len){
        len++;
        if(root.left==null && root.right==null){
            return len;
        }
        int left=0;
        int right=0;
        if(root.left!=null){
            left = traverse(root.left, len);
        }
        if(root.right!=null){
            right = traverse(root.right, len);
        }
        return Math.max(left, right);
    }

}
