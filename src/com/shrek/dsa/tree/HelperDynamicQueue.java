package com.shrek.dsa.tree;

public class HelperDynamicQueue {

	int front;
	int rear;
	int capacity;
	BinaryTreeNode[] array;
	
	public static void main(String[] args) {
		/*
		 * HelperDynamicQueue Queue = HelperDynamicQueue.createDynamicQueue();
		 * Queue.enqueue(Queue, 45); Queue.enqueue(Queue, 23); Queue.enqueue(Queue, 78);
		 * Queue.enqueue(Queue, 9);
		 */
		System.out.println("Enter testing Code");
	}
	
	static HelperDynamicQueue createDynamicQueue() {
		HelperDynamicQueue queue = new HelperDynamicQueue();
		queue.capacity = 1;
		queue.front = queue.rear = -1;
		queue.array = new BinaryTreeNode[queue.capacity];
		return queue;
	}
	
	void enqueue(HelperDynamicQueue queue, BinaryTreeNode data) {
		if(isFullQueue(queue)) {
			//System.out.println("Queue Overflow !!");
			resizeQueue(queue);
		}
		//System.out.println("Inserted "+data);
		queue.rear = ( queue.rear + 1 ) % queue.capacity;
		queue.array[queue.rear] = data;
		if( queue.front == -1 ) {
			queue.front = queue.rear;
		}
	}
	
	private void resizeQueue(HelperDynamicQueue queue) {
		// TODO Auto-generated method stub
		int size = queue.capacity;
		BinaryTreeNode[] newArray = new BinaryTreeNode[queue.capacity*2];
        for(int i=0;i<queue.capacity;i++){
        	newArray[i] = queue.array[i];
        }
        queue.array = newArray;
        queue.capacity = queue.capacity*2;
        if(queue.front > queue.rear) {
        	for(int i = 0;i < queue.front;i++) {
        		queue.array[i+size] = queue.array[i];
        	}
        	queue.rear = queue.rear + size;
        }
	}

	BinaryTreeNode dequeue(HelperDynamicQueue queue) {
		BinaryTreeNode data = null;
		if(isEmptyQueue(queue)) {
			//System.out.println("Queue is Empty !!");
			return null;
		} else {
			data = queue.array[queue.front];
			//System.out.println("Removed "+data);
			if( queue.front == queue.rear ) {
				queue.front = queue.rear = -1;
			} else{
				queue.front = ( queue.front + 1 ) % queue.capacity;
			}
		}
		return data;
	}

	int queueSize(HelperDynamicQueue queue) {
		return ( ( queue.capacity - queue.front + queue.rear + 1 ) % queue.capacity );
	}
	
	boolean isEmptyQueue(HelperDynamicQueue queue) {
		return (queue.front==-1);
	}
	
	boolean isFullQueue(HelperDynamicQueue queue) {
		return ( ( (queue.rear+1) % queue.capacity ) == queue.front );
	}
	
}
