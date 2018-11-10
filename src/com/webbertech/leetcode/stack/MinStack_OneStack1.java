package com.webbertech.leetcode.stack;
import java.util.Stack;

public class MinStack_OneStack1 {

	//solution: use one stack and min var, it seems very concise
	
	Stack<Integer> stack = new Stack<>();
	int min = Integer.MAX_VALUE;

	public void push(int x) {
		if (x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.peek() == min) {
			stack.pop();
			min = stack.pop();
		} else
			stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		MinStack_OneStack1 minStack = new MinStack_OneStack1();
		
       
		// the following is not right
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);

		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());

	}
}
