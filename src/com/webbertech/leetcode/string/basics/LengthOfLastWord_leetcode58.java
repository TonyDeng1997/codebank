package com.webbertech.leetcode.string.basics;
/* LeetCode 58
 * 
 * Given a string s consists of upper/lower-case alphabets 
 * and empty space characters ' ', return the length of last word in the string.
   If the last word does not exist, return 0.
   
   Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
 * */

public class LengthOfLastWord_leetcode58 {
    public static int lengthOfLastWord(String s) {
        String word[] = s.split("\\s+");
        if (word.length>=1) {
        	return word[word.length-1].length();
        } 
        return 0;
    }
    
    public static void main(String[] args) {
    	System.out.println(lengthOfLastWord("Hello World"));
    	System.out.println(lengthOfLastWord("Hello"));
    	System.out.println(lengthOfLastWord(""));
    }
}
