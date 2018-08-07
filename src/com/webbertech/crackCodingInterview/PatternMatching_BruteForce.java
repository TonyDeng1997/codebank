package com.webbertech.crackCodingInterview;

/*
 This is the same question as the PatternMatching.java.
 Validate: if text string: "catcatgocatgo" follows the pattern specified in 
 the string "aabab"
 
 The following solution is not working probably, but it is O(n^4).  It is extremely slow.
 Bad and bad design
*/

public class PatternMatching_BruteForce {
	
	boolean doesMatch(String pattern , String value) {
		if (pattern.length() == 0 ) 
			return value.length() == 0;
		
		int size = value.length();
		for (int mainSize=0; mainSize< size; mainSize++) {
			String main = value.substring(0, mainSize);
			
			for(int altStart = mainSize; altStart<=size; altStart++) {
				for (int altEnd = altStart; altEnd <= size; altEnd++) {
					String alt = value.substring(altStart, altEnd);
					String cand = buildFromPattern(pattern, main, alt);
					if(cand.equals(value)) {
						return true;
					}
				}
			}
			
		}
		
		return false;
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
	
	public static void main(String[] args) {
		PatternMatching_BruteForce pm = new PatternMatching_BruteForce();
		String text= "catcatgocatgo";
		String pattern = "aab";
		System.out.println(pm.doesMatch(pattern, text));
	}
}
