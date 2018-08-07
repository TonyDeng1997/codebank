package com.webbertech.leetcode.tree.path;

import com.webbertech.leetcode.util.TreeNode;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/*Leetcode 113 PATH SUM II
 * Get all path sum to k and return List of List.
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]


 * Solution accepted.
 * */
public class AllPathSumII_leetcode113 {
	public static List<List<Integer>> pathSum(TreeNode root, int sum){
		// create two list, one is the final list, and one is the list to store the the path
		List<List<Integer>> result  = new ArrayList<List<Integer>>();
		List<Integer> currentResult  = new ArrayList<Integer>();
		pathSum(root,sum,currentResult,result);
		return result;
	}

	/* When go down a path, if the path is not qualified, the last node is removed, so that the currentResult is on the parent node, in the next recursion,
	 * either it is left or right, so we can try to see if the new path qualified for the path or not.
	 * 
	 * When the path is qualified, the last node is removed, thus, backtrack, giving the possibility that one child of a node p makes a qualified path, and
	 * the other child of p will also make a qualified path.
	 * 
	 * It is only trying to judge if it is a path when it hits to a child whose left and right child are null, so it is depth first search.
	 * 
	 * */
	public static void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {
		if (root == null)
			return;
		
		//When enter the path, add the node right away, it will be removed later on from current list
		currentResult.add(new Integer(root.val));
		
		// this is when a full path goes to leave node, then add the current list to list
		if (root.left == null && root.right == null && sum == root.val) { 
			result.add(new ArrayList<Integer>(currentResult));
			//don't forget to remove the last integer, backtrack, even the path is qualified, remove the last node
			currentResult.remove(currentResult.size() - 1);
			return;
		} else {
			pathSum(root.left, sum - root.val, currentResult, result);
			pathSum(root.right, sum - root.val, currentResult, result);
		}
		//Why? for example, one path [5,4,11,7] is not qualified, it does not add the path to list, 
		//and both its children are null so pathSum does not do anything.
		// and get here, the following step is to remove 7. It serves as backtrack.
		currentResult.remove(currentResult.size() - 1);
	}
	
	 public static void main(String[] args) {
		  TreeNode root = new TreeNode(5);
		  root.left = new TreeNode(4);
		  root.right = new TreeNode(8);
		  root.left.left = new TreeNode(11);
		  root.left.left.left = new TreeNode(7);
		  root.left.left.right = new TreeNode(2);
		  root.right.left = new TreeNode(13);
		  root.right.right = new TreeNode(4);
		  root.right.right.left = new TreeNode(5);
		  root.right.right.right = new TreeNode(1);
		  List<List<Integer>> list = pathSum(root, 22);
		  
		  // the following is for testing
		  for(List<Integer> l : list) {
			  for (Integer i: l) {
				  System.out.print(i + " ");
			  }
			  System.out.println();
		  }
	  }
}