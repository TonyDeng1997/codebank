package com.webbertech.leetcode.array;
import java.util.Arrays;

/*leetcode 26
 Given a sorted array, remove the duplicates in place such 
 that each element appear only once and return the new length.
 Do not allocate extra space for another array, you must do this in place with constant memory.
*/

public class RemoveDuplicatedElementsInSortedArray_leetcode26 {
    public static int[] removeDuplicates(int[] nums) {
    	if (nums.length < 2)
    		return nums;
     
    	int i = 0;
    	int j = 1;
     
    	/*use two index to move and keep them with distance,
    	 * if the two numbers are the same, you want to move faster index one more,
    	 * you want the next one to overwrite the second dup.
    	 * 
    	 * if the two numbers are different, you want to move the slower index one more,
    	 * 
    	 * */
    	while (j < nums.length) {
    		if (nums[i] == nums[j]) {
    			j++;
    		} else {
    			i++;
    			nums[i] = nums[j];
    			j++;
    		}
    	}
     
    	int[] B = Arrays.copyOf(nums, i + 1);
     
    	return B;
    }
    
    //This is the original solution
    public static int removeDuplicatesII(int[] nums) {
    	if (nums.length < 2)
    		return 1;
     
    	int i = 0;
    	int j = 1;
     
    	/*use two index to move and keep them with distance,
    	 * if the two numbers are the same, you want to move faster index one more,
    	 * you want the next one to overwrite the second dup.
    	 * 
    	 * if the two numbers are different, you want to move the slower index one more,
    	 * 
    	 * */
    	while (j < nums.length) {
    		if (nums[i] == nums[j]) {
    			j++;
    		} else {
    			i++;
    			nums[i] = nums[j];
    			j++;
    		}
    	}
     
    	//int[] B = Arrays.copyOf(nums, i + 1);
     
    	return i+1;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,2,2,3};
    	int[] b = removeDuplicates(nums);
    	for(int num: b) {
    		System.out.print(num+" ");
    	}
    }
}
