package com.webbertech.leetcode.tree.traverse;
import java.util.ArrayList;
import java.util.List;
import com.webbertech.leetcode.util.TreeNode;

/*144. Binary Tree Preorder Traversal 
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

**/

public class PreOrderTraversal_leetcode144 {
	  public List<Integer> preorderTraversal(TreeNode root) {
	        List<Integer> list = new ArrayList<>();
	        if (root == null) {
	            return list;
	        }
	       return preorder(root,list);
	    }
	    
	    public List<Integer> preorder(TreeNode node, List<Integer> list) {
	        list.add(node.val);
	        if (node.left!=null) {
	            list = preorder(node.left, list); 
	        } 
	        if (node.right!=null) {
	            list = preorder(node.right, list);
	        }
	        return list;
	    }
}
