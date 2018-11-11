package com.webbertech.java.concurrent;

// TODO need better example
// http://tutorials.jenkov.com/java-concurrency/thread-signaling.html
class MonitorObject {
}

public class ThreadSignaling extends Thread {

	MonitorObject myMonitorObject = new MonitorObject();

	public void doWait() {
		synchronized (myMonitorObject) {
			try {
				myMonitorObject.wait();
			} catch (InterruptedException e) {
			}
		}
	}

	public void doNotify() {
		synchronized (myMonitorObject) {
			myMonitorObject.notify();
		}
	}
	
	public static void main(String[] args) {
		ThreadSignaling t = new ThreadSignaling();
		
	}
}