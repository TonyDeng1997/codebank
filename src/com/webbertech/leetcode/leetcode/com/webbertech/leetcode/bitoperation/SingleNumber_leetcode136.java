package com.webbertech.leetcode.bitoperation;

/*leetcode 136
 * 
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Solution:
 * bitwise XOR to solve this problem :

first , we have to know the bitwise XOR in java

    0 ^ N = N
    N ^ N = 0

So..... if N is the single number

N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N

= (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N

= 0 ^ 0 ^ ..........^ 0 ^ N

= N

* */

public class SingleNumber_leetcode136 {
	public static int singleNumber(int[] nums) {
	    int ans =0;
	    int len = nums.length;
	    for(int i=0;i!=len;i++) {
	        ans ^= nums[i];
	    }
	    return ans;
	}
	
	public static void main(String[] args) {
	  int[] nums = {1,2,2,1,3};
	  System.out.println(singleNumber(nums));
	  //the clue is that the array does not need to be sorted, if it is sorted,
	  //this problem might be easy
	  int a = 1, b=2;
	  System.out.println(a^=b);
	  System.out.println(a^=1);
	}
}