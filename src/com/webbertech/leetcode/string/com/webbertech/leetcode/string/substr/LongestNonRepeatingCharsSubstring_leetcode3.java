package com.webbertech.leetcode.string.substr;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * leetcode 3, 
 * 
 * longest substring that does not contains repeating characters
 * 
 * Solution1: N^3, if we put isRepeat inside of n^2.
 * Solution2: N^2, iterate though m substring, and check if
 *                 it is repeating.
 *                 
 * The following two solutions are not acceptible.
 * */
public class LongestNonRepeatingCharsSubstring_leetcode3 {

	 static boolean isRepeat(String str) {
		  HashSet<Character> set = new HashSet<>(); 
		  for(char c: str.toCharArray()) {
			  set.add(c);
		  }
		  return set.size()!=str.toCharArray().length;
	 }
	
	 public static int lengthOfLongestSubstring(String s) {
	        List<String> list = new ArrayList<>();
	        int len = s.length();
	        if (len == 0 || len == 1) return len;
	        for(int i=0;i<len;i++) {
	            for(int j=1;j<=len-i;j++) {
	                String substr = s.substring(i,i+j);
	                  list.add(substr);
	            }
	        }
	        int max =0;
			for(String sub: list) {
				 if( !isRepeat(sub) && sub.length()>max) {
					 max = sub.length();
				 }
			}
			return max;
	    }
	 
	 public static void main(String[] args) {
		 System.out.println(lengthOfLongestSubstring("a"));
		 System.out.println(lengthOfLongestSubstring("au"));
		 
		 System.out.println(lengthOfLongestSubstring("abcdea"));
		 System.out.println(lengthOfLongestSubstring("dmgoijilqeelsstfmkdtatkaobforctuqbjyktmayqnqkhxytarwvdyjfdawhvrywcyhx"));
	 }
}
