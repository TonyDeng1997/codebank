package com.webbertech.algorithm.tree;

public class FirstCommonAncestor2 {

   /*Solution 2: if any p 's parent that can cover q, then that parent is the first common ancestor
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
	
	TreeNode getSibling(TreeNode node) {
		if (node == null || node.parent == null) {
			return null;
		}
		
		TreeNode parent = node.parent;
		return parent.left == node ? parent.right : parent.left;
	}
	
	
	TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//if a tree only contains one node, then they will not have common ancester
	    if (!covers(root,p) || !covers(root,q)) {
	    	return null;
	    } 
	    // if one covers the other, this covering one is the ancestor for both
	    else if (covers(p,q)) {
	    	return p;
	    } else if(covers(q,p)) {
	    	return q;
	    }
	    
	    TreeNode sibling = getSibling(p);
	    TreeNode parent = p.parent;
	    
	    while (!covers(sibling,q)) {
	    	sibling= getSibling(parent);
	    	parent = parent.parent;
	    }
	    
	    return parent;
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
		  FirstCommonAncestor2 fca = new FirstCommonAncestor2();
		  
		  //test the simplest, it should be 1
		  TreeNode t= fca.commonAncestor(n1, n2,n3);
		  
		  //test some deeper nodes, it should be 1 
		  TreeNode t1= fca.commonAncestor(n1,n4,n5);
		  
		  //test some deeper nodes, it should be 1 , it works if both of the nodes are on one side
		  TreeNode t2= fca.commonAncestor(n1,n2,n4);
	}
	
	
}


