package com.webbertech.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Queue;

import com.webbertech.leetcode.util.TreeNode;

/* Leetcode 222 Count Tree nodes of complete binary tree
 * 
 * Given a complete binary tree, count the number of nodes.
Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, 
is completely filled, and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.

solution: because of the nature of the complete binary tree.
Then there are some shortcut to make the algorithm to be logn instead of n.
So the cases are,

1/ full binary tree, getLeft and getRight are the same, see below.
2/ a normal complete binary tree that is non full binary tree.
**/

public class CountCompleteTreeNodes_leetcode222 {

	// solution1 (better)
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;

		int l = getLeft(root) + 1; // number of nodes from root to the node
		int r = getRight(root) + 1;

		if (l == r) {
			// full binary tree, so it is 2^(l-1) -1 
			return (2 << (l - 1)) - 1;
		} else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
	}

	private int getLeft(TreeNode root) {
		int count = 0;
		while (root.left != null) {
			root = root.left;
			++count;
		}
		return count;
	}

	private int getRight(TreeNode root) {
		int count = 0;
		while (root.right != null) {
			root = root.right;
			++count;
		}
		return count;
	}

	// solution 2, just count every node, n nodes so it is O(n)
	static int countNodes2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> q = new ArrayDeque<>();
		int count = 1;
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode removed = q.poll();
			if (removed.left != null) {
				q.offer(removed.left);
				count++;
			}
			if (removed.right != null) {
				q.offer(removed.right);
				count++;
			}
		}
		return count;
	}

	
	public static void main(String[] args) {

		// normal binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		System.out.println(new CountTreeNodes().countNodes(root)); //return 6
        System.out.println(countNodes2(root));
		// full binary tree
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		  
		System.out.println(new CountTreeNodes().countNodes(root)); //return 7
		System.out.println(countNodes2(root));
		
		System.out.println("testing java");
		System.out.println(2 << 2); // 2*2*2
		System.out.println((2 << (3 - 1)) - 1);
	}
}
