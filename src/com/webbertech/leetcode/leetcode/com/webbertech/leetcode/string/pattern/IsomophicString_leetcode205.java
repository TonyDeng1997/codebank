package com.webbertech.leetcode.string.pattern;

/* 205 Isomophic string. 
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character 
while preserving the order of characters. No two characters may map to the 
same character but a character may map to itself.

For example,
Given "egg", "add", return true.
Given "foo", "bar", return false.
Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.

Solution: 
1/ firsts of all, this is a pattern thing.
2/ Clearly understand ASCII code, 0-127, use array to keep track of the character's ascii.
3/ At any index i, 
*/

public class IsomophicString_leetcode205 {

	public static boolean isIsomorphic(String s, String t) {
		int[] map = new int[128];
		int[] book = new int[128];
		for (int i = 0; i < s.length(); i++) {
			int cs = (int) s.charAt(i);
			int ts = (int) t.charAt(i);
			//egg - > add
			if (map[cs] == 0 && book[ts] == 0) { 
				map[cs] = ts;  //map[cs] saves ts 's value
			    book[ts] = 1;  // book[ts] is to keep track of the if the character in ts 
				                // exists already.
			} else if (map[cs] != ts) // if it exists but not saving the same character, then false
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("paper", "title"));
	}
}
