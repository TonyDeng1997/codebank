package com.webbertech.leetcode.array;
/*leetcode 268
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
find the one that is missing from the array.
For example, Given nums = [0, 1, 3] return 2.
Note: Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity? 
*/

public class MissingNumber_leetcode268 {
    
	public static int missingNumber(int[] nums) {
	      int sum=0;
	      for(int i=0;i<nums.length;i++) {
	    	  sum+=nums[i];
	      }
	      
	      int total=0;
	         
	      for(int i=0;i<=nums[nums.length-1];i++) {
	    	  total+=i;
	      }	
	      
	
	      return total-sum; 
     }
	
	public static void main(String[] args) {
		int[] a = {0, 1, 3};
		int[] b = {0};
		System.out.println(missingNumber(a));
	}
}