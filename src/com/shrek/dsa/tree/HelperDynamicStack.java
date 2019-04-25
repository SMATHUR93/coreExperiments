package com.shrek.dsa.tree;

public class HelperDynamicStack {

	int top;
	int capacity = 2;
	BinaryTreeNode[] array;
	
	public static void main(String[] args) {
		/*
		 * HelperDynamicStack stack = HelperDynamicStack.createStack();
		 * stack.push(stack, 45); stack.push(stack, 23); stack.push(stack, 78);
		 * stack.push(stack, 9);
		 */
		System.out.println("Enter testing Code");
	}
	
	static HelperDynamicStack createStack(){
		HelperDynamicStack stack = new HelperDynamicStack();
		stack.capacity = 1;
		stack.top = -1;
		stack.array = new BinaryTreeNode[stack.capacity];
		return stack;
	}
	
	void push(HelperDynamicStack stack, BinaryTreeNode data) {
		if(isFullStack(stack)) {
			//System.out.println("Stack overflow !!");
			doubleStack(stack);
		}
		//System.out.println("Inserted "+data);			
		stack.array[++stack.top] = data;
	}
	
	BinaryTreeNode pop(HelperDynamicStack stack) {
		if(isEmptyStack(stack)) {
			//System.out.println("Stack Underflow !!");
			return null;
		}
		return stack.array[stack.top--];
	}

	BinaryTreeNode top(HelperDynamicStack stack) {
		if(isEmptyStack(stack)) {
			return null;
		} else {
			return stack.array[stack.top];
		}
	}
	
	void doubleStack(HelperDynamicStack stack) {
		BinaryTreeNode[] newArray = new BinaryTreeNode[stack.capacity*2];
        for(int i=0;i<stack.capacity;i++){
        	newArray[i] = stack.array[i];
        }
        stack.array = newArray;
        stack.capacity = stack.capacity*2;
	}

	boolean isEmptyStack(HelperDynamicStack stack) {
		if(stack.top == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean isFullStack(HelperDynamicStack stack) {
		if(stack.top == (stack.capacity-1) ) {
			return true;
		} else {
			return false;
		}
	}
	
}
