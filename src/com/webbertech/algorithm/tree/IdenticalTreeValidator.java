package com.webbertech.algorithm.tree;


// one version to see if two trees are identical

public class IdenticalTreeValidator {

	boolean noChild(TreeNode t) {
		if(t.left == null && t.right == null) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean hasRightChild(TreeNode t) {
		if (t.left == null && t.right != null)
			return true;
		else {
			return false;
		}
	}
	
	boolean hasLeftChild(TreeNode t) {
		if (t.left != null && t.right == null) {
			return true;
		} else {
			return false;
		}
	}
	//return true for identical trees
	//return false for non identical trees
	boolean compareTrees(TreeNode t1, TreeNode t2) {
		
		//this condition is for non-leaf node, if they both have left child but both don't have right child
		//or viseversa 
		if(t1 == null && t2== null)
			return true;
		
		//if one tree has only has left and the other only has right, return false right away
		if(this.hasLeftChild(t1) && this.hasRightChild(t2) || 
				this.hasRightChild(t1)&& this.hasLeftChild(t2)) {
			return false;
		}
			
		//should handle leaf nodes, no problem of this		
		if(noChild(t1) && noChild(t2) && t1.item == t2.item) {
			return true;
		}
		
		//must fullfil this recursive requirement
		if(compareTrees(t1.left, t2.left) && compareTrees(t1.right,t2.right)) {
			return true;
		} else { 
			return false;
		}
	
	}
	
	public static void main(String[] args) {
		
		/*
		 *             1
		 *             / 
		 *            2
		 *            /
		 *           3
		 *          /
		 *         4
		 * 
		 * 
		 * */
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.left.left = new TreeNode(3);
		t1.left.left.left = new TreeNode(4);
		
		IdenticalTreeValidator solution = new IdenticalTreeValidator();
		System.out.println(solution.compareTrees(t1, t1));
		

		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.left.left = new TreeNode(3);
	    t2.left.left.right = new TreeNode(4);
		System.out.println(solution.compareTrees(t1, t2));
	}
}
