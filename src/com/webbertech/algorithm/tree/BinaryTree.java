package com.webbertech.algorithm.tree;

import java.util.ArrayList;

import com.webbertech.algorithm.linkedlist.LinkedList;

//Part IV
/* TODO: multiple trees algorithm
 *  Count inversions in an array | Set 2 (Using Self-Balancing BST)
    Print Common Nodes in Two Binary Search Trees
    Construct all possible BSTs for keys 1 to N
    K¡¯th smallest element in BST using O(1) Extra Space
    Count BST subtrees that lie in given range
    Count BST nodes that lie in a given range
    Data Structure for a single resource reservations
    How to handle duplicates in Binary Search Tree?
 */

public class BinaryTree {
   
	private TreeNode<Integer> root;
     
	BinaryTree() {
	}
	
	public TreeNode<Integer> getRoot() {
		return root;
	}
	

/* PartI
DFT, BFT (depth-first vs breadth-first)
	
          1
        /   \
      2       3
    /  \     /  \
   4    5   6    7
 /  \  
8    9

output:  pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7} and post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1}; 
*/
	
	//construct a tree from LevelOrder can be hard, how many possibilities?
	public void constructTree() {
       root = new TreeNode<Integer>(2,1,3);
       TreeNode<Integer> node1 = root.left.addLeft(4);
       node1.addLeft(8);
       node1.addRight(9);
       root.left.addRight(5);
       root.right.addLeft(6);
       root.right.addRight(7);
	}
	
	
	/*Part I*/
	public void PreOrderTraverse(TreeNode node) {
		//for recursion, it must handle leaves node
		if (node.left == null && node.right == null) {
			System.out.println(node.item);
		} else { //non leave node
			System.out.println(node.item);
	    	PreOrderTraverse(node.left);
	 	    PreOrderTraverse(node.right);
		}
	}
	
	
    public void InOrderTraverse(TreeNode node) {
    	if (node.left == null && node.right == null) {
			System.out.println(node.item);
		} else {
			InOrderTraverse(node.left);
			System.out.println(node.item);
			InOrderTraverse(node.right);
		}
	}
    
    
    public void PostOrderTraverse(TreeNode node) {
    	if (node.left == null && node.right == null) {
			System.out.println(node.item);
		} else {
    	
			PostOrderTraverse(node.left);
			PostOrderTraverse(node.right); 
			System.out.println(node.item);
		}
	}
    
    
    //pay attention to this solution
    //Breath first traverse: use queue to maintain, first add root node,
    // and then while loop through the queue as long as it is not empty, pull the first one,
    // at the meantime, add all its child node if any from left child to right child,
    // when pulling left child of root, its both children were pushed to the tail of the queue,
    // same for the right child of the root
    
   // private LinkedList LevelOrderArray = new LinkedList();
    private java.util.LinkedList StatusArray = new java.util.LinkedList();
    public void LevelOrderTraverse(TreeNode node) {
    	if (node != null) {
    		StatusArray.add(node);
    	}
    	
    	while (! StatusArray.isEmpty()) {
    	  TreeNode removedNode = (TreeNode)StatusArray.removeFirst();
    	  System.out.print("\t" + removedNode.item);
    	   
    	  if(removedNode.left != null) {
    		  StatusArray.addLast(removedNode.left);
    	  }
    	  
    	  if(removedNode.right != null) {
    		  StatusArray.addLast(removedNode.right);
    	  }
    	}
    }
	
    
    
   /*Part II
      TODO: binary tree construction
    Construct a binary tree from preoder
    ref: http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
    http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversal-set-2/
    http://algorithms.tutorialhorizon.com/construct-binary-search-tree-from-a-given-preorder-traversal-using-recursion/
   */
    

  //Part III
  /*TODO: see data structure cheatsheet, Binary Tree construction(Unique)
   * How to construct a binary tree using:
   * PreOrder, InOrder, PostOrder, and LevelOrder 
   * PreOrder - 8, 5, 9, 7, 1, 12, 2, 4, 11, 3
     InOrder - 9, 5, 1, 7, 2, 12, 8, 4, 3, 11
     PostOrder - 9, 1, 2, 12, 7, 5, 3, 11, 4, 8
     LevelOrder - 8, 5, 4, 9, 7, 11, 1, 12, 3, 2
  */

    public TreeNode buildBinaryTreeFromPrePostOrder(int[] pre, int[] post) {
    	
    	return null;
    }
    
    public TreeNode buildBinaryTreeFromInPreOrder(int[] in, int[] pre) {
    	return null;
    }
    
    public TreeNode buildBinaryTreeFromInPostOrder(int[] in, int[] post) {
    	return null;
    }
    
    public TreeNode buildBinaryTreeFromInLevelOrder(int[] in, int[] level) {
    	return null;
    }
    
    
    
 
    
    
    
    
        
	public static void main(String[] args) {
		BinaryTree b= new BinaryTree();
		
		b.constructTree();
		
		//testing true is fine
		//System.out.println(b.getRoot().left.left.item);
		
		//testing tree traversal
		
		System.out.println("testing PreOrder");
		b.PreOrderTraverse(b.getRoot());
		
		System.out.println("testing InOrder");
		b.InOrderTraverse(b.getRoot());
		
		System.out.println("testing PostOrder");
		b.PostOrderTraverse(b.getRoot());
	
		System.out.println("testing LevelOrder");
		b.LevelOrderTraverse(b.getRoot());
		
		System.out.println();
		
	
		

	
	}
	
}

