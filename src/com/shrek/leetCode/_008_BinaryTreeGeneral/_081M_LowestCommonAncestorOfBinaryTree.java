package com.shrek.leetCode._008_BinaryTreeGeneral;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 * 
 */

public class _081M_LowestCommonAncestorOfBinaryTree {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = makeTree(arr1);
        TreeNode p =  new TreeNode(5);
        TreeNode q =  new TreeNode(1);
        System.out.println("lowestCommonAncestor for Tree l1 = " + Arrays.toString(arr1) + " is " + lowestCommonAncestor(root, p, q));
        // printLevelOrder(root);
        // 3
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        root = makeTree(arr1);
        p =  new TreeNode(5);
        q =  new TreeNode(4);
        System.out.println("lowestCommonAncestor for Tree l1 = " + Arrays.toString(arr1) + " is " + lowestCommonAncestor(root, p, q));
        // printLevelOrder(root);
        // 5
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1,2};
        root = makeTree(arr1);
        p =  new TreeNode(1);
        q =  new TreeNode(2);
        System.out.println("lowestCommonAncestor for Tree l1 = " + Arrays.toString(arr1) + " is " + lowestCommonAncestor(root, p, q));
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

    public static TreeNode tn;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        tn=null;
        por(root, p, q);
        return tn;
    }
    public static boolean por(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return false;
        }
        boolean left = por(root.left, p, q);
        boolean right = por(root.right, p, q);
        boolean own = false;
        if(root==p || root==q){
            own = true;
        }
        if((left&&right) || (left&&own) || (own&&right)){
            tn = root;
        }
        return left||right||own;
    }

}
