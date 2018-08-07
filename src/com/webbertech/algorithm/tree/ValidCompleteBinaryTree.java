package com.webbertech.algorithm.tree;

/* A complete binary tree :
 * is a binary tree in which every level, except possibly the last,
 * is completely filled, which is filled from left to right.
 * */

public class ValidCompleteBinaryTree {
	
	/*use similar thing as level-order traversal and use queue
    //use a flag
    //Algorithm:
     *  Full node: a node has both left and right.
     	In the traversal, once a node is found which is NOT a Full Node, 
     	all the following nodes must be leaf nodes.
     	Also, one more thing needs to be checked to handle the below case: 
     	If a node has empty left child, then the right child must be empty.
    
    *
    * Test with:
    *
    *              1
  				  /   \
                 2     3
                        \
                         4
    *
    *              1
                 /   \
                2     3
               /
               4
               
      This implementation uses linklist, two good points:
      
      1/ linkedlist accepts null
      2/ linkedlist implements Queue
    */
    public static boolean isCompleteBinaryTree(TreeNode node) {
    	java.util.LinkedList<TreeNode> list = new java.util.LinkedList<>();
    	if(node == null) return false;
    	//add root		
    	list.addLast(node);
    	TreeNode curNode;
    	
    	/*list will add null, we use null pointer as 
    	 * an advantage here. 
    	 */
    	while((curNode = list.removeFirst()) != null) {
    	  list.addLast(curNode.left);
    	  list.addLast(curNode.right);
    	}
    	
    	/* At this point there should only be NULL values left in the list,
    	  if there is any non null node, it is not a complete binary tree
    	  for example: 1.left -> 2.left-> 3.left -> 4
    	  
    	  in the queue : 
    	   2 3
    	   3 N 4
    	   N 4 N N
    	   
    	   the second iteration, when list.removeFirst == 4, it return false.
        */
    	System.out.println(list.toString());
    	while (!list.isEmpty()) {
    	   if(list.removeFirst() != null) {
    		   return false;
    	   }	
    	}
    	
    	return true;
    }
    
    
    public static void main(String[] args) {
	
		TreeNode node= new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.right.left = new TreeNode(4);
		System.out.println(isCompleteBinaryTree(node));
		
		/*
		TreeNode node1= new TreeNode(1);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(3);
		node1.left.right = new TreeNode(4);
		System.out.println(isCompleteBinaryTree(node1));
		*/
		
		/*
		TreeNode node2= new TreeNode(1);
		node2.left = new TreeNode(2);
		node2.left.left = new TreeNode(3);
		node2.left.left.left = new TreeNode(4);
		System.out.println(isCompleteBinaryTree(node2));
		*/	
    }
}
