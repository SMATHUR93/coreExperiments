package com.shrek.dsa.stack;

public class DynamicStack {

	int top;
	int capacity = 2;
	int[] array;
	
	public static void main(String[] args) {
		DynamicStack stack = DynamicStack.createStack();
		stack.push(stack, 45);
		stack.push(stack, 23);
		stack.push(stack, 78);
		stack.push(stack, 9);
	}
	
	static DynamicStack createStack(){
		DynamicStack stack = new DynamicStack();
		stack.capacity = 1;
		stack.top = -1;
		stack.array = new int[stack.capacity];
		return stack;
	}
	
	void push(DynamicStack stack, int data) {
		if(isFullStack(stack)) {
			System.out.println("Stack overflow !!");
			doubleStack(stack);
		}
		System.out.println("Inserted "+data);			
		stack.array[++stack.top] = data;
	}
	
	int pop(DynamicStack stack) {
		if(isEmptyStack(stack)) {
			System.out.println("Stack Underflow !!");
			return 0;
		}
		return stack.array[stack.top--];
	}

	int top(DynamicStack stack) {
		if(isEmptyStack(stack)) {
			return -1;
		} else {
			return stack.array[stack.top];
		}
	}
	
	void doubleStack(DynamicStack stack) {
		int[] newArray = new int[stack.capacity*2];
        for(int i=0;i<stack.capacity;i++){
        	newArray[i] = stack.array[i];
        }
        stack.array = newArray;
        stack.capacity = stack.capacity*2;
	}

	boolean isEmptyStack(DynamicStack stack) {
		if(stack.top == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean isFullStack(DynamicStack stack) {
		if(stack.top == (stack.capacity-1) ) {
			return true;
		} else {
			return false;
		}
	}
	
}
