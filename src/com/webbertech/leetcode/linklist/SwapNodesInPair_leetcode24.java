package com.webbertech.leetcode.linklist;

import com.webbertech.leetcode.util.ListNode;

/*
 *  Leetcode 24
 *  Given a linked list, swap every two adjacent nodes and return its head.

	For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.

	Your algorithm should use only constant space. You may not modify the values in the list, 
	only nodes itself can be changed. 
 * */

public class SwapNodesInPair_leetcode24 {
	
	public static ListNode swapPairs(ListNode head) {
		   //initial case
	       if (head == null || head.next== null)
	          return head;
	       
	       //make a dummy node before head node
	       ListNode dummy = new ListNode(0);
	        ListNode p = head;
	        dummy.next = head;
	        ListNode q, tmp;
	        ListNode pre = dummy;
	        
	        //one special case
	        if (p!=null && p.next.next == null) {
	        	 ListNode temp = p;
	        	 p = p.next;
	             p.next = temp;
	             p.next.next = null;
	             return p;   
	        }
	        
	        //try to write down the object id to see how the linkedlist works
	        //see how pre works with dummy
	        while(p!=null && p.next!=null) {
	        	  q=p.next;
	              tmp=q.next;
	              q.next=p;
	              p.next=tmp;
	              // pre is dummy in the first time
	              // link pre to q
	              pre.next=q;
	              //rewrite pre with p
	              pre=p;
	              // now this p is the orignal q
	              p=p.next;
	        }  
	        return dummy.next;          
	}
	
	
	//recursion, this is my solution
	public ListNode swapPairs2(ListNode head) {
	    if(head==null||head.next==null)
	        return head;
	    ListNode p1=head;
	    ListNode p2=p1.next;
	    ListNode p3=p2.next;
	    p2.next=p1;
	    p1.next=swapPairs(p3);
	    return p2;
	}
	
	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
		ListNode.display(swapPairs(list));
	}
}
