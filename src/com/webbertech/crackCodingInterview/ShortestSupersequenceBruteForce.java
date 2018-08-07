package com.webbertech.crackCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * P584 Shortest Supersequence
 * 
 * Given two integer arrays, one shorter(all distinct elements) and the longer. 
 * Find the shortest subarray in the longer array that contains all the elements in the shorter array.
 * The items can appear in any order.
 * 
 *  Input: {1, 5, 9}
 *   {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7}
 * */

public class ShortestSupersequenceBruteForce {
    
	
	class SubArray {
		int start;
		int end;
		
		SubArray() {
			start = -1;    //preset to a value, make assumption that all the values are positive
			end = -1;      //otherwise use some Integer_MIN_VALUE
		}
	}
	
	
	//make sure the larger array is the first argument, this is still not right
	ArrayList searchLargeArray(int[] data, int[] shortArray) {
		
		if (data.length < shortArray.length) {
			 throw new IllegalArgumentException();
		}
		ArrayList list = new ArrayList();
		for(int i: shortArray) {
			list.add(i);
		}
		ArrayList result = new ArrayList(); // use this list to collect result
		
		//not entirely correct
		int i =0;
		int j =0;
		while (i< data.length) {
			SubArray sa = new SubArray();
			if (list.contains(data[i])) {
		       sa.start = i; //set start index
		         System.out.println(data[i]);
		      j = i+1;
		       while (j+1< data.length) {
		    	   if (list.size() <=0 )
		    		   break;
		    	   else if (list.contains(data[j])) {
		    		   System.out.println(data[j]);
		    	   } 
		    	   j++; 
		       }
		       
		   	  //when the list's size ==0, that means all the elements have been found, then add the end index into the object
					sa.end = j-1;
					   System.out.println("tseting here "+ (j-1));
					//add sa to the result
					result.add(sa);
				}
			//if not found, increase i
			i++;
			   
			}
		  return result;
		}
		
	
		
	
	//simple enough to figure out which is the shortest
	SubArray findShortest(ArrayList<SubArray> result) {
		int min= Integer.MAX_VALUE;
		SubArray shortest = null;;
		for(SubArray sa: result) {
			if (sa.end-sa.start < min) {
				min = sa.end-sa.start; //update the min
				shortest = sa;
			}
		}
		return shortest;
	}
	
	public static void main(String[] args) {
		int[] longArray = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
		int[] shortArray = {1, 5, 9};
		ShortestSupersequenceBruteForce s = new ShortestSupersequenceBruteForce();
		ArrayList arr = s.searchLargeArray(longArray, shortArray);
		SubArray sub = s.findShortest(arr);
		System.out.println("Test final result");
		System.out.println(sub.start);
		System.out.println(sub.end);
	}
	
}

