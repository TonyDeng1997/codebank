package com.webbertech.algorithm.tree;

public  class TreeNode <T> {
	T item;
	TreeNode<T> left;
	TreeNode<T> right;
	
	TreeNode() {
		item = null;
		left = null;
		right = null;
	}
	
	//must to have
	TreeNode (T item) {
		this.item = item;
		left = right = null;
	}
	
	//must to have
	TreeNode (T left, T item, T right) {
		this (new TreeNode(left), item, new TreeNode(right));
	}
	
	//have to have
	TreeNode (TreeNode<T> left, T item, TreeNode<T> right) {
		this.left = left;
		this.item = item;
		this.right = right;
	}
	
    //return the left child	
	TreeNode<T> addLeft(T item) {
		this.left = new TreeNode<T>(item);
		return this.left;
	}
	
	//return the right child
	TreeNode<T> addRight(T item) {
		this.right = new TreeNode<T>(item);
		return this.right;
	}
}