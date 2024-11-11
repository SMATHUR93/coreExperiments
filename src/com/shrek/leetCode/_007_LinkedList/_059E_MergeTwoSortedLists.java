package com.shrek.leetCode._007_LinkedList;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */

import java.util.Arrays;

public class _059E_MergeTwoSortedLists {

    public static void main(String[] args) {

        int[] arr1 = {1,2,4};
        int[] arr2 = {1,3,4};
        ListNode l1 = makeLL(arr1);
        ListNode l2 = makeLL(arr2);
        System.out.println("mergeTwoLists for Linked lists l1 = "+ Arrays.toString(arr1)+" ,l2 = "+Arrays.toString(arr2)+" is " + mergeTwoLists(l1, l2));
        // [1,1,2,3,4,4]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{};
        arr2 = new int[]{};
        l1 = makeLL(arr1);
        l2 = makeLL(arr2);
        System.out.println("mergeTwoLists for Linked lists l1 = "+ Arrays.toString(arr1)+" ,l2 = "+Arrays.toString(arr2)+" is " + mergeTwoLists(l1, l2));
        // []
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{};
        arr2 = new int[]{0};
        l1 = makeLL(arr1);
        l2 = makeLL(arr2);
        System.out.println("mergeTwoLists for Linked lists l1 = "+ Arrays.toString(arr1)+" ,l2 = "+Arrays.toString(arr2)+" is " + mergeTwoLists(l1, l2));
        // [0]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{1,2,4,7};
        arr2 = new int[]{5,6};
        l1 = makeLL(arr1);
        l2 = makeLL(arr2);
        System.out.println("mergeTwoLists for Linked lists l1 = "+ Arrays.toString(arr1)+" ,l2 = "+Arrays.toString(arr2)+" is " + mergeTwoLists(l1, l2));
        // [1,2,4,5,6,7]
        System.out.println("-------------- BREAK -----------------");

    }

    static ListNode makeLL(int[] arr){
        ListNode dummyHead = new ListNode();
        ListNode prev = dummyHead;
        ListNode newNode;
        for(int i=0;i<arr.length;i++){
            newNode = new ListNode(arr[i], null);
            prev.next = newNode;
            prev = newNode;
        }
        return dummyHead.next;
    }

    static void showLL(ListNode head){
        ListNode node = head;
        while(node!=null){
            System.out.println("node val = "+node.val);
            node = node.next;
        }
    }
    
    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode left, ListNode right){
        ListNode dummyHead =  new ListNode();
        ListNode curr = dummyHead;
        while(left!=null && right!=null){
            if(left.val < right.val){
                curr.next=left;
                left=left.next;
                curr = curr.next;
            } else{
                curr.next=right;
                right=right.next;
                curr = curr.next;
            }
        }
        curr.next = (left != null) ? left : right;

        System.out.println("Debugging: Start");
        ListNode node = dummyHead.next;
        while(node!=null){
            System.out.println("node val = "+node.val);
            node = node.next;
        }
        System.out.println("Debugging: End");

        return dummyHead.next;
    }
    
    /*public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode prev = dummyHead;
        ListNode newNode;
        int val=0;
        while(list1!=null || list2!=null){
            if(list1==null){
                val = list2.val;
                list2 = list2.next;
            } else if(list2==null){
                val = list1.val;
                list1 = list1.next;
            } else if(list1.val<list2.val){
                val = list1.val;
                list1 = list1.next;
            } else if(list1.val>=list2.val){
                val = list2.val;
                list2 = list2.next;
            }
            newNode = new ListNode(val, null);
            prev.next = newNode;
            prev = newNode;
        }

        System.out.println("Debugging: Start");
        ListNode node = dummyHead.next;
        while(node!=null){
            System.out.println("node val = "+node.val);
            node = node.next;
        }
        System.out.println("Debugging: End");

        return dummyHead.next;
    }*/
    
}
