package com.webbertech.algorithm.tree;

public class FirstCommonAncestor4 {

   /*Solution 4: TODO revisit this later
   */
	static class TreeNode {
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		int data;
		
		TreeNode(int data) {
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		 TreeNode  n1 = new TreeNode(1);
		  TreeNode n2= new TreeNode(2);
		  TreeNode n3 = new TreeNode(3);
		  TreeNode n4 = new TreeNode(4);
		  TreeNode n5 = new TreeNode(5);
		  TreeNode n6 = new TreeNode(6);
		  
		  n2.parent = n1;
		  n3.parent = n1;
		  n4.parent = n2;
		  n5.parent = n3;
		  n6.parent = n3;
		
		  n1.left = n2;
		  n1.right = n3;
		  
		  n2.left = n4;
		  n3.left = n5;
		  n3.right = n6;
		  
		     /*
		      *           1
		      *          / \
		      *          2  3
		      *         /  / \
		      *        4  5   6 
		      * */
		  FirstCommonAncestor4 fca = new FirstCommonAncestor4();
		  
		  /*
		  //test the simplest, it should be 1
		  TreeNode t= fca.commonAncestor(n1, n2,n3);
		  
		  //test some deeper nodes, it should be 1 
		  TreeNode t1= fca.commonAncestor(n1,n4,n5);
		  
		  TreeNode t2= fca.commonAncestor(n1,n5,n6);
		  */
	}
}