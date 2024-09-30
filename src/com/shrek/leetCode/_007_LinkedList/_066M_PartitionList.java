package com.shrek.leetCode._007_LinkedList;

import java.util.Arrays;

/**
 *
 * Given the head of a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * Example 2:
 *
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 *
 */

public class _066M_PartitionList {

    public static void main(String[] args) {
        int[] arr1 = {1,4,3,2,5,2};
        ListNode l1 = makeLL(arr1);
        int n=3;
        System.out.println("partition for Linked lists l1 = "+ Arrays.toString(arr1)+" , n = "+n+" is " + partition(l1, n));
        // [1,2,2,4,3,5]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{2,1};
        l1 = makeLL(arr1);
        n=2;
        System.out.println("partition for Linked lists l1 = "+ Arrays.toString(arr1)+" , n = "+n+" is " + partition(l1, n));
        // [1,2]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{-8,-7,7,5,3,-7,-8,-1,9,-2,4,6,-4,-1,3,0,4,-8,-8,-8,8,6,-4,-4};
        l1 = makeLL(arr1);
        n=0;
        System.out.println("partition for Linked lists l1 = "+ Arrays.toString(arr1)+" , n = "+n+" is " + partition(l1, n));
        // [[-8,-7,-7,-8,-1,-2,-4,-1,-8,-8,-8,-4,-4,7,5,3,9,4,6,3,0,4,8,6]]
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
    
    public static ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }
        if(head!=null && head.next==null){
            return head;
        }

        ListNode dummyHeadForFirstHalf = new ListNode();
        ListNode dummyHeadForSecondHalf = new ListNode();
        ListNode temp1 = dummyHeadForFirstHalf;
        ListNode temp2 = dummyHeadForSecondHalf;

        ListNode temp = head;
        while(temp!=null){
            ListNode newNode = new ListNode(temp.val);
            if(temp.val>=x){
                temp2.next = newNode;
                temp2 = newNode;
            } else{
                temp1.next = newNode;
                temp1 = newNode;
            }
            temp = temp.next;
        }

        temp1 = dummyHeadForFirstHalf.next;
        temp2 = dummyHeadForSecondHalf.next;

        ListNode dummyHeadForOutput = new ListNode();
        temp = dummyHeadForOutput;
        while(temp1!=null){
            ListNode newNode = new ListNode(temp1.val);
            temp.next = newNode;
            temp = newNode;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            ListNode newNode = new ListNode(temp2.val);
            temp.next = newNode;
            temp = newNode;
            temp2 = temp2.next;
        }

        ListNode node = dummyHeadForOutput.next;
        while(node!=null){
            System.out.println("node val = "+node.val);
            node = node.next;
        }
        return dummyHeadForOutput.next;
    }

}
