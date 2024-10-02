package com.shrek.leetCode._009_BinaryTreeBFS;

import java.util.*;

/**
 *
 * Given the root of a binary tree,
 * imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * Example 1:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 *
 * Example 2:
 * Input: root = [1,null,3]
 * Output: [1,3]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 */

public class _082M_BinaryTreeRightSideView {

    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{1,2,3,null,5,null,4};
        TreeNode root = makeTree(arr1);
        System.out.println("rightSideView for Tree l1 = " + Arrays.toString(arr1) + " is " + rightSideView(root));
        // printLevelOrder(root);
        // 1,2,3,null,5,null,4
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1,null,3};
        root = makeTree(arr1);
        System.out.println("rightSideView for Tree l1 = " + Arrays.toString(arr1) + " is " + rightSideView(root));
        // printLevelOrder(root);
        // [1,3]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{};
        root = makeTree(arr1);
        System.out.println("rightSideView for Tree l1 = " + Arrays.toString(arr1) + " is " + rightSideView(root));
        // printLevelOrder(root);
        // []
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1,2,3,4};
        root = makeTree(arr1);
        System.out.println("rightSideView for Tree l1 = " + Arrays.toString(arr1) + " is " + rightSideView(root));
        // printLevelOrder(root);
        // [1,3,4]
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

    public static List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> ll = new ArrayList<>();
        TreeNode temp;
        Queue<TreeNode> queue =  new LinkedList<>();
        int levelLength = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            levelLength = queue.size();
            for(int i=0;i<levelLength;i++){
                temp = queue.poll();
                if(i==(levelLength-1)){
                    ll.add(temp.val);
                }
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
        System.out.println(ll.toString());
        return ll;
    }

}
