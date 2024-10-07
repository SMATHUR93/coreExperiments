package com.shrek.leetCode._010_BinarySearchTree;

import java.util.*;

/**
 *
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Example 1:
 * Input: root = [3,1,4,null,2],
 * k = 1
 * Output: 1
 *
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1],
 * k = 3
 * Output: 3
 *
 * Constraints:
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 * Follow up:
 * If the BST is modified often (i.e., we can do insert and delete operations)
 * and you need to find the kth smallest frequently, how would you optimize?
 *
 * Hint 1
 * Try to utilize the property of a BST.
 *
 * Hint 2
 * Try in-order traversal.
 *
 * Hint 3
 * What if you could modify the BST node's structure?
 *
 * Hint 4
 * The optimal runtime complexity is O(height of BST).
 *
 */

public class _087M_KthSmallestElementInBST {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{3,1,4,null,2};
        int k = 1;
        TreeNode root = makeTree(arr1);
        System.out.println("kthSmallest for Tree l1 = " + Arrays.toString(arr1) + " is " + kthSmallest(root, k));
        // printLevelOrder(root);
        // 1
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{5,3,6,2,4,null,null,1};
        k = 3;
        root = makeTree(arr1);
        System.out.println("kthSmallest for Tree l1 = " + Arrays.toString(arr1) + " is " + kthSmallest(root, k));
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

    public static List<Integer> ll;
    public static int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        ll = new ArrayList<>();
        inOrder(root);
        System.out.println(ll.toString());
        return ((k-1>=0 && k-1<=ll.size()-1)?ll.get(k-1):0);
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
