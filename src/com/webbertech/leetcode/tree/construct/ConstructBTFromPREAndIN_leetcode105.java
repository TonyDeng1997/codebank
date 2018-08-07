package com.webbertech.leetcode.tree.construct;

import com.webbertech.leetcode.util.TreeNode;

/*Leetcode105 construct a binary tree from preorder and inorder traversal.
 *  
 * Solution1: recursion.
 * 
 * Preorder traversing implies that PRE[0] is the root node.
	Then we can find this PRE[0] in IN, say it's IN[5].
	Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
	Recursively doing this on subarrays, we can build a tree out of it.
	
   Solution2: iterative.
 * */

public class ConstructBTFromPREAndIN_leetcode105 {

	//solution1
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
	    return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	/*
	 * The parameter has inStart and inEnd and for loop is against
	 * */
	public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
	    if (preStart > preorder.length - 1 || inStart > inEnd) {
	        return null;
	    }
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inIndex = 0; // Index of current root in inorder, like above IN[5]
	    for (int i = inStart; i <= inEnd; i++) {
	        if (inorder[i] == root.val) {
	            inIndex = i;
	        }
	    }
	    /* 1/ For inorder list, from inStart to the left element of root, they are the left tree of root
	     * preStart+1 is because the next element in preorder is left child of root.
	     * 
	     * 2/ For inorder list, from the right element of inIndex(root) to the end is the right subtree of root. 
	     * preStart+inIndex-inStart+1 is the new index in the preorder array to find out the next root of the 
	     * right subtree of the original root node. For instance, in the test case, this value is 3.
	     * so pre[3] is 5. So the new root of the right subtree of original root(1) is 3.
	     * */
	    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
	    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
	    return root;
	}
	
	
	//array is [1,2,3,4,5,6,7]
	public static void main(String[] args) {
		int[] pre = {1,2,4,5,3,6,7};
		int[] in = {4,2,5,1,6,3,7};
		TreeNode t = buildTree(pre, in);
		TreeNode.inorder(t);
		System.out.println("test2");
		int[] pre1 = {1,2};
		int[] in1 = {2,1};
		
		TreeNode t1 = buildTree(pre1, in1);
		TreeNode.inorder(t1);
	}
}