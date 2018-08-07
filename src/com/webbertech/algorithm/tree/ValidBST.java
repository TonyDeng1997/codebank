package com.webbertech.algorithm.tree;


//tree definition : root.left.value <= root.value <= root.right.value 
public class ValidBST {

	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int value) {
			this.value = value;
		}
	}
	
	//create a dummy BST for testing
	public static TreeNode constructBST() {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.left.right= new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.right = new TreeNode(10);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);
		return root;
	}
	
	//create a dummy non BST tree altered from above tree 
	public static TreeNode constructNonBST() {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.left.right= new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.right = new TreeNode(10);
		root.right.right = new TreeNode(14);
		root.right.right.right = new TreeNode(13);
		return root;
	}
	
   //TODO construct BST from a sorted array
	public TreeNode constructBST(int data[]) {
		return null;
	}
	
	
	/* returns true if given search tree is binary
    search tree (efficient version) */
   static boolean isBST(TreeNode node) {
       return (isBSTUtil(node,Integer.MIN_VALUE,Integer.MAX_VALUE));
   }
    
   /* Returns true if the given tree is a BST and its 
  values are >= min and <= max. */
   static boolean isBSTUtil(TreeNode node, int min, int max)
   {
       /* an empty tree is BST */
       if(node == null)
           return true;
        
       /* false if this node violates the min/max constraints */
       if(node.value < min || node.value > max)
           return false;
        
       /* otherwise check the subtrees recursively
       tightening the min/max constraints */
       return (isBSTUtil(node.left, min, node.value) &&  // Allow only distinct values
         isBSTUtil(node.right, node.value, max));  // Allow only distinct values 
       
   }
	
	public static void main (String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(3);
		node.right = new TreeNode(3);
		
		System.out.println(isBST(constructBST()));
		System.out.println(isBST(constructNonBST()));
		System.out.println(isBST(node));
	}
	
}
