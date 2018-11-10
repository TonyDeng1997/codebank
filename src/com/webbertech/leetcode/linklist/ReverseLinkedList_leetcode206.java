package com.webbertech.leetcode.linklist;

import com.webbertech.leetcode.util.ListNode;

/*
 * leetcode 206 reverse singly linkedlist
 * 
 * Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
 * */
public class ReverseLinkedList_leetcode206 {

	
	 // Solution1: iterative
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
	 
	 // Solution2: recursion
	 public static ListNode reverseList2(ListNode head) {
			if (head == null || head.next == null) return head;  
		     ListNode nextListNode = head.next;  
		     head.next = null;  
		     ListNode rest = reverseList2(nextListNode);  
		     nextListNode.next = head; 
		     return rest;  
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
