package com.webbertech.leetcode.linklist;

import com.webbertech.leetcode.util.ListNode;

/*
 * Leetcode 21
 *  Merge two sorted linked lists and return it as a new list.
 *  The new list should be made by splicing together the nodes of the first two lists.
 * 
 * This passed.
 * */
public class MergedTwoSortedLinkedList_leetcode21 {
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 if (l1 == null) return l2;
	     if (l2 == null) return l1;
	     ListNode l3 = new ListNode(-1);
	     
	     ListNode head = new ListNode(-1);
	     head.next = l3;
	     while (l1!=null && l2!=null) {
	    	 if (l1.val< l2.val) {
	    		 l3.next= new ListNode(l1.val);
	    		 l1=l1.next;
	    	 } else {
	    		 l3.next = new ListNode(l2.val);
	    		 l2=l2.next;
	    	 }
	    	 l3 = l3.next;
	     }
	     
	     while(l1!=null) {
	    	 l3.next=new ListNode(l1.val);
	    	 l1 =l1.next;
	    	 l3 = l3.next;
	     }
	     
	     while(l2!=null) {
	    	 l3.next = new ListNode(l2.val);
	    	 l2 = l2.next;
	    	 l3 = l3.next;
	     }
	     
	     head = head.next.next;
	     return head;
	 }
	 
	 public static void main(String[] args) {
		 System.out.println("test1...");
		 ListNode l1 = new ListNode(1);
		 ListNode l2 = new ListNode(2);
		 ListNode.display(mergeTwoLists(l1,l2));
		 
		 
		 System.out.println("test2...");
		 l1 = new ListNode(2);
		  l2 = new ListNode(1);
		 ListNode.display(mergeTwoLists(l1,l2));
		 
		 System.out.println("test3...");
		 l1=null;
		 l2=null;
		  l1 = new ListNode(1);
		  l1.next = new ListNode(3);
		  l1.next.next = new ListNode(4);
		  l2 = new ListNode(0);
		  l2.next = new ListNode(2);
		 ListNode.display(mergeTwoLists(l1,l2));
	 }
}
