package com.webbertech.algorithm.string;

import java.util.HashSet;

public class StringPermuations {

	//this will get all the substrings including empty string.
	//recursion solution
    private  void permutation(String input, String sofar, HashSet<String> subStringSet) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
           
            //if the rest of the string contains the same character, then skip it.
            if (input.indexOf(c, i + 1) != -1)
            continue;
     
            //add to hashset
            subStringSet.add(sofar);
            //for debugging purpose
            //System.out.print(input.substring(0, i) + input.substring(i + 1) + "\t");
            //System.out.print(sofar+ "\t" + "\t" + c + "\n");
            
            //this is very simple
            permutation(input.substring(0, i) + input.substring(i + 1), sofar+c, subStringSet);
        }
    }
    
	public static void main(String[] args) {
		 String input = "abc";
		 HashSet<String> subStringSet = new HashSet<>();
		 StringPermuations sp = new StringPermuations();
		 sp.permutation(input, "",subStringSet );
		 
		 
		  // sp.getAllPermutations(input,subStringSet);
		 
		  for(String subStr : subStringSet) {
			  System.out.println(subStr);
		  }
        
    }	
}
