package com.webbertech.algorithm.tree;

public class FirstCommonAncestor {

   /*Solution 1: assume TreeNode has parent link.
    * This problem is similar to find the intersected node of two linked list.
    * First, need to know the depth of the two node, and make them the same level before
    * entering into the while loop;
    * 
    * loop through until two node.parent both are not null and both parents are the same
    * 
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
	
	//part of solution1
	int depth(TreeNode node) {
		int depth = 0;
		while(node != null) {
			node = node.parent;
			depth ++;
		}
		return depth;
	}
	
	//part of solution1
	//make the deeper node on the same level as the shallow node
	TreeNode goUp(TreeNode t, int diff) {
		while(diff>0 && t != null) {
			t = t.parent;
			diff--;
		}
		return t;
	}
	
	//part of solution1
	TreeNode commonAncestor(TreeNode p, TreeNode q) {
		int depthP = depth(p);
		int depthQ = depth(q);
		int diff = Math.abs(depthP-depthQ);
		TreeNode deeper = (depthP-depthQ) >0 ? p : q;
		TreeNode shallow = (depthP-depthQ) >= 0 ? p : q;

		//p and q already on the same level, and their two children of the same parent
		if (diff == 0) {
           if (deeper.parent == shallow.parent) {
        	   return deeper.parent; 
           }			
		}
		
		//now the deepp and shollow are on the same level
		deeper = goUp(deeper, diff);
		
		//you can not test if shallow or deep's parent is null or not in the condition
		// we litterally allow them to be null if their parents are null
		while(shallow != null & deeper!= null && shallow != deeper) {
			deeper = deeper.parent;
			shallow = shallow.parent;
		}
		
		//if any of the parents are null and at this point, this means there
		//is no common ancestor any more, and return null, otherwise return 
		//deeper or shallow is the same
		 return shallow== null || deeper == null ? null: deeper;
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
		  FirstCommonAncestor fca = new FirstCommonAncestor();
		  
		  //test the simplest
		  TreeNode t= fca.commonAncestor(n2,n3);
		  
		  //test some deeper nodes
		  TreeNode t1= fca.commonAncestor(n4,n5);
		  
	}
	
	
}


