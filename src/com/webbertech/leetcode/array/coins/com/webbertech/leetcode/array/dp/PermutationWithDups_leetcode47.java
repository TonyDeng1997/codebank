package com.webbertech.leetcode.array.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*leetcode47 Permutations II
 *  Given a collection of numbers that might contain 
 *  duplicates, return all possible unique permutations.
For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 * */

public class PermutationWithDups_leetcode47 {
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
		return list;
	}

	/* Like the normal permutation algorithm, this one specially handles the 
	 * 
	 * */
	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				/* if the i=1, by then temp is false, false, false, !used[i-1], meaning that
				 for the case 1,1,2, the second 1 will get the same thing as the first 1.
				 because used[0] is false, and nums[i] == nums[i - 1], so nums[i-1] was done previously already.
				 So the second 1 is entirely skipped
				*/
				if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
					continue;
				}
				//when an element is added, it is set to true
				used[i] = true;
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, used);
				//after backtrack, element will be set to false and removed.
				used[i] = false;
				tempList.remove(tempList.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] n = {1,1,2};
		List<List<Integer>> list = permuteUnique(n);
	}
}