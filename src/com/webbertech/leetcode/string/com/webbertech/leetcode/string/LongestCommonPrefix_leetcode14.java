package com.webbertech.leetcode.string;

/*leetcode14. Longest Common Prefix
 * Write a function to find the longest 
 * common prefix string amongst an array of strings.
 * 
 * Solution: two for loop to actually find it out the shortest common substring;
 * the inner loop is shortened from the end as we are looking for common prefix
 * */


public class LongestCommonPrefix_leetcode14 {
	public static String longestCommonPrefix(String[] strs) {
	    if(strs == null || strs.length == 0)    return "";
	    String pre = strs[0];
	    int i = 1;
	    
	    //iterate through
	    while(i < strs.length){
	    	
	    	/*good good*/
	        while(strs[i].indexOf(pre) != 0) {
	        	// loop to cut from the tail to make the longer string shorter, 
	        	// until the pre is the 
	        	// longest one
	            pre = pre.substring(0,pre.length()-1);
	        }
	        i++;
	    }
	    return pre;
	}
	
	 public static void main(String[] args) {
		 String[] strs = {"abce","ab", "abcd", "abcde"};
		 System.out.println(longestCommonPrefix(strs));
	 }
}
