package com.shrek.dsa.stack;

public class ArrayStack {

	int top;
	int capacity;
	int[] array;
	
	boolean isEmptyStack(ArrayStack stack) {
		return ( stack.top==-1 );
	}
	
	boolean isFullStack(ArrayStack stack) {
		return ( stack.top == ( stack.capacity-1) );
	}
	
	void push(ArrayStack stack, int data) {
		if(isFullStack(stack)) {
			System.out.println("Stack Overflow !!");
		} else {
			System.out.println("Inserted "+data);
			stack.array[++stack.top] = data;
		}
	}
	
	int pop(ArrayStack stack) {
		if(isEmptyStack(stack)) {
			System.out.println("Stack is Empty !!");
			return 0;
		} else {
			return ( stack.array[stack.top--] );
		}
	}
	
	void deleteStack(ArrayStack stack) {
		if(stack!=null) {
			if(stack.array!=null) {}
		}
	}
	
	public ArrayStack() {
		// TODO Auto-generated constructor stub
	}
	
	static ArrayStack createStack(int capacity) {
		ArrayStack stack = new ArrayStack();
		stack.capacity = capacity;
		stack.top = -1;
		stack.array = new int[stack.capacity];
		return stack;
	}
	
	public static void main(String[] args) {
		ArrayStack stack = ArrayStack.createStack(3);
		stack.push(stack, 45);
		stack.push(stack, 23);
		stack.push(stack, 78);
		stack.push(stack, 9);
	}
	
}
