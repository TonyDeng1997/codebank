package com.webbertech.leetcode.string.substr;

import java.util.ArrayList;
import java.util.Comparator;

/* LeetCode 179 Largest Number
 * Given a list of non negative integers, 
 * arrange them such that they form the largest number.
   For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
	Note: The result may be very large, so you need to return a string instead of an integer.

* Solution: string sorting, but when do the string sorting, try to combine the combination in the sorting.
* */

public class LargestNumber_leetcode179 {

	public static String largestNumber(int[] nums) {
		if (nums.length ==0)
			return null;
        
		ArrayList<String> str = new ArrayList<>();
        for(int i =0;i< nums.length;i++) {
        	str.add(String.valueOf(nums[i]));
        }
        
        str.sort(new MyComparator());
        StringBuilder sb = new StringBuilder();
        for(String s: str) {
        	sb.append(s);
        }
        
        return sb.toString();
	}

	static class MyComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			String s1 = o1+o2;
			String s2 = o2+o1;
			return s2.compareTo(s1);
		}
	}
	
	//121,12 - > 12121
	public static void main(String[] args) {
		int[] nums = {3,30, 34, 5, 9};
		System.out.println(largestNumber(nums));
	}

}
