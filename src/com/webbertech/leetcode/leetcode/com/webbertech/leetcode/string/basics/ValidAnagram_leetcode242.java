package com.webbertech.leetcode.string.basics;
/*
 * leetcode 242
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * */
import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram_leetcode242 {
	
	// This is O(nlogn) and O(n) space, 
	//this is accepted but there are better solution
	public static boolean isAnagram(String s, String t) {
        if (s.equals("") && t.equals("")) {
            return true;
        } else if (s.length() != t.length() ) {
            return false;
        }
        
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        Arrays.sort(s_char);
        Arrays.sort(t_char);
        
        return new String(s_char).equals(new String(t_char));
    }
	
	//solution2: use map
	public static boolean isAnagram2(String s, String t) {
        if (s.equals("") && t.equals("")) {
            return true;
        } else if (s.length() != t.length() ) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        //store s in it.
        for(int i=0;i<s.length();i++) {
        	if (!map.containsKey(s.charAt(i))) {
        		map.put(s.charAt(i),1);
        	} else {
        		map.put(s.charAt(i),map.get(s.charAt(i))+1);
        	}
        }
        
        for(int i=0;i<t.length();i++) {
        	if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i))<1) {
        		return false;
        	} else {
        		map.put(t.charAt(i),map.get(t.charAt(i))-1);
        	}
        }
        return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram")); //return true
		System.out.println(isAnagram("rat", "car"));  //return false;
		
		System.out.println(isAnagram2("anagram", "nagaram")); //return true
		System.out.println(isAnagram2("rat", "car"));  //return false;
	}
}
