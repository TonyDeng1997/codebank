package com.webbertech.algorithm.tree;

/* find the next node, the in-order successor of a given node in a binary tree
if n is the node you are given, then the in-order successor is the right node of n,
in another word it is the the left-most-node of the subtree of n.

* example trees:
* 
*      1
*     /                  1
*    2                  / \
*     \                2   3
*      3 <- n              
*     /             
*    4
*    
*     in-order for the first tree is: 2431, so if n = 3, the next will be, output is 1
*/




public class InOrderSuccessor {

	private static class TreeNode<T> {
	   	public TreeNode<T> left;
	   	public TreeNode<T> right;
	   	public TreeNode<T> parent;
	   	public T data;
	   	
	   	public TreeNode(T data, TreeNode<T> left,TreeNode<T> right, TreeNode<T> parent) {
	   		this.data = data;
	   		this.left = left;
	   		this.right = right;
	   		this.parent = parent;
	   	}
	} 
	
	TreeNode<Integer> inorderSuccessor(TreeNode<Integer> n) {
		 if (n==null) {
			  return null;
		 }
		 if (n.right!=null) {
			 return leftMostChild(n.right);
		 } else {
			 TreeNode<Integer> q = n;
			 TreeNode<Integer> x = q.parent;
			 while(x != null && x.left != q) {
				 q = x;
				 x = x.parent;
			 }

			 return x;
		 }
	}
	
	TreeNode<Integer> leftMostChild(TreeNode<Integer> t) {
		 if(t==null) 
			 return null;
		 
		  while(t.left!=null) {
			  t = t.left;
		  }
		  return t;
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> tree1  = new TreeNode<Integer>(1, null,null, null);
		TreeNode<Integer> n2= new TreeNode<Integer>(2, null,null, null);
		tree1.left = n2;
		n2.parent = tree1;
		TreeNode<Integer> n3= new TreeNode<Integer>(3, null,null, null);
		n2.right = n3;
		n3.parent = n2;
		TreeNode<Integer> n4= new TreeNode<Integer>(4, null,null, null);
		n3.left = n4;
		n4.parent = n3;
		
		InOrderSuccessor s = new InOrderSuccessor();
		
		//the input is n3 not root
		System.out.println(s.inorderSuccessor(n3).data);
		
		//this is simple tree
		/*
		 *         1
		 *        / \ 
		 *       2   3
		 *      /     \
		 *     4       5
		 *    /         \
		 *   6           7
		 * 
		 * */
		
		TreeNode<Integer> tree2  = new TreeNode<Integer>(1, null,null, null);
		TreeNode<Integer> m2= new TreeNode<Integer>(2, null,null, null);
		tree2.left = m2;
		m2.parent = tree1;
		TreeNode<Integer> m3= new TreeNode<Integer>(3, null,null, null);
		tree2.right = m3;
		m3.parent = tree2;
		
		TreeNode<Integer> m4= new TreeNode<Integer>(4, null,null, null);
		m2.left = m4;
		m4.parent = m2;
		
		TreeNode<Integer> m5= new TreeNode<Integer>(5, null,null, null);
		m3.right = m5;
		m5.parent = m2;
	
		TreeNode<Integer> m6= new TreeNode<Integer>(6, null,null, null);
		m4.left = m6;
		m6.parent = m4;
		
		TreeNode<Integer> m7= new TreeNode<Integer>(7, null,null, null);
		m5.right = m7;
		m7.parent = m5;
		
		System.out.println(s.inorderSuccessor(m3).data);
		
		
		
		
		//this is simple tree
		/*
		 *         1
		 *        / \ 
		 *       2   3
		 *      /     \
		 *     4       5
		 *    /        /
		 *   6        7
		 * 
		 * in order is: 6,4,2,1,3,7,5; the next one will be 7 
		 * */
		
		TreeNode<Integer> tree3  = new TreeNode<Integer>(1, null,null, null);
		 m2= new TreeNode<Integer>(2, null,null, null);
		tree3.left = m2;
		m2.parent = tree3;
		 m3= new TreeNode<Integer>(3, null,null, null);
		tree3.right = m3;
		m3.parent = tree3;
		
		m4= new TreeNode<Integer>(4, null,null, null);
		m2.left = m4;
		m4.parent = m2;
		
		m5= new TreeNode<Integer>(5, null,null, null);
		m3.right = m5;
		m5.parent = m2;
	
		m6= new TreeNode<Integer>(6, null,null, null);
		m4.left = m6;
		m6.parent = m4;
		
		m7= new TreeNode<Integer>(7, null,null, null);
		m5.left = m7;
		m7.parent = m5;
		
		System.out.println(s.inorderSuccessor(m3).data);
	}
}
