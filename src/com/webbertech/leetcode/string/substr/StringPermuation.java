package com.webbertech.leetcode.string.substr;

public class StringPermuation {

	//This solution is not right.
	public static void printCombinations(String initial, String combined) {
	    System.out.print(combined + " ");
	    for (int i = 0; i < initial.length(); i++) {
	        printCombinations(initial.substring(i + 1),combined + initial.charAt(i));
	    }
	}


	public static void main(String[] args) {
	        printCombinations("abc", "");
	    }
	
}
