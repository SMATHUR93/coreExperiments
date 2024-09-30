package com.shrek.leetCode._007_LinkedList;

/**
 * 
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. 
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * 
 * 
 * Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 * 
 */

import java.util.Arrays;
import java.util.Stack;

public class _062H_ReverseNodesInKGroup {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        ListNode l1 = makeLL(arr1);
        int k=2;
        System.out.println("reverseKGroup for Linked lists l1 = "+ Arrays.toString(arr1)+" , k = "+k+" is " + reverseKGroup(l1, k));
        // [2,1,4,3,5]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{1,2,3,4,5};
        l1 = makeLL(arr1);
        k=3;
        System.out.println("reverseKGroup for Linked lists l1 = "+ Arrays.toString(arr1)+" , k = "+k+" is " + reverseKGroup(l1, k));
        // [3,2,1,4,5]
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

    public static ListNode reverseKGroup(ListNode head, int k) {
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        ListNode ptr = head;
        ListNode slowPtr;
        ListNode fastPtr;
        while(ptr!=null){
            slowPtr = ptr;
            fastPtr = ptr;
            count=0;
            while(count<k && fastPtr!=null){
                count++;
                stack.push(fastPtr.val);
                System.out.println("Debugging push, count = "+count+" , fastPtr.val = "+fastPtr.val+" , slowPtr.val = "+slowPtr.val+" , ptr.val = "+ptr.val+" , k = "+k);
                fastPtr = fastPtr.next;
            }
            if(count!=k){
                slowPtr = slowPtr.next;
            } else{
                while(slowPtr!=fastPtr){
                    System.out.println("Debugging pop, count = "+count+" , stack.peek() = "+stack.peek());
                    slowPtr.val = stack.pop();
                    slowPtr = slowPtr.next;
                }
            }
            ptr = slowPtr;
        }

        ListNode node = head;
        while(node!=null){
            System.out.println("node val = "+node.val);
            node = node.next;
        }
        return head;
    }

}
