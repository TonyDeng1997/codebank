package com.webbertech.leetcode.linklist;

import com.webbertech.leetcode.util.ListNode;

/* Leetcode 141 Linkedlist cycle
 * Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?

* Solution: use faster and slower pointers, Flod's algorithm published in 1967
* 
* Accepted: key point, make sure that set faster pointer right.
*/
public class LinkedListCycleII_leetcode141 {

	 public static boolean hasCycle(ListNode head) {
	        if (head==null || head.next ==null) 
	            return false;
	        
	        ListNode slow = head;
	        ListNode fast = head.next.next;
	        ListNode meetNode= null;
	        while(fast!=null && fast.next!=null) {
	        	   if (fast != slow) {
		               fast = fast.next.next;
		               slow = slow.next;
		           } else {
		               meetNode = fast;
		               break;
		           }
	        }
	        if (meetNode == null)
	        	return false;
	        return true;
	        
	    }
	 
	public static void main(String[] args) {
	   System.out.println("testing1...");
	   ListNode list = new ListNode(1);
	   list.addNode(2);
	   System.out.println(hasCycle(list));
	   
	   System.out.println("testing2...");
	   ListNode list1 = new ListNode(1);
	   list1.addNode(2).addNode(3).addNode(4).addNode(5).next= list1.next;
	   System.out.println(hasCycle(list1));
	   
	   System.out.println("testing3...");
	   ListNode list2 = new ListNode(1);
	   list2.addNode(2).addNode(3).addNode(4).addNode(5);
	   System.out.println(hasCycle(list2));
	}
}
