package com.webbertech.leetcode.string.basics;

/* Leetcode 541 Reverse String II
 * 
 * Given a string and an integer k, 
 * you need to reverse the first k characters for every 2k characters 
 * counting from the start of the string. 
 * 
 * If there are less than k characters left, 
 * reverse all of them. 
 * 
 * If there are less than 2k but greater than or equal to k 
 * characters, then reverse the first k characters and left the other as original. 
 * 
 * 
 * Example:

	Input: s = "abcdefg", k = 2
	Output: "bacdfeg"

	Restrictions:
    The string consists of lower English letters only.
    Length of the given string and k will in the range [1, 10000]

 * */

public class ReverseStringII_leetcode541 {

	// reverse chars from i to j in array a
	static void reverse(char[] a, int i, int j) {
		while (i < j) {
			char temp = a[j];
			a[j] = a[i];
			a[i] = temp;
			i++;
			j--;
		}
	}

	public static String reverseStr(String s, int k) {
		if (s == null || s.isEmpty())
			return "";
		if (k == 0 || k == 1 )
			return s;
		char[] a = s.toCharArray();
		// If total is less than k or equal to k, then reverse all of them
		if (s.length() <= k) {
			reverse(a, 0, s.length() - 1);
			return String.valueOf(a);
		}

		int i = 1;
		int start = 0;
		int end = 2*k * i-1;
		while (end <= s.length() - 1) {
		    reverse(a, start, start+k-1);
			start = 2*k*i;
			end = start + 2*k - 1;
			i++;
		}

		// The rest of them is less than k
		if (start < s.length() - 1 && end - start < 2 * k && end-start > k) {
			   if (start+k-1 < s.length()-1) {
				  reverse(a, start, start+k-1);
			   } else {
				   reverse(a, start, s.length()-1);
			   }
		}
		return String.valueOf(a);
	}

	//expected: "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi"
	//output:   "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl"
	public static void main(String[] args) {
		String s1 = "abcdefg";  
		String s2 = "abcdefgh";
		String s3 = "abcdefghi";
		String s4 = "abcdefghij";
		String s5 = "abcd";
		String s6 = "abcdefg";
		String s7 = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
				
		System.out.println(reverseStr(s1, 2));   //bacdfeg
		System.out.println(reverseStr(s2, 2));   //bacdfegh
		System.out.println(reverseStr(s3, 2));   //bacdfehgi
		System.out.println(reverseStr(s4, 2));   //bacdfeghji
		System.out.println(reverseStr(s5, 4));   //dcba
		System.out.println(reverseStr(s6, 8));   //gfedcba
		System.out.println(s7.length());
		System.out.println(reverseStr(s7, 39));  
		
	    String s8= "imjkfnqcqnajmebeddqsgl";
	    System.out.println(s8.length());
	}
}
