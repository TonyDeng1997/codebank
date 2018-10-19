package com.webbertech.leetcode.array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * leetcode 219
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j 
 * in the array such that nums[i] = nums[j]
 * and the difference between i and j is at most k (distance).
 *  
 * 1 1 3 1 4 5 1, k = 3
 *  
 * This is a very good question, please pay attention to solution 3.
 * */

public class ContainsDuplicateII_leetcode219 {
	
	//solution1: native solution O((n-k)*k), slow
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
    	if (nums.length <= 1 || k <=0 ) return false;
    	
    	if (k>= nums.length) {
    		k = nums.length -1;
    	}
    	int j = 0;
    	for(int i=0;i<nums.length;i++) {
        	j = i+1;
        	while (j<=i+k && j< nums.length) {
        	  if (nums[i] == nums[j])
        		  return true;
        	  j++;
        	}
        
        }
        return false;
    }
    
    //solution2, 
    //using hashset instead
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
    	if (nums.length <= 1 || k <=0 ) return false;
        HashMap<Integer, Integer> map = new HashMap<>();   
        for(int i=0;i<nums.length;i++) {
           if (map.containsKey(nums[i])) {
        	   //exits an element whose index to the repeating element i is equal or less than k
        	   if (i-map.get(nums[i])<=k) {
        		   return true;
        	   }
           }
           //does not exists, then save it to the map
           map.put(nums[i],i);
        }
        return false;
    }
    
    
    //solution3: this is a working solution and it is better
    public static boolean containsNearbyDuplicate3(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int j = 0; j < nums.length; j++){
            /*don't keep any element which is repeating at distance k., 
        	   always keep k numbers, 
        	   when j< k, if there is any repeating, return true and quit 
        	   cleanly, 
        	   for index > k, only keep k element.
        	   it is more like a sliding window.
        	   for example: 1 2 1 1 2 3 1 , k=3
        	*/
        	if(j > k) {
        		set.remove(nums[j - k - 1]);
        	}
        	// api returns false if the element already exists
            if(!set.add(nums[j])) {
            	return true;
            }
        }
        return false;
    }
    
    
    public static void main(String[] args) {
    	/*
    	System.out.println("test 0");
    	int[] data = {99,99};
    	System.out.println(containsNearbyDuplicate3(data, 2)); // true
    	
    	System.out.println("test 1");
    	int[] data1 = {-1,-1};
    	System.out.println(containsNearbyDuplicate3(data1, 1)); //true
    	
    	System.out.println("test 2");
    	int[] data2 = {1};
    	System.out.println(containsNearbyDuplicate3(data2, 1)); // false
    	
    	System.out.println("test 3");
    	int[] data3 = {1,2}; 
    	System.out.println(containsNearbyDuplicate3(data3, 2)); //false
    	
    	System.out.println("test 4");
    	int[] data4 = {2,2};
    	System.out.println(containsNearbyDuplicate3(data4, 3));  // true
    	
    	System.out.println("test 5");
    	int[] data5 = {4,1,2,3,1,5};
    	System.out.println(containsNearbyDuplicate3(data5, 3));  //true
    	
    	System.out.println("test 6");
    	int[] data6 = {1,2,3,4,5,6,7,8,9,9};
    	System.out.println(containsNearbyDuplicate3(data6, 3));  //true
    	
    	System.out.println("test 7");
    	int[] data7 = {1,2,3,5,6,1,3,1};  
    	System.out.println(containsNearbyDuplicate3(data7, 3)); //true
    	
    	System.out.println("test 8");
    	int[] data8 = {1,2,3,5,6,1}; 
    	System.out.println(containsNearbyDuplicate3(data8, 3)); // false
    	*/
    	
    	System.out.println("test 0");
    	int[] data = {99,99};
    	System.out.println(containsNearbyDuplicate2(data, 2)); // true
    	
    	System.out.println("test 1");
    	int[] data1 = {-1,-1};
    	System.out.println(containsNearbyDuplicate2(data1, 1)); //true
    	
    	System.out.println("test 2");
    	int[] data2 = {1};
    	System.out.println(containsNearbyDuplicate2(data2, 1)); // false
    	
    	System.out.println("test 3");
    	int[] data3 = {1,2}; 
    	System.out.println(containsNearbyDuplicate2(data3, 2)); //false
    	
    	System.out.println("test 4");
    	int[] data4 = {2,2};
    	System.out.println(containsNearbyDuplicate2(data4, 3));  // true
    	
    	System.out.println("test 5");
    	int[] data5 = {4,1,2,3,1,5};
    	System.out.println(containsNearbyDuplicate2(data5, 3));  //true
    	
    	System.out.println("test 6");
    	int[] data6 = {1,2,3,4,5,6,7,8,9,9};
    	System.out.println(containsNearbyDuplicate2(data6, 3));  //true
    	
    	System.out.println("test 7");
    	int[] data7 = {1,2,3,5,6,1,3,1};  
    	System.out.println(containsNearbyDuplicate2(data7, 3)); //true
    	
    	System.out.println("test 8");
    	int[] data8 = {1,2,3,5,6,1}; 
    	System.out.println(containsNearbyDuplicate2(data8, 3)); // false
     }
}