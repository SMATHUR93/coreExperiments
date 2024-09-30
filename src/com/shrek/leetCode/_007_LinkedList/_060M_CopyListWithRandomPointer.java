package com.shrek.leetCode._007_LinkedList;

import java.util.Arrays;

/**
 * 
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list.
 * The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes
 * should point to new nodes in the copied list
 * such that the pointers in the original list
 * and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list,
 * where X.random --> Y,
 * then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 *
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
 * or null if it does not point to any node.
 *
 * Your code will only be given the head of the original linked list.
 *
 *
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 
 * Example 2:
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * 
 * Example 3:
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 *
 *
 * Constraints:
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random is null or is pointing to some node in the linked list.
 *
 * Hint 1
 * Just iterate the linked list and create copies of the nodes on the go. 
 * Since a node can be referenced from multiple nodes due to the random pointers, 
 * ensure you are not making multiple copies of the same node.
 * 
 * Hint 2
 * You may want to use extra space to keep old_node ---> new_node mapping 
 * to prevent creating multiple copies of the same node.
 * 
 * Hint 3
 * We can avoid using extra space for old_node ---> new_node mapping 
 * by tweaking the original linked list. Simply interweave the nodes of the old and copied list. 
 * For example: Old List: A --> B --> C --> D InterWeaved List: A --> A' --> B --> B' --> C --> C' --> D --> D'
 * 
 * Hint 4
 * The interweaving is done using next pointers and
 * we can make use of interweaved structure to get the correct reference nodes for random pointers.
 * 
 */

public class _060M_CopyListWithRandomPointer {

    public static void main(String[] args) {
        int[] arr1 = {1,2,4};
        ListNode l1 = makeLL(arr1);
        System.out.println("mergeTwoLists for Linked lists l1 = "+ Arrays.toString(arr1)+" is " + copyRandomList(l1));
        // [1,1,2,3,4,4]
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
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode random;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // Trick is to add clone node as next of original
    // and in next pass update its random next as next of random of original
    // after that just process the cloned nodes by one skip jump into new LL
    public static ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return null;
        }

        // Creating a new weaved list of original and copied nodes.
        ListNode ptr = head;
        while (ptr != null) {
            // Cloned node
            ListNode newNode = new ListNode(ptr.val);

            // Inserting the cloned node just next to the original node.
            // If A->B->C is the original linked list,
            // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        // Now link the random pointers of the new nodes created.
        // Iterate the newly created list and use the original nodes' random pointers,
        // to assign references to random pointers for cloned nodes.
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // Unweave the linked list to get back the original linked list and the cloned list.
        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        ListNode ptr_old_list = head; // A->B->C
        ListNode ptr_new_list = head.next; // A'->B'->C'
        ListNode head_new = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null)
                    ? ptr_new_list.next.next
                    : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_new;
    }

}
