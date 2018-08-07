package com.webbertech.algorithm.tree;

public class CheckSubTree {
 
	/*Requirement: if there is a node n in T1 that n's subtree is identical to T2, ask the employer
	 * that if n can be the root, if n can not be root, that means, cutting from n it is identical to T2, 
	 * then the following solution1 will work
	 *  
	 *solution 1: think of traversal and compare the array or string of the traversal elements
	  First of all, it needs a careful and clear thought, after thinking, we find out that
	  in-order does not work as two different trees will have the same in-order traversal.
	  
	  pre-order will work in the condition that we preserve the null child. Post-order I did not think about it.
	  for pre-order and preserve the null child, the sequence of elements can distinguish the following trees:
	  
	     3      and       3
	    /                  \
	   4                    4
	*/
	
	//assume that we know t1 is larger than t2
	boolean containsTree(TreeNode t1, TreeNode t2) {
		StringBuilder string1 = new StringBuilder();
		StringBuilder string2 = new StringBuilder();
		
		getOrderString(t1, string1);
		getOrderString(t2, string2);
		
		return string1.indexOf(string2.toString())!=-1;
	}
	
	//part of solution1
	void getOrderString(TreeNode t, StringBuilder sb) {
		if (t == null) {
			sb.append("X");
			return;
		}
		
		//pre-order, first do the node, and then left and then right
		sb.append(t.item+ " "); // add root
		getOrderString(t.left,sb);
		getOrderString(t.right, sb);
	}
	
	
	//solution 2
	
	
	boolean subTree(TreeNode t1, TreeNode t2) {
		if (t1==null) {
			return false;
		} else if (t2 == null)  {
			// t1 is n't null but t2 is null, it is true
			return true;
		} else if (t1.item == t2.item && matchTree(t1, t2)){
			//this condition is t1 and t2 are identical
			return true;
		} 
		return subTree(t1.left, t2) || subTree(t1.right, t2);
	}
	
	//this is a classic problem, try to remember it
	//the following method check if t1 and t2 are identical.
	boolean matchTree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		} else if (t1 == null || t2 == null) {
			return false;
		} else if (t1.item != t2.item) {
			return false;
		} else {
			return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
		}
	}
	
	
	public static void main(String[] args) {
	  TreeNode tree1 = new TreeNode(1);
	  tree1.left = new TreeNode(2);
	  tree1.right = new TreeNode(3);
	  tree1.left.left = new TreeNode(4);
	  
	  //solution 1 does not work with this case
	  TreeNode tree2 = new TreeNode(1);
	  tree2.left = new TreeNode(2);
	  tree2.right = new TreeNode(3);
	
	  //it works for this case because it does not start from the root
	  //note that it does not work for 1,2,4 left-most branch
	  //by reading thre requirement 
	  TreeNode tree3 = new TreeNode(2);
	  tree3.left = new TreeNode(4);
			  
	  System.out.println("\n Testing solution1 \n");
	  CheckSubTree cst = new CheckSubTree();
	  System.out.println(cst.containsTree(tree1,tree2)); // this is false		  
	  System.out.println(cst.containsTree(tree1,tree3)); // this is true
	  
	  //solution 2 testing
	  System.out.println("\n Testing solution2 \n");                                                               
	  System.out.println(cst.subTree(tree1,tree2)); // this is false		  
	  System.out.println(cst.subTree(tree1,tree3)); // this is true
	  
	  //testing the matchTree
	  System.out.println(cst.matchTree(tree2, tree2));
	}
	
	
	
}
