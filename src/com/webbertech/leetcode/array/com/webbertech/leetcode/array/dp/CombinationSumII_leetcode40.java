package com.webbertech.leetcode.array.dp;
import java.util.*;
/*leetcode40 Combination SumII
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
* */

public class CombinationSumII_leetcode40 {
	public List<List<Integer>> combinationSum2(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, 
			int remain, int start) {
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else {
	        for(int i = start; i < nums.length; i++) {
	            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
	            tempList.add(nums[i]);
	            //don't want to reuse element i, but need to add i+1 to the tempList.
	            backtrack(list, tempList, nums, remain - nums[i], i + 1);
	            tempList.remove(tempList.size() - 1); 
	        }
	    }
	} 
}