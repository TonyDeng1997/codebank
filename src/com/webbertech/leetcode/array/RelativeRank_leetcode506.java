package com.webbertech.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/* 	Leetcode506 Relative Rank
 * 
 *  Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 *  
 *  Input: [5, 4, 3, 2, 1]
	Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
	Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
	For the left two athletes, you just need to output their relative ranks according to their scores.
 * 
 *  Note:

    N is a positive integer and won't exceed 10,000.
    All the scores of athletes are guaranteed to be unique.
    
    
    Solution: To better understand this, check the following exampke,
    
Input:[10,3,8,9,4]
Output:["","Bronze Medal","","","Silver Medal"]
Expected:["Gold Medal","5","Bronze Medal","Silver Medal","4"]
    
*/

public class RelativeRank_leetcode506 {
	public static String[] findRelativeRanks(int[] nums) {
		int len = nums.length;
		String[] res = new String[len];
		int[] copy = Arrays.copyOf(nums, len);

		// NlogN
		Arrays.sort(copy);

		int i = 0, j = len - 1;
		// equal handles if the array has only 1 element
		while (i <= j) {
			int temp = copy[i];
			copy[i] = copy[j];
			copy[j] = temp;
			i++;
			j--;
		}

		// build map.
		HashMap<Integer, String> rank = new HashMap<>();

		// TODO: finish the following part
		for (i = 0; i < len; i++) {

			rank.put(copy[0], "Gold Medal");
			rank.put(copy[1], "Silver Medal");
			rank.put(copy[2], "Bronze Medal");
			rank.put(copy[3], "4");
			rank.put(copy[4], "5");
		}
		// End of todo

		// use the map
		for (i = 0; i < len; i++) {
			res[i] = rank.get(nums[i]);
		}
		return res;
	}

	// solution2, similar but simple, use one dimensional array
	public static String[] findRelativeRanksII(int[] nums) {
		Integer[] index = new Integer[nums.length];

		// can not use Arrays.copyOf() as it will return a int[] instead
		// of Integer[], thus can not use Arrays reverse sort.
		for (int i = 0; i < nums.length; i++) {
			index[i] = i;
		}

		// what the heck is this doing? it is a comparator thing, which means for a,b order, 
		// b has to be larger than a, thus it is a decending order. And it will get the 
		// relative ranking
		Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));

		String[] result = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				result[index[i]] = "Gold Medal";
			} else if (i == 1) {
				result[index[i]] = "Silver Medal";
			} else if (i == 2) {
				result[index[i]] = "Bronze Medal";
			} else {
				result[index[i]] = (i + 1) + "";
			}
		}

		return result;
	}

	/*
	 * solution 3, use two dimensional array
	 * 
	 * Basically this question is to find out the score -> ranking mapping. The
	 * easiest way is to sort those scores in nums. But we will lose their
	 * original order. We can create (score , original index) pairs and sort
	 * them by score decreasingly. Then we will have score -> ranking (new
	 * index) mapping and we can use original index to create the result.
	 * 
	 * Time complexity: O(NlgN). Space complexity: O(N). N is the number of
	 * scores.
	 * 
	 * Example:
	 * 
	 * nums[i] : [10, 3, 8, 9, 4] pair[i][0] : [10, 3, 8, 9, 4] pair[i][1] : [
	 * 0, 1, 2, 3, 4]
	 * 
	 * After sort: pair[i][0] : [10, 9, 8, 4, 3] pair[i][1] : [ 0, 3, 2, 4, 1]
	 * 
	 */
	
	
	 public String[] findRelativeRanksIII(int[] nums) {
	        int[][] pair = new int[nums.length][2];
	        
	        for (int i = 0; i < nums.length; i++) {
	            pair[i][0] = nums[i];
	            pair[i][1] = i;
	        }
	        
	        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));
	        String[] result = new String[nums.length];

	        for (int i = 0; i < nums.length; i++) {
	            if (i == 0) {
	                result[pair[i][1]] = "Gold Medal";
	            }
	            else if (i == 1) {
	                result[pair[i][1]] = "Silver Medal";
	            }
	            else if (i == 2) {
	                result[pair[i][1]] = "Bronze Medal";
	            }
	            else {
	                result[pair[i][1]] = (i + 1) + "";
	            }
	        }

	        return result;
	    }
	public static void main(String[] args) {
		int[] a = { 10, 3, 8, 9, 4 };
		String[] res = findRelativeRanksII(a);
		for (String s : res) {
			System.out.println(s);
		}
	}
}
