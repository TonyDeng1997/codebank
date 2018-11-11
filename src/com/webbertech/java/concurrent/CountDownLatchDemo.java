package com.webbertech.java.concurrent;

//Java Program to demonstrate how  
//to use CountDownLatch, Its used  
//when a thread needs to wait for other  
//threads before starting its work. 
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String args[]) throws InterruptedException {
		// Let us create task that is going to
		// wait for four threads before it starts
		CountDownLatch latch = new CountDownLatch(4);

		// Let us create four worker
		// threads and start them.
		Worker first = new Worker(1000, latch, "WORKER-1");
		Worker second = new Worker(2000, latch, "WORKER-2");
		Worker third = new Worker(3000, latch, "WORKER-3");
		Worker fourth = new Worker(4000, latch, "WORKER-4");
		Worker five = new Worker(5000, latch, "WORKER-5");
		Worker six = new Worker(6000, latch, "WORKER-6");
		Worker seven = new Worker(7000, latch, "WORKER-7");
		Worker eight = new Worker(8000, latch, "WORKER-8");
		first.start();
		second.start();
		third.start();
		fourth.start();
		five.start();
		six.start();
		seven.start();
		eight.start();
		// The main task waits for four threads
		latch.await();

		// Main thread has started
		System.out.println(Thread.currentThread().getName() + " has finished");
	}
}

//A class to represent threads for which 
//the main thread waits. 
class Worker extends Thread {
	private int delay;
	private CountDownLatch latch;

	public Worker(int delay, CountDownLatch latch, String name) {
		super(name);
		this.delay = delay;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(delay);
			//Thread.sleep(1000);
			latch.countDown();
			System.out.println(Thread.currentThread().getName() + " finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}