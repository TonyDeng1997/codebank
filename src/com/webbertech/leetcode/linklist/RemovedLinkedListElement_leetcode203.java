package com.webbertech.leetcode.linklist;

import com.webbertech.leetcode.util.ListNode;

/* Leetcode 203
 * Remove Linked List Elements
 * 
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5 

Pay attention to this.

 * */
public class RemovedLinkedListElement_leetcode203 {
	public static ListNode removeElements(ListNode head, int val) {
		   	//dummy pointer/variable saves the address of this object,
			//changing second saves the same address of the same object.
			//changing the value of 'second' will not change the value of 'dummy'
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode first = head;
	        ListNode second = dummy;
	        while(first != null) {
	            if (first.val == val) {
	                first = first.next;
	                second.next = first;
	            } else {
	                first = first.next;
	                second = second.next;
	            }
	        }
	        return dummy.next;
	    }
	 

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ListNode list = new ListNode(1);
      list.next = new ListNode(2);
      list.next.next = new ListNode(1);

      //ListNode.display(removeElements(list,2));
      ListNode.display(removeElements(list,1));
	}
}
