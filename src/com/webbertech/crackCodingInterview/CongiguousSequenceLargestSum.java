package com.webbertech.crackCodingInterview;

//Continous sequence, find a sequence has the largest sum and return the sum
/*
 * this algorithm is specially designed for the fact that 
 * the array is alternating with positive and negative number
 * 
 * This is a good question to practise
 * */
public class CongiguousSequenceLargestSum {
 
	static int getLargestSum(int[] arr) {
		int sum = 0, maxSum =0;
		
		for(int i=0;i< arr.length;i++) {
			sum += arr[i];
			if (sum > maxSum) {
				maxSum = sum;
			} else if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;
	}
	
	
	/*
	 * this is how it is working, the key is to reset sum to 0 if sum is negative
	 * Just one round of iteration of array, always increment i
	 * */
	  
	public static void main(String[] args) {
	  
		int[] test = {5,-9,6,-2,3};
		System.out.println(getLargestSum(test));
	}
}
