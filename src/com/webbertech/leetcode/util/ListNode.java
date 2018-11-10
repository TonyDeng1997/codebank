package com.webbertech.leetcode.util;
public class ListNode {

	 // Definition for singly-linked list.
	  
	      public int val;
	       public ListNode next;
	       public ListNode(int x) { val = x; this.cur=this; }
	       public ListNode cur;
	       
	       public static void display(ListNode list) {
	 		  while(list!=null) {
	 			  System.out.println(list.val);
	 			  list = list.next;
	 		  }
	 	  }
	       
	      ListNode addNode(ListNode node) {
	    	  if (this.cur==null) return null;
	    	  this.cur.next = node;
	    	  this.cur = this.cur.next;
	    	  return this.cur;
	      }
	      
	      public ListNode addNode(int val) {
	    	  if (this.cur == null) return null;
	    	  this.cur.next = new ListNode(val);
	    	  this.cur= this.cur.next;
	    	  return this.cur;
	      }
}


