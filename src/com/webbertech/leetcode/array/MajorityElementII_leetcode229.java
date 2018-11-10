package com.webbertech.leetcode.array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode 229 
/*
 * Given an integer array of size n, find all elements that appear more than [ n/3 ] times. 
 * The algorithm should run in linear time and in O(1) space.
 * 
 * */
// 1       output: 1
// 2 2     output: 2
// 1 2 3   null
// 1 1 2 3  output: 1
// 1 1 2 2 3 3 null
// 3 3 3 3 3 3 output 3
// 3 3 3 2 2 2

//Not working yet

/*
 *        List<Integer> list = new ArrayList<>();
	      
	        if (nums.length==0)
	        	return list;
	        if (nums.length <=2) {
	        	for(int i=0;i<nums.length;i++) {
	        		list.add(nums[i]);
	        	}
	        }
	        int i=0;
	        int j=i+1;
	        int count=1;
	        int threshold = nums.length/3;
	        while(j<nums.length) {
	        	if (nums[i] == nums[j]) {
	        		count++;
	        	} else {
	        		// 1 1 2 2 3 3
	        		if(count>=threshold) {
	        			list.add(nums[i]);
	        		}
	        		count=0;
	        		
	        	}
	        	i++;j++;
	        }
	
	        return list;
 * */

//accepted but this is not O(1) space
// need to check a better solution
public class MajorityElementII_leetcode229 {
	
	  public static List<Integer> majorityElement(int[] nums) {
	 
		  int threshold = nums.length/3;
	        ArrayList<Integer> list = new ArrayList<>();
	        if (nums.length == 0)
	                return list;
	        if (nums.length < 3) {
	        	for (int i: nums) {
	        	if (!list.contains(i))
	        		list.add(i);
	        	}
	        	return list;
	        }
            //build a frequency of an array	      
	        HashMap<Integer, Integer> map = new HashMap<>();
	        for (int i: nums) {
	        	if (!map.containsKey(i)) {
	        		map.put(i, 1);
	        	} else {
	        		map.put(i, map.get(i)+1);
	        		if (map.get(i)>threshold) {
	        			if (!list.contains(i)) {
	        				list.add(i);
	        			}
	        		}
	        	}
	        }
	        
	        return list;
	  }
	  
	  public static void main(String[] args) {
		  int[] list = {1,2};
		 List<Integer> data = majorityElement(list);
		  for(int i: data) {
			  System.out.println(i);
		  }
	  }
}
