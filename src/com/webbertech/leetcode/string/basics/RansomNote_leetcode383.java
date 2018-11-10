package com.webbertech.leetcode.string.basics;

import java.util.HashMap;

/* Leetcode 383
 * Given an arbitrary ransom note string and another string 
 * containing letters from all the magazines, write a function 
 * that will return true if the ransom note can be constructed from the magazines ; 
 * otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 * 
 * 
 * solution: use map. Test all characters in one string will be part of the second string.
 * Note that the condition to check the count should not below 0 is very critical.
 * 
 * test case: ransomNOte: [a,a] and magazine: [a,b] return false.
 * 
 * This leetcode question is simple.
 * */
public class RansomNote_leetcode383 {

	public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length()>magazine.length()) {
            return false;
        }
        HashMap<Character, Integer> map= new HashMap<>();
        for(int i=0;i<magazine.length();i++) {
            if (map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i),map.get(magazine.charAt(i))+1);
            } else {
                map.put(magazine.charAt(i),1);
            }
        }
        boolean canConstruct = true;
        for(int i=0;i<ransomNote.length();i++) {
            if (map.containsKey(ransomNote.charAt(i)) && map.get(ransomNote.charAt(i))!=0) {
                map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1);
            } else {
                canConstruct = false;
                break;
            }
        }
         return canConstruct;
    }
	
	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
		System.out.println(canConstruct("aa", "aba"));
	}
}

