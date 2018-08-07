package com.webbertech.leetcode.tree;

import com.webbertech.leetcode.util.TreeNode;

/*
 *  Leetcode 226
 *  
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9

 to 
 
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * */
public class InvertTree_leetcode226 {
	 public TreeNode invertTree(TreeNode root) {
         if (root == null || (root.left == null && root.right == null)) 
             return root;
         TreeNode temp = invertTree(root.left);
         root.left = invertTree(root.right);
         root.right = temp;
         return root;
 }
}
