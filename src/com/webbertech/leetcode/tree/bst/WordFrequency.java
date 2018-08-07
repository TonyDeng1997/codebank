package com.webbertech.leetcode.tree.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class WordFrequency {

	  static List<String> retrieveMostFrequentlyUsedWords(String literatureText, 
              List<String> wordsToExclude) {
	
		 List<String> wordsResult = new ArrayList<>();
		 String[] words = literatureText.split("\\s+");
		 Map<String, Integer> wordsMap = countWords(words);


		  Set<Entry<String, Integer>> set = wordsMap.entrySet();
		 List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
	        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
	        {
	            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
	            {
	                return (o2.getValue()).compareTo( o1.getValue() );
	            }
	        } );
	        
		 
	       for(Map.Entry<String, Integer> entry:list ){
	    	   if (!wordsToExclude.contains(entry.getKey()) && entry.getValue() > 1) {
					 wordsResult.add(entry.getKey());
				 }
	        }
	        
		  return wordsResult;
       }
	  
	
	  
	  public static Map<String, Integer> countWords(String[] words) {
	        if (words == null) return null;
	    	Map<String, Integer> m = new HashMap<String, Integer>();
	    	 for(int i=0;i< words.length;i++) {
	    		if (m.containsKey(words[i])) {
	    		 int count= m.get(words[i]);
	    		 count++;
	    		 m.put(words[i], count); 
	    		}  else {
	    			m.put(words[i], 1);
	    		}
	    	 }
	    	return m;
	    }	
	    
	  public static void main(String[] args) {
		  String text = "hello ni hao ni hello ni hao hao hao an the dog cat.";
		  List<String> exclude = new ArrayList<>();
		  exclude.add("an");
		  exclude.add("the");
		  List<String> result = retrieveMostFrequentlyUsedWords(text, exclude);
		  
		  for(String word: result)
		  System.out.println(word);
		  
	  }
}
