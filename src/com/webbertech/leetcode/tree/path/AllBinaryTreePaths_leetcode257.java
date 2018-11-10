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
 * */

public class AllBinaryTreePaths_leetcode257 {
	
	//getPath will add to list
	void getPath(List<String> list, TreeNode node, String s) {
		if (node.left==null && node.right == null) {
	        list.add(s);
	        return;
		}
		if (node.left!=null) {
			getPath(list, node.left, s+"->"+node.left.val);
		}
		if (node.right!=null) {
			getPath(list, node.right, s+"->"+node.right.val);
		}
	}
	
	//this method will not add to list
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        String s = String.valueOf(root.val);
        getPath(list, root, s);
        return list;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		
		AllBinaryTreePaths_leetcode257 obj = new AllBinaryTreePaths_leetcode257();
		List<String> list = obj.binaryTreePaths(root);
		for(String str: list) {
			System.out.println(str);
		}
	}
}
