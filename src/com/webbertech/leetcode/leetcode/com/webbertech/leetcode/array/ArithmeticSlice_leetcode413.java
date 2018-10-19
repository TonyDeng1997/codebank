package com.webbertech.leetcode.array;

/*
 *  Leetcode 413 Arithmetic Slice
 *  Return arithmetic slice in an given array.
 *  
 *  A sequence of number is called arithmetic if it consists of at least three elements and if 
 *  the difference between any two consecutive elements is the same.
 *  
For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9

The following sequence is not arithmetic.
1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. 
A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.

Example:
A = [1, 2, 3, 4]
return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
* 
**/

/*
 * Solution:
 * A[i]-A[i-1] == A[i-1]-A[i-2], already guarantees that 
 * the slice is equal to 3 elements.
 * 
 * Since it counts from index 2, so for not arithmetic slice, it reset curr
 * to 0. See the next slice, sum just increase 1.
 * 
 * For the case where it is a continuous slice, say now 4 numbers are in a slice.
 * Then sum is to get sum+cur, cur increases 1 already, and cur is not reset to 0.
 * Besides the current new slice, the longer slice of the 4 elements is also counted.
 * */


public class ArithmeticSlice_leetcode413 {
	public static int numberOfArithmeticSlices(int[] A) {
	    int curr = 0, sum = 0;
	    for (int i=2; i<A.length; i++)
	        if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
	            curr += 1;
	            sum += curr;
	        } else {
	            curr = 0;
	        }
	    return sum;
	}
	
	 public static void main(String[] args) {
		 int[] A= {-1,1,3,3,3,2,1,0};
		 int[] A1= {1,1};
		 int[] A2= {1};
		 int[] A3={1,2,3,4};
		 System.out.println(numberOfArithmeticSlices(A));
		 System.out.println(numberOfArithmeticSlices(A1));
		 System.out.println(numberOfArithmeticSlices(A2));
		 System.out.println(numberOfArithmeticSlices(A3));
	 }
}