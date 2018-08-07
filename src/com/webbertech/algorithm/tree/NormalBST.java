package com.webbertech.algorithm.tree;

public class NormalBST {
	
	   /* 
     * These two methods are working fine, try to write another generic BST and copy this
    //first time call, the node should be root
    public void insertInOrder(TreeNode node, int d) {
    	TreeNode newNode = new TreeNode(d);
    	
    	if (node.data == Integer.MIN_VALUE) {
    		node.data = d;
    		return;
    	}
    	
    	if (d > node.data) {
    		if (node.right == null) {
    			node.right = newNode;
    		} else {
    			node = node.right;
    			insertInOrder(node, d);
    		}
    	
    	} else if (d <= node.data) {
    		if (node.left == null ) {
    			node.left = newNode;
    		} else {
    			node = node.left;
    			insertInOrder(node, d);
    			
    		}
    	
    	}
    
    }
    
    
    
    //pay attention to this method
    public TreeNode find(TreeNode node, int d) {
    	if (d == node.data) {
    		return node;
    	} else if (d <= node.data) {
    		return node.left != null ? find(node.left, d) : null;
    	} else if (d > node.data) {
    		return node.right != null? find(node.right,d) : null;
    	} 
    	return null;
    }
    
    
    //TODO: test this, never tested this is right or wrong
    public void delete(TreeNode node, int d) {
    	if (node ==null) return;
    	
    	if (find(node,d) == null) return;
    	
    	if (d == node.data)
    		node = null;
    	
    	while (d!= node.data ) {
    		if (node.left !=null && d!= node.left.data) {
    			node = node.left;
    		} else if (node.right != null && d!=node.right.data){
    			node = node.right;
    		}
    	}
    	
         if (d== node.left.data) {
        	 TreeNode toBeRemoved = node.left;
        	 if (node.left.right != null && node.left.left !=null) {
        		 node.left = node.left.right; //for example removed the 10 from the above tree
        	    node.left.left = toBeRemoved.left;
        	 } else if (node.left.right!=null && node.left.left ==null) {
        		 node.left = node.left.right; //for example removed the 10 from the above tree
        	 } else if (node.left.right == null) {
        		 node.left = node.left.left;
        	 }
         }
    	
         if (d== node.right.data) {
        	 TreeNode toBeRemoved = node.left;
        	 if (node.left.right != null && node.left.left == null) {
        		 node.left = node.left.right; //for example removed the 10 from the above tree
             } else if (node.left.right != null && node.left.left != null){
            	 node.right = node.right.left;
             } else {
            	 node.right = null;
             }
        		 node.left.left = toBeRemoved.left;
         }
    }
    */
	
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
