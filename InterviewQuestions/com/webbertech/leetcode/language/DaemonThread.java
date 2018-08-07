package com.webbertech.leetcode.language;
/*
 * Understand what daemon thread is.
 * It is usually used for service thread.
 * 
 * In the debug mode, no debugging point to break is necessary.
 * And you can see Daemon thread was there for 5 secs and disappear, 
 * and main thread is going on and on.
 * 
*/

public class DaemonThread extends Thread{
    public DaemonThread() {
    
    }
    
    public void run() {
    	// let it sleep 5 secs and watch it in debugging view
       	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Is this thread Daemon? - "+isDaemon());
    }
 
    public static void main(String a[]) throws InterruptedException {
    	System.out.println("In main thread");
        DaemonThread dt = new DaemonThread();
        
        dt.setDaemon(true);
        // even you can set daemon constrain here also
        // it is like dt.setDeamon(true)
        dt.start();
        while(true) {
        	System.out.println("main thread**");
        	Thread.sleep(1000);
        	
        }
    }
}