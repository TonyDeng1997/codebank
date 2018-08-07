package com.webbertech.leetcode.linklist;
/* leetcode 2
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
 * */

import com.webbertech.leetcode.util.ListNode;

public class LinkedListAddTwoNumbers_leetcode2 {
		 
	  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        if (l1 == null) return l2;
	        if (l2 == null) return l1;
	        int len1=0;
	        ListNode h1 = l1;
	        
	        while(h1!=null) {
	            len1++;
	            h1=h1.next;
	        }
	        h1= l1;
	        int len2=0;
	        ListNode h2 = l2;
	        while(h2!=null) {
	            len2++;
	            h2 = h2.next;
	        }
	        h2 = l2;
	        ListNode loopStart = len1<len2? h1:h2;
	        ListNode h3 = new ListNode(Integer.MAX_VALUE);
	        ListNode head = h3;
	        int carry =0;
	        while(loopStart!=null) {
	            int sum = h1.val+ h2.val + carry;
	            int value = sum % 10;
	             carry = sum / 10;
	            h1 = h1.next;
	            h2 = h2.next;
	            h3.next = new ListNode(value);
	            h3= h3.next;
	            loopStart= loopStart.next;
	        }
	       if (len1<len2) {
	    	   /*
	    	    * [9,8] and [1]
	    	    * */
	    	   while (carry != 0 && h2!=null) {
	    		   int value = (h2.val+carry) % 10;
	    		   carry = (h2.val + carry)/10;
	    		   h3.next = new ListNode(value);
	    		   h2= h2.next;
	    		   h3 = h3.next;
	    	   }
	           h3.next = h2;
	       } else {
	    	  while (carry != 0 && h1!=null) {
	    		   int value = (h1.val+carry) % 10;
	    		   carry = (h1.val + carry)/10;
	    		   h3.next = new ListNode(value);
	    		   h1= h1.next;
	    		   h3 = h3.next;
	    	   }
	           h3.next = h1;
	       }
	       if (carry != 0) {
	    	   h3.next = new ListNode(carry);
	       }
	       head = head.next;
	       return head;
	    }
	  
	  
	
	  
	  public static void main(String[] args) {
		  ListNode l1 = new ListNode(2);
		  l1.next = new ListNode(4);
		  l1.next.next = new ListNode(3);
		  ListNode l2 = new ListNode(5);
		  l2.next = new ListNode(6);
		  l2.next.next = new ListNode(4);
		  
		  ListNode list = addTwoNumbers(l1,l2);
		  ListNode.display(list);
		   
		  ListNode l3 = new ListNode(9);
		  l3.next = new ListNode(8);
		  ListNode l4 = new ListNode(1);
		  ListNode list1 = addTwoNumbers(l3,l4);
		  ListNode.display(list1);
		  
		  ListNode l5 = new ListNode(5);
		  ListNode l6 = new ListNode(5);
		  ListNode list2 = addTwoNumbers(l5,l6);
		  ListNode.display(list2);
	  }
}
