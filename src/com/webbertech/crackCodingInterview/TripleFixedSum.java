package com.webbertech.crackCodingInterview;

import java.util.Arrays;

/*
 * Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. 
 * If there is such a triplet present in array, then print the triplet and return true. 
 * Else return false. For example, if the given array is {12, 3, 4, 1, 6, 9} and given 
 * sum is 24, then there is a triplet (12, 3 and 9) present in array whose sum is 24.
 * 
 * 
 * */


public class TripleFixedSum {
	//for example, {12, 3, 4, 1, 6, 9}, find triplet that sum to 24
		//step 1, sort the array, it is O(nlogn)
		//step 2, 
		public static void findTripleNumbers(int[] array, int sum) {
			   	 Arrays.sort(array);  //nlogn
			   	 //array.length-2 will be for l, 
			   	 //and r starts from array.length-1 if it doesn't move
			  
			  for(int i=0; i< array.length-2; i++) {
				  int l= i+1;
				  int r= array.length-1;
				  while(l<r) {
					  if(array[i] + array[l] + array[r] == sum) {
						  System.out.println(array[i] + " " + array[l] + " " + array[r]);
						  break;
					  } else if (array[i] + array[l] + array[r] < sum) {
						  l++;
					  } else {
						  r--;
					  }
				  }
			  }
		 }
}