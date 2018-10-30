package com.webbertech.leetcode.util;

import java.util.*;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	public TreeNode() {
	}
	
	private static TreeNode root;

	public static TreeNode getRoot() {
		return root;
	}

	// This method mainly calls insertRec()
	// tree.insert(50); use this method to build a bst,
	// just pass any arbitrary number in it.
	public void insert(int key) {
		root = insertRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	static TreeNode insertRec(TreeNode root, int key) {
		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new TreeNode(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.val) {
			root.left = insertRec(root.left, key);
		} else if (key > root.val) {
			root.right = insertRec(root.right, key);
		}

		/* return the (unchanged) node pointer */
		return root;
	}

	// This method mainly calls InorderRec().
	// This is inorder traversal and used for testing purpose
	public static void inorder(TreeNode root) {
		inorderRec(root);
	}

	// A utility function to do inorder traversal of BST
	static void inorderRec(TreeNode root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.val + " ");
			inorderRec(root.right);
		}
	}
	
	public static void printLevelOrder(List<List<Integer>> list) {
		for(List<Integer> l: list) {
			for(int i: l) {
				System.out.print(i+ " ");
			}
			System.out.println();
		}
	}
}