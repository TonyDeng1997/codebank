package com.webbertech.leetcode.tree.bst;

import com.webbertech.leetcode.util.TreeNode;

/*
 * Get the predecessor and successor of a bst tree
 * 
 * Solution: recursion, if the val is root, then it is simple.
 * 
 * Pay attention to other cases, which is quite simple.
 * 
 * */


public class BSTInorderPredecessorSuccessor {

	static int successor, predecessor;

	public static void successorPredecessor(TreeNode root, int val) {
		if (root != null) {
			if (root.val == val) {
				// go to the right most element in the left subtree, it will the
				// predecessor.
				if (root.left != null) {
					TreeNode t = root.left;
					while (t.right != null) {
						t = t.right;
					}
					predecessor = t.val;
				}
				if (root.right != null) {
					// go to the left most element in the right subtree, it will
					// the successor.
					TreeNode t = root.right;
					while (t.left != null) {
						t = t.left;
					}
					successor = t.val;
				}
			} else if (root.val > val) {
				// we make the root as successor because we might have a
				// situation when value matches with the root, it wont have
				// right subtree to find the successor, in that case we need
				// parent to be the successor
				successor = root.val;
				successorPredecessor(root.left, val);
			} else if (root.val < val) {
				// we make the root as predecessor because we might have a
				// situation when value matches with the root, it wont have
				// right subtree to find the predecessor, in that case we need
				// parent to be the predecessor.
				predecessor = root.val;
				successorPredecessor(root.right, val);
			}
		}
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(7);
		root.left.right = new TreeNode(15);
		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);
		root.left.right.left = new TreeNode(13);
		root.left.right.right = new TreeNode(18);
		successorPredecessor(root, 10);
		System.out.println("Inorder Successor of 10 is : " + successor + " and predecessor is : " + predecessor);
		successorPredecessor(root, 30);
		System.out.println("Inorder Successor of 30 is : " + successor + " and predecessor is : " + predecessor);
	}
}
