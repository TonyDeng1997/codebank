package com.webbertech.leetcode.string.substr;

/* Leetcode 28.
 * 
Implement strStr().
Returns the index of the first occurrence of needle in haystack, 
or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to 
ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. 
This is consistent to C's strstr() and Java's indexOf().
*/

public class StrStr_leetcode28 {
	
	public static int strStr2(String haystack, String needle) {
		 if (haystack.equals("") && needle.equals("")) {
	            return 0;
	     }  else if (haystack.equals("") && !needle.equals("")) {
	            return -1;
	     } else {
	           for(int i=0;i<=haystack.length()-needle.length();i++) {
	             int j=0;
	        	   for (j=0;j<needle.length();j++) {
	            	 if (haystack.charAt(i+j) != needle.charAt(j)) {
	            		 break;
	            	 }
	             }
	             if (j==needle.length()) {
	            	 return i;
	             }
	           }
	           
	     }
		 
		 return -1;
    }
	
	public static int strStr(String haystack, String needle) {
		  for (int i = 0; ; i++) {
		    for (int j = 0; ; j++) {
		      if (j == needle.length()) {
		    	  return i;
		      }
		      if (i + j == haystack.length()) {
		    	  return -1;
		      }
		      if (needle.charAt(j) != haystack.charAt(i + j)) {
		    	  break;
		      }
		    }
		  }
	}
	
	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
	}
}
