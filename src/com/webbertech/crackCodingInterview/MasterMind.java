package com.webbertech.crackCodingInterview;

//P492 not very difficult
/*
 * Computer has four slots, R, G, B, Y meaning red, green, blue, and yellow.
 * If you get a correct color with correct slot, it is a hit.
 * If you get guess a color that exists but in wrong slot, it is a pseudo-hit.
 * A lot can be a hit can not be counted as a pseudo-hit. 
 * 
 * write a method that, give a guess and a solution, returns the number of hits and pseudo-hits
 * 
 * Example: answer RGBY, Guess GGRR, one hit two pseudo-hits
*/

public class MasterMind {
  
	 class Result {
	     public int hits =0;
	     public int pseduoHits =0;
	     public String toString() {
	    	 return "(" + hits + ", " + pseduoHits + ")";
	     }
	 }
	
	 int code(char c) {
	   switch(c) {
	   case 'B': return 0;
	   case 'G': return 1;
	   case 'R': return 2;
	   case 'Y': return 3;
	   default : return -1;
	   }	 
	 }
	 
	 int MAX_COLORS= 4;
	 
	 Result getResult(String guess, String solution) {
		 if (guess.length() != solution.length()) 
			 return null;
		 
	     int[] freq = new int[MAX_COLORS];     //array to count mishits elements in guess
	     int[] checker = new int[MAX_COLORS];  //array to count the freq of solution elements
	     int[] match =new int[MAX_COLORS]; //array to store match element
	     Result result  = new Result();
	     
	     //first count all the element occurences for solution and store in checker array
	     
	     for(int i=0;i< solution.length();i++) {
	        int code = code(solution.charAt(i));
	        checker[code]++;
	     } 
	     
	     for(int i=0;i< guess.length();i++) {
	    	 int code = code(guess.charAt(i));
	    	 if (guess.charAt(i) == solution.charAt(i)) {
	    		 result.hits++;
	    		 match[code]++;
	    	 } else {
	    		 //only use the frequence array for pseudo hits, not for hits. Otherwise 
	    		 //hits will make things complex
	    		
	    		 freq[code]++;
	    	 }
	     }
	     
	     
	     
	    /*
	     * The following is from the how to crack coding interview, I don't think it is correct
	     * 
	     for(int i=0;i<guess.length();i++) {
	    	 int code = code(guess.charAt(i));
	    	 //freq[code] > 0 because the psedu hits are among these non zero hits
	    	 //for any slot that guess is all the non-match hits including some element
	    	 //that is already counted for hit, we need to remove those
	    	 //for this test example: the freq table is: 0 1 2 0
	    	 
	    	 if (code >= 0 && freq[code]>0 && guess.charAt(i) != solution.charAt(i)) {
	    		 freq[code]--;
	             result.pseduoHits++;
	    	 }
	     }*/
	       
	     //we have three array now, first off subtract the matched array from the freq array 
	     /*
	      * For example, the checker array is: 1, 1,1,1
	      *              the freq array is:  0,1,2,0             
	      *              the match array is: 0,1,0,0
	      * 
	      * */
	     for(int i=0;i< freq.length;i++) {
	    	 if (match[i]!=0) {
	    		 freq[i] = freq[i] - match[i];
	    	 }
	     }
	     
	     for(int i=0;i< freq.length;i++) {
	    	 
	    	 if (freq[i]!=0) {
	    		 freq[i] = freq[i] - checker[i];
	    	 }
	    	 result.pseduoHits += freq[i];
	     }
	      
	     return result;
	 }
	 
	 public static void main(String[] args) {
		System.out.println(new MasterMind().getResult( "GGRR","RGBY").toString());
	 }
}
