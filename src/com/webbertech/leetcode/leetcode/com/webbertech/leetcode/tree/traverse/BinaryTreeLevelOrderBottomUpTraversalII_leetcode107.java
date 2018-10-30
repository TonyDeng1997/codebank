package com.webbertech.leetcode.tree.traverse;

import java.util.ArrayList;
import java.util.List;

import com.webbertech.leetcode.util.TreeNode;

/*
 * Leetcode 102 Binary Tree Level Order Traversal 
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

solution: Use a recursion
 * */

public class BinaryTreeLevelOrderBottomUpTraversalII_leetcode107 {
	 
   //solution 1
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<>();
	    travelTree(0, root, result);
	    List<List<Integer>> reverseRst = new ArrayList<>();
	    for (int i = 0; i < result.size(); i++) {
	        reverseRst.add(result.get(result.size() - i - 1));
	    }
	    return reverseRst;
	}

	private void travelTree(int level, TreeNode root, List<List<Integer>> result) {
	    if (root == null) return;
	    if (result.size() <= level) result.add(new ArrayList<>());
	    result.get(level).add(root.val);
	    travelTree(level + 1, root.left, result);
	    travelTree(level + 1, root.right, result);
	}	

	 //solution2
	 public List<List<Integer>> levelOrderBottom2(TreeNode root) {
	        List<List<Integer>> mainLs = new ArrayList<>();
	        int maxDepth = getMaxDepth(root);
	        for(int i=0;i<maxDepth;i++){
	            mainLs.add(new ArrayList<Integer>());
	        }
	        processTree(root,mainLs,maxDepth);
	        return mainLs;
	    }
	    
	    public void processTree(TreeNode root,List<List<Integer>> mainLs,int level){
	        if (root==null){
	            return;
	        }
	        List<Integer> ls = mainLs.get(level-1);
	        //System.out.println("adding " + root.val + " at level " + level);
	        ls.add(root.val);        
	        processTree(root.left,mainLs,level-1);
	        processTree(root.right,mainLs,level-1);
	    }
	    
	    public int getMaxDepth(TreeNode root){
	        if(root==null){
	            return 0;
	        }
	        return Math.max(getMaxDepth(root.left),getMaxDepth(root.right))+1;
	    }
	    
	public static void main(String[] args) {
		TreeNode r = new TreeNode(3);
		r.left = new TreeNode(9);
		r.right = new TreeNode(20);
		r.right.left = new TreeNode(15);
		r.right.right = new TreeNode(7);
		
	}
	 
}
