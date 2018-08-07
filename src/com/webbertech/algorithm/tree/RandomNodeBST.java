package com.webbertech.algorithm.tree;

import java.util.Random;

/*In a BST class, 
 * implement a method getRandomNode and return a node with 
 * equal possibility.
  Two points in this question, first it is a tree, 
  so don't introduce array idea to keep track of the stuff. 
  Also to keep equal possibility, the left subtree and 
  right subtree's odd should be the same,
  which is: LEFT_SIZE * 1/n, RIGHT_SIZE * 1/n.
  We can store a size variable in each node.
  
  Pay attention to this code: Need to revisit
*/

public class RandomNodeBST {
        
	     class TreeNode {
        	private int data;
        	public TreeNode left;
        	public TreeNode right;
        	public int size = 0;
        	
        	public TreeNode(int d) {
        		this.data = d;
        		size++;
        	}
        
        	
        	public int data () {
            	return data;
            }
       
        	public int size() {
        	   return size;	
        	}
        	
        	//this is tricky, pay attention to here
        	public TreeNode getIthNode(int i) {
        		int leftSize = this.left == null ? 0: left.size();
        		
        		if (i < leftSize) {
        			return left.getIthNode(i);
        		} else if (i == leftSize) {
        			return this;
        		} else {
        			return right.getIthNode(i- (leftSize + 1));
        		}
        	}
        	
        	public TreeNode find(int d) {
        		if (d== data) {
        			return this;
        		} else if (d<= data) {
        			return left != null ? left.find(d): null;
        		} else if (d>data) {
        			return right != null ? right.find(d): null;
        		}
        		return null;
        	}
        	
        	public void insertInOrder(int d) {
        		 if (d <= this.data) {
        			 if (this.left == null) {
        				 this.left = new TreeNode(d);
        			 } else {
        				 this.left.insertInOrder(d);
        			 }
        		 } else if (d > this.data) {
        			 if (this.right == null) {
        				 this.right = new TreeNode(d);
        			 } else {
        				 this.right.insertInOrder(d);
        			 }
        		 }
        		 size ++;
        	}
        	
        }
        
	 	
     	public int size () {
         	return (root ==null ) ? 0: root.size;
        }

     	public TreeNode getRandomNode() {
     		if (root == null) {
     			return null;
     		} 
     		
     		Random random = new Random();
     		int i = random.nextInt(size());
     		return root.getIthNode(i);
     	}
     	
        private TreeNode root;
        
        public void setRoot(TreeNode root) {
           	this.root = root;
        }
        
        public TreeNode getRoot() {
        	return root;
        }
        
        public void insertInOrder(int value) {
        	if (root == null) {
        		root = new TreeNode(value);
        	} else {
        		root.insertInOrder(value);
        	}
        }
        
        public static void main(String[] args) {
        	
        	/*
        	 *       20
        	 *      / \
        	 *     10  30
        	 *    / \  
        	 *   5    15 
        	 *  / \    / \
        	 *  3  7   14  17
        	 * */
        	
        	//did not use static inner class, just playful with inner class
        	RandomNodeBST tree= new RandomNodeBST();
        	RandomNodeBST.TreeNode root =  tree.new TreeNode(20);
        	tree.setRoot(root);
        	tree.insertInOrder(10);
        	
        	
        	/*
        	tree.insertInOrder(root, 20);
        	tree.insertInOrder(root, 10);
        	tree.insertInOrder(root, 30);
        	tree.insertInOrder(root, 5);
        	tree.insertInOrder(root, 3);
        	tree.insertInOrder(root, 7);
        	tree.insertInOrder(root, 15);
        	tree.insertInOrder(root, 14);
        	tree.insertInOrder(root, 17);
        	tree.insertInOrder(root, 35);
        	System.out.println(tree.find(root, 35).data);
         	System.out.println(tree.find(root, 20).data);
         	System.out.println(tree.find(root, 17).data);
         	System.out.println(tree.find(root, 18));
         	
         	System.out.println(root.size());
        	*/
        	
        	//tree.delete(root, 35);
        }
        
        
}
