package com.webbertech.leetcode.tree.traverse;

import java.util.ArrayList;
import java.util.List;

import com.webbertech.leetcode.util.TreeNode;
public class InorderTraversal_leetcode94 {

/*
* leetcode94 
* Given a binary tree, return the inorder traversal of its nodes' values.
For example:
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3

return [1,3,2].
Note: Recursive solution is trivial, could you do it iteratively?
* */
	
	public void inorderTraversal(TreeNode root, List<Integer> list) {
		if (root.left!=null) {
			inorderTraversal(root.left, list);
		}
		list.add(root.val);
		if (root.right!=null) {
			inorderTraversal(root.right,list);
		}
	}
	
	  public List<Integer> inorderTraversal(TreeNode root) {
	      List<Integer> list = new ArrayList<>();   
	      if (root == null) {
	    	  return list;
	    	  
	      }
	      inorderTraversal(root,list);
	      return list;
	  }
}
