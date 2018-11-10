package com.webbertech.leetcode.tree.path;

import com.webbertech.leetcode.util.TreeNode;

/*Leetcode 572 Subtree of another
 * 
 *  Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2

Given tree t:

   4 
  / \
 1   2

Return true, because t has the same structure and node values with a subtree of s.

Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0

Given tree t:

   4
  / \
 1   2

Return false. 
 * 
 * 
 * Solution: 
 * 
 * 1/ find the root of the subtree where it is equal to the value of another tree.
 * 2/ compare the root of the subtree is the same as the other tree
 * 
 * not accpeted by leetcode
 * */
public class SubtreeOfAnotherTree_leetcode572 {

	public static boolean isSubtree(TreeNode s, TreeNode t) {
        TreeNode subTree = findSubtreeRoot(s,t);
        if (subTree == null) {
            return false;
        }
        return isSameTree(subTree, t);
    }
    
    static TreeNode findSubtreeRoot(TreeNode s, TreeNode t) {
        // is tree is a subtree of itself
    	/*This logic has problem, because
    	 * [1,1], [1], subtree returns is [1,1] not [1].
    	 * 
    	 * */
    	if (t == s || t.val == s.val) {
            return s;
        }
    	
        TreeNode r=null;
        if (s.left!=null) {
            r= findSubtreeRoot(s.left, t);
            if (r!=null) {
              return r;
            }
        }
        
        if (s.right!=null) {
            r= findSubtreeRoot(s.right, t);
            if (r!=null) {
            	return r;
            }
        }
        
        // if t.left or t.right is null then return null
        return r;
  
    }
    
    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
	
    
    public static void main(String[] args) {
    	/* test1
    	TreeNode s = new TreeNode(3);
    	t.left = new TreeNode(4);
    	t.right = new TreeNode(5);
    	t.left.left = new TreeNode(1);
    	t.left.right = new TreeNode(2);
    	
    	TreeNode t = new TreeNode(4);
    	s.left = new TreeNode(1);
    	s.right = new TreeNode(2);
    	System.out.println(isSubtree(s,t));
    	*/
    	TreeNode s = new TreeNode(1);
    	s.left = new TreeNode(1);
    	
    	TreeNode t = new TreeNode(1);
    	System.out.println(isSubtree(s,t));
    }
}
