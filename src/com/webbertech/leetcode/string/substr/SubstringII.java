package com.webbertech.leetcode.string.substr;

import java.util.ArrayList;
import java.util.List;

//Recursive method
/*
It first checks the base case: 
if both start and end are equal to in.length(). 
Because if they are, that means there are no more substrings to be found, and the program ends.
Let's start with start=0 and end=1. They obviously don't equal in.length(), 
and end definitely doesn't equal in.length()+1. 
Thus, substring(0,1) will be printed out, which is 1.  (input "1234")
The next iteration of substrings will be substrings(0,2), 
and in.substring(0,2) will be printed, which is 12. 
This will continue until end == in.length()+1, which happens when the program finishes substrings(0,4) and tries to move on to substrings(0,5). 
5 == in.length()+1, so when that happens, the program will do substrings(start+1,start+1), which is substrings(1,1). 
The process will continue with substrings(1,2), and (1,3), until (1,5) when the program will run substrings(2,2).
All of this will continue until substrings(4,4), which, at that point, the program stops.
The result looks like this:

1 12 123 1234

2 23 234

3 34

4
* 
*/

public class SubstringII {
	static String in = "abcd";

	static void substrings(int start, int end) {
		if (start == in.length() && end == in.length()) {
			return;
		} else {
			if (end == in.length() + 1) {
				substrings(start + 1, start + 1);
			} else {
				System.out.println(in.substring(start, end));
				substrings(start, end + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		substrings(0, 1);
	}
	
}