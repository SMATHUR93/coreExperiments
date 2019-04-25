package com.shrek.dsa.queue;

public class DynamicQueue {

	int front;
	int rear;
	int capacity;
	int[] array;
	
	public static void main(String[] args) {
		DynamicQueue Queue = DynamicQueue.createDynamicQueue();
		Queue.enqueue(Queue, 45);
		Queue.enqueue(Queue, 23);
		Queue.enqueue(Queue, 78);
		Queue.enqueue(Queue, 9);
	}
	
	static DynamicQueue createDynamicQueue() {
		DynamicQueue queue = new DynamicQueue();
		queue.capacity = 1;
		queue.front = queue.rear = -1;
		queue.array = new int[queue.capacity];
		return queue;
	}
	
	void enqueue(DynamicQueue queue, int data) {
		if(isFullQueue(queue)) {
			System.out.println("Queue Overflow !!");
			resizeQueue(queue);
		}
		System.out.println("Inserted "+data);
		queue.rear = ( queue.rear + 1 ) % queue.capacity;
		queue.array[queue.rear] = data;
		if( queue.front == -1 ) {
			queue.front = queue.rear;
		}
	}
	
	private void resizeQueue(DynamicQueue queue) {
		// TODO Auto-generated method stub
		int size = queue.capacity;
		int[] newArray = new int[queue.capacity*2];
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

	int dequeue(DynamicQueue queue) {
		int data = 0;
		if(isEmptyQueue(queue)) {
			System.out.println("Queue is Empty !!");
			return 0;
		} else {
			data = queue.array[queue.front];
			System.out.println("Removed "+data);
			if( queue.front == queue.rear ) {
				queue.front = queue.rear = -1;
			} else{
				queue.front = ( queue.front + 1 ) % queue.capacity;
			}
		}
		return data;
	}

	int queueSize(DynamicQueue queue) {
		return ( ( queue.capacity - queue.front + queue.rear + 1 ) % queue.capacity );
	}
	
	boolean isEmptyQueue(DynamicQueue queue) {
		return (queue.front==-1);
	}
	
	boolean isFullQueue(DynamicQueue queue) {
		return ( ( (queue.rear+1) % queue.capacity ) == queue.front );
	}
	
}
