package com.webbertech.algorithm.tree;

public class CheckBalancedTree {
 
//by definition, one node, height is 0
//http://www.comp.dit.ie/rlawlor/Alg_DS/searching/3.%20%20Binary%20Search%20Tree%20-%20Height.pdf
	
	 public static int getHeight(TreeNode t) {
		 if (t==null) return -1;
		 else {
			 return Math.max(getHeight(t.left),getHeight(t.right)) + 1;
		 }
	 } 
	 
	 //for each node, the left and right subtree of the node the depth different is no
	 //more than 1
	 public static boolean isBalancedTree(TreeNode t) {
		 if (t == null) {
			 return true;
		 } else {
			if (Math.abs(getHeight(t.left)-getHeight(t.right)) > 1)
			{
				return false;
			}
		 }
		 
		 return isBalancedTree(t.left) && isBalancedTree(t.right);
	 }
	 
	 public static void main(String[] args) {
		 TreeNode t = new TreeNode(1);
		 t.left = new TreeNode(2);
		 t.left.left = new TreeNode(3);
		 System.out.println(getHeight(t));
		 
		 
		 System.out.println(isBalancedTree(t));
		 
		 TreeNode t1 = new TreeNode(1);
		 t1.left = new TreeNode(2);
		 t1.right = new TreeNode(3);
		 System.out.println(getHeight(t1));
		 System.out.println(isBalancedTree(t1));
	 }
}
