package com.webbertech.leetcode.tree.bst;

import java.util.ArrayList;
import java.util.List;

import com.webbertech.leetcode.util.TreeNode;

import static com.webbertech.leetcode.tree.bst.TreePathFromRootToNode.findPath;
import static com.webbertech.leetcode.tree.bst.lca_bt_leetcode236.lowestCommonAncestor;

public class DistanceOfTwoNodeInBT {
	static int distance(TreeNode root, TreeNode p, TreeNode q) {
    	List<Integer> listP = new ArrayList<>();
    	List<Integer> listQ = new ArrayList<>();
    	boolean findP = findPath(root, listP , p.val);
    	boolean findQ = findPath(root, listQ, q.val);
    	int distance = 0;
    	if (findP && findQ) { // both node exists and were found
    		TreeNode lca = lowestCommonAncestor(root, p, q);
    		List<Integer> listLca = new ArrayList<>();
    		if (findPath(root, listLca, lca.val)) {
    			distance  =listP.size()+listQ.size() - 2* listLca.size();
    		} 
    	}
    	return distance;
    }
    
    public static void main(String[] args) {
		   // Let us create the Binary Tree shown in above diagram.
	    TreeNode root = new TreeNode(1);
	    TreeNode n1= root.left = new TreeNode(2);
	    TreeNode n2= root.right = new TreeNode(3);
	    TreeNode n3= root.left.left = new TreeNode(4);
	    TreeNode n4= root.left.right = new TreeNode(5);
	    TreeNode n5= root.right.left = new TreeNode(6);
	    TreeNode n6= root.right.right = new TreeNode(7);
	    System.out.println(distance(root, n1, n2)); // 2
	    System.out.println(distance(root, n3, n6)); // 4
	    
	    
	}
}
