package com.webbertech.leetcode.tree.bst;

import com.webbertech.leetcode.util.TreeNode;

/* 235. Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: The lowest common ancestor is defined between two nodes 
v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself) ?

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
since a node can be a descendant of itself according to the LCA definition.
 * 
 * 
 * solution: recursion should work.
 * 
 * If root is null, return null.
 * If both are smaller than root, then recursively call func(root.left, p, q)
 * If both are larger than root, then recursively call func(root.right, p, q)
 * If by any chance root is the same as one of the nodes p or q, return root

* Accepted by leetcode.
*/

public class lca_bst_leetcode235 {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
        	return null;
        }
        if (root.val> p.val && root.val>q.val) {
           return lowestCommonAncestor(root.left, p, q);
        } 
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        return root;
    }
}
