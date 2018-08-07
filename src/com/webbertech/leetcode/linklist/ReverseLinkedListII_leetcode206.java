package com.webbertech.leetcode.linklist;

import com.webbertech.leetcode.util.ListNode;

//use recursion
public class ReverseLinkedListII_leetcode206 {
	 
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;  
	     ListNode nextListNode = head.next;  
	     head.next = null;  
	     ListNode rest = reverseList(nextListNode);  
	     nextListNode.next = head; 
	     return rest;  
	 }
	 
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ListNode newNode= reverseList(head);
		ListNode.display(newNode);
	}
}