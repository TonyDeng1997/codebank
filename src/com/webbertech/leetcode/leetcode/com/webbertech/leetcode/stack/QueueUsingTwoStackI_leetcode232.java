package com.webbertech.leetcode.stack;
import java.util.Stack;

/* Leetcode 232
 * Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- 
which means only push to top, peek/pop from top, size, 
and is empty operations are valid.
Depending on your language, stack may not be supported natively. 
You may simulate a stack by using a list or deque (double-ended queue), 
as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, 
no pop or peek operations will be called on an empty queue).


Solution: two stack, the following implementation is not good. Please do not use it.
This implementation in reality do not use Stack, use ArrayDeque for performance issue

 * */


public class QueueUsingTwoStackI_leetcode232 {
	Stack<Object> inStack ;  
	Stack<Object> storageStack; 
	
	public QueueUsingTwoStackI_leetcode232() {
		inStack = new Stack<>();
		storageStack = new Stack<>();
	}
	
	// Push element x to the back of queue.
    public void push(Object x) {
    	if (!(x instanceof Integer))
    		throw new IllegalArgumentException();
    	inStack.add(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	//move one element to inStack
    	if (inStack.isEmpty()) {
    		 return;
    	}
    	//move n-1 to second stack
    	while(inStack.size()>1) {
    		storageStack.add(inStack.peek());
    		inStack.pop();
    	}
    	inStack.pop(); //pop the bottom one
    	
    	while(!storageStack.isEmpty()) {
    		inStack.add(storageStack.peek());
    		storageStack.pop();
    	}
    }

    // Get the front element.
    public int peek() {
    	//move n-1 to second stack
    	while(inStack.size()>1) {
    		storageStack.add(inStack.peek());
    		inStack.pop();
    	}
    	int ret = (Integer)inStack.peek();
    	while(!storageStack.isEmpty()) {
    		inStack.add(storageStack.peek());
    		storageStack.pop();
    	}
    	return ret;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inStack.isEmpty();
    }

    public int size() {
    	return inStack.size();
    }
    
    public static void main(String[] args) {
    	QueueUsingTwoStackI_leetcode232 obj = new QueueUsingTwoStackI_leetcode232();
    	obj.push(1);
    	obj.push(2);
    	
    	System.out.println(obj.peek());
    	obj.pop();
    	System.out.println(obj.peek());
    	obj.pop();
    	obj.pop();
    	obj.push("hello");
    }
}