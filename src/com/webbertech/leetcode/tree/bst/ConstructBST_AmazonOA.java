package com.webbertech.leetcode.tree.bst;

/*This is an amazon OA question:
 * Given an array of {5,6,3,1,2,4}, and construct a bst.
 * Given two nodes value in the above list, and calculate their path distance.
 * 
 * 
 * solution:
 * 
 * given a tree [5, 10,15, 20,25,30,35, null, null, null, 45]
 *  distance of (20,45) = 3,
 *  distance of (30,35) = 2;
 *  distance of (20,35) = 4;
 * 
 * Approach:

Distance(X, Y) = Distance(root, X) +Distance(root, Y) - 2*(Distance(root to LCA(X,Y)
where LCA(X,Y) = Lowest Common Ancestor of X,Y
In the above exam­ple if Distance(20,45) = 3
Distance(root, 20) = 2
Distance(root, 45) = 3
LCA(20, 45) = 10
Distance(root, 10) = 1
Distance(20,45) = 2+3 — 2*1 = 3

 * */

class Node {
	Node left;
	Node right;
	int data;
	Node(int data) {
		this.data = data;
	}
}

public class ConstructBST_AmazonOA {
	// Find distance from n1 and n2	
	static public int findDistance(Node root, int n1, int n2) {
		int x = Pathlength(root, n1) - 1;
		int y = Pathlength(root, n2) - 1;
		int lcaData = findLCA(root, n1, n2).data;
		int lcaDistance = Pathlength(root, lcaData) - 1;
		return (x + y) - 2 * lcaDistance;
	}

	// Length from root to node n1
	static public int Pathlength(Node root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0
					|| (x = Pathlength(root.right, n1)) > 0) {
				// System.out.println(root.data);
				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	// Find least common ansestor of  n1 and n2
	// this is not the optimal for bst, this is for general bt.
	static public Node findLCA(Node root, int n1, int n2) {
		if (root != null) {
			if (root.data == n1 || root.data == n2) {
				return root;
			}
			Node left = findLCA(root.left, n1, n2);
			Node right = findLCA(root.right, n1, n2);

			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			}
			if (right != null) {
				return right;
			}
		}
		return null;
	}
	
	 // Recursively construct bst 
	 static Node constructBST(Node node, int num) {
		if (node.data>num) {
			if (node.left == null) {
				node.left = new Node(num);
			} else {
				node.left = constructBST(node.left, num);
			}
		
		} else {
			if (node.right == null) {
				node.right = new Node(num);
			} else {
				node.right = constructBST(node.right, num);
			}
		}
		return node;
	}
	
	public static int bstDistance(int[] values, int n, int node1, int node2) {
		// WRITE YOUR CODE HERE
		
		//init params check
		if (n == 0) {
			return 0;
		}
		
		boolean flag = false;
		for (int i: values) {
			if (i==node1) { 
				flag= true;
			  break;
			}
		}
		if (flag == false) 
			return -1;
		
		flag = false;
		for (int i: values) {
			if (i==node2) { 
				flag= true;
			  break;
			}
		}
		if (flag == false) {
			return -1;
		}
		
		Node root = null;
		root = new Node(values[0]);
		// Construct bst
		for(int i=1;i<n; i++) {
			root = constructBST(root, values[i]);
		}
		// Find distance
		int distance = findDistance(root, node1, node2);
		return distance;
	}
	
	public static void main(String[] args) {
		int[] values ={5,6,3,1,2,4};
		int s = bstDistance(values, 6, 2,4);
		System.out.println(s);
		
		int[] values1 = {9,7,5,3,1};
		int s1 = bstDistance(values1, 5, 7,20);
		System.out.println(s1);
	}
}
