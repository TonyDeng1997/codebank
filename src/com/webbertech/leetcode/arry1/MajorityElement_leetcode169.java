package com.webbertech.leetcode.array;
//leetcode 169

/*
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than n/2 times.

You may assume that the array is non-empty and the majority element always 
exist in the array.
 * 
 * */

public class MajorityElement_leetcode169 {

	 public static int majorityElement(int[] nums) {
	    int count=0;
	    int majority = nums[0];
	    int threshold = nums.length/2;
	    for(int i=0;i<nums.length;i++) {
	    	if (majority == nums[i]) {
	    		count++;
	    		if (count>threshold) {
	    			return nums[i];
	    		}
	    	} else {
	    		count--;
	    		if (count<0) {
	    			count = 0;
	    			//change majority even though we don't know if it is true or not
	    			majority= nums[i];
	    		} 
	    	}
	    }
	    
	    return majority;
	 }
	
	 public static void main(String[] args) {
		 int[] a ={1,1,1,2,2};
		 int[] b ={1,1,2,2,2};
		 int[] c ={1,1,1,1,2};
		 System.out.println( majorityElement(a));
		 System.out.println(majorityElement(b));
		 System.out.println(majorityElement(c));
		 
	 } 
	 
}
