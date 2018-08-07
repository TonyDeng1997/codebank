package com.webbertech.leetcode.tree.traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.webbertech.leetcode.util.TreeNode;

/*
 * Leetcode 199 Get the right view of the tree and return in a list.
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.

	For example:
	Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

You should return [1, 3, 4].

            1
           / \
          2   3
         / \
        4   5
       / \ 
      6   7
           \
            8
            

solution 1:
level order traversal, use List<List<Integer>>, get the last element of each level's list. 

solution2 : 
using recursion
**/

public class BinaryTreeRightSideView_leetcode199 {
	 
	public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                //this if is the only thing different than a normal level order traversal
                if (i == size - 1) {
                    //last element in current level
                    result.add(node.val);
                }
                
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
	
	public static List<Integer> rightSideViewII(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public static void rightView(TreeNode curr, List<Integer> result, int currDepth){
        //initial condition is very important to return
    	if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        //first do right to include all the elements from right view, 
        rightView(curr.right, result, currDepth + 1);
        //in case right does not have a right most node, but left had, then the following will have it. [1,2,3,null,5]
        rightView(curr.left, result, currDepth + 1);
    }
	   
	 public static void main(String[] args) {
		 /* use array list a queue
		 ArrayList<Integer> list = new ArrayList<>();
		 list.add(1);
		 list.add(2);
		 list.add(3);
		 list.add(4);
         System.out.println(list.remove(0));
         System.out.println(list.remove(0));
         */
		 //testing 1
		 /*
		 TreeNode root = new TreeNode(1);
		 root.left = new TreeNode(2);
		 List<Integer> list = rightSideView(root);
		 */                       
		 //test2
		 TreeNode root = new TreeNode(1);
		 root.left = new TreeNode(2);
		 root.left.right = new TreeNode(5);
		 root.right = new TreeNode(3);
		// root.right.right = new TreeNode(6);
		 List<Integer> list = rightSideViewII(root);
		 
		 
		 //test3
		 /*
		 Input:
			 [1,2,3,null,null,4]
		 Output:
			 [1,3]
		 Expected:
			 [1,3,4]
		 */
		 
		 /*test4
		 root = new TreeNode(1);
		 root.left = new TreeNode(2);
		 root.right = new TreeNode(3);
		 root.right.right = new TreeNode(4);
		 list = rightSideView(root);
		 */
		 for(int i: list) {
			 System.out.println(i);
		 }
	 }
}
