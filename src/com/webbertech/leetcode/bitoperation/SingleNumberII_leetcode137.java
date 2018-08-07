package com.webbertech.leetcode.bitoperation;

/* leetcode 137
 * Given an array of integers, every element appears 
 * three times except for one, which appears exactly once. 
 * Find that single one. Your algorithm should have a linear runtime complexity.
 * without any extra space.
 *
 * Solution1: Use map, construct a map, and loop the map to see
 *            which value is not 3. But this requires extra space
 *            used by map.
 *            
 * Solution2: like the following,
 * 
 * As for challenging you:
   Does this work when the number that doesn't occur
   exactly three times occurs more than once? 
   If it appears twice, or four times, and so on.
   This works when all but one value appear three times, 
   can you extend it to 4? 5? Can you generalize it to take 
   the number of repetitions as a parameter?

 * For example, 3,1,2,1,2,1,2,3
 * */

public class SingleNumberII_leetcode137 {
	public int singleNumber(int[] A) {
	    int ones = 0, twos = 0;
	    for(int i = 0; i < A.length; i++){
	        ones = (ones ^ A[i]) & ~twos;
	        twos = (twos ^ A[i]) & ~ones;
	    }
	    return ones;
	}
	 
	 public static void main(String[] args){
	   	 System.out.println(1^2^2^3^1);
	   	 System.out.println(1^2^2^1);
	 }
}
