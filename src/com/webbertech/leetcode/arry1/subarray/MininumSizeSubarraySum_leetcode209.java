package com.webbertech.leetcode.array.subarray;

/*
 * Leetcode 209.
 * 
 * Minimum Size Subarray Sum (leetcode209). 
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a contiguous subarray of which the sum ¡Ý s. 
 * If there isn't one, return 0 instead. For example, 
 * given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal
 * length under the problem constraint. 
 * */

public class MininumSizeSubarraySum_leetcode209 {
	
	
	   //Solution1: O(n*m), leetcode passed, most generic thought
	   public static int minSubArrayLen(int s, int[] nums) {
		   // edge case: if there is only 1 element
		   // edge case: if all the number sum in the array is less than s
		   if (nums.length == 0 || (nums.length == 1 && nums[0] > s)) {
			   return 0;
		   }
		   
	       int left = 0, right =0, sum=0;
	       Integer min  = Integer.MAX_VALUE; //max length
	       int len = nums.length;
	       
	       while(right< len) {
	    	   sum= sum+nums[right];
	    	   right++;
	    	   if (sum >= s) {
	    		   if (right-left < min) {
	    			   min = right-left;
	    		   }
	    		   left++;
    			   right=left;
    			   sum =0;
	    	   } 	    	   
	       }
	       
	       // if all the elements sum is less than s
	       int total = 0;
	       for (int i: nums) {
	    	   total = total+ i;
	       }
	       if (total<s) {
	    	   return 0;
	       }
	       return min;
	   }
	   
	   
	   //Solution2 O(n)
	   public int minSubArrayLenII(int s, int[] a) {
		   if (a == null || a.length == 0)
		     return 0;
		   
		   int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
		   
		   while (j < a.length) {
		     sum += a[j++];
		     
		     while (sum >= s) {
		       min = Math.min(min, j - i);
		       sum -= a[i++];
		     }
		   }
		   
		   return min == Integer.MAX_VALUE ? 0 : min;
		 }
	   
	   
	   //Other solutions
	   
	   private int solveN(int s, int[] nums) {
	        int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
	        while (end < nums.length) {
	            while (end < nums.length && sum < s) {
	            	sum += nums[end++];
	            }
	            if (sum < s) {
	            	break;
	            }
	            while (start < end && sum >= s) {
	            	sum -= nums[start++];
	            }
	            if (end - start + 1 < minLen) {
	            	minLen = end - start + 1;
	            }
	        }
	        return minLen == Integer.MAX_VALUE ? 0 : minLen;
	    }

	    private int solveNLogN(int s, int[] nums) {
	        int[] sums = new int[nums.length + 1];
	        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
	        int minLen = Integer.MAX_VALUE;
	        for (int i = 0; i < sums.length; i++) {
	            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
	            if (end == sums.length) break;
	            if (end - i < minLen) minLen = end - i;
	        }
	        return minLen == Integer.MAX_VALUE ? 0 : minLen;
	    }
	    
	    private int binarySearch(int lo, int hi, int key, int[] sums) {
	        while (lo <= hi) {
	           int mid = (lo + hi) / 2;
	           if (sums[mid] >= key){
	               hi = mid - 1;
	           } else {
	               lo = mid + 1;
	           }
	        }
	        return lo;
	    }
	    
	   
	   public static void main(String[] args) {
		   int[] a = {2,3,1,2,4,3};
		   System.out.println(minSubArrayLen(7, a));
		   
		   int[] b = {100};
		   System.out.println(minSubArrayLen(7, b));
		   
		   int[] c = {1,2,3,4,5};
		   System.out.println(minSubArrayLen(11, c));
		   
		   int[] d = {1,1};
		   System.out.println(minSubArrayLen(3, d));
	   }
}