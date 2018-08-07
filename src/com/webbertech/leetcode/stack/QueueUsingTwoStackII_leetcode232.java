package com.webbertech.leetcode.stack;

import java.util.Stack;

/*
 * Leetcode 232, it is better than the I, because its peek is simpler
 * */
public class QueueUsingTwoStackII_leetcode232 {
	Stack<Integer> queue = new Stack<Integer>();
	// Push element x to the back of queue.
	public void push(int x) {
	    Stack<Integer> temp = new Stack<Integer>();
	    while(!queue.empty()){
	        temp.push(queue.pop());
	    }
	    queue.push(x);
	    while(!temp.empty()){
	        queue.push(temp.pop());
	    }
	}

	// Removes the element from in front of queue.
	public void pop() {
	    queue.pop();
	}

	// Get the front element.
	public int peek() {
	    return queue.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
	    return queue.empty();
	}
	
	public static void main(String[] args) {
		QueueUsingTwoStackII_leetcode232 obj = new QueueUsingTwoStackII_leetcode232();
    	obj.push(1);
    	obj.push(2);
    	
    	System.out.println(obj.peek());
    	obj.pop();
    	System.out.println(obj.peek());
    	obj.pop();
    	obj.pop();
    	
    }
}
