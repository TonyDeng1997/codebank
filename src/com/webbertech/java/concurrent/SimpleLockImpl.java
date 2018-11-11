package com.webbertech.java.concurrent;

/*
 * This is a simple lock implementation,
 * the while(true) {wait();} is called spin lock.
 * 
 * The core part in this lock() method is to set the locking variable to true.
 * 
 * When other thread access the code, and call the lock(), and this variable is true
 * so it will not be able to access more. The second calling
 * thread has to wait until the first calling thread is done and unlock which
 * is calling notify() and notifyAll().
 * 
 * */
class Lock {
	private boolean isLocked = false;

	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			wait(); // wait(0)
		}
		isLocked = true;
	}

	public synchronized void unlock() {
		isLocked = false;
		notify();
	}
}

public class SimpleLockImpl {

	public SimpleLockImpl() {
		// TODO Auto-generated constructor stub
	}

	private Lock lock = new Lock();
	  private int count = 0;

	  public int inc() throws InterruptedException{
	    lock.lock();
	    int newCount = ++count;
	    lock.unlock();
	    return newCount;
	  }
}
