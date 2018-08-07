package com.webbertech.leetcode.string.slidingwindow;

import java.util.HashMap;
/*
 * leetcode 3, 
 * 
 * longest substring that does not contains repeating 
 * characters
 *  Solution: there are two N solutions here.
 * */

public class LongestNonRepeatingCharsSubstringOptimized_leetcode3 {

	//solution 1
	public static int lengthOfLongestSubstring(String s) {
		int result = 0;
		int[] cache = new int[256];
		for (int i = 0, j = 0; i < s.length(); i++) {
			j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
			cache[s.charAt(i)] = i + 1;
			result = Math.max(result, i - j + 1);
		}
		return result;
	}

	//solution 2, use the example "abcdea"
	public static int lengthOfLongestSubstringII(String s) {
		if (s.length() == 0)
			return 0;
		//save character and its index
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		
		//j is the start index of the first repeating element, 
		// and i is the end index
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				//get the first repeating elem index
				j = Math.max(j, map.get(s.charAt(i)) + 1); //plus 1 is to get the real length
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1); //i-j is the index diff and +1 is to get the real length
		}
		return max;
	}
	

	// Solution3: a rewrite of the above two solution using a magic general template
	/*
	 * d is the length of the longest substring, init it at 0.
	 * end keep going if no repeating element until repeating element appears, count++.
	 * while loop counter>0 and increase begin index in the cache to figure out which element repeats, and decrease the count.
	 * when count==0 we find the longest substr, because by then end is 1 index off, and begin is 1 index off, so 
	 * d=max(d, end-begin)  
	*/
	public static int lengthOfLongestSubstringIII(String s) {
	        int[] cache= new int[256]; 
	        int counter=0, begin=0, end=0, d=0; 
	        while(end<s.length()){
	            if(cache[s.charAt(end++)]++>0) {
	            	counter++; //count keep track how many repeating elements
	            }
	            
	            //if repeating elements is not zero, begin increase
	            //counter>1 meaning there is repeating char, and we would like to use
	            //begine to find that out which one.
	            while(counter>0) { 
	            	if(cache[s.charAt(begin++)]-- >1) { 
	            		counter--;
	            	}
	            }
	            d=Math.max(d, end-begin); //while valid, update d
	        }
	        return d;
	}
   
	
	/*
	 * Same as solution 3 but had the logic a little clear
	 * */
	public static int lengthOfLongestSubstringIII_2(String s) {
	        int[] cache= new int[256]; 
	        int counter=0, begin=0, end=0, d=0; 
	        while(end<s.length()){
	            if(cache[s.charAt(end)]>0) {
	            	counter++; //count keep track how many repeating elements
	            }
	            cache[s.charAt(end)]++;
	            end++;
	            //if repeating elements is not zero, begin increase
	            //counter>1 meaning there is repeating char, and we would like to use
	            //begine to find that out which one.
	            while(counter>0) { 
	            	if(cache[s.charAt(begin)] >1) { 
	            		counter--;
	            	}
	            	cache[s.charAt(begin)]--;
	            	begin++;
	            }
	            d=Math.max(d, end-begin); //while valid, update d
	        }
	        return d;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("a"));
		System.out.println(lengthOfLongestSubstring("au"));
		System.out.println(lengthOfLongestSubstring("abcdea"));
		System.out.println(
				lengthOfLongestSubstring("dmgoijilqeelsstfmkdtatkaobforctuqbjyktmayqnqkhxytarwvdyjfdawhvrywcyhx"));
	
		//testing second impl
		System.out.println(lengthOfLongestSubstringII("a"));
		System.out.println(lengthOfLongestSubstringII("au"));
		System.out.println(lengthOfLongestSubstringII("abcdea"));
		System.out.println(
				lengthOfLongestSubstringII("dmgoijilqeelsstfmkdtatkaobforctuqbjyktmayqnqkhxytarwvdyjfdawhvrywcyhx"));
	
	    //testing third impl
		System.out.println(lengthOfLongestSubstringIII("a"));
		System.out.println(lengthOfLongestSubstringIII("au"));
		System.out.println(lengthOfLongestSubstringIII("abcdea"));
		System.out.println(
				lengthOfLongestSubstringIII("dmgoijilqeelsstfmkdtatkaobforctuqbjyktmayqnqkhxytarwvdyjfdawhvrywcyhx"));
		
	    //testing third impl2
			System.out.println(lengthOfLongestSubstringIII_2("a"));
			System.out.println(lengthOfLongestSubstringIII_2("au"));
			System.out.println(lengthOfLongestSubstringIII_2("abcdea"));
			System.out.println(
					lengthOfLongestSubstringIII_2("dmgoijilqeelsstfmkdtatkaobforctuqbjyktmayqnqkhxytarwvdyjfdawhvrywcyhx"));
	}
}