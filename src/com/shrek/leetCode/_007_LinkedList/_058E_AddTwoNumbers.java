package com.shrek.leetCode._007_LinkedList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 *You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 *
 */

public class _058E_AddTwoNumbers {

    public static void main(String[] args) {

        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};
        ListNode l1 = makeLL(arr1);
        ListNode l2 = makeLL(arr2);
        System.out.println("addTwoNumbers for Linked lists l1 = "+ Arrays.toString(arr1)+" ,l2 = "+Arrays.toString(arr2)+" is " + addTwoNumbers(l1, l2));
        // [7,0,8]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{0};
        arr2 = new int[]{0};
        l1 = makeLL(arr1);
        l2 = makeLL(arr2);
        System.out.println("addTwoNumbers for Linked lists l1 = "+ Arrays.toString(arr1)+" ,l2 = "+Arrays.toString(arr2)+" is " + addTwoNumbers(l1, l2));
        // [0]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{9,9,9,9,9,9,9};
        arr2 = new int[]{9,9,9,9};
        l1 = makeLL(arr1);
        l2 = makeLL(arr2);
        System.out.println("addTwoNumbers for Linked lists l1 = "+ Arrays.toString(arr1)+" ,l2 = "+Arrays.toString(arr2)+" is " + addTwoNumbers(l1, l2));
        // [8,9,9,9,0,0,0,1]
        System.out.println("-------------- BREAK -----------------");

    }

    static ListNode makeLL(int[] arr){
        ListNode head = new ListNode(arr[0], null);
        ListNode prev = head;
        ListNode newNode;
        for(int i=1;i<arr.length;i++){
            newNode = new ListNode(arr[i], null);
            prev.next = newNode;
            prev = newNode;
        }
        return head;
    }

    static void showLL(ListNode head){
        ListNode node = head;
        while(node!=null){
            System.out.println("node val = "+node.val);
            node = node.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = null;
        ListNode prev = out;
        ListNode newNode;
        int carry = 0;
        int digit = 0;
        int val1, val2, sum=0;
        while(l1!=null || l2!=null){
            val1 = l1!=null ? l1.val : 0;
            val2 = l2!=null ? l2.val : 0;
            System.out.println("Iteration check, val1 = "+val1+" , val2 = "+val2);
            sum = val1 + val2 + carry;
            if(sum>=10){
                carry = sum / 10;
                digit = sum % 10;
                boolean l1NextNull = l1!=null ? l1.next==null : true;
                boolean l2NextNull = l2!=null ? l2.next==null : true;
                boolean bothNextNUll = l1NextNull && l2NextNull;
                if(bothNextNUll){
                    System.out.println("Last more than 10 Carry Case check, val1 = "+val1+" , val2 = "+val2+" , sum = "+sum+" , digit = "+digit+" , carry = "+carry);
                    newNode = new ListNode(digit, null);
                    if(prev==null){
                        out =  newNode;
                        prev = newNode;
                    } else{
                        prev.next = newNode;
                    }
                    prev = newNode;
                    newNode = new ListNode(carry, null);
                    prev.next = newNode;
                    prev = newNode;
                } else{
                    System.out.println("Normal more than 10 Carry Case check, val1 = "+val1+" , val2 = "+val2+" , sum = "+sum+" , digit = "+digit+" , carry = "+carry);
                    newNode = new ListNode(digit, null);
                    if(prev==null){
                        out =  newNode;
                        prev = newNode;
                    } else{
                        prev.next = newNode;
                    }
                    prev = newNode;
                }
            } else{
                newNode = new ListNode(sum, null);
                if(prev==null){
                    out =  newNode;
                    prev = newNode;
                } else{
                    prev.next = newNode;
                }
                prev = newNode;
                carry = 0;
                digit = 0;
            }
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
            System.out.println();
        }

        System.out.println("Debugging: Start");
        ListNode node = out;
        while(node!=null){
            System.out.println("node val = "+node.val);
            node = node.next;
        }
        System.out.println("Debugging: End");

        return out;
    }

}
