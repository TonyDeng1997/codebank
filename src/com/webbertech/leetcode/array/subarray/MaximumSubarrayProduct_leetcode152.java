package com.webbertech.leetcode.array.subarray;

/*  Leetcode 152
 * 
 *  Find the contiguous subarray within an array 
 *  (containing at least one number) which has the largest product.
	For example, given the array [2,3,-2,4],
	the contiguous subarray [2,3] has the largest product = 6. 
 * */

public class MaximumSubarrayProduct_leetcode152 {

	static int maxProduct(int a[]) {
		int max = a[0]; //store the result that is the max we have found so far
		int n = a.length;
		int imax = max, imin = max;

		/*imax/imin stores the max/min product of
		 subarray that ends with the current number a[i]*/
		for (int i = 1; i < n; i++) {
			/*multiplied by a negative makes big number smaller, small number
			 bigger so we redefine the extremums by swapping them*/
			if (a[i] < 0) {
				int temp = imax;
				imax = imin;
				imin = temp;
			}

			/*max/min product for the current number is either the current
			 number itself or the max/min by the previous number times the 
			 current one*/
			imax = Math.max(a[i], imax * a[i]);
			imin = Math.min(a[i], imin * a[i]);
			System.out.println(i+ " " + imax + " " + imin);
			//the newly computed max value is a candidate for our global result
			max = Math.max(max, imax);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, -2, 4 };
		System.out.println(maxProduct(a));
		/*
		int[] b = { -2, 3, -4 };
		System.out.println(maxProduct(b));
		
		int[] c = { -2, 3, 0 };
		System.out.println(maxProduct(c));
		*/
	}
}
