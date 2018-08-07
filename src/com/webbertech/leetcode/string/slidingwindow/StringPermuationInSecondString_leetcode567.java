package com.webbertech.leetcode.string.slidingwindow;

/*
String Permutation in second String(leetcode567). 
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
In other words, one of the first string's permutations is the substring of the second string. 

Example 1: Input:s1 = "ab" s2 = "eidbaooo" Output:True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2: Input:s1= "ab" s2 = "eidboaoo" Output: False
Note: The input strings only contain lower case letters. The length of both given strings is in range [1, 10,000]

Solution: 
Sliding window. Use a map concept to preserve everything in s1.
abba -> {a:2, b:2}. Since there are only 26 lower case letters in this problem, 
we can just use an array to represent the map. 

We just need to create a sliding window with length of s1, 
move from beginning to the end of s2. When a character moves in from right of the window, 
we subtract 1 to that character count from the map. When a character moves out from left 
of the window, we add 1 to that character count. 
So once we see all zeros in the map, meaning equal numbers of every characters between s1 
and the substring in the sliding window, we know the answer is true.
*/

public class StringPermuationInSecondString_leetcode567 {
	
	public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        
        // this array serves as a map
        int[] count = new int[26];
        
        /* The following step is to build the map. 
        	For every char in s1, we mark them in the array.
            For any char in the window size len1, s2 make them negative. Note that 
           now in the map, all the ones in the map should be positive.
        */ 
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) {
        	return true;
        }
        
        /*Use the example s1= "ab", s2= "ebad"
         * By here, the count is 1000(-1)0000... .
         * */
        
        /*
         * The first line in the following loop is to keep unmarking the character in case
         * they are marked in map from s1. 
         * 
         * The second line in the following loop is to recover the chars that was deducted 1
         * in the step of building the map. because they could have appear in the rest of the 
         * substrings in s2, and this is a remedy.
         * 
         * The trick of this sliding window is that, it is not checking the substring of s2 with the same 
         * size as s1 with the next character. It checks chunks of substring of s1, and s2-s1.
         * 
         * With each of the character from [len1, len2], it will check the map to see if all the character's
         * index is reset to 0. 
         * */
        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }
        return false;
    }
    
    private static boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
    	String s1 ="ab";
    	String s2 = "eidbaooo";
    	String s3 = "ebad";
    	System.out.println(checkInclusion(s1, s2));
    	System.out.println(checkInclusion(s1, s3));
    }   
}