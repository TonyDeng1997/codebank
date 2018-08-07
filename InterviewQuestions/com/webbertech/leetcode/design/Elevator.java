package com.webbertech.leetcode.design;

import java.util.ArrayDeque;
import java.util.ArrayList;

class Location {
  String buildingId;
  String unitId;
}

class Elevator {
	int id;
	Location loc;
	int cur;
	boolean waiting; 
	ArrayDeque<Integer> requests;
	
	public Elevator(){
		requests = new ArrayDeque<>();
	}
			
	
	
	// start moving
	void move(int cur, int dest) {
		if (!waiting && dest>0) {
			waiting = false;
		}
		// GO from cur to dest
	}
	
	void stop() {
		waiting = true;
	}
	
	void getRequest(int dest) {
		requests.offer(dest);
	}
	
	// each time
	void processRequest(ArrayDeque<Integer> dests) {
		int dest = dests.poll();
		move(cur, dest);
	}
	
	//init
	void start() {
		  while(!requests.isEmpty()) {
			processRequest(requests); 
		  }
	}
}