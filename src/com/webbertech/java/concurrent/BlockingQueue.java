package com.webbertech.java.concurrent;

import java.util.LinkedList;
import java.util.List;

/*
 * An implementation of blocking queue, 
 * 1/ when enqueue and the queue is full then wait, if empty then notifyAll, then do enqueue
 * 2/ when dequeue and the queue is empty then wait, if full then notifyAll, then to the dequeue
 * 
 * 
 * */
public class BlockingQueue {

	private List queue = new LinkedList();
	private int limit = 10;

	public BlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		return this.queue.remove(0);
	}
	
	public static void main(String[] args) {
		// TODO add some tests
	}
}