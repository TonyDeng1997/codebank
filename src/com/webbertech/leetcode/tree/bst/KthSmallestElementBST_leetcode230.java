package com.webbertech.leetcode.tree.bst;

import java.util.ArrayList;

import com.webbertech.leetcode.util.TreeNode;

/*
 * Leetcode 230. Kth Smallest Element in a BST
 * 
 * Given a binary search tree, write a function kthSmallest 
 * to find the kth smallest element in it.

   Note:
   You may assume k is always valid, 1<=k<=n BST's total elements.
   Follow up:
   What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?  
   How would you optimize the kthSmallest routine?
 * */
public class KthSmallestElementBST_leetcode230 {
	 public static void inorderTraversal(TreeNode root, ArrayList<Integer> list) {
			if (root.left!=null) {
				inorderTraversal(root.left, list);
			}
			list.add(root.val);
			if (root.right!=null) {
				inorderTraversal(root.right,list);
			}
		}
		
		  public static ArrayList<Integer> inorderTraversal(TreeNode root) {
		      ArrayList<Integer> list = new ArrayList<>();   
		      if (root == null) {
		    	  return list;
		    	  
		      }
		      inorderTraversal(root,list);
		      return list;
		  }
		  
	    public static int kthSmallest(TreeNode root, int k) {
	        ArrayList<Integer> result = inorderTraversal(root);
	        
	        return result.get(k-1);
	    }  
	
	 //TODO need to get second solution
	  
	  public static void main(String[] args) {
		  TreeNode tree = new TreeNode(4);
		  tree.left = new TreeNode(3);
		  tree.left.left = new TreeNode(1);
		  tree.left.right = new TreeNode(2);
		  tree.right = new TreeNode(6);
		  tree.right.left = new TreeNode(5);
		  tree.right.right = new TreeNode(7);
		  System.out.println(kthSmallest(tree,1));
	  }
}
