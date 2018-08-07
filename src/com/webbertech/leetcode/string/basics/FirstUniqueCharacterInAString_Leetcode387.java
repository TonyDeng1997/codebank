package com.webbertech.leetcode.string.basics;

import java.util.HashMap;

/*
 * Leetcode 387
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

Solution: Use map

Accepted and very simple.

 * 
 * */
public class FirstUniqueCharacterInAString_Leetcode387 {
	 public int firstUniqChar(String s) {
	        if (s == null || s.isEmpty()) {
	            return -1;
	        }
	        HashMap<Character, Integer> map = new HashMap<>();
	        for (int i=0;i<s.length();i++) {
	            if (map.containsKey(s.charAt(i))) {
	                map.put(s.charAt(i),map.get(s.charAt(i))+1);
	            } else {
	                map.put(s.charAt(i),1);
	            }
	        }
	        
	        int index = -1;
	        for(int i=0;i<s.length();i++) {
	            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > 1) {
	                continue;
	            } else {
	                index = i;
	                break;
	            }
	        }
	        return index;
	    }
}
