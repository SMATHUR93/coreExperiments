package com.shrek.leetCode._008_BinaryTreeGeneral;

/**
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 *
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 *
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 *
 *
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 *
 * Constraints:
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 *
 *
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _069E_SameTree {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{1,2,3};
        TreeNode root1 = makeTree(arr1);
        Integer[] arr2 = new Integer[]{1,2,3};
        TreeNode root2 = makeTree(arr2);
        // printLevelOrder(root);
        System.out.println("maxDepth for Tree l1 = "+ Arrays.toString(arr1)+" , Tree l2 = "+ Arrays.toString(arr2)+" is " + isSameTree(root1, root2));
        // true
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1,2};
        root1 = makeTree(arr1);
        arr2 = new Integer[]{1,null,2};
        root2 = makeTree(arr2);
        // printLevelOrder(root);
        System.out.println("maxDepth for Tree l1 = "+ Arrays.toString(arr1)+" , Tree l2 = "+ Arrays.toString(arr2)+" is " + isSameTree(root1, root2));
        // false
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1,2,1};
        root1 = makeTree(arr1);
        arr2 = new Integer[]{1,1,2};
        root2 = makeTree(arr2);
        // printLevelOrder(root);
        System.out.println("maxDepth for Tree l1 = "+ Arrays.toString(arr1)+" , Tree l2 = "+ Arrays.toString(arr2)+" is " + isSameTree(root1, root2));
        // false
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1,null,1};
        root1 = makeTree(arr1);
        arr2 = new Integer[]{1,null,1};
        root2 = makeTree(arr2);
        // printLevelOrder(root);
        System.out.println("maxDepth for Tree l1 = "+ Arrays.toString(arr1)+" , Tree l2 = "+ Arrays.toString(arr2)+" is " + isSameTree(root1, root2));
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

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null && q!=null){
            return false;
        }
        if(p!=null && q==null){
            return false;
        }
        return sameTreeRec(p, q);
    }

    public static boolean sameTreeRec(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean left = true;
        boolean right = true;
        left = sameTreeRec(p.left, q.left);
        right = sameTreeRec(p.right, q.right);
        return left && right;
    }
    
}
