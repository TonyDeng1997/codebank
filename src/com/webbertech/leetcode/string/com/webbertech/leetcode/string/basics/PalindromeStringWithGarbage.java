package com.webbertech.leetcode.string.basics;
/*
 * leetcode 125
 * 
 *  Given a string, determine if it is a palindrome, 
 *  considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? 
This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome. 
*/
public class PalindromeStringWithGarbage {
	 public static boolean isPalindrome(String s) {
	        if (s.equals("")) {
	            return true;
	        }
	        String newStr = s.replaceAll("([^0-9a-zA-Z])","");
	        newStr = newStr.toLowerCase();
	        System.out.println(newStr);
	        StringBuilder sb = new StringBuilder();
	        return sb.append(newStr).reverse().toString().equals(newStr);
	    }
	 
	  public static void main(String[] args) {
		  System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	  }
}