package com.webbertech.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//the input string contains dup but the output should not have dup
//solution : use a hashmap instead of list

public class StringPermutationWithDups {

	//this is working and easy to remember

	static HashMap<String, Integer> getPerms(String reminder) {

	
	int len = reminder.length();
	
	HashMap<String, Integer> result = new HashMap<>();
	
	if (len==0) {
		result.put("", 1);
		return result;
	}
	
	for (int i =0;i< len; i++) {
		
		//remove i
		String before = reminder.substring(0, i);
		String after = reminder.substring(i+1);
		
		HashMap<String, Integer> partial = getPerms(before+ after);
	
		for(Map.Entry<String, Integer> entry : partial.entrySet()) {
		     String newS = reminder.charAt(i) + entry.getKey();
			if (!entry.getKey().equals(newS))
			//	if (result.get(reminder.charAt(i) + s)) == 0)
			result.put(newS,1);
		}
	}
	
	
	return result;
}

public static void main(String[] args) {
	HashMap<String, Integer> list = getPerms("aac");
	
	for(Map.Entry<String, Integer> entry : list.entrySet()) {
	    System.out.println(entry.getKey());
	}
	
}
}

