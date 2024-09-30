package com.shrek.leetCode._008_BinaryTreeGeneral;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 * 
 * Hint 1
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 *
 */

public class _075M_FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{1,2,5,3,4,null,6};
        TreeNode root = makeTree(arr1);
        flatten(root);
        System.out.println("flatten for Tree l1 = " + Arrays.toString(arr1) + " is ");
        printLevelOrder(root);
        // [1,null,2,null,3,null,4,null,5,null,6]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{};
        root = makeTree(arr1);
        flatten(root);
        System.out.println("flatten for Tree l1 = " + Arrays.toString(arr1) + " is ");
        printLevelOrder(root);
        // []
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{0};
        root = makeTree(arr1);
        flatten(root);
        System.out.println("flatten for Tree l1 = " + Arrays.toString(arr1) + " is ");
        printLevelOrder(root);
        // [0]
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

    /**
     *
     *
     * Algorithm
     *
     * So basically, this is going to be a super short algorithm and a short-er implementation
     *
     * We use a pointer for traversing the nodes of our tree starting from the root. We have a loop that keeps going until the node pointer becomes null which is when we would be done processing the entire tree.
     *
     * For every node we check if it has a left child or not. If it doesn't we simply move on to the right hand side i.e.
     *
     *  node = node.right
     * If the node does have a left child, we find the first node on the rightmost branch of the left subtree which doesn't have a right child i.e. the almost rightmost node.
     *
     *  rightmost = node.left
     *  while rightmost != null:
     *  rightmost = rightmost.right
     * Once we find this rightmost node, we rewire the connections as explained in the intuition section.
     *
     *  rightmost.right = node.right
     *  node.right = node.left
     *  node.left = null
     *
     * @param root
     */
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }

}
