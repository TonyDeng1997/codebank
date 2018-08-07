package com.webbertech.leetcode.linklist;

import com.webbertech.leetcode.util.ListNode;

/*
 * leetcode92 Reverse Linked List II
 *  Reverse a linked list from position m to n. Do it in-place and in one-pass.

	For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	return 1->4->3->2->5->NULL. 
	Note:
Given m, n satisfy the following condition:
1 ¡Ü m ¡Ü n ¡Ü length of list. 

solution: if n == m , don't do anything.
          if m==1, n==length, reverse the whole list.
          if m==1, n< length, then reverse part of them
          if m>1, n<=length, then reverse part of them.
          Because it has to be done in one pass, so there 
          is no way to know the length.
 * */

public class ReverseLinkedlistFromMToN_leetcode92 {
	
	  //solution1: seems too slow?
	  public static ListNode reverseBetween(ListNode head, int m, int n) {
            if (m==n) return head;
            ListNode newHead=head;
            int pre=m;
            while(pre-1>0) {
            	newHead=newHead.next;
            	pre--;
            }
            //reverse n-m times
            int count=n-m;
            ListNode p = newHead;
            ListNode q= p.next;
        	ListNode temp = null;
        	p.next = null;
            while(count>0) {
            	temp = q.next;
                q.next = p;
                p=q;
                q=temp;
                count--;
            }
            //by the last q, the q.next is the tail.
            head.next = p;
            ListNode cur=p;
            ListNode tail =null;
            while(cur!=null) {
            	tail=cur;
            	cur=cur.next;
            }
            tail.next = q;
            return head;
	  }
	  
	  
	  //Solution2: Solution1 uses three while loop. Instead we can use two loop in the following solution.
	  
	  public static ListNode reverseBetween2(ListNode head, int m, int n) {
		    if(head == null) return null;
		    ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
		    dummy.next = head;
		    ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
		    for(int i = 0; i<m-1; i++) 
		    	pre = pre.next;
		    
		    ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
		    ListNode then = start.next; // a pointer to a node that will be reversed
		    
		    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
		    // dummy-> 1 -> 2 -> 3 -> 4 -> 5
		    
		    /*How to remember this logic*/
		    for(int i=0; i<n-m; i++)
		    {
		        start.next = then.next;
		        then.next = pre.next;
		        pre.next = then;
		        then = start.next;
		    }
		    
		    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
		    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
		    
		    return dummy.next;
		}
	
	  
	  public static void main(String[] args) {
		  ListNode list = new ListNode(1);
		  list.addNode(2);
		  list.addNode(3);
		  list.addNode(4);
		  list.addNode(5);
		  ListNode newHead = reverseBetween2(list, 2,4);
	  }
}
