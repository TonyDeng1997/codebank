package com.webbertech.leetcode.tree.bst;

import java.util.Arrays;
import com.webbertech.leetcode.util.TreeNode;

/*Leetcode 108
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * input: [1,3]
 * 
 * Solution: use binary search method to make it balanced.
 * Note balance bst is a keyword here, otherwise it can be any other forms.
 * Also pay attention to the java api copyOfRange() it is not inclusive for the upper bound.
 * */

public class ConstructBSTFromSortedArray_leetcode108 {
	 public static TreeNode sortedArrayToBST(int[] nums) {
	        if (nums.length == 0) return null;
	        if (nums.length == 1) return new TreeNode(nums[0]);
	        int mid = nums.length/2;   
	        TreeNode root = new TreeNode(nums[mid]);
	        int[] leftArray = Arrays.copyOfRange(nums, 0, mid);
	        root.left = sortedArrayToBST(leftArray);
	        int[] rightArray = Arrays.copyOfRange(nums, mid+1, nums.length);
	        root.right = sortedArrayToBST(rightArray);
	        return root;
	    }
	 
	 public static void main(String[] args) {
		 int[] data = {1,3};
		 TreeNode node = sortedArrayToBST(data);
	 }
}
