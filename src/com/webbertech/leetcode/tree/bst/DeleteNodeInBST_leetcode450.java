package com.webbertech.leetcode.tree.bst;
import com.webbertech.leetcode.util.TreeNode;
/*
 * Leetcode 450
 * 
 * Given a root node reference of a BST and a key, 
 * delete the node with the given key in the BST. 
 * Return the root node reference (possibly updated) 
 * of the BST.

Basically, the deletion can be divided into two stages:
    Search for a node to remove.
    If the node is found, delete the node.

Note: Time complexity should be O(height of tree).
Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node 
with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown 
in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
 * */
/*
 * solution: 
 * 
 * recursion works like this, think of the root is the node that is going to be delete.
 * 
 * deletion can be three cases:
 * 
 * 1/ left node, just delete it.
 * 
 * 2/ root has single child, return the other child.
 * 
 * 3/ root has two children, and delete the root, and find the smallest element of
 *   root's right subtree which is root.right's left most leaf.
 * 
 * */

public class DeleteNodeInBST_leetcode450 {
	
	// this method delete the node with value of key, and return the root node.
	public static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}

		// not finding the node to be deleted, do the recursion
		if (root.val > key) {
			root.left= deleteNode(root.left, key); // return the root node after delete the key node
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		}

		// root equals to key
		else {
			 // node with only one child or no child
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			/*
		          50                            60
	           /     \         delete(50)      /   \
	          40      70       --------->    40    70 
	                 /  \                            \ 
	                60   80                           80
            */
			
			// root node equals to key but with two children:
			// get the inorder successor, smallest in the right subtree
			root.val = minValue(root.right);  //set root's value to 60

			/* Delete the inorder successor which is 60 in the right subtree.
			 * pass 70 as the root, and set the 60 as the sec argument to remove 
			 * 60 from the right subtree.
			*/
			root.right = deleteNode(root.right, root.val);
		}
		return root;
	}

	static int minValue(TreeNode root) {
		int minv = root.val;
		while (root.left != null) {
			minv = root.left.val;
			root = root.left;
		}
		return minv;
	}

	//http://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
	public static void main(String[] args) {
		TreeNode tree = new TreeNode();
		/*
		 * Let us create following BST 50 / \ 30 70 / \ / \ 20 40 60 80
		 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		System.out.println("Inorder traversal of the given tree");
		TreeNode root = tree.getRoot();
		tree.inorder(root);
		System.out.println("\nDelete 20");
		deleteNode(root, 20);
		System.out.println("Inorder traversal of the modified tree");
		TreeNode.inorder(tree.getRoot());
		System.out.println("\nDelete 30");
		deleteNode(tree.getRoot(), 30);
		System.out.println("Inorder traversal of the modified tree");
		tree.inorder(tree.getRoot());
		System.out.println("\nDelete 50");
		deleteNode(tree.getRoot(), 50);
		System.out.println("Inorder traversal of the modified tree");
		tree.inorder(tree.getRoot());
		/*
		 * Output:
		 * 
		 * Inorder traversal of the given tree 20 30 40 50 60 70 80 
		 * Delete 20
		 * Inorder traversal of the modified tree 30 40 50 60 70 80 
		 * Delete 30
		 * Inorder traversal of the modified tree 40 50 60 70 80 
		 * Delete 50
		 * Inorder traversal of the modified tree 40 60 70 80
		 */
	}
}