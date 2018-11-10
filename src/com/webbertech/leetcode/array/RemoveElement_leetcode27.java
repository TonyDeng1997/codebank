package com.webbertech.leetcode.array;
//leetcode 27

/*
* Given an array and a value, remove all instances of that value in place 
and return the new length.

Do not allocate extra space for another array, 
you must do this in place with constant memory.

The order of elements can be changed. 
It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

* */

/*
 * solution:  array is not sorted, and use two pointers and go from each end.
 * The above solution is accepted, but try to redo it and see if it can be simpler.
 * 
 * */


//try [2,2,3] and 2, left should be 3
public class RemoveElement_leetcode27 {
  public static int removeElement(int[] nums, int val) {
	  int count=0;
      int i=0;
      int j= nums.length-1;
      if (nums.length==1) {
          if (nums[0] == val) return 0;
          else return 1;
      }
      while(i<=j) {
          if(nums[i]==val && nums[j]!=val) {
              nums[i] = nums[j];
              count++;
              i++;
              j--;
          } else if (nums[i]!=val &&  nums[j]!=val){
              i++;
          } else if( nums[j] == val) {
              j--;
              count++;
          } 
          
      }
      
      return nums.length - count;
    }
	
	public static void main(String[] args) {
		int[] a={2,2,3};
		int length= removeElement(a,2);
		System.out.println(length);
		//the following should be 3
		System.out.println(a[0]);
		
	}
	
}
