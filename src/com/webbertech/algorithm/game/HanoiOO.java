package com.webbertech.algorithm.game;

import java.util.ArrayDeque;
class Tower {
	
	private ArrayDeque<Integer> disks;
	
	private int index;
	
	public Tower(int i) {
		disks = new ArrayDeque<Integer>();
		index = i;
	}
	
	public int index() {
		return index;
	}
	
	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error placing disk" + d);
		} else {
			disks.push(d);
		}
	}
	
	public void moveTopTo(Tower t) {
		int top = disks.pop();
		t.add(top);
	}
	
	//current tower is the source tower
	public void moveDisks(int n, Tower dest, Tower buffer) {
		if (n>0) {
			moveDisks(n-1, buffer, dest);
			moveTopTo(dest);
			moveDisks(n-1, dest, this);
		}
	}
}

public class HanoiOO {
	
	public static void main(String[] args) {
		int n = 3;
		Tower[] towers = new Tower[n];
		//this i is label of the tower
		for (int i=0; i< 3;i++) {
			towers[i] = new Tower(i);
		}
		//add disk to the tower
		for (int i=n-1;i>=0;i--) {
			towers[0].add(i);
		}
		
		towers[0].moveDisks(n, towers[2], towers[1]);
	}
	
	
}
