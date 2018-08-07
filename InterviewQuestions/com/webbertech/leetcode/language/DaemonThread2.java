package com.webbertech.leetcode.language;
/*
 * Understand what daemon thread is.
 * It is usually used for service thread.
 *
 * This example shows you what is user thread. User thread is a thread 
 * that is non-daemon thread and not main thread.
 * 
 * Thread1 is daemon thread. Thread2 and Thread3 are user thread.
 * Thread2 and Thread3 will sleep 15 secs, and Thread1 will sleep for 10 secs.
 * Daemon thread thread 1 will exit when it is done while other two user threads
 * are still working.
 * 
*/

public class DaemonThread2 extends Thread{

    public void run() {
    	if (!this.isDaemon() ) {
    		try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	} else {
    		// let daemon thread sleep 10 secs, you will see it.
    		try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
        System.out.println("Is this thread Daemon? - "+isDaemon());
    }
 
    public static void main(String a[]) throws InterruptedException {
    	
        DaemonThread2 dt1 = new DaemonThread2();
        DaemonThread2 dt2 = new DaemonThread2();
        DaemonThread2 dt3 = new DaemonThread2();
        dt1.setName("DaemonThread");
        dt1.setDaemon(true);
        dt2.setName("userThread2");
        dt3.setName("userThread3");
        // even you can set daemon constrain here also
        // it is like dt.setDeamon(true)
        dt1.start();
        dt2.start();
        dt3.start();
    }
}