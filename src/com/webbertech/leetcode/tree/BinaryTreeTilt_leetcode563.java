package com.webbertech.leetcode.tree;

import com.webbertech.leetcode.util.TreeNode;

/*
 * Leetcode 563 Binary Tree Tilt
 * 
 * Given a binary tree, return the tilt of the whole tree.
	The tilt of a tree node is defined as the absolute difference 
	between the sum of all left subtree node values and the sum of all right 
	subtree node values. Null node has tilt 0. The tilt of the whole tree is 
	defined as the sum of all nodes' tilt.
	
Example:
Input: 
         1
       /   \
      2     3
      
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1

Note:
The sum of node values in any subtree won't exceed the range of 32-bit integer.
All the tilt values won't exceed the range of 32-bit integer.

Solution: 
First I come up with a solution that, get each left node 's tilt and right node's tilt and add them 
together, then you have to add the tilt of the current node, which is the abs of sum of left subtree minus sum of 
right subtree and this is not correct in my solution. There might be some better way to do so,
but I will just go with some existing solution using postOrder traversal.

* */

public class BinaryTreeTilt_leetcode563 {

	/*
	 * solution1 not right static int sum = 0; public static int
	 * findTilt(TreeNode root) { if (root == null || (root.left==null &&
	 * root.right==null)) { return 0; } if (root.left == null ) { return
	 * root.right.val; } else if (root.right == null) { return root.left.val; }
	 * // if have both children return findTilt(root.left) +
	 * findTilt(root.right) + Math.abs(root.left.val-root.right.val); }
	 * 
	 */
	static int result;

	public static int findTilt(TreeNode root) {
		postOrder(root);
		return result;
	}

	/*Note that this method is called postOrder traversal,
	 * it is using its concept but it is doing its only thing.
	 * */
	static private int postOrder(TreeNode root) {
		if (root == null)
			return 0;

		int left = postOrder(root.left);
		int right = postOrder(root.right);

		//the core logic
		result += Math.abs(left - right);

		return left + right + root.val;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		findTilt(root);

		/*
		 * Input:[1,2,3,4,null,5] Output:4 Expected:11
		 */
	}
}
