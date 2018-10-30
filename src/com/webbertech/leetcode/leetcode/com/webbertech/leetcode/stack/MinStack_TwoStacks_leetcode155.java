package com.webbertech.leetcode.stack;
import java.util.Stack;

/*Leetcode 155*/
//this solution should be very concise
//dataStack will store everything
//minStack will save anything smaller or equal than its top, accepted
public class MinStack_TwoStacks_leetcode155 {
	 Stack<Integer> dataStack ;
	 Stack<Integer> minStack;
	 
	 public MinStack_TwoStacks_leetcode155() {
		 dataStack = new Stack<>();
		 minStack = new Stack<>();
	 }
	
	 void push(int x) {
		 //push in order
		 dataStack.push(x);
		 if (minStack.empty()||x<=minStack.peek()) {
			 minStack.push(x);
		 }
	 }
	 
	 void pop() {
		if (dataStack.peek()== getMin()) {
			minStack.pop();
		}
		dataStack.pop();
	 }
	 
	 int top() {
	    return dataStack.peek();	 
	 }
	 
	 int getMin() {
	  return minStack.peek();
	 }
	 
	public static void main(String[] args) {
		MinStack_TwoStacks_leetcode155 minStack = new MinStack_TwoStacks_leetcode155();
	        
		//result should be -3, 
		minStack.push(-2);
		System.out.println(minStack.getMin()); // -2
		minStack.push(0); // -2 0
		System.out.println(minStack.getMin()); //-2
		minStack.push(-3); //-2 0 -3
		System.out.println(minStack.getMin()); //-3

		minStack.pop(); //-2 0
		System.out.println(minStack.top()); //0
		System.out.println(minStack.getMin()); //-2
	}
}