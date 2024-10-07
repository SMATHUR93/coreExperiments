package com.shrek.leetCode._009_BinaryTreeBFS;

import java.util.*;

/**
 * 
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 *
 *
 * Example 2:
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 *
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 * 
 */

public class _083E_AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = makeTree(arr1);
        System.out.println("averageOfLevels for Tree l1 = " + Arrays.toString(arr1) + " is " + averageOfLevels(root));
        // printLevelOrder(root);
        // [3.00000,14.50000,11.00000]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{3,9,20,15,7};
        root = makeTree(arr1);
        System.out.println("averageOfLevels for Tree l1 = " + Arrays.toString(arr1) + " is " + averageOfLevels(root));
        // printLevelOrder(root);
        // [3.00000,14.50000,11.00000]
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
    
    public static List<Double> averageOfLevels(TreeNode root) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> ll = new ArrayList<>();
        TreeNode temp;
        while(!queue.isEmpty()){
            int currentLength = queue.size();
            double sum = 0;
            for(int i=0;i<currentLength;i++){
                temp = queue.poll();
                sum+=temp.val;
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            double d = (double) (sum/currentLength);
            ll.add(d);
        }
        return ll;
    }

}
