package com.webbertech.crackCodingInterview;

//this is a manual way to create BST, it is a brain refresher

public class CreatBST {
	
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
	    
		public TreeNode(int value) {
			this.data = value;
		}
		
	    void add(int value) {
	    	if (value > data) {
	    		if (right== null) {
	    			right = new TreeNode(value);
	    		} else {
	    			right.add(value);
	    		}
	    	} else {
	    		if (left == null) {
	    			left = new TreeNode(value);
	    		} else {
	    			left.add(value);
	    		}
	    	}
	    } 
	
	}
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(20);
		tree.add(10);
		tree.add(15);
		tree.add(25);
		tree.add(6);
		tree.add(30);
	}
}
