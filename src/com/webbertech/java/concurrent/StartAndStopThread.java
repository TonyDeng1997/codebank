package com.webbertech.java.concurrent;

public class StartAndStopThread implements Runnable {
	private boolean doStop = false;

    public synchronized void doStop() {
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        return this.doStop == false;
    }

    @Override
    public void run() {
        while(keepRunning()) {
            // keep doing what this thread should do.
            System.out.println("Running");
            try {
                Thread.sleep(3L * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
    	// This is how to implement runnable to create thread.
    	StartAndStopThread myRunnable = new StartAndStopThread();
        Thread thread = new Thread(myRunnable);
        // Don't call thread.run() that is wrong
        thread.start();
        try {
            Thread.sleep(10L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Don't call thread.stop(), that is a pitfall
        myRunnable.doStop();
    }
}