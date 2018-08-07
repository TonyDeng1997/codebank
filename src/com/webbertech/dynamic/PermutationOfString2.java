package com.webbertech.dynamic;

import java.util.ArrayList;

public class PermutationOfString2 {

	
	//instead of passing the permutation backup the stack, we can push
	//the prefix down the stack. When we get to the bottom (base case)
	// prefix holds a full permutation
	
	static ArrayList<String> getPerms(String str) {
		ArrayList<String> result = new ArrayList<>();
		getPerms("", str, result);
		return result;
	}
	
	static void getPerms(String prefix, String remainder, ArrayList<String> result) {
		if (remainder.length() == 0) {
		//System.out.println(prefix);
			result.add(prefix);
		}
         
		int len = remainder.length();
		
		for (int i =0;i< len; i++) {
			String before = remainder.substring(0,i);
			String after = remainder.substring(i+1,len);
			char c = remainder.charAt(i);
			getPerms(prefix + c, before+ after, result);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = getPerms("abc");
	
		for (String str : list) {
			System.out.println(str);
		}
	}
}
