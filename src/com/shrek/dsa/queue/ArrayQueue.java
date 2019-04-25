package com.shrek.dsa.queue;

public class ArrayQueue {

	int front, rear;
	int capacity;
	int[] array;
	
	boolean isEmptyQueue(ArrayQueue queue) {
		return ( queue.front == -1 );
	}
	
	boolean isFullQueue(ArrayQueue queue) {
		return ( ( ( queue.rear + 1 ) % queue.capacity ) == queue.front );
	}
	
	int queueSize(ArrayQueue queue) {
		return ( queue.capacity - queue.front + queue.rear + 1 ) % queue.capacity;
	}
	
	void enqueue(ArrayQueue queue, int data) {
		if(isFullQueue(queue)) {
			System.out.println("Queue Overflow !!");
		} else {
			System.out.println("Inserted "+data);
			queue.rear = ( queue.rear + 1 ) % queue.capacity;
			queue.array[queue.rear] = data;
			if( queue.front == -1 ) {
				queue.front = queue.rear;
			}
		}
	}
	
	int dequeue(ArrayQueue queue) {
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
	
	void deleteQueue(ArrayQueue queue) {
		if(queue!=null) {
			if(queue.array!=null) {}
		}
	}
	
	public ArrayQueue() {
		// TODO Auto-generated constructor stub
	}
	
	static ArrayQueue createQueue(int capacity) {
		ArrayQueue queue = new ArrayQueue();
		queue.capacity = capacity;
		queue.front = -1;
		queue.rear = -1;
		queue.array = new int[queue.capacity];
		return queue;
	}
	
	public static void main(String[] args) {
		ArrayQueue Queue = ArrayQueue.createQueue(3);
		Queue.enqueue(Queue, 45);
		Queue.enqueue(Queue, 23);
		Queue.enqueue(Queue, 78);
		Queue.enqueue(Queue, 9);
	}
}