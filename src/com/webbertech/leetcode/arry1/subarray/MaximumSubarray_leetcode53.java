package com.webbertech.leetcode.array.subarray;

/*
 * Leetcode 53.
 * 
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest sum. For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
   the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * */

/*
 * solution: 
 * set int max = 0,
 * first pointer i starts from 0, and second pointer j starts from i+1.
 * second pointer goes as long as sum is getting larger. 
 * If sum is going down,  stop and check the sum
 * with max, if larger, then replace max, else, i++ and j= i+1, keeps going
 * 
 * Jon Bentley (Sep. 1984 Vol. 27 No. 9 Communications of the ACM P885)
 * 
 * Solution: keep it in mind
 * */

public class MaximumSubarray_leetcode53 {
	 public static int maxSubArray(int[] nums) {
	        if (nums.length == 0) return 0;
	        if (nums.length ==1) return nums[0];
	        int maxSoFar= nums[0];
	        int maxEndingHere = nums[0];
	        for (int i=1;i<nums.length;i++) {
	        	maxEndingHere= Math.max(maxEndingHere+ nums[i],nums[i]); //maxEndingHere is the max value when i in different places.
	        	maxSoFar=Math.max(maxSoFar, maxEndingHere);	
	        }
	        
	        return maxSoFar;
	 }
	 
	 public static void main(String[] args) {
		 int[] a={-2,1,-3,4,-1,2,1,-5,4};
		 System.out.println(maxSubArray(a));
	 }
}