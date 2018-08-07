package com.webbertech.leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*leetcode78
 * 
 *  Given a set of distinct integers, nums, 
 *  return all possible subsets.
Note: The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * 
 * */
public class Subsets_leetcode78 {
	public static List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	  //  Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	/*how this work: 
	 * core logic is that, add+backtrack+remove
	 * */
	private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> list = subsets(nums);
	}
}
