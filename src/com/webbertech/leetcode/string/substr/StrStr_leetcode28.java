package com.webbertech.leetcode.string.substr;

/* Leetcode 28.
 * 
Implement strStr().
Returns the index of the first occurrence of needle in haystack, 
or -1 if needle is not part of haystack.

The C library function char *strstr(const char *haystack, const char *needle) function 
finds the first occurrence of the substring needle in the string haystack. 
The terminating '\0' characters are not compared.

*/

public class StrStr_leetcode28 {
	public int strStr(String haystack, String needle) {
		 if (haystack.equals("") && needle.equals("")) {
	            return 0;
	        }  else if (haystack.equals("") && !needle.equals("")) {
	            return -1;
	        } else {
	            return haystack.indexOf(needle);
	        }
    }
	
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
	
	public static void main(String[] args) {
		System.out.println(strStr2("aaabc", "abc"));
	}
}
