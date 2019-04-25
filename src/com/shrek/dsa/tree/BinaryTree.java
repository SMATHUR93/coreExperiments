package com.shrek.dsa.tree;

import java.util.Stack;

public class BinaryTree {
	
	static BinaryTreeNode root;
	
//	public BinaryTree() { 
//		this.root = null; 
//	}
//
//	public BinaryTree(BinaryTreeNode root) {
//		super();
//		this.root = root;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		
		BinaryTreeNode n7 = new BinaryTreeNode(7, null, null);
		BinaryTreeNode n6 = new BinaryTreeNode(6, null, null);
		BinaryTreeNode n5 = new BinaryTreeNode(5, null, null);
		BinaryTreeNode n4 = new BinaryTreeNode(4, null, null);
		BinaryTreeNode n3 = new BinaryTreeNode(3, n6, n7);
		BinaryTreeNode n2 = new BinaryTreeNode(2, n4, n5);
		BinaryTreeNode n1 = new BinaryTreeNode(1, n2, n3);
		
		tree.root = n1;
		
		printPreOrderUsingRecursion(root);System.out.println();
		printInOrderUsingRecursion(root);System.out.println();
		printPostOrderUsingRecursion(root);System.out.println();
		printPreOrderWithoutRecusion(root);System.out.println();
		printInOrderWithoutRecusion(root);System.out.println();
		printPostOrderWithoutRecusion(root);System.out.println();
		printLevelOrder(root);
		
	}

	private static void printPreOrderUsingRecursion(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		if(root!=null) {
			System.out.print(root.data+", ");
			printPreOrderUsingRecursion(root.left);
			printPreOrderUsingRecursion(root.right);
		}
	}
	
	private static void printInOrderUsingRecursion(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		if(root!=null) {
			printInOrderUsingRecursion(root.left);
			System.out.print(root.data+", ");
			printInOrderUsingRecursion(root.right);
		}
	}
	
	private static void printPostOrderUsingRecursion(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		if(root!=null) {
			printPostOrderUsingRecursion(root.left);
			printPostOrderUsingRecursion(root.right);
			System.out.print(root.data+", ");
		}
	}
	
	private static void printPreOrderWithoutRecusion(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		HelperDynamicStack stack = HelperDynamicStack.createStack();
		while(true) {
			while(root!=null){
				System.out.print(root.data+", ");
				stack.push(stack, root);
				root = root.left;
			}
			if(stack.isEmptyStack(stack)) {
				break;
			}
			root = stack.pop(stack);
			root = root.right;
		}
	}

	private static void printInOrderWithoutRecusion(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		HelperDynamicStack stack = HelperDynamicStack.createStack();
		while(true) {
			while(root!=null){
				stack.push(stack, root);
				root = root.left;
			}
			if(stack.isEmptyStack(stack)) {
				break;
			}
			root = stack.pop(stack);
			System.out.print(root.data+", ");
			root = root.right;
		}
	}
	
	private static void printPostOrderWithoutRecusion(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		HelperDynamicStack stack = HelperDynamicStack.createStack(); 
		stack.push(stack, root); 
		BinaryTreeNode prev = null; 
		while (!stack.isEmptyStack(stack)) {
			BinaryTreeNode current = stack.top(stack); 
			if (prev == null || prev.left == current ||	prev.right == current) { 
				if (current.left != null) {
					stack.push(stack, current.left); 
				} else {
					if (current.right != null) {
						stack.push(stack, current.right); 
					} else { 
						stack.pop(stack); 
						System.out.print(current.data+", "); 
					}
				}
			} else {
				if (current.left == prev) {
					if (current.right != null) {
						stack.push(stack, current.right); 
					} else { 
						stack.pop(stack); 
						System.out.print(current.data+", ");
					}
				} else {
					if (current.right == prev) {
						stack.pop(stack);
						System.out.print(current.data+", ");  
					}
				}
			}
			prev = current; 
		} 
	}
	
	private static void printLevelOrder(BinaryTreeNode root) {
		// TODO Auto-generated method stub
		BinaryTreeNode temp;
		HelperDynamicQueue queue = HelperDynamicQueue.createDynamicQueue();
		queue.enqueue(queue, root);
		while(!queue.isEmptyQueue(queue)) {
			temp = queue.dequeue(queue);
			System.out.print(temp.data+", ");
			if(temp.left!=null) {
				queue.enqueue(queue, temp.left);
			}
			if(temp.right!=null) {
				queue.enqueue(queue, temp.right);
			}
		}
	}

}
