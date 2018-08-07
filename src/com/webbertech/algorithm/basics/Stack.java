package com.webbertech.algorithm.basics;

public class Stack {
	private int top = -1;
	private final int MAX = 10;
	private int[] s;
	
	Stack() {
	   s = new int[MAX];	
	}
	
	void checkStackSize() {
		int[] newS = null;
		if (top > MAX/2) {
			newS = new int[top*2];
			for(int i=0;i<=top;i++) {
				newS[i] = s[i];
			}
			
			this.s= newS;	
		}
		
	}
	
	void push(int item) {
	   checkStackSize();
	   top++;
	    s[top] = item;
	    
	}
	
	int pop() {
		if (top < 0) 
			throw new java.lang.ArrayIndexOutOfBoundsException();
		int removed = s[top];
		top--;
		return removed;
	}
	
	int getSize() {
		return top+1;
	}
	
	int peek() {
	   if (top>0)
	   {
		   return s[top];
	   } else 
		   return -1;
	}
	
	public static void main(String[] args) {
		 
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		s.push(10);
		s.push(11);
		s.push(12);
		s.push(13);
		s.push(14);
		s.push(15);
		
		System.out.println("size is:" + s.getSize());
		
		s.pop();
		
		System.out.println("clearing the stack");
		while (s.getSize() != 0) {
			System.out.println(s.pop());
		}
	}
}
