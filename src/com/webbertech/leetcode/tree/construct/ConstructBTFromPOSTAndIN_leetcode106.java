package com.webbertech.leetcode.tree.construct;

import com.webbertech.leetcode.util.TreeNode;

/*leetcode 106
 * Given postorder and inorder integer array, reconstruct the binary tree and return its
 * root.
 * 
 * Solution1: 
 * 
 * 

The the basic idea is to take the last element in postorder array as the root, 
find the position of the root in the inorder array; 
then locate the range for left sub-tree 
and right sub-tree and do recursion. Use a HashMap to record the index of root in the inorder array.

public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
	if (inorder == null || postorder == null || inorder.length != postorder.length)
		return null;
	HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
	for (int i=0;i<inorder.length;++i)
		hm.put(inorder[i], i);
	return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, 
                          postorder.length-1,hm);
}

private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, 
                                 HashMap<Integer,Integer> hm){
	if (ps>pe || is>ie) return null;
	TreeNode root = new TreeNode(postorder[pe]);
	int ri = hm.get(postorder[pe]);
	TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
	TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
	root.left = leftchild;
	root.right = rightchild;
	return root;
}
 * */

public class ConstructBTFromPOSTAndIN_leetcode106 {

	static int pInorder; // index of inorder array
	static int pPostorder; // index of postorder array

	private static TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
		if (pPostorder < 0) {
			return null;
		}
		/*  pInderoder and pPostorder are two indices that goes from the end
		 * of the array.
		 * */
		
		// create root node
		TreeNode n = new TreeNode(postorder[pPostorder--]);
		
		// if right node exist, create right subtree
		if (inorder[pInorder] != n.val) {
			n.right = buildTree(inorder, postorder, n);
		}
		pInorder--;
		// if left node exist, create left subtree
		if ((end == null) || (inorder[pInorder] != end.val)) {
			n.left = buildTree(inorder, postorder, end);
		}
		return n;
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		pInorder = inorder.length - 1;
		pPostorder = postorder.length - 1;
		return buildTree(inorder, postorder, null);
	}

	
	
	/*Tree is like
	 * 7, 6, null, 5,3, null, 4, null, null, null, 2, null, 1
	 * 
	 * */
	public static void main(String[] args) {
		int[] post = { 1, 2, 4, 5, 3, 6, 7 };
		int[] in = { 4, 2, 5, 1, 6, 3, 7 };
		TreeNode t = buildTree(in, post);
		TreeNode.inorder(t);
		System.out.println("\ntest2");
		int[] pre1 = { 1, 2 };
		int[] in1 = { 2, 1 };
		TreeNode t1 = buildTree(pre1, in1);
		TreeNode.inorder(t1);
	}
}