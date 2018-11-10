package com.webbertech.leetcode.tree.traverse;

import com.webbertech.leetcode.util.TreeNode;

/*Leetcode 114. Flatten Binary Tree to Linked List
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
     
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

Solution: recursively break the right child, 
and make it the right child of its left child.
Note this is a pre-order traversal.

This is my accepted solution.
* */


//solution1
public class FlattenBinaryTreeToLinkedList_leetcode114 {
	
	static TreeNode preOrder(TreeNode node) {
	   if (node==null) return node;
	   if (node.left == null && node.right == null)
		   return node;
	
	   TreeNode tempRight=null;
	   if (node.right!=null) {
		   tempRight = node.right;
	   }
	    preOrder(node.left);
		node.right = node.left;
		node.left = null;
		if(node.right == null) {
			preOrder(tempRight);
			node.right = tempRight;
		}
		else {
			while(node.right!=null) {
				node = node.right;
			}
			//node.right = preOrder(tempRight);
			preOrder(tempRight);
			node.right = tempRight;
			
		}
	   return node;
	}
	
	public static void flatten(TreeNode root) {
        if (root ==null || 
        		root.left==null && root.right==null) 
        	return;
        root = preOrder(root);
    }

	
/* Solution2
 * 
 * */
	
	static private TreeNode prev = null;

	public static void flatten2(TreeNode root) {
	    if (root == null)
	        return;
	    flatten2(root.right);
	    flatten2(root.left);
	    root.right = prev;
	    root.left = null;
	    prev = root;
	}
	
/*
 * Solution3: 
 * An improved version of solution 2
 * */	
	



public static void flatten3(TreeNode root) {
    flatten3(root,null);
}

private static TreeNode flatten3(TreeNode root, TreeNode pre) {
    if(root==null) return pre;
    pre=flatten3(root.right,pre);    
    pre=flatten3(root.left,pre);
    root.right=pre;
    root.left=null;
    pre=root;
    return pre;
}



	public static void main(String[] args) {
		System.out.println("Test1");
		TreeNode root=new TreeNode(1);
		root.right = new TreeNode(2);
		flatten2(root);
		while(root!=null){
			System.out.println(root.val);
			root = root.right;
		}
		
		System.out.println("Test2");
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(5);
		root1.left.left = new TreeNode(3);
		root1.left.right = new TreeNode(4);
		root1.right.right = new TreeNode(6);
		
		flatten2(root1);
		
		while(root1!=null){
			System.out.println(root1.val);
			root1 = root1.right;
		}
		
		System.out.println("Test3");
		root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		flatten2(root);
		
		while(root!=null){
			System.out.println(root.val);
			root = root.right;
		}
	}
}