package com.webbertech.leetcode.language;

/* If b is not synchonized like the code below:
 * The result would be 0, 10, etc. Because sum is not finished before it is used.
 * Please confirm with the  
 * */
public class JavaMonitor2 {
	public static void main(String[] args) {
		ThreadB1 b = new ThreadB1();
		b.start();

		System.out.println("Total is: " + b.total);

	}
}

class ThreadB1 extends Thread {
	int total;

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			total += i;
		}
	}
}