package com.webbertech.leetcode.tree.bst;



/*
 * Inorder successor of Binary tree
 * 
 * ref: http://algorithms.tutorialhorizon.com/inorder-successor-in-binary-tree/
 * 
 * solution: since it is not bst, so can not use bst technique to solve this issue.
 * 
 * Given a tree [a,b,c, d,e, f,g, null,null, i, null,null, null, null, null,
 *   null, j, null, x]
 * 
 * There are three cases:
 * Case 1 : If the x has a right child then its inorder suc­ces­sor will the left most 
 * ele­ment in the right sub tree of x.
 * 
 * case 2: 
 * 
 * 1/ Start from the root and com­pare it with x, if matched then we have found the node.
   2/ else go left and right.
   3/ recur­sively do step 2 and 3 till you find the node x.
   4/ Now when you have found the node, stop the recursion.
   5/ Now recur­sion will back­track to the root, every recur­sive call will return the node itself 
   (say it will be stored in n) so when it back­tracked to its par­ent which will be root now, check 
   whether parent.left = n, if not , keep going up.
 * 
 * Case 3: if x is the right most node in the while tree then its inorder suc­ces­sor will be NULL.
 * 
 * This is a complex one.
 * 
 * */

public class BTInorderSuccessor {
	public static TreeNode n = null;
	public static Boolean nodeFound = false;
	
	

	
	public TreeNode inOrderSuccBiTree(TreeNode root, TreeNode x){
		nodeFound = false;
		
		// if the node has right node, then successor is it right child's left most leaf
		if(x.right!=null){
			TreeNode temp = leftMostTreeNode(x.right);
			System.out.println("The In Order Successor for '" + x.val + "' is "+ temp.val );
			return null;
		}
		
		//else do this
		return findRecur(root, x);
	}
	
	public void display(TreeNode root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.val);
			display(root.right);
		}
	}
	
	
	// this method is backtracked to cover if x is the right most leaf of the whole tree
	// or it is the node without right child.
	public TreeNode findRecur(TreeNode root, TreeNode x){
		if(root==null) return null;
		if(root==x||(n = findRecur(root.left,x))!=null||(n=findRecur(root.right,x))!=null){	

			if(n!=null){
				if(root.left==n){
					nodeFound = true;
					System.out.println("The In Order Successor for '" + x.val + "' is "+ root.val );
					return null;
				}
			}
			// if root is x, then return root
			return root;
		}
		return null;
	}
	
	public TreeNode leftMostTreeNode(TreeNode x){
		while(x.left!=null){
			x = x.left;
		}
		nodeFound = true;
		return x;
	}
	
	//TODO change my util class to T and update all the code
	private static class TreeNode {
		char val;
		TreeNode left;
		TreeNode right;
		public TreeNode(char data){
			this.val = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void main(String args[]){
		TreeNode root = new TreeNode('a');
		root.left = new TreeNode('b');
		root.right = new TreeNode('c');
		root.left.left = new TreeNode('d');
		root.left.right = new TreeNode('e');
		TreeNode x = new TreeNode('x');
		root.left.right.left = new TreeNode('i');
		root.left.right.left.right = new TreeNode('j');
		root.left.right.left.right.right = x;
		root.right.left = new TreeNode('f');
		TreeNode y = new TreeNode('g');
		root.right.right = y;

		BTInorderSuccessor i = new BTInorderSuccessor();
		System.out.print(" Tree : ");
		i.display(root);
		System.out.println();
		nodeFound = false;
		i.inOrderSuccBiTree(root, x);
		if(!nodeFound){
			System.out.println("InOrder Successor of " + x.val + " is NULL");
		}
		nodeFound = false;
		i.inOrderSuccBiTree(root, root);
		if(!nodeFound){
			System.out.println("InOrder Successor of " + root.val + " is NULL");
		}
		nodeFound = false;
		i.inOrderSuccBiTree(root, y);
		if(!nodeFound){
			System.out.println("InOrder Successor of " + y.val + " is NULL");
		}
	}
}