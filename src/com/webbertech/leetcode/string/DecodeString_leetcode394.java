package com.webbertech.leetcode.string;

import java.util.Stack;

/*
 * Leetcode 394 Decode string
 * 
Given an encoded string, return it's decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside 
the square brackets is being repeated exactly k times. 
   
Note that k is guaranteed to be a positive integer. 
You may assume that the input string is always valid; 
No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits 
and that digits are only for those repeat numbers, k. 
For example, there won't be input like 3a or 2[4].
  
Examples:

s = "3[a]2[bc]", return "aaabcbc". 
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
* */

public class DecodeString_leetcode394 {
	
	
	/*
	 * solution: The trick is in the parsing.
	 * Using a stack is a good way to do this.
	 * 
	 * s = "3[a2[c]]"
	 * */
	  public static String decodeString(String s) {
	        String res = "";
	        Stack<Integer> countStack = new Stack<>();
	        Stack<String> resStack = new Stack<>();
	        int idx = 0;
	        while (idx < s.length()) {
	        	//because in the format, the digit comes first
	            if (Character.isDigit(s.charAt(idx))) {
	                int count = 0;
	                //digits might have more than one bits
	                while (Character.isDigit(s.charAt(idx))) {
	                    count = 10 * count + (s.charAt(idx) - '0');
	                    idx++;
	                }
	                countStack.push(count);
	            }
	            else if (s.charAt(idx) == '[') {
	                resStack.push(res);  //push empty string to the stack, it is used for pop up later
	                res = "";            // reset it to empty string as we need res to store latter character to repeat first
	                idx++;
	            }
	            else if (s.charAt(idx) == ']') {
	                StringBuilder temp = new StringBuilder (resStack.pop());
	            	//StringBuilder temp = new StringBuilder ();
	                int repeatTimes = countStack.pop();
	                for (int i = 0; i < repeatTimes; i++) {
	                    temp.append(res);
	                }
	                res = temp.toString();
	                idx++;
	            }
	            else {
	                res += s.charAt(idx++);
	            }
	        }
	        return res;
	    }

	
	public static void main(String[] args) {
		System.out.println(decodeString("3[a2[c]]"));
	}
}