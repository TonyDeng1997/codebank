package com.webbertech.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Leetcode189 
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

solution: the actual movement is not the k, but k%numbers.length, and make sure to figure out the boundary,
1/ first move out from tail to numbers.length-k%numbers.length to a list
2/ move from numbers.length-k%numbers.length to 0 to (i+numbers.length-k%numbers.length) index, shift the rest
3/ move the shift-out elements back to the front
accepted

*/


public class RotateArrayInCircle_leetcode189 {
	  public static void rotate(int[] nums, int k) {
		  int move= k%nums.length;
		  if (move == 0)
			  return;
		  LinkedList<Integer> list = new LinkedList<>();
		  //move out the actual element from the tail
          for (int i=nums.length-1;i>=nums.length-move;i--) {
        	  list.add(nums[i]);
          }
          //from the left element of the vacant from the tail, move all
          //elements to the back
          for(int i=nums.length-move-1;i>=0;i--) {
        	  nums[i+move] = nums[i];
          }
          int length= list.size();
          for (int i=0;i<length;i++) {
        	 nums[i] = list.removeLast();
          }
	  }
	  
	  public static void main(String[] args) {
		  int[] a = {1,2,3,4,5,6,7};
		  rotate(a, 3);
		
		
		  
	  }
}
