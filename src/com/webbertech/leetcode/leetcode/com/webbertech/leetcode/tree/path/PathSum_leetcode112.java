package com.webbertech.leetcode.tree.path;

import com.webbertech.leetcode.util.TreeNode;

/* Leetcode 112
 *  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
 *  adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 * */

public class PathSum_leetcode112 {

	  //solution 1: recursion
	  public static boolean hasPathSum(TreeNode root, int sum) {
	        if(root == null) return false;
	        if (root.left == null && root.right == null) 
	        	return root.val == sum; 
	        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
	        
	    }
	  
	  //solution2: recursion but different point of view
	  public static boolean hasPathSum2(TreeNode root, int sum) {
	       if(root==null) return false;
	           //sub node val.when sum is 0 and the node is leaf,we find the path.
	        sum -= root.val;
	        //leaf 
	        if (root.left == null && root.right == null) {
	            if (sum == 0)
	                return true;
	        } else {
	            if (root.left != null)
	                 if(hasPathSum(root.left, sum))
	                     return true;
	            if (root.right != null)
	                 if(hasPathSum(root.right, sum))
	                     return true;
	        }   
	            //arrive to leaf,but sum is not 0,so we must plus node val
	        sum += root.val;
	        return false;
	    }
	  
	  
	  //solution3 : use iterative
	  /*
	   *  #iteratively:DFS
    if not root:return False
    if not root.left and not root.right and sum==root.val:
        return True
    stack=[(root,root.val)]
    while stack:
        temp,val=stack.pop()
        if not temp.left and not temp.right and val==sum:
            return True
        if temp.left:
            stack.append((temp.left,val+temp.left.val))
        if temp.right:
            stack.append((temp.right,val+temp.right.val))
    return False
    
	   * */
	  
	  public static void main(String[] args) {
		  TreeNode root = new TreeNode(5);
		  root.left = new TreeNode(4);
		  root.right = new TreeNode(8);
		  root.left.left = new TreeNode(11);
		  root.left.left.left = new TreeNode(7);
		  root.left.left.left = new TreeNode(2);
		  root.right.left = new TreeNode(13);
		  root.right.right = new TreeNode(4);
		  root.right.right.right = new TreeNode(1);
		  
		  System.out.println(hasPathSum(root,22));
	  }
}
