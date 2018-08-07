package com.webbertech.algorithm.tree;

public class FirstCommonAncestor3 {

   /*Solution 3: The above two solutions uses a parent link, in this solution there is no parent link
    * This is a must-to-know solution
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
	
	TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//if a tree only contains one node, then they will not have common ancester
	    if (!covers(root,p) || !covers(root,q)) {
	    	return null;
	    } 
	    
	    return ancestorHelper(root, p, q);
	}
	
	TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root ==p || root ==q) {
			return root;
		}
		
		boolean pIsOnLeft = covers(root.left, p);
		boolean qIsOnLeft = covers(root.left,q);
		
		//this is an optimization to see if both nodes are on one side
		if(pIsOnLeft != qIsOnLeft) {
			//Nodes are on different side
		   return root;
		}
		
		//if both are one the same side, left or right?
		TreeNode childSide = pIsOnLeft ? root.left: root.right;
		return ancestorHelper(childSide,p,q);
	}
	
	
	boolean covers(TreeNode root, TreeNode p) {
		if (root == null)
			return false;
		if (root == p ) 
			return true;
		return covers(root.left, p) || covers(root.right, p);
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
		  FirstCommonAncestor3 fca = new FirstCommonAncestor3();
		  
		  //test the simplest, it should be 1
		  TreeNode t= fca.commonAncestor(n1, n2,n3);
		  
		  //test some deeper nodes, it should be 1 
		  TreeNode t1= fca.commonAncestor(n1,n4,n5);
		  
		  TreeNode t2= fca.commonAncestor(n1,n5,n6);
	}
}


