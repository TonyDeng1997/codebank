package com.webbertech.leetcode.tree.bst;

import java.util.ArrayList;

import com.webbertech.leetcode.util.ListNode;
import com.webbertech.leetcode.util.TreeNode;

/*Leetcode 109
 * See class name.
 * 
 * Given a singly linked list where elements are sorted in 
 * ascending order, convert it to a height balanced BST.
 * 
 * Solution: 
 * 
 * Convert it to list, and then do it recursively so it is
 * O(n).
 * 
 * Leetcode accepted.
 * */
public class ConstructBalancedBSTFromSortedLinklist_leetcode109 {

	  public static TreeNode sortedListToBST(ListNode head) {
	        if (head == null)  return null;
	        ListNode cur = head;
	        ArrayList<Integer> list = new ArrayList<>();
	        while(cur!=null) {
	        	list.add(cur.val);
	        	cur=cur.next;
	        }
	        int[] a= new int[list.size()];
	        for(int i=0;i<list.size();i++) {
	        	a[i] = list.get(i);
	        }
	        TreeNode root = sortedListToBST(a, 0, a.length-1);
	        return root;
	  }
	  
	  // need to consider if [0] case.
	 static  TreeNode sortedListToBST(int[] a, int low, int high) {
		  if (low > high) { // Done
				return null;
		  }
		  int mid= (low+high)/2;
		  TreeNode root = new TreeNode(a[mid]);
		
		  root.left = sortedListToBST(a, low, mid-1);
		  root.right = sortedListToBST(a, mid+1, high);
		  return root;
	  }
	  
	  public static void main(String[] args) {
		  ListNode list = new ListNode(0);
		  TreeNode root = sortedListToBST(list);
	  }
}