package com.shrek.leetCode._008_BinaryTreeGeneral;

/**
 *
 * Given a binary tree
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 *
 * Explanation: Given the above binary tree (Figure A),
 * your function should populate each next pointer to point to its next right node,
 * just like in Figure B.
 * The serialized output is in level order as connected by the next pointers,
 * with '#' signifying the end of each level.
 *
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 6000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow-up:
 *
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 *
 */

import java.util.*;

public class _074M_PopulatingNextRightPointersInEachNodeII {

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1,2,3,4,5,null,7};
        Node root1 = makeTree(arr1);
        // printLevelOrder(root);
        System.out.println("connect for Tree l1 = "+ Arrays.toString(arr1)+" is " + connect(root1));
        // 1,#,2,3,#,4,5,7,#
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{1,2,2,null,3,null,3};
        root1 = makeTree(arr1);
        // printLevelOrder(root);
        System.out.println("connect for Tree l1 = "+ Arrays.toString(arr1)+" is " + connect(root1));
        // false
        System.out.println("-------------- BREAK -----------------");

        arr1 = new Integer[]{0,0,0,0,null,null,0,null,null,null,0};
        root1 = makeTree(arr1);
        // printLevelOrder(root);
        System.out.println("connect for Tree l1 = "+ Arrays.toString(arr1)+" is " + connect(root1));
        // false
        System.out.println("-------------- BREAK -----------------");
    }

    // Arrays is in level order so use queue to implement BFS traversal
    public static Node makeTree(Integer[] arr){
        System.out.println("makeTree for arr = "+ Arrays.toString(arr));
        if(arr.length==0 || arr[0]==null){
            return null;
        }
        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i=1;
        Node left, right;
        while(!queue.isEmpty() && i<arr.length){
            Node current = queue.poll();

            if(i<=arr.length-1 && arr[i]!=null){
                left = new Node(arr[i]);
                current.left = left;
                queue.add(left);
            }
            i++;
            if(i<=arr.length-1 && arr[i]!=null){
                right = new Node(arr[i]);
                current.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }

    public static void printLevelOrder(Node root) {
        Node temp;
        Queue<Node> queue = new LinkedList<>();
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
        System.out.println();
    }
    
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static Node connect(Node root) {
        if(root==null){
            return null;
        }
        Node temp, next;
        Map<Node, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.next = null;
        map.put(root, 1);
        while(!queue.isEmpty()){
            temp = queue.poll();
            next = queue.peek();
            if(temp.left!=null) {
                queue.add(temp.left);
                map.put(temp.left, map.get(temp)+1);
            }
            if(temp.right!=null) {
                queue.add(temp.right);
                map.put(temp.right, map.get(temp)+1);
            }
            if(next!=null && map.get(temp)==map.get(next)){
                temp.next = queue.peek();
            } else{
                temp.next = null;
            }
            System.out.println("DEBUGGING EACH NODE IN QUEUE, temp.val = "+temp.val+", temp.next.val = "+(temp.next!=null?temp.next.val:"X")+" !! ");
        }
        return root;
    }

}
