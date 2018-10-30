package com.webbertech.leetcode.tree.bst;

/*
 * Find the distance between root to any node
 * ref: http://algorithms.tutorialhorizon.com/find-the-distance-from-root-to-given-node-of-a-binary-tree/
 * */
public class FindDistanceFromRootToNode {

	/*
	 * pay attention to the logic
	 * 
	 * */
	public int Pathlength(Node root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0
					|| (x = Pathlength(root.right, n1)) > 0) {
				return x + 1;
			}
			return 0;  // if did not find the node in left or right subtree, then return 0
		}
		return 0; //if root is null return 0;
	}

	public static void main(String[] args) throws java.lang.Exception {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.right.right = new Node(45);
		FindDistanceFromRootToNode i = new FindDistanceFromRootToNode();
		System.out.println("Distance from root to 45 is : "
				+ (i.Pathlength(root, 45)-1));                //should output 3
		
		System.out.println("Distance from root to 5 is : "
				+ (i.Pathlength(root, 5)-1));                //should output 3
	}
}