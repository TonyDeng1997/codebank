package com.webbertech.leetcode.tree;

import com.webbertech.leetcode.util.TreeNode;

/*Leetcode 111. Minimum Depth of Binary Tree
 * 
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the 
shortest path from the root node down to the nearest leaf node.

solution: if for node a, if a.left or a.right is null, then
    do the max, if both are there do min. Solution accepted.
 * */
public class MinDepthBT_leetcode111 {
	
	
	//similar to maxDepth but use Math.min.
	//
	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null || root.right == null) {
			return Math.max(minDepth(root.left), minDepth(root.right))+1;
		}
      return Math.min(minDepth(root.left), minDepth(root.right)) + 1;    
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(3);
		System.out.println(minDepth(root));
	}
}
