package com.webbertech.leetcode.tree.bst;

import com.webbertech.leetcode.util.TreeNode;

/*
 * leetcode 98
 * 
 *  BST: left less than root value
 *       right larger than root value
 *       
 *      
 *       
 *  This is the by far good solution than the previous solution that I had
 * */
public class IsValidBST_leetcode98 {

	/*
	 * SOLUTION1: 
	 */
	   public static boolean isValidBST(TreeNode root) { 
	  		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE); 
	   }
	   
	   public static boolean isValidBST(TreeNode root, long minVal, long maxVal) { 
	   if (root == null) 
	      return true; 
	   
	   if (root.val >= maxVal || root.val <= minVal)
	      return false; 
	   
	   return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal); }
	   
	 // Your solution can not pass this case:[ Long.MIN_VALUE , null , Long.MAX_VALUE ]
	  
	 

	//Solution2 : improved version of version 1
	public static boolean isValidBST2(TreeNode p, Integer low, Integer high) {
		if (p == null)
			return true;
		return (low == null || p.val > low) && (high == null || p.val < high) && isValidBST2(p.left, low, p.val)
				&& isValidBST2(p.right, p.val, high);
	}

	public static boolean isValidBST2(TreeNode root) {
		return isValidBST2(root, null, null);
	}

	// solution3: another implementation similar to solution2
	public static boolean isValidBST3(TreeNode root) {
		return isValidBST3(root, null, null);
	}

	public static boolean isValidBST3(TreeNode root, Integer min, Integer max) {
		if (root == null)
			return true;

		if (min != null && root.val <= min || max != null && root.val >= max) {
			return false;
		}

		return isValidBST3(root.left, min, max == null ? root.val : Math.min(root.val, max))
				&& isValidBST3(root.right, min == null ? root.val : Math.max(root.val, min), max);
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(Integer.MIN_VALUE); 
		 root.left=null ;
		 root.right =  new TreeNode(Integer.MAX_VALUE); 
		 System.out.println(isValidBST(root)); // return false
		 
		 root = new TreeNode(10); 
		 root.left = new TreeNode(5);
		 root.right = new TreeNode(15); 
		 root.right.left = new TreeNode(6);
		 root.right.right = new TreeNode(20);
		 System.out.println(isValidBST2(root)); // return false
		
		root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.right = new TreeNode(6);
		root.right.right = new TreeNode(20);
		System.out.println(isValidBST2(root)); // return true;
	}
}