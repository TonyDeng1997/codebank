package com.webbertech.crackCodingInterview;

import java.util.Arrays;

//given two arrays, find a pair that has the smallest difference
//This is a good one for brain tester
//P474

public class SmallestDifference {
	//solution1: two while loop, bruteforce, init a var to be smallest diff
	//keep comparing and updating that var

	//solution2:  AlogA + BlogB O(nlogn)
	/*  idea: sort two arrays, and compare the elements to update the minDiff
	 *  update the index of the smaller element, because making its index increase 
	 *  will make it larger thus in the hope that to make the diff smaller 
	 * */
   static int findSmallestDifferencePair(int[] arr1, int[] arr2) {
 		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int i=0, j=0;
		int minDiff =Integer.MAX_VALUE;
		while(i< arr1.length && j < arr2.length) {
			
         if (Math.abs(arr1[i]-arr2[j]) < minDiff) {
			   minDiff= Math.abs(arr1[i]-arr2[j]);
         }
          
         if (arr1[i] < arr2[j]) {
            i++;        	 
         } else {
        	 j++;
         }
        	  
		}
		return minDiff;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,11,15};
		int[] b = {4,5,12, 13, 15};
		System.out.println(findSmallestDifferencePair(a,b));
	}
	
}
