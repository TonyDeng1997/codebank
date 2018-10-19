package com.webbertech.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Leetcode 347 Top K Frequent Elements 
 * 
 *  Given a non-empty array of integers, return the k most frequent elements.
    For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].

    Note:
    You may assume k is always valid, 1 ¡Ü k ¡Ü number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * 
 * */

public class TopKFrequentElements_leetcode347 {
    
	/*Solution:
	 * 
	 *  1. first build a map in O(n), key is the number, value is the freq
	 *  2. create list of k length to return result
	 *  3. create k lists like List [] bucket = new List[len+1], 
	 *     use bucket[i] = new ArrayList<>(); to store all the elements with the same frequency
	 *     Let us call it frequency bucket. 
	 */
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return list;
		}
        if (nums.length< k) {
			for (int i: nums) {
				list.add(i);
			}
			return list;
		}
		
        //build frequency map
        /*map is like
         * 
         * 1 = 3
         * 2 = 2
         * 3 = 1 
         * */
		HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
        	if (map.containsKey(nums[i])) {
        		map.put(nums[i], map.get(nums[i])+1);
        	} 
        	map.put(nums[i], 1);
        }
        
        //build bucket
        /*[1,1,1,2,2,3], it will be
         * bucket[3] = [1,1,1]
         * bucket[2] = [2,2]
         * bucket[1] = [3]
         * */
        /* why bucket array is length+1?
           think about 1,1,1,1,1, map(1,5), bucket[5].add(1) is the list object.
        */
        List<Integer> [] bucket = new List[nums.length + 1];
        for (Integer key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
      
        /* bucket.length-1 is the highest frequency.
         * we go decreasing order, so that it will cover top k element.
         * Each element we take only 1 element.
         * */
        for (int i = bucket.length - 1; i >k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) { //num is the number appears in the array, and bucket[i] is the list object 
                   list.add(num);
                   break;
                }
            }
        }
        return list;
    }
	
	public static void main(String[] args) {
		int[] a={1,1,1,2,2,3};
		List<Integer> list = topKFrequent(a, 2);
	}
}