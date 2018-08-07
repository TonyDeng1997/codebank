package com.webbertech.leetcode.array.backtracking;

import java.util.*;

/*leetcode46
 *  Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

 * 
 * */
public class Permuations_leetcode46 {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		// Arrays.sort(nums); // not necessary
		backtrack(list, new ArrayList<Integer>(), nums);
		return list;
	}

	/*
	 * Initially, the tempList is empty, with more and more element added, if it
	 * is the same as the num array, then add it.
	 */
	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		}
		for (int i = 0; i < nums.length; i++) {
			if (tempList.contains(nums[i]))
				continue; // element already exists, skip
			tempList.add(nums[i]);
			backtrack(list, tempList, nums);
			tempList.remove(tempList.size() - 1);
		}

	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List list = permute(nums);
		/*
		 * List<List<Integer>> l = new ArrayList<List<Integer>>(); List<Integer>
		 * num = new ArrayList<>(); num.add(1);num.add(2);num.add(3); l.add(new
		 * ArrayList<>(num));
		 */
		/*
		 * ArrayList<Integer> list = new ArrayList<>();
		 * list.add(1);list.add(2);list.add(3); list.remove(0); list.add(1, 4);
		 */
	}
}
