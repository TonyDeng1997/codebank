package com.webbertech.leetcode.array.dp;
import java.util.*;
/*
 * Leetcode131 palindrome partitioning
 * 
 *  Given a string s, partition s such that every substring 
 *  of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s = "aab",
Return
[
  ["aa","b"],
  ["a","a","b"]
]
 * */


public class PalindromePartitioning_leetcode131 {
		public static List<List<String>> partition(String s) {
		   List<List<String>> list = new ArrayList<>();
		   backtrack(list, new ArrayList<>(), s, 0);
		   return list;
		}

		/*
		 * Solution: s= aab
		 *  
		 * 
		 * */
		public static void backtrack(List<List<String>> list, List<String> tempList, String s, 
				int start) {
		   /* In order to partition the string s, the index must go to the end to complete.
		    * tempList is only responsible for adding qualified substr into it.
		    * Thus this is the intial condition to add tempList to list. 
		    * */
			if(start == s.length()) {
		      list.add(new ArrayList<>(tempList));
		   }
		   else {
		      for(int i = start; i < s.length(); i++) {
		    	 //from start to i it is a palindrome
		         if(isPalindrome(s, start, i)) {
		        	//add this palindrome to list. substr start from 0 and end in i.
		            tempList.add(s.substring(start, i + 1));
		            // check from i+1 to the end of s to see new substr
		            backtrack(list, tempList, s, i + 1);
		            tempList.remove(tempList.size() - 1);
		         }
		      }
		   }
		}

		public static boolean isPalindrome(String s, int low, int high){
		   while(low < high) {
		      if(s.charAt(low++) != s.charAt(high--)) {
		    	  return false;
		      }
		   }
		   return true;
		} 
		
		public static void main(String[] args) {
			List<List<String>> list = partition("aab");
		}
}
