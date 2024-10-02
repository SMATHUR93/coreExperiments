package com.shrek.leetCode._008_BinaryTreeGeneral;

/**
 *
 * Given two integer arrays inorder and postorder
 * where inorder is the inorder traversal of a binary tree
 * and postorder is the postorder traversal of the same tree,
 * construct and return the binary tree.
 *
 * Example 1:
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 * Constraints:
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 *
 */

import java.util.*;

public class _073M_ConstructBinaryTreeFromInorderAndPostorder {

    public static void main(String[] args) {

        /*int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root1 = buildTree(preorder, inorder);
        System.out.println("buildTree for Tree preorder = "+ Arrays.toString(preorder)+" and Tree inorder = "+ Arrays.toString(inorder)+" is ");
        printLevelOrder(root1);
        System.out.println("-------------- BREAK -----------------");

        preorder = new int[]{3,9,20,15,7};
        inorder = new int[]{9,3,15,20,7};
        root1 = buildTree(preorder, inorder);
        System.out.println("buildTree for Tree preorder = "+ Arrays.toString(preorder)+" and Tree inorder = "+ Arrays.toString(inorder)+" is ");
        printLevelOrder(root1);
        System.out.println("-------------- BREAK -----------------");*/
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

    public static int postorderIndex = 0;
    public static Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length-1;
        inorderIndexMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(inorder, postorder, 0, postorder.length - 1);
    }
    public static TreeNode arrayToTree(int[] inorder, int[] postorder,int left, int right){
        if(left > right){
            return null;
        }
        int rootVal = postorder[postorderIndex];
        TreeNode root = new TreeNode(rootVal);
        postorderIndex--;
        int index = inorderIndexMap.get(rootVal);
        root.right = arrayToTree(
                inorder,
                postorder,
                index + 1,
                right
        );
        root.left = arrayToTree(
                inorder,
                postorder,
                left,
                index -1
        );
        return root;
    }

}
