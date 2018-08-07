package com.webbertech.leetcode.stack;
import java.util.Stack;

/*leetcode 155 Min Stack
 * 
 *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

*
*/
public class MinStack_OneStack_Leetcode155 {

	long min;
	Stack<Long> stack;

	public MinStack_OneStack_Leetcode155() {
		stack = new Stack<>();
	}

	public void push(int x) {
		if (stack.isEmpty()) {
			stack.push(0L);
			min = x;
		} else {
			stack.push(x - min);// Could be negative if min value needs to
								// change
			if (x < min)
				min = x;
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;

		long pop = stack.pop();

		if (pop < 0)
			min = min - pop;// If negative, increase the min value

	}

	public int top() {
		long top = stack.peek();
		if (top > 0) {
			return (int) (top + min);
		} else {
			return (int) (min);
		}
	}

	public int getMin() {
		return (int) min;
	}

	public static void main(String[] args) {
		MinStack_OneStack_Leetcode155 minStack = new MinStack_OneStack_Leetcode155();
		/*
		 * minStack.push(-1); System.out.println(minStack.top());
		 * System.out.println(minStack.getMin()); minStack.push(1);
		 * System.out.println(minStack.top());
		 * System.out.println(minStack.getMin());
		 */
		/*
		 * minStack.push(-2); minStack.push(0); minStack.push(-1);
		 * System.out.println(minStack.getMin());
		 * System.out.println(minStack.top()); minStack.pop();
		 * System.out.println(minStack.getMin());
		 */

		/*
		 * minStack.push(-2); minStack.push(0); minStack.push(-3);
		 * System.out.println(minStack.getMin());
		 * System.out.println(minStack.top()); minStack.pop();
		 * System.out.println(minStack.getMin());
		 */

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