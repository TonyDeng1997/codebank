package com.webbertech.leetcode.tree.bst;

import static com.webbertech.leetcode.tree.bst.TreePathFromRootToNode.findPath;
import static com.webbertech.leetcode.tree.bst.lca_bst_leetcode235.lowestCommonAncestor;

import java.util.ArrayList;
import java.util.List;
import com.webbertech.leetcode.util.TreeNode;

/*AmazonOA questions
 * Given [7,4,2,5,3,8], get distance between 4 and 8. 
 * The head is 7, 5 is the right child of 4. 
 * So from 4 to 9, the distance is 2.
 * 
 * 
 * Solution: don't think you can sort the array and return the distance between two nodes.
 * That is wrong.
 * 
 * The generic solution is to use the formula: distance = distanceRootToP1 + distanceRootToP2 - 2*distanceRootToLCA.
 * 
 * 1/ Construct BST (recursion)
 * 2/ Get distance from root to node (recursion)
 * 3/ Step two use array list, so that we can get distance.
 * 4/ get lca of two nodes of bst (recursion).
 * 5/ use step two to get distance from root to lca (recursion)
 * 6/ use the formula to return the distance
 * */

public class DistanceOfTwoNodeInBST {
	static int distance(TreeNode root, int p, int q) {
    	List<Integer> listP = new ArrayList<>();
    	List<Integer> listQ = new ArrayList<>();
    	boolean findP = findPath(root, listP , p);
    	boolean findQ = findPath(root, listQ, q);
    	int distance = 0;
    	if (findP && findQ) { // both node exists and were found
    		TreeNode lca = lowestCommonAncestor(root, new TreeNode(p), new TreeNode(q));
    		List<Integer> listLca = new ArrayList<>();
    		if (findPath(root, listLca, lca.val)) {
    			distance  =listP.size()+listQ.size() - 2* listLca.size();
    		} 
    	}
    	return distance;
    }
    
	//construct bst
	static TreeNode constructBST(TreeNode root, int n) {
		if (root == null ) return null;
		if (n < root.val) {
			if (root.left == null) {
				root.left = new TreeNode(n);
			}
			else {
				 constructBST(root.left, n);
			}
		}
		if (n> root.val) {
			if (root.right == null) {
				root.right = new TreeNode(n);
			} else {
				 constructBST(root.right, n);
			}
		}
		return root;
	}
	
    public static void main(String[] args) {
		   // Let us create the Binary search tree shown in above diagram.
	    int[] a = {7,4,2,5,3,8};
	    TreeNode root = new TreeNode(a[0]);
	    for(int i=1;i<a.length;i++) {
	    	root = constructBST(root, a[i]);
	    }
	    
    	System.out.println(distance(root, 4,8)); 
	    System.out.println(distance(root, 5, 3)); 
	}
}