package com.shrek.leetCode._007_LinkedList;

/**
 *
 * Given the head of a sorted linked list,
 * delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 *
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 *
 */

import java.util.*;

public class _064M_RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,3,4,4,5};
        ListNode l1 = makeLL(arr1);
        System.out.println("deleteDuplicates for Linked lists l1 = "+ Arrays.toString(arr1)+" is " + deleteDuplicates(l1));
        // [1,2,5]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{1,1,1,2,3};
        l1 = makeLL(arr1);
        System.out.println("deleteDuplicates for Linked lists l1 = "+ Arrays.toString(arr1)+" is " + deleteDuplicates(l1));
        // [2,3]
        System.out.println("-------------- BREAK -----------------");
    }

    static ListNode makeLL(int[] arr){
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        ListNode newNode;
        for(int i=0;i<arr.length;i++){
            newNode = new ListNode(arr[i]);
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

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummyHead.next;
    }

    // Using map very inefficient
    /*public static ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        ListNode ptr = head;
        int count = 0;
        while (ptr!=null) {
            count = map.getOrDefault(ptr.val, 0);
            map.put(ptr.val, count+1);
            ptr =  ptr.next;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        ListNode newNode;
        for(int i: map.keySet()){
            if(map.get(i)<=1){
                newNode = new ListNode(i);
                prev.next = newNode;
                prev = newNode;
            }
        }
        ListNode node = dummyHead.next;
        while(node!=null){
            System.out.println("node val = "+node.val);
            node = node.next;
        }
        return dummyHead.next;
    }*/

}
