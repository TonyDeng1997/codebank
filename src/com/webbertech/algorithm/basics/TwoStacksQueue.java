package com.webbertech.algorithm.basics;

//use two stack to implement a queue

public class TwoStacksQueue<T> {
	GenericStack<T> inStack = new GenericStack<>();
	GenericStack<T> outStack = new GenericStack<>();

	//move all elements from stack1 to stack2
	void moveStack(GenericStack<T> stack1, GenericStack<T> stack2) {
		while(stack1.getSize()>0) {
			stack2.push(stack1.pop());
		}
	}
	
	public  T removeFirst() {
		if (inStack.getSize() == 0) 
			return null;
	   	moveStack(inStack,outStack);
	   	T t = outStack.pop();
	   	moveStack(outStack, inStack);
	   	return t;
	}
	
	public  T peekFirst() {
		if (inStack.getSize() == 0) 
			return null;
	   	moveStack(inStack,outStack);
	   	T t = outStack.peek();
	   	moveStack(outStack, inStack);
	   	return t;
	}
	
	public void addLast(T item) {
		inStack.push(item);
	}
	
	public int getSize() {
		return inStack.getSize();
	}
	
	public static void main(String[] args) {
		TwoStacksQueue<Integer> tsq = new TwoStacksQueue<>();
		tsq.addLast(1);
		tsq.addLast(2);
		tsq.addLast(3);
		tsq.addLast(4);
		tsq.addLast(5);
		tsq.addLast(6);
		tsq.addLast(7);
		tsq.addLast(8);
		tsq.addLast(9);
		tsq.addLast(10);
		tsq.addLast(11);
		
	   System.out.println(tsq.removeFirst());
	   System.out.println(tsq.removeFirst());
	   System.out.println(tsq.removeFirst());
	   System.out.println(tsq.removeFirst());
	   System.out.println(tsq.removeFirst());
	   System.out.println(tsq.removeFirst());
	   System.out.println(tsq.removeFirst());
	   System.out.println(tsq.removeFirst());
	   System.out.println(tsq.removeFirst());
	   System.out.println(tsq.removeFirst());
	   System.out.println(tsq.removeFirst());
	   System.out.println(tsq.removeFirst());
	   
	}
}
