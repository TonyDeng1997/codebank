package com.webbertech.leetcode.string.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* Leetcode 438
 * 
 * Given a string s and a non-empty string p, 
 * find all the start indices of p's anagrams in s.
   Strings consists of lowercase English letters only and
   the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.
Example 1:

Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

test input: baa, aa

Sliding window:   
we are interested only when every hash[i] becomes 0. 
There are a number of ways of doing it. To understand OP's approach, 

we observe that:
the sum of all hash[i] is always >=0;
count is the sum of all positive hash[i];
therefore, every hash[i] is zero if and only if count is 0.
The genius of this approach is that the code is shorter, 
compared to our instinctive approach of maintaining the 
count of hash[i]==0. 
* */

public class FindAllAnagramsInAStringOptimized_leetcode439 {
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;
		int[] hash = new int[256]; // character hash
		// record each character in p to hash
		for (char c : p.toCharArray()) {
			hash[c]++;
		}
		// two points, initialize count to p's length
		int left = 0, right = 0, count = p.length();
		while (right < s.length()) {
			// move right everytime, if the character exists in p's hash,
			// decrease the count
			// current hash value >= 1 means the character is existing in p
			if (hash[s.charAt(right++)]-- >= 1)
				count--;

			// when the count is down to 0, means we found the right anagram
			// then add window's left to result list
			if (count == 0)
				list.add(left);

			// if we find the window's size equals to p, then we have to move
			// left (narrow the window) to find the new match window
			// ++ to reset the hash because we kicked out the left
			// only increase the count if the character is in p
			// the count >= 0 indicate it was original in the hash, cuz it won't
			// go below 0
			if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
				count++;
		}
		return list;
	}

	//Second solution to make the logic easy to understand
	public static List<Integer> findAnagramsII(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;
        //character hash, 256 or 128 does not matter. 256 for extended ascii
		int[] hash = new int[256];  

		// record each character in p to hash
		for (char c : p.toCharArray()) {
			hash[c]++;
		}
		// two points, initialize count to p's length
		int left = 0, right = 0, count = p.length();

		while (right < s.length()) {
			// move right everytime, if the character exists in p's hash,
			// decrease the count
			// current hash value >= 1 means the character is existing in p
			if (hash[s.charAt(right)] >= 1) {
				count--;
			}
			hash[s.charAt(right)]--;
			right++;

			// when the count is down to 0, means we found the right anagram
			// then add window's left to result list
			if (count == 0) {
				list.add(left);
			}
			// if we find the window's size equals to p, then we have to move
			// left (narrow the window) to find the new match window
			// ++ to reset the hash because we kicked out the left
			// only increase the count if the character is in p
			// the count >= 0 indicate it was original in the hash, cuz it won't
			// go below 0
			if (right - left == p.length()) {
				if (hash[s.charAt(left)] >= 0) { 
					//for those are not in p, they should be negative right now
					count++;
				}
				hash[s.charAt(left)]++;
				left++;
			}
		}
		return list;
	}
    
	static void display(List<Integer> list) {
		for(int i: list) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	/*
	//A variation of the first two solutions using map.
	public static List<Integer> findAnagramsIII(String s, String p) {
	       HashMap<Character, Integer> map = new HashMap<>();
	       List<Integer> list = new ArrayList<>();
	       int start =0, end =0;
	       //construct the map
	       for(int i=0;i<p.length();i++) {
	           if(map.containsKey(p.charAt(i))) {
	            map.put(p.charAt(i), map.get(p.charAt(i))+1);
	           } else {
	               map.put(p.charAt(i),1);
	           }
	       }
	       int count = p.length();
	       while(end< s.length()) {
	           if(map.containsKey(s.charAt(end)) && map.get(s.charAt(end))>=1) {
	               count--;
	           }
	           if (!map.containsKey(s.charAt(end))) {
	        	   map.put(s.charAt(end), -1);
	           }
	           end++;
	           
	           if (count==0) {
	               list.add(start);
	           }
	           if (end-start == p.length()) {
	               if (map.get(s.charAt(start))>=0) {
	                   count++;
	               }
	               map.put(s.charAt(start), map.get(s.charAt(start))+1);
	               start++;
	           }
	           
	       }
	        return list;
	 }*/
	
	public static void main(String[] args) {
	/*
		List<Integer> list = findAnagramsIII("baa", "aa");  //output 1
		display(list);
		list = findAnagramsIII("cbaebabacd", "abc"); //output 0 6
		display(list);
		list = findAnagramsIII("abab", "ab"); //output 0 1 2
		display(list);
	    list = findAnagramsIII("cbbaa", "aa");  //output 1
		display(list);
		*/
		
		List<Integer> list = findAnagramsII("baa", "aa");  //output 1
		display(list);
		list = findAnagramsII("cbaebabacd", "abc"); //output 0 6
		display(list);
		list = findAnagramsII("abab", "ab"); //output 0 1 2
		display(list);
	    list = findAnagramsII("cbbaa", "aa");  //output 1
		display(list);
		
		
		/*
		//Testing the first impl
		list = findAnagrams("baa", "aa");
		display(list);
		list = findAnagrams("cbaebabacd", "abc");
		display(list);
		list = findAnagrams("abab", "ab");
		display(list);
		*/
	}
}
