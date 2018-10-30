package com.webbertech.leetcode.linklist;

import com.webbertech.leetcode.util.ListNode;

/* Leetcode 61 Rotate List
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.


Solution: need to calculate the length of the list,

the shiftNum = k%length, if shiftNum == 0 or k == 0 don't shift.
if head is null or head.next is null, don't shift
 * 
 * Accepted.
 * */
public class RotateListByK_leetcode61 {

	//[1,2] , 1
	//[1,2,3], 1000
	//[1,2], 2

	public static ListNode rotateRight(ListNode head, int k) {
		    if (head == null || head.next == null) return head;
		    if (k==0) return head;
		 
		    
	        //find the shifted nodes
	        ListNode curHead= head;
	        int length = 0;
	        while(curHead!=null) {
	        	length++;
	        	curHead = curHead.next;
	        }
	        
	        
	    
	        
	        //shifted numbers
	        k = k%length;
	      //if it shifts the multiples of length of the list, then don't do anything
	        if (k == 0) return head;
	        // find out the new head node that is length-1-k
	        int i=0;
	        ListNode cur = head;
	        while(cur!=null & i<length-1-k){
	        	cur = cur.next;
	        	i++;
	        }
	        ListNode newHead = cur.next;
	        cur.next = null;
	         curHead= newHead;
	        while(curHead!=null && curHead.next!=null) {
	        	curHead=curHead.next;
	        }
	        curHead.next = head;
	        //head.next=null;
	        
	        return newHead;
	        
	        
	 }
	 
	 public static void main(String[] args) {
		 
		 ListNode head = new ListNode(1);
		 head.next  = new ListNode(2);
		 head.next.next  = new ListNode(3);
	
		 ListNode newHead = rotateRight(head,1);
	 }
	
}
