package com.webbertech.leetcode.string.substr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* Leetcode 438
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

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
 * 
 * 
 * Solution1: 
 * 
 * 1/ if anagram is nlogn, it is going to be n^2 logn
 * 2/ if anagram is n, and it is going to be n^2
 * 
 * Solution2: 
 * */

public class FindAllAnagramsInAString_leetcode438 {
	
	static boolean isAnagram(String a, String b) {
		if (a.length()!= b.length()) {return false;}
		if ((a ==null|| a.isEmpty()) || (b==null || b.isEmpty())) {
			return false;
		}
		HashMap<Character,Integer>  map = new HashMap<>();
		for(int i=0;i<a.length();i++) {
			if (map.containsKey(a.charAt(i))) {
				map.put(a.charAt(i), map.get(a.charAt(i))+1);
			} else {
				map.put(a.charAt(i), 1);
			}
		}
		
		for (int i=0;i<b.length();i++) {
			if (map.containsKey(b.charAt(i)) && map.get(b.charAt(i))!=0) {
				map.put(b.charAt(i), map.get(b.charAt(i))-1);
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length()< p.length()) {
            return list;
        }
        
        for(int i=0;i<=s.length()-p.length();i++) {
        	String substr = s.substring(i, i+p.length());
            if (isAnagram(substr,p)) {
                list.add(i);
            }
        }
        return list;
    }
	
	
   public static void main(String[] args) {
	 List<Integer> list=  findAnagrams("baa","aa");
   }
}
