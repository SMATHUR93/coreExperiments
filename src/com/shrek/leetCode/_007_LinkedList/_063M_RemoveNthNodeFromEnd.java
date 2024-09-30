package com.shrek.leetCode._007_LinkedList;

import java.util.Arrays;
import java.util.List;

/**
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * Follow up: Could you do this in one pass?
 *
 * Hint 1
 * Maintain two pointers and update one with a delay of n steps.
 *
 */

public class _063M_RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        ListNode l1 = makeLL(arr1);
        int n=2;
        System.out.println("removeNthFromEnd for Linked lists l1 = "+ Arrays.toString(arr1)+" , n = "+n+" is " + removeNthFromEnd(l1, n));
        // [1,2,3,5]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{1};
        l1 = makeLL(arr1);
        n=1;
        System.out.println("removeNthFromEnd for Linked lists l1 = "+ Arrays.toString(arr1)+" , n = "+n+" is " + removeNthFromEnd(l1, n));
        // []
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{1,2};
        l1 = makeLL(arr1);
        n=1;
        System.out.println("removeNthFromEnd for Linked lists l1 = "+ Arrays.toString(arr1)+" , n = "+n+" is " + removeNthFromEnd(l1, n));
        // [1]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{1,2};
        l1 = makeLL(arr1);
        n=2;
        System.out.println("removeNthFromEnd for Linked lists l1 = "+ Arrays.toString(arr1)+" , n = "+n+" is " + removeNthFromEnd(l1, n));
        // [2]
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        /*if(n==1 && head!=null && head.next==null){
            return null;
        }*/
        ListNode ptr = head;
        ListNode ptrPlusN = head;
        int count = 1;
        while(count<n && ptrPlusN!=null){
            count++;
            ptrPlusN = ptrPlusN.next;
        }
        System.out.println("Debugging A, count = "+count+" , ptr.val = "+ptr.val+" , ptrPlusN.val = "+ptrPlusN.val);
        ListNode prev = ptr;
        while(ptrPlusN.next!=null){
            prev = ptr;
            ptr = ptr.next;
            ptrPlusN = ptrPlusN.next;
        }
        System.out.println("Debugging B, count = "+count+" , prev.val = "+prev.val+" , ptr.val = "+ptr.val+" , ptrPlusN.val = "+ptrPlusN.val);
        if(prev!=ptr){
            prev.next = ptr.next;
        } else{
            head = ptr.next;
        }
        ListNode node = head;
        while(node!=null){
            System.out.println("node val = "+node.val);
            node = node.next;
        }
        return head;
    }

}
