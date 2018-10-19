package com.webbertech.leetcode.array;

/*
 * Leetcode 34. Search for a Range
 * 
 * Given an array of integers sorted in ascending order, 
 * find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

 * 
 * 
 * Solution: 
 * 1/ binary search find first number, say pos is index m;
 * 2/ set the i = m-1, j=m+1;
 *    while(a[i]==a[m]) i--;
 *    while(a[j]==a[m]) j++;
 *    return i+1, j-1;
 *  
 *  Need to pay attention to a lot of edge cases. The following is accepted.
 * */

public class SearchForARange_leetcode34 {
	public static int[] searchRange(int[] nums, int target) {
		int[] range = new int[2];
	
		if (nums.length == 0) {
			range[0] = -1;
			range[1] = -1;
			return range;
		}

		int low = 0;
		int high = nums.length - 1;
		int mid = -1;
		boolean found= false;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (nums[mid] > target) {
				high = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				found= true;
				break;
			}
		}
		
		//If the target is not in the array. 
		//To think if the target < 0 or > number.length is not right, think about [1,5], 4
		if (!found ) {
			range[0] = range[1] = -1;
			return range;
		}
		/* When there is only one or two elements in the array.
		 * In this case, think about 2,2, if mid ==0, then we need to find the right bound.
		 */
		if (mid == 0) {
			if (nums[0] == target) {
				range[0] = 0;
			}
			int right = mid+1;
			while(right< nums.length && nums[right]== target) {
				right++;
			}
			range[1] = right-1;
			return range;
		}
		/*
		 * When mid is the right most element? 
		 * Think about [1,2],2 , firstly mid is 0, then mid is 1, and find 2.
		 * So right bound is range[1], try to go left. Is there any case where
		 * left needs to go left, no, because mid is going from lower to higher.
		 * */
		if (mid == nums.length - 1) {
			/*
			int left = mid - 1;
			while (left > 0 && nums[left] == target)
				left--;
			range[0] = left + 1;
			*/
			range[0] = mid;
			range[1] = mid;
			return range;
		}
		// Else 
		int left = mid - 1;
		int right = mid + 1;
		while (left >= 0 && nums[left] == target)
			left--;
		while (right < nums.length && nums[right] == target)
			right++;
		range[0] = left + 1;
		range[1] = right - 1;
		return range;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int[] res = searchRange(nums, 8); //3,4
		System.out.println(res[0] + " " + res[1]);
		int[] nums1 = { 1 };       // 0 0 
		res = searchRange(nums1, 1);
		System.out.println(res[0] + " " + res[1]);

		int[] nums2 = {1,4 };  // 1 1
		res = searchRange(nums2, 4);
		System.out.println(res[0] + " " + res[1]);
		
		int[] nums3 = {1,2,2}; // 1 2
		res = searchRange(nums3, 2);
		System.out.println(res[0] + " " + res[1]);
		
		int[] nums4 = {}; // -1 -1
		res = searchRange(nums4, 2);
		System.out.println(res[0] + " " + res[1]);
		
		int[] nums5 = {2,2}; // 0,1
		res = searchRange(nums5, 2);
		System.out.println(res[0] + " " + res[1]);
		
		int[] nums6 = {1,1,2}; // 0,1
		res = searchRange(nums6, 1);
		System.out.println(res[0] + " " + res[1]);
		
		int[] nums7 = {1,5}; // -1,-1
		res = searchRange(nums7, 4);
		System.out.println(res[0] + " " + res[1]);
	}
}