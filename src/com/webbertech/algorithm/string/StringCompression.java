package com.webbertech.algorithm.string;

/* * 
 * Input: aabccccccaa
   Output: a2b1c5a3
   If the output string is longer than the original return the original
 */

public class StringCompression {
   
	static String compress(String str) { 
		StringBuilder compressed = new StringBuilder();
		int countConsecutive =0;
		
		for(int i=0;i<str.length();i++) {
			//no matter what, it will increase by 1, because aab, or abb, a will increase
			//in first case, the second round the count will be 2 for a
			countConsecutive++;
			
			 //check next char not the same, then add to string
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {  //aab for example
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive =0;
			}
		}
		
	//	return compressed.length() < str.length()? compressed.toString(): str;
		return compressed.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(compress("abbbb"));
	}
}
