package com.webbertech.languageAPI;

//In one pass O(n)
//because as long as one of the complement of a pair of num in the map
//you will definitely hit the other number later, 
//so display is guaranteed
import java.util.HashMap;
import java.util.Map;
public class TwoSumToK {
	
     public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    public static void main(String[] args) {
    	int[] a = {3,2,4};
    	int[] b=twoSum(a, 6);
    	for(int i=0;i<b.length;i++) {
    		System.out.println(b[i]);
    	}
    }
}