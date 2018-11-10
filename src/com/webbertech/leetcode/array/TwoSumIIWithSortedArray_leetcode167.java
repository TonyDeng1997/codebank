package com.webbertech.leetcode.array;

import java.util.HashMap;

/* 167 Two Sum II - Input array is sorted
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 * 
 * */


public class TwoSumIIWithSortedArray_leetcode167 {

	   //The following solution works but it seems too slow
	   public static int[] twoSum(int[] numbers, int target) {
	        int mid= (numbers.length-1)/2;
	        int i=mid, j=i+1;
	        int[] res= new int[2];
	        while(i>=0&& j<numbers.length && i<j) {
	            if (numbers[i] + numbers[j] == target) {
	                res[0] = i+1;
	                res[1] = j+1;
	                break;
	            } else if (numbers[i] + numbers[j] > target) {
	            	if (i>0) {
	            		i--;
	            	} else {
	            		j--;
	            	}
	            } else {
	            	if (j<numbers.length) {
	                 j++;
	            	} else {
	            		i++;
	            	}
	            }
	        }
	        return res;
	    }
	   
	   
	   //this solution is still too slow
	   public static int[] twoSumII(int[] numbers, int target) {
		   int[] res= new int[2];
		   
		   int i=0;
		   int j=1;
		   
		   while(i<j&& j<numbers.length) {
			   if (numbers[i] + numbers[j] == target ) {
				   res[0] = i+1;
				   res[1] = j+1;
				   break;
			   }
			   if (numbers[i]+ numbers[j]< target) {
				   if (j!=numbers.length-1) {
					   j++;
				   } else {
					   i++;
				   }
			   } 
		   }
		   return res;
	   }
	   
	   //solution three using map, map always should be considered first
	   
	   public int[] twoSumIII(int[] numbers, int target) {
	       int[] res= new int[2];
	       HashMap<Integer,Integer> map = new HashMap<>();
			  for (int i=0;i<numbers.length;i++) {
			      map.put(numbers[i],i);
			  }
			  
			  for (int i=0;i<numbers.length;i++) {
			      if (map.containsKey(target-numbers[i])) {
			          res[0]=i+1;
			          res[1]=map.get(target-numbers[i])+1;
			          break;
			      }
			  }
	        return res;
	    }
	   
	   public static void main(String[] args) {
		   int[] data= {5,25,75};
		   int[] res= twoSumII(data,100);
	   }
}

