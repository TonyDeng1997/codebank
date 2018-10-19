package com.webbertech.leetcode.array.dp;
import java.util.*;
/*leetcode39
Given a set of candidate numbers (C) (without duplicates) 
and a target number (T), find all unique combinations in C 
where the candidate numbers sums to T. The same repeated number
may be chosen from C unlimited number of times.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]

solution: 
the technique is backtrack recursion, so the parameter is like, 
collecting list, temp list, source data or/and target data and 
initial starting index of for loop. When you enter the backtrack method, 
the first thing is to check when to add the temp list to the collecting list. 
Then in the else of the rest of the method, we implement a for loop and then 
call the recursion method inside of it. Another thing is that, before we call 
recursion method, we first add the element to the temp list, mark the cache array
or some flag related to the element that is going to be added into temp list, 
after the recursion call, it will be all restored.
*/

public class CombinationSum_leetcode39 {
	public static List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	/*
	 * list: collecting list
	 * tempList: temp list
	 * nums: input data source
	 * remain: target number, which is also the input data source,
	 * start: the starting index of for loop that is inside of the recursion method
	 * 
	 * To understand this solution, try to get some data to test,
	 * [2, 3, 6, 7] and target 7,
		A solution set is:
		[[7],[2, 2, 3]]
	 * */
	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, 
			int remain, int start) {
	    if(remain < 0) return;  //0 is the bottom line, anything less than will be no meaning
	    else if(remain == 0) { // meaning templist already contains the elements that sum to remain
	    	list.add(new ArrayList<>(tempList));
	    }
	    else { 
	        for(int i = start; i < nums.length; i++) {
	            tempList.add(nums[i]);
	            // not i + 1 because we can reuse same elements
	            // the starting point is one of the trick suited for different questions
	            backtrack(list, tempList, nums, remain - nums[i], i); 
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	
	public static void main(String[] args) {
		int[] n = {2, 3, 6, 7};
		int target = 7;
		List<List<Integer>> list = combinationSum(n,target);
		
	}
}