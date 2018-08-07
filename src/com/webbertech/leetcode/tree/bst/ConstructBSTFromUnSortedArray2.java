package com.webbertech.leetcode.tree.bst;
import com.webbertech.leetcode.util.TreeNode;

/*
 * Solution: 
 * */

/*Consider this class is a BST tree class*/
public class ConstructBSTFromUnSortedArray2 {
	private  TreeNode root;
	
	 //This addNode is also recursive, and it is the same as the constructBST
	 // from the other file
	 TreeNode addNode(TreeNode node, int num) {
		if (node == null) {
			return new TreeNode(num);
		}
		else {
			if (node.val>num) {
				if (node.left == null) {
					node.left = new TreeNode(num);
				} else {
					node.left = addNode(node.left, num);
				}
			} else {
				if (node.right == null) {
					node.right = new TreeNode(num);
				} else {
					node.right = addNode(node.right, num);
				}
			}
		}
		return node;
	}
	
	public static void main(String[] args) {
		int[] nums = {5,3,2,1,7,6,8};
		ConstructBSTFromUnSortedArray2 obj = new ConstructBSTFromUnSortedArray2();
		TreeNode root = null;
		for (int i=0;i<nums.length;i++) {
		  root = obj.addNode(root, nums[i]);
		}
	}
}