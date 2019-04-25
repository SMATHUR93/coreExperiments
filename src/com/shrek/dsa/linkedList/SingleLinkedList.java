package com.shrek.dsa.linkedList;

import java.util.Scanner;

public class SingleLinkedList {

	static Node head;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinkedList singleLL = new SingleLinkedList();
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter number of nodes");
//		int lengthOfLL = input.nextInt();
//		System.out.println("Enter the nodes data");
//		Node newNode = new Node(input.nextInt());
//		singleLL.head = newNode;
//		Node prevNode = newNode;
//		for(int i=0;i<lengthOfLL-1;i++) {
//			newNode = new Node(input.nextInt());
//			prevNode.next = newNode;
//			prevNode = newNode;
//		}
//		newNode.next = null;
		
		Node n4 = new Node(44, null);
		Node n3 = new Node(35, n4);
		Node n2 = new Node(29, n3);
		Node n1 = new Node(12, n2);
				
		singleLL.head = n1;
				
		printLL(singleLL.head);
		
		SingleLinkedList.head = insertNodeAtStart(SingleLinkedList.head, new Node(0, null));
		printLL(singleLL.head);
		SingleLinkedList.head = insertNodeAtEnd(SingleLinkedList.head, new Node(56, null));
		printLL(singleLL.head);
		SingleLinkedList.head = insertNodeAtIndex(SingleLinkedList.head, new Node(22, null), 3);
		printLL(singleLL.head);
		 
	}
	
	private static Node insertNodeAtIndex(Node head, Node newNode, int index) {
		// TODO Auto-generated method stub
		Node current = head;
		int counter= 1;
		while((counter<(index-1)) && (current.next!=null) ) {
			current = current.next;
			counter++;
		}
		newNode.next = current.next;
		current.next = newNode;
		return head;
	}

	private static Node insertNodeAtEnd(Node head, Node newNode) {
		// TODO Auto-generated method stub
		Node current = head;
		while(current.next!=null) {
			current = current.next;
		}
		current.next = newNode;
		return head;
	}
	
	private static Node insertNodeAtStart(Node head, Node newNode) {
		// TODO Auto-generated method stub
		newNode.next = head;
		return newNode;
	}

	private static void printLL(Node head) {
		while(head!=null) {
			System.out.print(head.data+"->");
			head = head.next;
		}
		System.out.println();
	}
}
