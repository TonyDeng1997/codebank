package com.webbertech.leetcode.linklist;

import com.webbertech.leetcode.util.ListNode;

/*
 * leetcode 206 reverse singly linkedlist
 * */
public class ReverseLinkedListI_leetcode206 {

	 public static ListNode reverseList(ListNode head) {
		 if (head == null)
	            return null;
	        ListNode p1 = head;
	        ListNode p2 = p1.next;
	        p1.next=null;
	        while(p2!=null) {
	            ListNode p3= p2.next;
	            p2.next = p1;
	            p1=p2;
	            p2=p3;
	        }
	        return p1;
	    }
	 
	 public static void main(String[] args) {
		 ListNode head = new ListNode(1);
		 head.next = new ListNode(2);
		 head.next.next = new ListNode(3);
		 ListNode newNode = reverseList(head);
		 while(newNode!=null) {
			 System.out.print(newNode.val+" ");
			 newNode = newNode.next;
		 }
	 }
}
