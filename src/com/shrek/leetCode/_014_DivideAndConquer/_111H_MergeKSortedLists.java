package com.shrek.leetCode._014_DivideAndConquer;

import java.util.Arrays;

/**
 *
 * You are given an array of k linked-lists lists,
 * each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * Example 2:
 * Input: lists = []
 * Output: []
 *
 *  Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 * Constraints:
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 *
 */

public class  _111H_MergeKSortedLists {

    public static void main(String[] args) {
        ListNode[] lists;
        int[] arr1, arr2, arr3;

        arr1 = new int[]{1,4,5};
        arr2 = new int[]{1,3,4};
        arr3 = new int[]{2,6};
        lists = new ListNode[]{makeLL(arr1), makeLL(arr2), makeLL(arr3)};
        System.out.println("mergeKLists for lists = "+ Arrays.toString(lists) +" equals ");
        showLL(mergeKLists(lists));
        // [1,1,2,3,4,4,5,6]
        System.out.println();

        lists = new ListNode[]{};
        System.out.println("mergeKLists for lists = "+ Arrays.toString(lists) +" equals ");
        showLL(mergeKLists(lists));
        // []
        System.out.println();

        arr1 = new int[]{};
        lists = new ListNode[]{makeLL(arr1)};
        System.out.println("mergeKLists for lists = "+ Arrays.toString(lists) +" equals ");
        showLL(mergeKLists(lists));
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

    // Trick is to merge 2 lists from start till end
    public static ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n==0){
            return null;
        }
        if(n==1){
            return lists[0];
        }
        for(int i=1;i<n;i++){
            lists[0] = merge2Lists(lists[0], lists[i]);
        }
        return lists[0];
    }

    public static ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                curr.next=list1;
                list1=list1.next;
                curr = curr.next;
            } else{
                curr.next=list2;
                list2=list2.next;
                curr = curr.next;
            }
        }
        curr.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    // brute force
    /*public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode();
        ListNode op = dummyHead;
        int n = lists.length;
        int total=0;
        ListNode tempHead;
        ListNode[] ptrs = new ListNode[n];
        for(int i=0;i<n;i++){
            tempHead = lists[i];
            ptrs[i] = lists[i];
            // ptrs[i] = new ListNode(lists[i].val, lists[i].next);
            while(tempHead!=null){
                total+=1;
                tempHead=tempHead.next;
            }
        }
        int minVal = Integer.MAX_VALUE;
        // boolean allComplete=false;
        ListNode newNode=null;
        int index=-1;
        for(int i=0;i<total;i++){
            System.out.println("START :: Debugging for node no = " + (i+1));
            minVal = Integer.MAX_VALUE;
            // allComplete=false;
            index=-1;
            for(int j=0;j<n;j++){
                if(ptrs[j]!=null){
                    System.out.println("     Debugging for minVal = "+minVal+" , ptrs[j].val = "+ptrs[j].val);
                    if(minVal>ptrs[j].val){
                        System.out.println("     Debugging in change pointer");
                        minVal = ptrs[j].val;
                        index=j;
                    }
                }
            }
            ptrs[index] = ptrs[index].next;
            System.out.println("FINISH :: Adding minValue = " + minVal);
            newNode =  new ListNode(minVal);
            op.next = newNode;
            op = newNode;
        }
        return dummyHead.next;
    }*/

}
