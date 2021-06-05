package com.shrek.dsa.linkedList;

public class ReverseALinkedList {

    static Node head;

    public static void main(String[] args) {
        Node n4 = new Node(40);
        Node n3 = new Node(30, n4);
        Node n2 = new Node(20, n3);
        Node n1 = new Node(10, n2);
        ReverseALinkedList.head = n1;
        printLL(ReverseALinkedList.head);
        System.out.println("On Reverse");
        ReverseALinkedList.head = reverseLL(ReverseALinkedList.head);
        printLL(ReverseALinkedList.head);
    }

    public static Node reverseLL(Node head){
        Node current = head;
        Node next = null, prev = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static void printLL(Node head) {
        while(head!=null) {
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println();
    }

}
