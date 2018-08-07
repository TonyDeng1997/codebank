package com.webbertech.crackCodingInterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/*P572 find the longest word made of other words in the list.
 * */
public class LongestWord {

	/* solution 1: not completely correct and will not be accepted.
	 * Because we assume that each composite word is composed by other
	 * two words.
	 * M words and N length, it is O(M*N)
	*/
	 String getLongestCompositeWord(String[] list) {
		 HashMap<String, Boolean> map = new HashMap<>();
		 
		 for (String w: list) {
			 map.put(w, true);
		 }
		 
		 String longestWord = list[0];
		 
		 for(String w: list) {
			 for (int i=1;i< w.length();i++) {
				 String first = w.substring(0, i);
				 String second = w.substring(i);
				 if (map.containsKey(first)  && map.containsKey(second)) {
					 if (w.length() > longestWord.length()) {
						 longestWord = w;
					 }
					
				 }
			 }
		 }
		 return longestWord;
	 }
	 
	 /*Solution 2: Use DP and recursion to construct a word,
	  * 1/ the map is used to keep track of composite word. true if it is a composed word, and false it is not.
	  * 2/ the original solution from the book adds intermediate substrings into map, that is wrong
	  * 3/ Finally, only the composite word made of other words will be true; composite word partially made of
	  *    other words are false. The atomic word will be false.
	  * 
	  * */
	 String printLongestWord(String[] arr) {
		 //put all words in a map
		 HashMap<String,Boolean> map = new HashMap<>();
		 for (String str: arr) {
			 map.put(str,true) ;
		 }
		 
		 Arrays.sort(arr, new LengthComparator()); //sort by length
		 String longestWord = arr[0];
		 for (String s: arr) {
		  // System.out.println(canBuildWord(s, true, map));
			 if (canBuildWord(s, true, map)) {
				 longestWord = s;
			 }
		 }
		 return longestWord;
	 }
	 
	 /*DP, recursion, the book has this termination condition wrong, it should return boolean value.
	 */
	boolean canBuildWord(String str, boolean isOriginalWord, HashMap<String, Boolean> map) {
	   /*if the str here is the rest of the word where the left of the original was already found in the map.
	    * when we call the recursive canBuildWord, we always set the str as false(non-original word), but then
	    * here we can actually check if it exists, then we will return true.
	    * The logic is then: if left is found in the map and right is also found in the map, 
	    * then this word's value will be true. Similar to the above solution 1 with two words.
	    * 
	    * For example: whatsoever = what + soever,
	    * 
	    * when "soever" is str here, it will not hit the following because map does not have it.
	    * Then it calls canBuildWord recursively, and map contains "so", then "ever" is str and
	    * comes into this method again. This time "ever" will be returned in the following if block.
	    * 
	    */
		if (map.containsKey(str) && !isOriginalWord) {
		   return map.containsKey(str);
	   }
	   
	   for (int i=1;i< str.length();i++) {
		 String left = str.substring(0,i);
		 String right = str.substring(i);
		 //try to understand this, for each right word, see the logic, because the right isn't an original word
		 // at least we do not know, and we want to figure it out so we put a false here
		 // if it does exist, then just return the existing word, and we don't want to do any work on it
		 try {
			 //there is a bug over here, need to fix it, don't use debugger, just think it through
			 if (map.containsKey(left) && canBuildWord(right, false, map)) {
				 return true;
			 } 
		 } catch (Exception e) {
		     System.out.println("left:" + left);
		     System.out.println("right:" + right);
		 }
		  
	   }
	   
	   //if str is a word in the map, then we update it, else don't add new substring into the map
	    if (map.containsKey(str)) {
		   map.put(str, false);
	    }
	   return false;
	}
	
	
    //this way is new in jdk 7 up
	class LengthComparator implements Comparator<String> {
		@Override
		public int compare(String str1, String str2) {
			return Integer.compare(str1.length(), str2.length());
		}
	}
	
	public static void main(String[] args) {
		LongestWord longestWord = new LongestWord();
		
        //the following list contains a few candidate composite words, and a composite word that is not completed made of
	    //other words, but it is the longest.	
		String[] list = {"capable", "cap", "able", "noon", "after", "afternoon", "what", "so", "ever", "whatsoever",
				"news","paper", "man", "newspaperman", "newspapermanaaaa"};
		
		
		//test solution 1
		//System.out.println(longestWord.getLongestCompositeWord(list));
		
		//test solution2
		System.out.println(longestWord.printLongestWord(list));
	}
}
