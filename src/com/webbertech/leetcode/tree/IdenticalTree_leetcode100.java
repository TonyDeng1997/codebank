package com.webbertech.leetcode.tree;
//leetcode 100

import com.webbertech.leetcode.util.TreeNode;

public class IdenticalTree_leetcode100 {
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q == null) return true;
        if (p==null||q==null) return false;
        
        if(p.val!=q.val) return false;
        
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(4);
		System.out.println(isSameTree(t1,t2));
		
	}
}
