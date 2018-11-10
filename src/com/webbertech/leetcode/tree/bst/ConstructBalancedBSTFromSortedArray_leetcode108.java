package com.webbertech.leetcode.tree.bst;

import java.util.Arrays;

import com.webbertech.leetcode.util.TreeNode;

public class ConstructBalancedBSTFromSortedArray_leetcode108 {

	/*
	 * Leetcode 108 Given an array where elements are sorted in ascending order,
	 * convert it to a height balanced BST.
	 */

	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		TreeNode head = helper(nums, 0, nums.length - 1);
		return head;
	}

	public static TreeNode helper(int[] num, int low, int high) {
		if (low > high) { // Done
			return null;
		}
		int mid = (low + high) / 2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = helper(num, low, mid - 1);
		node.right = helper(num, mid + 1, high);
		return node;
	}
	
	public static void main(String[] args) {
		int[] nums = {5,3,2,1,7,6,8};
		Arrays.sort(nums);
		TreeNode node = sortedArrayToBST(nums);
	}
}