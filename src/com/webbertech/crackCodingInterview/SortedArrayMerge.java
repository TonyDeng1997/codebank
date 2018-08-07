package com.webbertech.crackCodingInterview;

//P396
/*
 * Given two sorted array A and B, A is big enough to merge B in.
 * Write a method to merge B to A.
 * 
    A = {1,3,5,7,9,11}
    
    B = {2,4,6,8}
 * 
 *   
 * */

public class SortedArrayMerge {

	int[] mergeSmallSortedArrayToLargeSortedArray(int[] a , int[] b, int lastA, int lastB) {
		if (a.length< b.length) 
			throw new IllegalArgumentException();
		
		 /*the algorithm is to compare and merge from the back of both arrays.
		  * 
		  *   11
		  *   9,11
		  *   8,9,11,
		  *   ...
		  */
	    int aEnd = lastA -1;
	    int bEnd = lastB -1;
		int end = lastA + lastB - 1;   
		
		while(bEnd>=0) {
			if (aEnd>=0 && a[aEnd] > b[bEnd]) {
				a[end] = a[aEnd];
					aEnd--;
			} else {
				a[end] = b[bEnd];
					bEnd--;
			}
				end--;
		}
		                        
	
		return a;
	}
	
	public static void main(String[] args) {
		int[] a = new int[10];
		a[0] = 2; a[1]=4; a[2] = 6; a[3]=8; a[4] =10; a[5] = 12;
		int[] b= {1,3,5,7}; 
		SortedArrayMerge s = new SortedArrayMerge();
		s.mergeSmallSortedArrayToLargeSortedArray(a,b, 6, 4);
		for (int i: a){
			System.out.print(i + " ");
		}
	}
}
