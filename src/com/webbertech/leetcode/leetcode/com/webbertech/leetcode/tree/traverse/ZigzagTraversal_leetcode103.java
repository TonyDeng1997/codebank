package com.webbertech.leetcode.tree.traverse;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import com.webbertech.leetcode.util.TreeNode;

/*Leetcode 103. Binary Tree Zigzag Level Order Traversal 
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
*
*  Solution is very similar to the level order traversal.
*  Maybe use a flag to record it is level and if it is odd level don't 
*  do anything. For even level, try to reverse it.
*  
*  Since it is convinient to use ArrayList and Queue, ArrayDeque,
*  so it is advantegous to know this api methods very well.
*  
*  Accepted. The trick is that, 
*  
*  1/ pre add root in queue. 
*     queue is required, removed list is created outside.
*      
*  2/ loop the queue.
*     a. first thing while loop to empty out queue,
*        and add values into level list.
*     b. at the same time add nodes to removedList
*     
*     c. add level list to big list.
*     
*     d. add next levels nodes to queue from the removedList.
*     
*  Pay attention that removedList is the temp list to keep track of the 
*  level.
* */

public class ZigzagTraversal_leetcode103 {

	//solution queue+ two list
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> queue = new ArrayDeque<>();
		// pre add root to start the loop machine
		queue.add(root);
		int flag = 0;
		List<TreeNode> removedList = new ArrayList<>(); // keep track of removed
														// element

		while (!queue.isEmpty()) {
			flag++; // record level
			List<Integer> level = new ArrayList<>(); 
			
			/* Remove all the elements in the queue
			   at any time the elements in the queue 
			   are on the same level. One copy is made in 
			   
			*/
			while (queue.size() > 0) {
				TreeNode removed = queue.poll(); 
				level.add(removed.val);
				removedList.add(removed);
			}
			// even order, reverse
			if ((flag & 1) == 0) {
				Collections.reverse(level);
			}
			list.add(level);
			
			/* The following are for the next level
			 * For a tree like [1,2,3,4,5,6,7],
			 * for example removedList contains [2,3],
			 * then the following will add [4,5,6,7] into the queue.
			*/  
			while (!removedList.isEmpty()) {
				// add the last element of the removedList to the queue
				TreeNode removed = removedList.remove(0);
				if (removed.left != null)
					queue.offer(removed.left);
				if (removed.right != null)
					queue.offer(removed.right);
			}
		}

		return list;
	}
	
	public static void main(String[] args) {
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		r.right = new TreeNode(3);
		r.left.left = new TreeNode(4);
		r.right.right = new TreeNode(5);
		List<List<Integer>> list = zigzagLevelOrder(r);
		TreeNode.printLevelOrder(list);
		
		TreeNode r1 = new TreeNode(3);
		r1.left = new TreeNode(9);
		r1.right = new TreeNode(20);
		r1.right.left = new TreeNode(15);
		r1.right.right = new TreeNode(7);
		List<List<Integer>> list2 = zigzagLevelOrder(r1);
		TreeNode.printLevelOrder(list2);
	}
}