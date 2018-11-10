package com.webbertech.leetcode.tree.path;

import java.util.ArrayList;
import java.util.List;

import com.webbertech.leetcode.util.TreeNode;

/*  Leetcode 129 Sum root to leaf
 *   If paths are like 1->2, 1->3, then
 *   it is sum = 12+13 == 25.
 *   
 *   Solution: 
 *   
 *   Similar to leetcode 257 where ues a string to store a path.
 *   Then use a list of String to store all the path.
 *   Since the path is in order, don't have to reverse it.
 *   So use Integer.valueOf(string) to convert to integer,
 *   and iterate the list of string to add them up.
 * 
 * 
 * Accepted by leetcode. 
 * */
public class SumRootToLeaf_leetcode129 {
	 public int sumNumbers(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        List<String> list = new ArrayList<>();
	        String s = String.valueOf(root.val);
	        sumNumbers(list, root, s);
	        int sum =0;
	        for(String str: list) {
	            sum+=  Integer.valueOf(str);
	        }
	        return sum;
	    }
	    
	    void sumNumbers(List<String> list, TreeNode node, String s) {
	        // when it is a full path
	    	if (node.left == null && node.right == null) {
	            list.add(s);
	            return;
	        }
	    	// simple recursion
	        if (node.left!=null) {
	            sumNumbers(list, node.left, s+String.valueOf(node.left.val));
	        }
	        if (node.right!=null) {
	            sumNumbers(list, node.right, s+String.valueOf(node.right.val));
	        }
	    }
}
