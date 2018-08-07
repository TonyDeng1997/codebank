package com.webbertech.crackCodingInterview;

import java.util.ArrayList;
import java.util.HashMap;

//P499
/*
 * A string to match from: catcatgocatgo (13 letters)
 * A pattern to match: aabab (meaning match if a is cat, and b is ) 
 * 
 * solution 1: brute force, this is very slow  O(n^5)
 * 
 * solution 2: 
 *   1/ if a in pattern is 1 letter, 3 a would be 3, there are 2 bs, and 10 letters in string
 *      then each b is 5 letters in string, this is valid
 *      
 *      if a in pattern is 2 letters, 3 a would be 6, there will be 7 letters for 2 b, 
 *      it is impossible
 *      
 *      if a in pattern is 3 letters, each b is 2 letters, possible
 *      
 * */

public class PatternMatching {
	
	int countOf(String pattern, char c) {
	   int count = 0;
	   for (int i=0;i<pattern.length();i++) {
		   if (pattern.charAt(i) == c) {
			   count++;
		   }
	   }
	   return count;
	}
	
	/*from the pattern, main and alternative token string from text string
	 * to build a new text string based on the pattern string, and return
	 * this new string. 
	 * 
	 * The new string is used to compare with the text string
	 * */
	String buildFromPattern(String pattern, String main, String alt) {
	   StringBuffer sb = new StringBuffer();
	   char first = pattern.charAt(0);
	   for (char c: pattern.toCharArray()) {
		  if (c == first ){
		   sb.append(main);
		  } else {
		   sb.append(alt);
	      }
	   }
	   return sb.toString();
	}
	
	boolean doesMatch(String pattern, String value) {
		if (pattern.length() == 0) 
			return value.length() == 0;
		
		char mainChar = pattern.charAt(0); //the first letter in the pattern
		char altChar = mainChar == 'a' ? 'b' : 'a'; //smart way
		int size = value.length(); //this is the text to be searched
		int countOfMain = countOf(pattern, mainChar);
		int countOfAlt = pattern.length() - countOfMain;
		int firstAlt = pattern.indexOf(altChar); //meaning b in the test case
		
		//13 letters in text, 3 main char is a
		int maxMainSize = size / countOfMain;
		
		/*core logic is here
		 * 	up to here, we know the first and second token string, and we know the pattern
		    so we can build up a string with the same length as the text string
			and compare with the text string
		 */
		for (int mainSize =0; mainSize <= maxMainSize; mainSize++) {
			//the length for pattern letter b
			int remainingLength = size - mainSize * countOfMain;
			//the first main substring, in this example will be c
			String first = value.substring(0,mainSize);
			
			
			//the second condition is intuitive, but the first condition should also be considered
			if (countOfAlt==0 || remainingLength % countOfAlt ==0) {
				 /*the following step is very import, because it needs to know 
				 * the second pattern letter's index and the size of the main pattern letter's string
				 * in the text to be search, then we skip all the main pattern token(a) strings ('cat')
				 * and then first the first alt token string 's starting index
				 */
				 int altIndex = firstAlt * mainSize; 
				 int altSize = countOfAlt == 0 ? 0: remainingLength /countOfAlt;
				 String second = countOfAlt == 0 ? "":value.substring(altIndex, altSize+ altIndex);
				
			
				 String cand = buildFromPattern(pattern, first, second);
				 if (cand.equals(value)) {
					 return true;
				 }
			}
			
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		PatternMatching pm = new PatternMatching();
		String text= "catcatgocatgo";
		String pattern = "aabab";
		System.out.println(pm.doesMatch(pattern, text));
	}
	
}
