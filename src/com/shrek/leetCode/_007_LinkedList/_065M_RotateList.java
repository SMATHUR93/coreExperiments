package com.shrek.leetCode._007_LinkedList;

import java.util.Arrays;

/**
 * 
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 *
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 * 
 */

public class _065M_RotateList {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        ListNode l1 = makeLL(arr1);
        int n=2;
        System.out.println("rotateRight for Linked lists l1 = "+ Arrays.toString(arr1)+" , n = "+n+" is " + rotateRight(l1, n));
        // [4,5,1,2,3]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{0,1,2};
        l1 = makeLL(arr1);
        n=4;
        System.out.println("rotateRight for Linked lists l1 = "+ Arrays.toString(arr1)+" , n = "+n+" is " + rotateRight(l1, n));
        // [2,0,1]
        System.out.println("-------------- BREAK -----------------");

        arr1 = new int[]{1,2};
        l1 = makeLL(arr1);
        n=2;
        System.out.println("rotateRight for Linked lists l1 = "+ Arrays.toString(arr1)+" , n = "+n+" is " + rotateRight(l1, n));
        // [1,2]
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

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        if(k==0){
            return head;
        }
        if(head!=null && head.next==null){
            return head;
        }
        int n = 0;
        ListNode temp = head;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        ListNode dummyHeadForFirstHalf = new ListNode();
        ListNode dummyHeadForSecondHalf = new ListNode();
        ListNode dummyHeadForOutput = new ListNode();
        ListNode prev;
        if(k%n!=0){
            k = k%n;
            prev = dummyHeadForSecondHalf;
            temp =  head;
            for(int i=0;i<n-k;i++){
                System.out.println("Debugging loop 1 , temp = "+temp.val);
                ListNode newNode = new ListNode(temp.val);
                prev.next = newNode;
                prev = newNode;
                temp =  temp.next;
            }
            prev = dummyHeadForFirstHalf;
            for(int i=0;i<k;i++){
                System.out.println("Debugging loop 2 , temp = "+temp.val);
                ListNode newNode = new ListNode(temp.val);
                prev.next = newNode;
                prev = newNode;
                temp =  temp.next;
            }
            prev = dummyHeadForOutput;
            ListNode temp1 = dummyHeadForFirstHalf.next;
            ListNode temp2 = dummyHeadForSecondHalf.next;
            for(int i=1;i<=n;i++){
                ListNode newNode;
                if(i<=k){
                    newNode = new ListNode(temp1.val);
                    temp1 = temp1.next;
                } else{
                    newNode= new ListNode(temp2.val);
                    temp2 = temp2.next;
                }
                System.out.println("Debugging loop 3 , newNode = "+newNode.val);
                prev.next = newNode;
                prev = newNode;
            }
        } else {
            dummyHeadForOutput.next = head;
        }


        ListNode node = dummyHeadForOutput.next;
        while(node!=null){
            System.out.println("node val = "+node.val);
            node = node.next;
        }
        return null;
    }

    // Just rotating , exceeds lime limit
    /*public static ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        if(k==0){
            return head;
        }
        if(head!=null && head.next==null){
            return head;
        }
        ListNode ptr =  head;
        ListNode dummyHead = new ListNode(0, ptr);
        ListNode prev = dummyHead;
        for(int i=0;i<k;i++){
            prev = dummyHead;
            while(ptr!=null){
                if(ptr.next==null){
                    ptr.next = dummyHead.next;
                    prev.next = null;
                    dummyHead.next = ptr;
                    break;
                } else {
                    prev = prev.next;
                }
                ptr = ptr.next;
            }
        }
        ListNode node = dummyHead.next;
        while(node!=null){
            System.out.println("node val = "+node.val);
            node = node.next;
        }
        return null;
    }*/
    
}
