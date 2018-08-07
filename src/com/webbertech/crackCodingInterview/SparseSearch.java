package com.webbertech.crackCodingInterview;

/*
 * P401
 * Sparse Search: 
 * 
 * Given a sorted array of strings that is interspersed with empty string, 
 * write a method to find the location of a given string. 
 * 
 * {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
 * 
 * input: ball, output: 4
 * 
 *  
 * */

/*Solution 1: the dumbass way to find it is O(n) 
  Solution 2: O(logn) to use a modified binary search, the worse case is O(n), 
  and no better than O(n). The problem here is that the string to be searched 
  is assumed not to be "", what if it is ""? ask your interviewer 
  
 * */

public class SparseSearch {
	
	int findPos(String[] array, String input, int first, int last) {
	    if (first > last) return -1;
	    
	    int mid = (last + first)/2;

	    
	    /*this is the core part, try to avoid the empty string from now on
	     * if mid is "", then it will replace mid with left or right index that is not ""
	     * and then the later recursion will be just doing what native binary search does
	     */
	    if(array[mid].isEmpty()) {
	    	int left = mid -1;
	    	int right = mid +1;
	    	
	    	while (true) {
	    		if (left < first && right > last) {
	    			return -1;
	    		} else if (right <= last && !array[right].isEmpty()) { 
                     mid = right;   //find the nonempty string to be mid, and break out right away
                     break;
	    		} else if (left >= first && !array[left].isEmpty()) {
	    			 mid = first;  //same as above
	    			 break;
	    		}
	    		right++;
	    		left--;
	    	}
	    }
	    
	    
	    if (array[mid].equals(input)) {
	    	return mid;
	    } else if (array[mid].compareTo(input) <0 ) { //search right
	    	return findPos(array, input, mid+1, last);
	    } else {
	    	return findPos(array, input, first, mid-1);
	    }
	    

	}
	
	
	//try to understand Java String libary
  public static void main(String[] args) {
	  String a = "";
	  String b = " "; 
	  System.out.println(a.compareTo(b));
	  System.out.println("a".compareTo("b"));
	  System.out.println("aa".compareTo("ab"));
	  System.out.println("aa".compareTo("abc"));
	  System.out.println("ac".compareTo("abc"));
	  System.out.println("acb".compareTo("abc"));
	  System.out.println("abc".compareTo("ab"));
	  
	  String[] str1 = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
	  String[] str2 = {"at", "", "", "all", "ball", "", "", "car", "", "", "dad", "", ""};
	  SparseSearch s = new SparseSearch();
	  System.out.println(s.findPos(str1,"ball", 0, str1.length-1));
	  System.out.println(s.findPos(str1,"at", 0, str1.length-1));
	  System.out.println(s.findPos(str2,"all", 0, str1.length-1));
  }
}
