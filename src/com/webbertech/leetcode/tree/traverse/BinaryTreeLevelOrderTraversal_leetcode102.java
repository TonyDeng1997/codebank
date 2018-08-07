package com.webbertech.leetcode.tree.traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Leetcode 102 Binary Tree Level Order Traversal 
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

solution: Use iterative way, accepted
 * */

import com.webbertech.leetcode.util.TreeNode;

public class BinaryTreeLevelOrderTraversal_leetcode102 {
	 public  static List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> list = new ArrayList<List<Integer>>();
	        if (root == null) {
	          return list;
	        }
	        // use a queue to keep track of the node
	        LinkedList<TreeNode> q = new LinkedList<>();
	        q.add(root);
	       	LinkedList<TreeNode> removedElements = new LinkedList<>();
	        while(!q.isEmpty()) {
	        	//only the same level of node stored in the queue at all time
	        	ArrayList<Integer> level = new ArrayList<>();
	        	while (q.size()>0){
	        		TreeNode removed = q.poll();
	        		level.add(removed.val);
	        		removedElements.add(removed);
	        	} 
	        	list.add(level);
	        	while(!removedElements.isEmpty()) {
	        		TreeNode removed = removedElements.poll();
	        		if (removed.left!=null) q.add(removed.left);
	        		if (removed.right!=null) q.add(removed.right);
	        	}
	        }
	        return list;
	    }
	  
		public static void main(String[] args) {
			TreeNode r = new TreeNode(1);
			r.left = new TreeNode(2);
			r.right = new TreeNode(3);
			r.left.left = new TreeNode(4);
			r.right.right = new TreeNode(5);
		
			List<List<Integer>> list = levelOrder(r);
			TreeNode.printLevelOrder(list);
		}
	  
}
