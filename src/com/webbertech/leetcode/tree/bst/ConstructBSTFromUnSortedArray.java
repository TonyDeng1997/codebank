package com.webbertech.leetcode.tree.bst;

import com.webbertech.leetcode.util.TreeNode;

/*
 * Solution: Tree is about recursion so is bst.
 * To construct bst no matter your param is an array of integer or just one integer.
 * It has to be recursion.
 * */

public class ConstructBSTFromUnSortedArray {

	//Read through a list of integers
	static TreeNode unsortedArrayToBST(int[] nums) {
		if (nums.length ==0) {
			throw new IllegalArgumentException();
		}
		TreeNode root = new TreeNode(nums[0]);
		for (int i=1;i< nums.length;i++) {
			root = constructBST(root, nums[i]);
		}
		return root;
 	}
	
	// Use recursion to construct bst 
	static TreeNode constructBST(TreeNode node, int num) {
		if (node.val>num) {
			if (node.left == null) {
				node.left = new TreeNode(num);
			} else {
				node.left = constructBST(node.left, num);
			}
		
		} else {
			if (node.right == null) {
				node.right = new TreeNode(num);
			} else {
				node.right = constructBST(node.right, num);
			}
		}
		return node;
	}
	
	public static void main(String[] args) {
		int[] nums = {5,3,2,1,7,6,8};
		TreeNode node = unsortedArrayToBST(nums);
	}
}