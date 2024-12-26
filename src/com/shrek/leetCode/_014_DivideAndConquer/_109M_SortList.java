package com.shrek.leetCode._014_DivideAndConquer;

import java.util.Arrays;

/**
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Example 1:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 *  Example 2:
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 *
 *  Example 3:
 * Input: head = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 *
 */

public class _109M_SortList {

    public static void main(String[] args) {
        int[] arr1;
        ListNode head;

        arr1 = new int[]{4,2,1,3};
        head = makeLL(arr1);
        System.out.println("sortList for nums = "+ Arrays.toString(arr1) +" equals ");
        showLL(sortList(head));
        // [1,2,3,4]
        System.out.println();

        arr1 = new int[]{-1,5,3,4,0};
        head = makeLL(arr1);
        System.out.println("sortList for nums = "+ Arrays.toString(arr1) +" equals ");
        showLL(sortList(head));
        // [-1,0,3,4,5]
        System.out.println();

        arr1 = new int[]{};
        head = makeLL(arr1);
        System.out.println("sortList for nums = "+ Arrays.toString(arr1) +" equals ");
        showLL(sortList(head));
        // []
        System.out.println();

    }

    static void showLL(ListNode head){
        ListNode node = head;
        System.out.println("Starting itration ");
        while(node!=null){
            System.out.println("node val = "+node.val);
            node = node.next;
        }
        System.out.println("Complete itration ");
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
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeList(left, right);
    }

    public static ListNode mergeList(ListNode left, ListNode right){
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
        return dummyHead.next;
    }

    public static ListNode findMiddle(ListNode head){
        ListNode slow=null, fast=head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = (slow==null) ? head : slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    // brute force
    /*public static ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        // ListNode root = head;
        // ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode iPtr = head;
        ListNode jPtr = head;
        int temp;
        while(iPtr!=null){
            // System.out.println("Debugging, iPtr.val = "+iPtr.val);
            jPtr=head;
            while(jPtr!=null){
                // System.out.println("    Debugging, jPtr.val = "+ jPtr.val);
                if(iPtr.val < jPtr.val){
                    // System.out.println("        Swapping here");
                    temp = iPtr.val;
                    iPtr.val = jPtr.val;
                    jPtr.val = temp;
                }
                jPtr = jPtr.next;
            }
            iPtr = iPtr.next;
        }
        return head;
    }*/

}
