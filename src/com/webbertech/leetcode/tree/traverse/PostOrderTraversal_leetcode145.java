package com.webbertech.leetcode.tree.traverse;

import java.util.ArrayList;
import java.util.List;

import com.webbertech.leetcode.util.TreeNode;

/*
 * Leetcode 145, 
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.

	For example:
	Given binary tree {1,#,2,3},
   
   1
    \
     2
    /
   3

 	return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

Solution 1 is accepted.
 * 
 * */

public class PostOrderTraversal_leetcode145 {
	
	
	//solution 1: recursive
	  void postorderTraversal(TreeNode node, List<Integer> list) {
		  if (node == null)
			  return;
		  if (node.left!=null) {
			  postorderTraversal(node.left, list);
		  }
		  if (node.right!=null){
			  postorderTraversal(node.right, list);
		  }
		  list.add(node.val);
	  }
	
	  public List<Integer> postorderTraversal(TreeNode root) {
		  List<Integer> list = new ArrayList<>();
		  postorderTraversal(root,list);
		  return list;
	  }
	  
	  //iterative???
}
