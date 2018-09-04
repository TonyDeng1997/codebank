package com.webbertech.leetcode.stack;

import java.util.Stack;

/*
 * Leetcode 20 Valid Parenthesis 
 * 
* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true
**/

public class ValidateParenthesis_leetcode20 {
	
	/*
	 * Solution 1
	 * */
	static boolean validParenthesis(String s) {
		if (s == null|| s.isEmpty()) {
			return false;
		}
		char c[] = s.toCharArray();
		int[] stack = new int[c.length];
		int top = -1;
		for(int i=0;i<c.length;i++) {
			switch(c[i]) {
				case '{': stack[++top] = c[i]; break;
				case '<': stack[++top] = c[i]; break;
				case '[': stack[++top] = c[i]; break;
				case '(': stack[++top] = c[i]; break;
				case '}' : 
					if (stack[top--] != '{') 
						return false;
					break;
				case '>' :
					if (stack[top--] != '<') 
						return false;
					break;
				case ']':
					if (stack[top--] != '[') 
						return false;
					break;
				case ')':
					if (stack[top--] != '(') 
						return false;
					break;
				default: return false;
			}
		}
		return top == -1;
	}
	
	static boolean validParenthesis2(String s) {
		if (s == null|| s.isEmpty()) {
			return false;
		}
		 Stack<Character> stack = new Stack<>();
		 char c[] = s.toCharArray();
			for(int i=0;i<c.length;i++) {
				switch(c[i]) {
					case '{': ;
					case '<': 
					case '[': 
					case '(': stack.push(c[i]); break;
					case '}' : 
						if (stack.pop() != '{') 
							return false;
						break;
					case '>' :
						if (stack.pop() != '<') 
							return false;
						break;
					case ']':
						if (stack.pop() != '[') 
							return false;
						break;
					case ')':
						if (stack.pop() != '(') 
							return false;
						break;
					default: return false;
				}
			}
			return true;
    }
		

	public static void main(String[] args) {
		System.out.println(validParenthesis(""));
		System.out.println(validParenthesis("abc"));
		System.out.println(validParenthesis("<>"));
		System.out.println(validParenthesis("<>[](){}"));
		System.out.println(validParenthesis("{([<>])}"));
	}
}