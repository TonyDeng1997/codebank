package com.webbertech.algorithm.tree;

public class FullBinaryTree {

	
	//using recursion is simple
    public static boolean isFullBinaryTree(TreeNode node) {
    	
    	    // Empty tree is full so return true.
    	    // This also makes the recursive call easier.
    	    if (node == null) {   
    	    	return true;
    	    }

    	    // count the number of children
    	    int count = (node.left == null?0:1) + (node.right == null?0:1);

    	    // We are good if this node has 0 or 2 and full returns true for each child.
    	    // Don't need to check for left/right being NULL as the test on entry will catch
    	    // NULL and return true.
    	    return count != 1 && isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
    
    }
    
    
}
