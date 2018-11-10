package com.webbertech.leetcode.tree;

import com.webbertech.leetcode.util.TreeNode;

/** Definition for a binary tree node. */
public class CountTreeNodes {
    public int countNodes(TreeNode root) {
    	if(root == null ) 
           return 0;
    	return countNodes(root.left)+countNodes(root.right)+1;
    }
    
    public static void main(String[] args) {
    	
    	//by level [1 2 3 4 5 6 7]
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	root.right.left = new TreeNode(6);

    	
    	System.out.println(new CountTreeNodes().countNodes(root));
    }
}