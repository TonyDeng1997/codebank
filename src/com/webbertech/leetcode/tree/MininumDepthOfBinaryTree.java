package com.webbertech.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

import com.webbertech.leetcode.util.TreeNode;

/*
 * Leetcode 111
 * Mininum Depth of Binary Tree.
 * 
 * Given a binary tree, find its minimum depth.

   The minimum depth is the number of nodes along 
   the shortest path from the root node down to the nearest leaf node.
   
   Need to check this out
 * */

public class MininumDepthOfBinaryTree {

	//solution 1
	public int minDepth(TreeNode root) {
	    return root == null ? 0 : (root.left == null && root.right == null) ? 1 : Math.min(minDepth(root.left, 2), minDepth(root.right, 2));
	}

	public int minDepth(TreeNode node, int min) {
	    return node == null ? Integer.MAX_VALUE : isLeaf(node) ? min : Math.min(minDepth(node.left, min + 1), minDepth(node.right, min + 1));
	}

	public boolean isLeaf(TreeNode node) {
	    return node.left == null && node.right == null;
	}
	
	//solution 2: use level order
	    public int minDepth2(TreeNode root) {
	        if(root==null)
	            return 0;
	        Deque<TreeNode> queue=new ArrayDeque<TreeNode>();
	        int depth=0;
	        queue.offer(root);
	        while(!queue.isEmpty()){
	            boolean flag=false;
	            depth++;
	            int len=queue.size();
	            int count=0;
	            while(count<len){
	                TreeNode p=queue.poll();
	                if(p.left!=null)
	                    queue.offer(p.left);
	                if(p.right!=null)
	                    queue.offer(p.right);
	                count++;
	                if(p.right==null&&p.left==null)
	                    flag=true;
	            }
	            if(flag==true)
	                break;

	        }
	        return depth;
	    }
	    
	  //solution 3
	    public int minDepth3(TreeNode root) {

	        if(root == null) return 0;

	        if(root.left != null && root.right != null){
	            return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
	        }else{
	            return Math.max(minDepth(root.left),minDepth(root.right)) + 1;
	        }

	    }

}
