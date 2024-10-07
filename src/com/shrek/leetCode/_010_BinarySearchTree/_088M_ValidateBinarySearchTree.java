package com.shrek.leetCode._010_BinarySearchTree;

import java.util.*;

/**
 *
 * Given the root of a binary tree,
 * determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 *
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 *
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 *
 */

public class _088M_ValidateBinarySearchTree {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{2,1,3};
        TreeNode root = makeTree(arr1);
        System.out.println("isValidBST for Tree l1 = " + Arrays.toString(arr1) + " is " + isValidBST(root));
        // printLevelOrder(root);
        // true
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{5,1,4,null,null,3,6};
        root = makeTree(arr1);
        System.out.println("isValidBST for Tree l1 = " + Arrays.toString(arr1) + " is " + isValidBST(root));
        // printLevelOrder(root);
        // false
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{2,2,2};
        root = makeTree(arr1);
        System.out.println("isValidBST for Tree l1 = " + Arrays.toString(arr1) + " is " + isValidBST(root));
        // printLevelOrder(root);
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

    public static List<Integer> ll;
    public static boolean isValidBST(TreeNode root) {
        ll = new ArrayList<>();
        inOrder(root);
        boolean isValid = true;
        for(int i=1;i<ll.size();i++){
            if(ll.get(i-1)>=ll.get(i)){
                isValid=false;
                break;
            }
        }
        return isValid;
    }

    public static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        ll.add(root.val);
        inOrder(root.right);
    }

}
