package com.webbertech.leetcode.string.basics;

public class PalindromeString {
  
	public static boolean isPalinDromeString(String str) {
	   if (str.equals("")) return false;
	   
	   int i=0;
	   int j=str.length()-1;
	   
	   while(i<j) {
		   if (str.charAt(i) == str.charAt(j)) {
			   i++;
			   j--;
		   } else {
			   return false;
		   }
	   }
	   
	   return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalinDromeString("abc"));
		System.out.println(isPalinDromeString("aba"));
		System.out.println(isPalinDromeString("abba"));
	}
}
