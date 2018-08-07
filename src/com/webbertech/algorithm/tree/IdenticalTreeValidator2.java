package com.webbertech.algorithm.tree;

public class IdenticalTreeValidator2 {

//	a simpler recursive way
	 public static boolean identicalTree(TreeNode t1, TreeNode t2) {
		 if (t1 ==null && t2 == null) {
			 return true;
		 } else if (t1 == null || t2 == null) {
			 return false;
		 } else if (t1.item != t2.item) {
			 return false;
		 } 
		 
		 return identicalTree(t1.left,t2.left) && identicalTree(t1.right, t2.right);
			 
	 }
	 
	 public static void main(String[] args) {
		 BinaryTree b= new BinaryTree();
		 b.constructTree();
		 TreeNode root = b.getRoot();
		 
		 TreeNode testTree = new TreeNode(1);
		 testTree.left = new TreeNode(2);
		 testTree.left = new TreeNode(3);
			
		 System.out.println(identicalTree(root, testTree));	
	 }
}
