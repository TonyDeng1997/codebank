package com.webbertech.dynamic;

import java.util.ArrayList;

//this is working and easy to remember, remember this

public class PurmutationOfString1 {

	static ArrayList<String> getPerms(String reminder) {

		
		int len = reminder.length();
		
		ArrayList<String> result = new ArrayList<>();
		
		if (len==0) {
			result.add("");
			return result;
		}
		
		for (int i =0;i< len; i++) {
			
			//remove i
			String before = reminder.substring(0, i);
			String after = reminder.substring(i+1);
			
			ArrayList<String> partial = getPerms(before+ after);
		
			for(String s: partial) {
				result.add(reminder.charAt(i) + s);
			}
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = getPerms("aac");
	
		for (String str : list) {
			System.out.println(str);
		}
		
	}
}
