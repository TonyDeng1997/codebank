package com.webbertech.leetcode.tree.bst;

import java.util.ArrayList;
import java.util.List;

import com.webbertech.leetcode.util.TreeNode;

/*
 * Get the tree path and store in a list from root to the given node.
 * Provided that there is no dup of k in the tree.
 * This question is from geeksforgeeks.
 * 
 * Output:

LCA(4, 5) = 2
LCA(4, 6) = 1
LCA(3, 4) = 1
LCA(2, 4) = 2 

 * 
 * Solution 1: using recursion
 * */

public class TreePathFromRootToNode {
	
	/*
	 * Find the path from node with value k to the root node
	 * 
	 * solution, recursion idea is simple, an empty list, and root.
	 * Once you enter this check if root is null then don't add to list.
	 * Otherwise, add the root to the list first. 
	 * */
	static boolean findPath(TreeNode root, List<Integer> path, int k) {
	    // base case
	    if (root == null) {
	    	return false;
	    }
	 
	    // Store this node in path list. The node will be removed if
	    // not in path from root to k
	    path.add(root.val);
	 
	    // See if the k is same as root's key
	    if (root.val == k) {
	    	return true;
	    }
	        
	    // Check if k is found in left or right sub-tree
	    // if it enters any of these recursion and find a path to k
	    // and return true, then we don't care of ther rest.
	    if ((root.left!=null && findPath(root.left, path, k)) ||
	         (root.right!=null && findPath(root.right, path, k))) {
	        return true;	
	    }
	 
	    // If not present in subtree rooted with root, remove root from
	    // path[] and return false. (Pay attention to this)
	    // If the recursion somehow fail to find a path,
	    // the following will remove all the 'root' node 
	    // that has been added to the path recursively, and all the way
	    // up except the entry which is the real root node.
	   
	    path.remove(path.size()-1);
	    return false;
	}
	 

	
	
}
