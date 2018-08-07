package com.webbertech.algorithm.game;

public class Hanoi {
	
	// move n-1 disks from a to b, by using c
	// move the nth disk from a to c
	// move the n-1 disk from b to c by using a
	// and do this recursively
	public void move(int n, char a, char b, char c) {
        if(n == 1) {
            System.out.println("Disk " + n + " From " + a + " To " + c);
        } else {
            move(n-1,a,c,b);
            System.out.println("Disk " + n + " From " + a + " To " + c);
            move(n-1,b,a,c);
        }
    }
}
