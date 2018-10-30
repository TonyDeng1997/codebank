package com.webbertech.leetcode.linklist;
/*
 * Given a linked list, remove the nth node from the end of list and return its head.

	For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
	Note:
	Given n will always be valid.
	Try to do this in one pass.

 * */

import com.webbertech.leetcode.util.ListNode;

public class RemoveLastNthNodeSinglyList {

	 public static ListNode removeNthFromEnd(ListNode head, int n) {
	        if (head == null) return null;
	        if (n==0) return head;
	        if (head.next == null && n == 1) {
	            return null;
	        }
	        
	        ListNode slow = head;
	        ListNode fast = head;
	        ListNode res = slow;
	        int i=0; //counter to keep track of the faster pointer to go n steps first
	        while (fast!=null && i<=n ) {
	            fast= fast.next;
	            i++;
	        }
	     
	        //if fast is already null, then the n is larger than the length of the list?
	        if (i == n) {
	        	//remove the first node of list
	        	slow  = slow.next;
	        	return slow;
	        }
	        
	        while(fast!=null) {
	            slow=slow.next;
	            fast=fast.next;
	        }
	        slow.next = slow.next.next;
	        return res;
	    }
	 
	 public static void main(String[] args) {
		 System.out.println("test1");
		 ListNode l1 = new ListNode(1);
		 l1.next = new ListNode(2);
		 
		 //output is 1
		 ListNode list = removeNthFromEnd(l1,1);
		 ListNode.display(list);
		 
		 //null
		 System.out.println("test2");
		  l1 = new ListNode(1);
		
		 ListNode.display(removeNthFromEnd(l1,1));
		 
		 //output should be 2
		 System.out.println("test3");
		  l1 = new ListNode(1);
		  l1.next = new ListNode(2);
		 ListNode.display(removeNthFromEnd(l1,2));
		 
		 //output should be 2,3
		 System.out.println("test4");
		  l1 = new ListNode(1);
		  l1.next = new ListNode(2);
		  l1.next.next = new ListNode(3);
		 ListNode.display(removeNthFromEnd(l1,3));
	 }
}
