package com.webbertech.algorithm.tree;

public class MaxTreeDepth {
	/*
     * The depth of a binary tree can be gotten in another way. 
     * If a binary tree has only one node, its depth is 1. 
     * If the root node of a binary tree has only a left subtree, its depth is the depth of the left subtree plus 1. 
     * Similarly, its depth is the depth of the right subtree plus 1 if the root node has only a right subtree. 
     * What is the depth if the root node has both left subtree and right subtree? 
     * It is the greater value of the depth of the left and right subtrees plus 1.
       Note: this algorithm works for any binary tree. 
       ref: 
       http://codercareer.blogspot.com/2013/01/no-35-depth-of-binary-trees.html
       http://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
       
        maxDepth()
      1. If tree is empty then return 0
      2. Else
         if a node has no left and right, then it is depth is 1.
     (a) Get the max depth of left subtree recursively  i.e., 
          call maxDepth( tree->left-subtree)
     (a) Get the max depth of right subtree recursively  i.e., 
          call maxDepth( tree->right-subtree)
     (c) Get the max of max depths of left and right 
          subtrees and add 1 to it for the current node.
         max_depth = max(max dept of left subtree,  
                             max depth of right subtree) 
                             + 1
     (d) Return max_depth
     
     eg, 
           1
          / \
         2   3
        / \
       4   5
       
        maxDepth('1') = max(maxDepth('2'), maxDepth('3')) + 1
                               = 2 + 1
                                  /    \
                                /         \
                              /             \
                            /                 \
                          /                     \
               maxDepth('1')                  maxDepth('3') = 1
    = max(maxDepth('4'), maxDepth('5')) + 1
      = 1 + 1   = 2         
                   /    \
                 /        \
               /            \
             /                \
           /                    \
      maxDepth('4') = 1     maxDepth('5') = 1
       
       
     * */
    public static int maxDepth(TreeNode node) {
        if (node == null) return 0;
        else {
          
        	//comment out the following, because the 
        	//leave node's left and right are null, so return 0, thus
        	//leave node's depth is always 1.
        	//if (node.left == null && node.right ==null) {
          //	  return 1;
          //} else {
        	
        	  int leftDepth = maxDepth(node.left);
        	  int rightDepth = maxDepth(node.right);
        	  return Math.max(leftDepth, rightDepth)+1;
         // }	
        }
    }
    
    public static void main(String[] args) {
    	System.out.println("getting the depth of the tree");
    	BinaryTree b= new BinaryTree();
		
		b.constructTree();
		System.out.println(maxDepth(b.getRoot()));
    }
}
