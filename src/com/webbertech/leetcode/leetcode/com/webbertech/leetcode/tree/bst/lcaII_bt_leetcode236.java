package com.webbertech.leetcode.tree.bst;
import static com.webbertech.leetcode.tree.bst.TreePathFromRootToNode.findPath;

import java.util.ArrayList;
import java.util.List;
import com.webbertech.leetcode.util.TreeNode;

/*
Leetcode 236. 
Find the least common ancestry of two tree node.
*/

public class lcaII_bt_leetcode236 {
	// Returns LCA if node n1, n2 are present in the given binary tree,
	// otherwise return -1
	static int findLCA(TreeNode root, int n1, int n2) {
	    // to store paths to n1 and n2 from the root
	    List<Integer> path1 = new ArrayList<>();
	    List<Integer> path2 = new ArrayList<>();
	 
	    // Find paths from root to n1 and root to n1. If either n1 or n2
	    // is not present, return -1
	    if (!findPath(root, path1, n1) || !findPath(root, path2, n2))
	          return -1;
	 
	    /* Compare the paths to get the first different value */
	    int i;
	    for (i = 0; i < path1.size() && i < path2.size() ; i++)
	        if (path1.get(i) != path2.get(i))
	            break;
	    return path1.get(i-1);
	}
	
	public static void main(String[] args) {
		   // Let us create the Binary Tree shown in above diagram.
	    TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(7);
	    System.out.println(findLCA(root, 4, 5));  // output 2
	    System.out.println(findLCA(root, 4, 6));   // output 1
	    System.out.println(findLCA(root, 3, 4));   // output 1
	    System.out.println(findLCA(root, 2, 4));   // output 2
	}
}