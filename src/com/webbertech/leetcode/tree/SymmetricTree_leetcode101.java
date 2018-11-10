package com.webbertech.leetcode.tree;

import com.webbertech.leetcode.util.TreeNode;

/* Leetcode 101
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * 
 * */

public class SymmetricTree_leetcode101 {
	
	  //solution1: clear and efficient
	  public static boolean isSymmetric1(TreeNode root) {
	        return isMirror(root,root);
	  }
      
	  // solution2: whole chunk of code but every easy to understand
	  public static boolean isSymmetric2(TreeNode root) {
		  if (root == null) return true;
		  
		  if (root.left == null && root.right == null) {
			  return true;
		  } else if (root.left == null||root.right==null) {
			  return false;
		  }
		  
		  if (root.left.val!=root.right.val) {
			  return false;
		  }
		  
	        return isMirror(root.left,root.right);
	    }
	    
	  /* the core logic is here
	   1/ a or b is null, then check if they are both null, return true if they are all null,
	      or false only one of them is null.
	  
	  */
	  public static boolean isMirror(TreeNode a,TreeNode b){
		  //TODO rewrite this part, too confusing, but it make sense
	        return a==null||b==null?a==b:a.val==b.val&&
	        		isMirror(a.left,b.right)&&
	        		isMirror(a.right,b.left);
	  }
	  
	  public static void main(String[] args) {
		  TreeNode t = new TreeNode(1);
		  t.left = new TreeNode(2);
		  t.left.right = new TreeNode(3);
		  t.right = new TreeNode(2);
		  t.right.left = new TreeNode(3);
	
		  TreeNode t1 = new TreeNode(1);
		  t1.left = new TreeNode(2);
		  t1.left.right = new TreeNode(3);
		  t1.right = new TreeNode(2);
		  t1.right.left = new TreeNode(3);
		  
		  TreeNode t2 = new TreeNode(1);
		  t2.left = new TreeNode(2);
		  t2.left.right = new TreeNode(3);
		  t2.right = new TreeNode(2);
		  t2.right.right = new TreeNode(3);
		
		  //testing
		  System.out.println(isSymmetric1(t));   //true
		  System.out.println(isSymmetric1(t1));  //true
		  System.out.println(isSymmetric1(t2));  //false
		  
		  System.out.println("********");
		  System.out.println(isMirror(t2, null));
	  }
}
