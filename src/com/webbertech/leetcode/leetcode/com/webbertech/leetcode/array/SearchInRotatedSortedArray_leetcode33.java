package com.webbertech.leetcode.array;

/*
 * Leetcode 33. Search in rotated sorted array(No dups)
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to 
 * you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. 
If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.

    Solution1: 
 *  1. Find the largest or smallest number, and get its index.
 *  Let say the smallest number's index is i, and length is n, then it needs to 
 *  rotate n-i steps. Then it is O(n) already.
 *  2. Once rotated, it is a binary search. O(logn)
 *  
 *  Solution2: use binary search (O(logn))
 *  come up with a number [4 5 6 7 0 1 2] search for 0.
 * */

public class SearchInRotatedSortedArray_leetcode33 {
	 static int search(int A[],  int target) {
		   int n = A.length;
	        int lo=0,hi=n-1;
	        // find the index of the smallest value using binary search.
	        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
	        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
	        while(lo<hi){
	           // int mid=(lo+hi)/2;
	        	int mid = lo + (hi-lo)/2;
	            if(A[mid]>A[hi]) lo=mid+1;
	            else hi=mid;
	        }
	        // lo==hi is the index of the smallest value and also the number of places rotated.
	        int rot=lo;
	        lo=0;hi=n-1; // remember to reset these
	        // The usual binary search and accounting for rotation.
	        while(lo<=hi){
	            //int mid=(lo+hi)/2;
	         	int mid = lo + (hi-lo)/2;
	            int realmid=(mid+rot)%n;
	            if(A[realmid]==target) return realmid;
	            if(A[realmid]<target)lo=mid+1;
	            else hi=mid-1;
	        }
	        return -1;
	 }
	 
	 public static void main(String[] args) {
		 int[] num = {4, 5, 6, 7, 0, 1, 2, 3};
		 System.out.println(search(num,7));
	
		 int[] num1 = {4, 3, 2, 1, 0, 5, 6, 7};
		 System.out.println(search(num1,7));
	
	 }
}