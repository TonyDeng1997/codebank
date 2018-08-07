package com.webbertech.dynamic;


//permutation without dups, this is provided by "how to crack coding interview"
//this solution is tested not quite working, there are some bugs in it

import java.util.ArrayList;

public class PermutationOfString {

	//part of solution 1
	//use recursion
	static ArrayList<String> getPerms(String str) {
		
		if (str == null) return  null;
		
		ArrayList<String> permutations = new ArrayList<>();
		
		//base case
		if (str.length() ==0 ) {
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String substr = str.substring(1);
		ArrayList<String> words = getPerms(substr);
		for(String word : words) {
			for(int i=0;i<=word.length();i++) {
				String s = insertCharAt(word, i, first);
			}
		}
		return permutations;
	}
	
	//part of solution 1
	//how to join a string heh?
	static String insertCharAt(String word, int index, char ch) {
	   	return word.substring(0, index) + ch + word.substring(index );
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = getPerms("abc");
		for(String s : list ) {
			System.out.println(s);
		}
	}
}
