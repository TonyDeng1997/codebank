package com.webbertech.leetcode.tree.path;

import java.util.HashMap;
import java.util.Map;

import com.webbertech.leetcode.util.TreeNode;

/*
 * Leetcode 437 Path Sum III (Partial path sum to k).
 * 
 * You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.
The path does not need to start or end at the root or a leaf, 
but it must go downwards (traveling only from parent nodes to child nodes).
The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

Solution1: recursion
Time Complexity should be O(N^2) for the worst case and O(NlogN) for balanced binary Tree.

Solution2: better solution
17ms O(n) java prefix sum using hashmap.

 * */
public class PathSumIII_leetcode437 {

	// solution1: nlogn to n^2.
	public int pathSum1(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		int rootSum = findPath(root, sum);
		int leftSum = findPath(root.left, sum);
		int rightSum = findPath(root.right, sum);
		return rootSum+ leftSum + rightSum;
		//return findPath(root, sum) + pathSum1(root.left, sum) + pathSum1(root.right, sum);
	}

	public static int findPath(TreeNode root, int sum) {
		int count = 0;
		// hit the leaf node
		if (root == null) {
			return count;
		}
		if (sum == root.val) {
			count++;
		}
		count += findPath(root.left, sum - root.val);
		count += findPath(root.right, sum - root.val);
		return count;
	}

	// solution 2, accepted O(n)
	public static int pathSum2(TreeNode root, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1); // Default sum = 0 has one count
		return backtrack(root, 0, sum, map);
	}

	// BackTrack one pass
	public static int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map) {
		if (root == null)
			return 0;
		sum += root.val;
		// See if there is a subarray sum equals to target
		int res = map.getOrDefault(sum - target, 0);
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		// Extend to left and right child
		res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
		// Remove the current node so it wont affect other path
		map.put(sum, map.get(sum) - 1);
		return res;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);
		root.right.right = new TreeNode(11);
	//	int size = pathSum1(root, 8);
	//	System.out.println(size);
	}
}