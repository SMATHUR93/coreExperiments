package com.shrek.leetCode._009_BinaryTreeBFS;

import java.util.*;

/**
 *
 * Given the root of a binary tree,
 * return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 *
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 *
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 *
 */

public class _085M_BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = makeTree(arr1);
        System.out.println("zigzagLevelOrder for Tree l1 = " + Arrays.toString(arr1) + " is " + zigzagLevelOrder(root));
        // printLevelOrder(root);
        // [[3],[20,9],[15,7]]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1};
        root = makeTree(arr1);
        System.out.println("zigzagLevelOrder for Tree l1 = " + Arrays.toString(arr1) + " is " + zigzagLevelOrder(root));
        // printLevelOrder(root);
        // [[1]]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{};
        root = makeTree(arr1);
        System.out.println("zigzagLevelOrder for Tree l1 = " + Arrays.toString(arr1) + " is " + zigzagLevelOrder(root));
        // printLevelOrder(root);
        // []
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
    
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> out = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp;
        boolean fifo=true;
        while(!queue.isEmpty()){
            int currentLevel = queue.size();
            List<Integer> ll = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<currentLevel;i++){
                temp = queue.poll();
                if(fifo==true){
                    ll.add(temp.val);
                } else{
                    stack.push(temp.val);
                }
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            if(fifo==false){
                while(!stack.empty()){
                    ll.add(stack.pop());
                }
            }
            out.add(ll);
            fifo=!fifo;
        }
        return out;
    }

}
