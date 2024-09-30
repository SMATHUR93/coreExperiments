package com.shrek.leetCode._007_LinkedList;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 *
 * Example 2:
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 *
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 * Follow up: Could you do it in one pass?
 *
 */

public class _061M_ReverseLinkedListII {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        ListNode l1 = makeLL(arr1);
        int left = 2;
        int right = 4;
        System.out.println("reverseBetween for Linked lists l1 = "+ Arrays.toString(arr1)+" , left = "+left+" , right = "+right+" is " + reverseBetween(l1, left, right));
        // [1,4,3,2,5]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{5};
        l1 = makeLL(arr1);
        left = 1;
        right = 1;
        System.out.println("reverseBetween for Linked lists l1 = "+ Arrays.toString(arr1)+" , left = "+left+" , right = "+right+" is " + reverseBetween(l1, left, right));
        // [5]
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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        ListNode node = head;
        while(node!=null){
            count++;
            if(count>=left && count<=right){
                System.out.println("Debugging push, count = "+count+" , node.val = "+node.val);
                stack.push(node.val);
            }
            node = node.next;
        }
        count = 0;
        node = head;
        while(node!=null){
            count++;
            if(count>=left && count<=right){
                System.out.println("Debugging pop, count = "+count+" , stack.peek() = "+stack.peek());
                node.val = stack.pop();
            }
            node = node.next;
        }
        node = head;
        while(node!=null){
            System.out.println("node val = "+node.val);
            node = node.next;
        }
        return head;
    }

    // Revers without range
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode ptr = head;
        while(ptr!=null){
            ListNode nextNode = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = nextNode;
        }
        return prev;
    }

}
