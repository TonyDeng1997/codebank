package com.webbertech.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Leetcode 506 Relative Ranks
 * Given scores of N athletes, find their relative ranks and 
 * the people with the top three highest scores, 
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.

Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.

For example:

Input:
[10,3,8,9,4]
Output:
["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Expected:
["Gold Medal","5","Bronze Medal","Silver Medal","4"]

Solution: 

1/ sort it : using above example, it is 3,4,8,9,10

2/ use map for ranking? map<number, rank>, rank = length-i
 3, 5
 4, 4
 8, 3
 9, 2
 10,1

3/ result: nums[] is the original array
**/

public class RelativeRanks_leetcode506 {
	public String[] findRelativeRanks(int[] nums) {
        int[] ranks = nums.clone(); 
        Arrays.sort(ranks);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<ranks.length; i++){
            map.put(ranks[i], nums.length-i);
        }
        String[] res = new String[nums.length];
        for(int i = 0; i<nums.length; i++){
            int rank = map.get(nums[i]);
            String rankStr = rank+"";
            if(rank==1) rankStr = "Gold Medal";
            else if(rank==2) rankStr = "Silver Medal";
            else if(rank==3) rankStr = "Bronze Medal";
            res[i] = rankStr; 
        }
        return res; 
    }
}