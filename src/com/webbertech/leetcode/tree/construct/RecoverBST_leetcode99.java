package com.webbertech.leetcode.tree.construct;

import com.webbertech.leetcode.util.TreeNode;

/*
 * leetcode 99 recover a binary search tree
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
   Recover the tree without changing its structure.
	Note:
	A solution using O(n) space is pretty straight forward. 
	Could you devise a constant space solution? 
 * */

/*
Solution1: morris traversal
Solution2: 

*/

public class RecoverBST_leetcode99 {

	static TreeNode firstElement = null;
	static TreeNode secondElement = null;
	// The reason for this initialization is to avoid null pointer exception in
	// the first comparison when prevElement has not been initialized
	static TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

	public static void recoverTree(TreeNode root) {

		// In order traversal to find the two elements
		traverse(root);

		// Swap the values of the two nodes
		int temp = firstElement.val;
		firstElement.val = secondElement.val;
		secondElement.val = temp;
	}

	
	//morris traversal - in order traversal
	private static void traverse(TreeNode root) {
		if (root == null)
			return;

		traverse(root.left);
		// Start of "do some business",
		// If first element has not been found, assign it to prevElement (refer
		// to 6 in the example above)
		if (firstElement == null && prevElement.val >= root.val) {
			firstElement = prevElement;
		}

		// If first element is found, assign the second element to the root
		// (refer to 2 in the example above)
		if (firstElement != null && prevElement.val >= root.val) {
			secondElement = root;
		}
		prevElement = root;
		// End of "do some business"
		traverse(root.right);
	}

	public static void main(String[] args) {
		/*
		 * test1 Input:[1,2,3] Output:[1,2,3] Expected:[2,1,3]
		 * 
		 */
		/*
		 * Input:[2,3,1] Output:[3,2,1] Expected:[2,1,3]
		 */
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		recoverTree(root);
         
		
		System.out.println("testing..");
		/*
		 * Input:[3,null,2,null,1] 
		 * Expected:[1,null,2,null,3]
		 */
		TreeNode root1 = new TreeNode(3);
		root1.right = new TreeNode(2);
		root1.right.right = new TreeNode(1);
		recoverTree(root1);
	}
}