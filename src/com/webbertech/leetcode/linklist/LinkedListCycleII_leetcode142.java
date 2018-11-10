package com.webbertech.leetcode.linklist;

import com.webbertech.leetcode.util.ListNode;

/*
 * leetcode 142, 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Note: Do not modify the linked list.
 * 
 * 
 * Solution: This is not to detect a cycle, this is to 
 * return the head, which is a math calculation. Be sure to understand the logic of math.
 * https://discuss.leetcode.com/topic/19367/java-o-1-space-solution-with-detailed-explanation/2
 * 
 * 
 * Define two pointers slow and fast. Both start at head node, fast is twice as fast as slow. 
 * If it reaches the end it means there is no cycle, 
 * otherwise eventually it will eventually catch up to slow pointer somewhere in the cycle.

Let the distance from the first node to the the node where cycle begins be A, and let say the slow pointer travels travels A+B. 
The fast pointer must travel 2A+2B to catch up. The cycle size is N. 
Full cycle is also how much more fast pointer has traveled than slow pointer at meeting point.

A+B+N = 2A+2B
N=A+B
From our calculation slow pointer traveled exactly full cycle 
when it meets fast pointer, and since originally it travled A 
before starting on a cycle, it must travel A to reach the point 
where cycle begins! We can start another slow pointer at head node, 
and move both pointers until they meet at the beginning of a cycle.
**/


public class LinkedListCycleII_leetcode142 {


//the other key to successfuly make this right is to use the faster
	//pointer to control the loop
	 public static ListNode detectCycle(ListNode head) {
	        
	        ListNode slow = head;
	        ListNode fast =  head;
	        while(fast!=null && fast.next!=null) {
	           fast = fast.next.next;
	           slow = slow.next;
	           if (slow == fast) {
	        	   ListNode slow2 = head;
	        	   while(slow!=slow2) {
	        		   slow2 = slow2.next;
	        		   slow = slow.next;
	        	   }
	        	   return slow;
	           }
	        }
	        return null;
	}
	 
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = head;
		System.out.println(detectCycle(head).val);
	}
	 
	 
}
