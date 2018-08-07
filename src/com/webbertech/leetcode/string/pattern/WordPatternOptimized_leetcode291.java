package com.webbertech.leetcode.string.pattern;

import java.util.HashMap;
import java.util.HashSet;

/*
 * Leetcode 290 WordPattern
 * Given a pattern and a string str, 
 * find if str follows the same pattern.

Here follow means a full match, such that there is a bijection 
between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.

Notes:
You may assume pattern contains only lowercase letters, and 
str contains lowercase letters separated by a single space.

**/

/*
 * Solution: 
 *  Use a hashmap and hashset.
 *  1/ hashmap is to throw (key,value) -> (pattern,word) in map
 *  2/ but hashmap does not check different key has the same value
 *  3/ Use a hashset to check save all the words in it and check the map and set's length
 *  4/ if set and map does not have the length it is false, then 
 *  5/ reconstruct the string values of the map to compare with the original string,
 *     and return true or false. This step is very critical to construct
 *     a new string from its pattern if it is like a,a,a,a.
 * */

public class WordPatternOptimized_leetcode291 {
	public static boolean wordPattern(String pattern, String str) {
        int pattern_len = pattern.length();
        //token means words
        String[] str_tokens = str.split("\\s+");
        int tokensNum = str_tokens.length;
        
        if (tokensNum!=pattern_len) {
            return false;
        }
        
        //get the pattern token for each str token
        HashMap<Character,String> tokenMap = new HashMap<>();
        //HashMap<Character, Integer> patternTokens = new HashMap<>();
        for(int i=0;i<pattern.length();i++) {
             if (tokenMap.containsKey(pattern.charAt(i))) {
            	 continue;
             }
             //for any non-duplicated pattern character c, 
             //save this character and its related str token at c' index
             //patternTokens.put(pattern.charAt(i),i);
             tokenMap.put(pattern.charAt(i), str_tokens[i]);
        }
        
        //check tokenMap if any different pattern letter they have the same
        //string token return false
        HashSet<String> tokenSet = new HashSet<>();
         for(String value: tokenMap.values()) {
        	 tokenSet.add(value);
         }
        if( tokenSet.size()!=tokenMap.size()) 
        	return false;
        
        //the following reconstruct is very important
        // as if pattern is a,a,a,a but with different value
        // then result is different than str.
        StringBuilder result = new StringBuilder();
        for(int i=0;i<pattern.length();i++) {
        	result.append(tokenMap.get(pattern.charAt(i)));
        }
        return result.toString().equals(str.replaceAll("\\s+", ""));
        
    }
	 
	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog cat cat dog";
		System.out.println(wordPattern(pattern, str)); //output true
		
		pattern = "abca";
		str = "dog cat cat dog";
		System.out.println(wordPattern(pattern, str)); // false
		
		pattern = "abba";
		str= "dog cat cat fish";
		System.out.println(wordPattern(pattern, str)); // false
		
		pattern = "aaaa";
		str= "dog cat cat dog";
		System.out.println(wordPattern(pattern, str)); // false
		
		pattern = "abba";
		str = "dog dog dog dog";
		System.out.println(wordPattern(pattern, str)); // false
	}
}