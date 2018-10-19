package com.webbertech.leetcode.array;
/* Given an array nums, write a function to move all 0's to the end of it while 
 * maintaining the relative order of the non-zero elements.
   For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
   nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/
 
//not only zero, it can be any value

public class MoveZeros {
	
	//solution 1
	public void moveZeroes(int[] nums) {
	    if (nums.length==0 || nums.length==1) {
	    	return;
	    }
	    
	    int i=0,j=1;
	    while(i<nums.length&& j<nums.length) {
	    	if (nums[i] == 0 && nums[j] != 0) {
	    		int temp= nums[i];
	    		nums[i] = nums[j];
	    		nums[j] = temp;
	    		i++;
	    		j++;
	    	} else if (nums[i] == 0 && nums[j] == 0) {
	    		j++; //i does not move
	    	} else if (nums[i]!=0 && nums[j]==0) {
	    		i++;
	    		j++;
	    	} else {
	    		i++;  // this is that both i and j are not 0, both increase
	    		j++;
	    	}
	    }
	    
	}
	 
	//solution 2: same as solution 1 but need to optimize something
	public void moveZeroes2(int[] nums) {
	    if (nums.length==0 || nums.length==1) {
	    	return;
	    }
	    
	    int i=0,j=1;
	    while(i<nums.length&& j<nums.length) {
	    	if (nums[i] == 0 && nums[j] != 0) {
	    		int temp= nums[i];
	    		nums[i] = nums[j];
	    		nums[j] = temp;
	    		i++;
	    		j++;
	    	} else if (nums[i] == 0 && nums[j] == 0) {
	    		j++; //i does not move, because we need to wait for a non 0 j to replace i
	    	} else if (nums[i]!=0) {
	    		// as long as i is not 0, if j is 0 or non 0 is not important,
	    		// we need to increase i to find the next 0 to replace, so i and j must move at the same time
	    		i++;
	    		j++;
	    	} 
	    }
	    
	}

	public static void main(String[] args) {

	}
}
