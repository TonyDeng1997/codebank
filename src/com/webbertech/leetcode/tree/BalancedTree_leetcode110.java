package com.webbertech.leetcode.tree;
//leetcode 110

import com.webbertech.leetcode.util.TreeNode;

public class BalancedTree_leetcode110 {

	 public static int depth(TreeNode root) {
	        if (root==null) return 0;
	        return Math.max(depth(root.left) , depth(root.right)) +1;
	  }
	 
	    public static boolean isBalanced(TreeNode root) {
	        if (root == null) return true;
	        if (Math.abs(depth(root.left)-depth(root.right))>1) {
	            return false;
	        }
	        return isBalanced(root.left) && isBalanced(root.right);
	    }
	    
	    public static void main(String[] args) {
	    	TreeNode t = new TreeNode(1);
	    	t.left = new TreeNode(2);
	    	t.left.left = new TreeNode(4);
	    	t.left.left.left = new TreeNode(4);
	    	t.right = new TreeNode(3);
	    	System.out.println(isBalanced(t));
	    }
}
