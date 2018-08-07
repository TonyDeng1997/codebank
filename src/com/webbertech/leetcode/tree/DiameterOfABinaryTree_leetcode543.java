package com.webbertech.leetcode.tree;
import com.webbertech.leetcode.util.TreeNode;

/* leetcode 543. Diameter of Binary Tree 
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree

          1
         / \
        2   3
       / \     
      4   5    

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
Note: The length of path between two nodes is represented by the number 
of edges between them.

Solution: 
1/ this path issue is not a path from root to leaf.
2/ use recursion, height counting problem.
*/

public class DiameterOfABinaryTree_leetcode543 {
	   int max = 0;
	    
	    public int diameterOfBinaryTree(TreeNode root) {
	        maxDepth(root);
	        return max;
	    }
	    
	    /*
	     * Core logic here.
	     * */
	    private int maxDepth(TreeNode root) {
	        if (root == null) return 0;
	        
	        int left = maxDepth(root.left);
	        int right = maxDepth(root.right);
	        
	        // the only difference than maxDepth impl is to update the max
	        // with the sum of left and right.
	        max = Math.max(max, left + right);
	        
	        return Math.max(left, right) + 1;
	    }
}