package com.webbertech.leetcode.array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Leetcode 350
 * Given two arrays, write a function to compute their intersection.

	Example:
	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2,2].

	Note:
	Each element in the result must be unique.
	The result can be in any order.
	
	
	Follow up:
	What if the given array is already sorted? How would you optimize your algorithm?
	What if nums1's size is small compared to nums2's size? Which algorithm is better?	
	What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

	Solution: 
	Can not use hash set because the intersection can have duplicates.
	Use hashmap instead. Track the number of each elements in the first array.
	Once find the element in the second array in hashmap decrease 1. 
    Then, convert the hashmap to array.	
    
    Accepted.
 * */


public class IntersectionOfTwoArrays_leetcode350 {
	public static int[] intersect(int[] nums1, int[] nums2) {
		 if (nums1.length==0 || nums2.length == 0 ) {
        	 return new int[0]; 
         }
		 int[] longer = nums1.length > nums2.length ? nums1: nums2;
		 int[] shorter = nums1.length > nums2.length ? nums2: nums1;
		 
         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
         
         //Store the longer one in a map, the value is the occurences of the number
         for (int i: longer) {
        	 if (map.containsKey(i)) {
        		 map.put(i, map.get(i)+1);
        	 } else {
        		 map.put(i,1);
        	 }
         }
         
         ArrayList<Integer> list = new ArrayList<>();
         
         // Go through shorter list to add it right away if find them in the map; decrease the count by one and see if there is 
         // a dup element in the map, then add it again.
         for (int i: shorter) {
        	 if (map.containsKey(i)  && map.get(i)!=0) {
        		 list.add(i);
        		 map.put(i, map.get(i)-1);
        	 }
         }
          int[] res= new int[list.size()];
         int count=0;
        for (Integer i : list) {
        	res[count++]=i;
        }
          return res;
	}

	
	/*
	 * Fix the bug:
	 * 
	 * Input:
[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]
Output:
[0,2,4,6]
Expected:
[6,4]
	 * 
	 * */
	public static void main(String[] args) {
	
		int[] a= {1};
		int[] b={1};
		int[] c = intersect(a,b);
		for(int i: c) {
			System.out.println(i);
		}
		
		int[] d = {4,7,9,7,6,7};
		int[] e = {5,0,0,6,1,6,2,2,4};
		for(int i: IntersectionOfTwoArrays_leetcode350.intersect(d,e)) {
			System.out.println(i);
		}
		
		
		int[] f = {1,2,2,1};
		int[] g = {2,2};
		for(int i: IntersectionOfTwoArrays_leetcode350.intersect(f,g)) {
			System.out.println(i);
		}
	}
}
