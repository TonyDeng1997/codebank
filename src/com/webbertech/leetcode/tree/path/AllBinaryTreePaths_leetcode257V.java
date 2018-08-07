package com.webbertech.leetcode.tree.path;

import java.util.ArrayList;
import java.util.List;

import com.webbertech.leetcode.util.TreeNode;

/*
 * Leetcode 257 Binary Tree Paths
 * 
 *  Given a binary tree, return all root-to-leaf paths.

	For example, given the following binary tree:

   	  1
 	/   \
   2     3
    \
     5

	All root-to-leaf paths are:

	["1->2->5", "1->3"]
	
	return a list of list.
	
Solution: using backtrack. Add path when from root to leave.

	1/ add node to the current list
	2/ if node is leave, add current list to the big list
	   remove the node from current list
	3/ recursion for left and right
	4/ backtrack from current list.
 * */

public class AllBinaryTreePaths_leetcode257V {
	
	static List<List<Integer>> getPath(TreeNode node) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> curList = new ArrayList<>();
		getPath(list, curList, node);
		return list;
	}
	
	//getPath will add to list
	static void getPath(List<List<Integer>> list, List<Integer> curList, TreeNode node) {

		 if (node== null) return;
		 curList.add(node.val);
		 
		 //add a full path from root to leave
		if (node.left==null && node.right == null) {
	        list.add(new ArrayList(curList));
	        curList.remove(curList.size()-1);
	        return;
		}
		
		//recursively
			getPath(list, curList, node.left);
			getPath(list, curList, node.right);
	
		// backtrack
		curList.remove(curList.size()-1);
	}
	

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		
		List<List<Integer>>list = getPath(root);
		for(List<Integer> l: list) {
			for(Integer i: l) {
				System.out.print(i+ " ");
			}
			System.out.println();
		}
	}
}
