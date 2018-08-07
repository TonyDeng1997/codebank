package com.webbertech.algorithm.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IterativePermutation {

	static ArrayList<Character> getNewString(char[] c ) {
		ArrayList<Character> newStr = new ArrayList<>();
		for(char l: c) {
			newStr.add(l);
		}
		return newStr;
	}
	
	public static Set<String> nonDuplicatedPermutation(String str) {
		char[] c = str.toCharArray();
		HashSet<String> set = new HashSet<>();
		ArrayList<Character> newString;
		
		for(int i=0;i<c.length;i++) {
			newString = getNewString(c);
			for(int j=1;j<c.length-1;j++) {
				newString.add(j, c[i]);
				//add that new string to
				set.add(newString.toString());
			}
		}
		return set;
	}
}
