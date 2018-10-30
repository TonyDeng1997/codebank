package com.webbertech.leetcode.tree;

import com.webbertech.leetcode.util.TreeNode;
import java.util.*;
/*
 * Leetcode 572 subtree of another tree, check if t is the subtree of s.
 * 
 * Solution1: simple recursion, basically need to use isSameTree method to check if s and t are the same tree and
 * s.left and t are the sub tree or s.right and t are the sub tree(not same tree).
 * 
 * Accepted by leetcode.
 * 
 * Solution2: using a iterative way. Accepted by leetcode.
 * */

public class Subtree_leetcode572 {
	public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        
        if (isSameTree(s,t)) {
            return true;
        }
        
        // note here it is not isSameTree, it is to check if it is t is s.left or s.right 's subtree.
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
	
	// solution2
	public static boolean isSubtree2(TreeNode s, TreeNode t) {
	    Queue<TreeNode> nodes = new ArrayDeque<>();
	    //add the root first, the queue is going to iterate through s, 
	    // the larger tree
	    nodes.offer(s);
	    // The following is a standard technique in level traversal
	    while (!nodes.isEmpty()) {
	    	// poll is like pull the head
	        TreeNode node = nodes.poll();
	        if (isSameTree(node, t)) {
	            return true;
	        }
	        if (node.left != null) {
	            nodes.offer(node.left);
	        }
	        if (node.right != null) {
	            nodes.offer(node.right);
	        }
	    }
	    return false;
	}
    
    public static boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val!=t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
    
    // solution3: less ideal using preorder
    public static boolean isSubtree3(TreeNode s, TreeNode t) {
    	// Java uses a naive contains algorithm so to ensure linear time, 
        // replace with KMP algorithm
    	return serialize(s).contains(serialize(t)); 
    }

    public static String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serialize(root, res);
        return res.toString();
    }

    private static void serialize(TreeNode cur, StringBuilder res) {
        if (cur == null) {
        	res.append(",#"); 
        	return;
        }
        res.append("," + cur.val);
        serialize(cur.left, res);
        serialize(cur.right, res);
    }
    
    // This method is used to analyze the algorithm
    
    public static String inorder_serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        inorder_serialize(root, res);
        return res.toString();
    }
    
    private static void inorder_serialize(TreeNode cur, StringBuilder res) {
        if (cur == null) {
        	res.append(",#"); 
        	return;
        }
        inorder_serialize(cur.left, res);
        res.append("," + cur.val);
        inorder_serialize(cur.right, res);
    }
    
    // This method is used to analyze the algorithm
    public static String postorder_serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        postorder_serialize(root, res);
        return res.toString();
    }
    
    private static void postorder_serialize(TreeNode cur, StringBuilder res) {
        if (cur == null) {
        	res.append(",#"); 
        	return;
        }
        postorder_serialize(cur.left, res);
        postorder_serialize(cur.right, res);
        res.append("," + cur.val);
    }
    
    
    //solution4 preorder but uses string, least ideal
    public static boolean isSubtree4(TreeNode s, TreeNode t) {
        String spreorder = generatepreorderString(s); 
        String tpreorder = generatepreorderString(t);
        return spreorder.contains(tpreorder) ;
    }
    
    public static String generatepreorderString(TreeNode s){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stacktree = new Stack();
        stacktree.push(s);
        while(!stacktree.isEmpty()){
           TreeNode popelem = stacktree.pop();
           if(popelem==null)
              sb.append(",#"); // Appending # inorder to handle same values but not subtree cases
           else      
              sb.append(","+popelem.val);
           if(popelem!=null){
                stacktree.push(popelem.right);    
                stacktree.push(popelem.left);  
           }
        }
        return sb.toString();
    }
    
    
    /* Test out how preorder works.
     * */
    public static void main(String[] args) {
      TreeNode s = new TreeNode(3);
      s.left = new TreeNode(4);
      s.right = new TreeNode(5);
      s.left.left = new TreeNode(1);
      s.left.right = new TreeNode(2);
      s.left.right.left = new TreeNode(6);
      
      TreeNode t = new TreeNode(4);
      t.left = new TreeNode(1);
      t.right = new TreeNode(2);
      
      //The above two trees are not subtree relation
      System.out.println("testing out four implementations");
      System.out.println(isSubtree(s,t));     //return false
      System.out.println(isSubtree2(s,t));    //return false;
      System.out.println(isSubtree3(s,t));    //return false;
      System.out.println(isSubtree4(s,t));    //return false;
      System.out.println();
      //All above imples is to say preorder works
      
      //Test out generatepreorderString to see how impl4 works
      System.out.println("testing out impl4");
      System.out.println(generatepreorderString(s));
      System.out.println(generatepreorderString(t));
      System.out.println();
      
      //Test out how impl3 works, similar to above methods
      System.out.println("testing out impl3");
      System.out.println(serialize(s));
      System.out.println(serialize(t));
      System.out.println();
      
      //The following is a good tree, should return true
      TreeNode s1 = new TreeNode(3);
      s1.left = new TreeNode(4);
      s1.right = new TreeNode(5);
      s1.left.left = new TreeNode(1);
      s1.left.right = new TreeNode(2);
      System.out.println("testing out impl3 on a good tree with subtree");
      System.out.println(isSubtree3(s1,t));    //return true;
      
      System.out.println("========subtree============");
      System.out.println("preorder serialization");
      System.out.println(serialize(s1));
      System.out.println(serialize(t));
      System.out.println();
      
      System.out.println("inorder serialization");
      System.out.println(inorder_serialize(s1));
      System.out.println(inorder_serialize(t));
      System.out.println();
      
      System.out.println("postorder serialization");
      System.out.println(postorder_serialize(s1));
      System.out.println(postorder_serialize(t));
      System.out.println();
      System.out.println("====================");
      
      System.out.println("========non subtree============");
      System.out.println("preorder serialization");
      System.out.println(serialize(s));
      System.out.println(serialize(t));
      System.out.println();
      
      System.out.println("inorder serialization");
      System.out.println(inorder_serialize(s));
      System.out.println(inorder_serialize(t));
      System.out.println();
      
      System.out.println("postorder serialization");
      System.out.println(postorder_serialize(s));
      System.out.println(postorder_serialize(t));
      System.out.println();
      System.out.println("====================");
      
      System.out.println("========postorder fails to check subtree============");
       s = new TreeNode(12);
       t = new TreeNode(1);
      System.out.println(postorder_serialize(s));
      System.out.println(postorder_serialize(t));
      
      System.out.println("========inorder fails to check subtree============");
      s = new TreeNode(3);
      s.left = new TreeNode(4);
      s.right = new TreeNode(5);
      s.left.left = new TreeNode(1);
      s.left.right = new TreeNode(2);
      s.left.left.left = new TreeNode(0);
      t = new TreeNode(4);
      t.left = new TreeNode(1);
      t.right = new TreeNode(2);
      System.out.println(inorder_serialize(s));
      System.out.println(inorder_serialize(t));
    }
}