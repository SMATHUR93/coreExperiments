package com.shrek.dsa.tree;

public class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;

	public BinaryTreeNode() {
		// TODO Auto-generated constructor stub
	}
	
	public BinaryTreeNode(int data) {
		super();
		this.data = data;
	}
	
	public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
}
