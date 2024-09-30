package com.shrek.leetCode._007_LinkedList;

/**
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * Example 2:
 *
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * Example 3:
 *
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *
 * Constraints:
 *
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 *
 *
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 *
 */

public class _057E_LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(-4);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l1;
        System.out.println("hasCycle for Linked list head = [3,2,0,-4], pos = 1 is " + hasCycle(head));
        // true
        System.out.println("-------------- BREAK -----------------");

        head = new ListNode(1);
        l1 = new ListNode(2);
        head.next = l1;
        l1.next = head;
        System.out.println("hasCycle for Linked list head = [1], pos = -1 is " + hasCycle(head));
        // true
        System.out.println("-------------- BREAK -----------------");

        head = new ListNode(1);
        System.out.println("hasCycle for Linked list head = [1], pos = -1 is " + hasCycle(head));
        // false
        System.out.println("-------------- BREAK -----------------");

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode r = head;
        ListNode t = head;
        while(r.next!=null && r.next.next!=null){
            r = r.next.next;
            t = t.next;
            if(r==t){
                return true;
            }
        }
        return false;
    }

}


