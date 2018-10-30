/*
 * 
 * Leetcode 83
 * 
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3. 

111 -> 1

Pay attention to this problem, need to quickly type up the solution.
Please write another code for unsorted array
 * */

package com.webbertech.leetcode.linklist;

import java.util.HashSet;

import com.webbertech.leetcode.util.ListNode;

public class RemoveDupsOfSortedList_leetcode83 {

	 public static ListNode deleteDuplicates(ListNode head) {
	        if (head == null || head.next == null) return head;
	       // ListNode dummy = new ListNode(0);
	       // dummy.next = head;
	        ListNode current = head;
	        while(current.next!=null) {
	            if (current.val == current.next.val) {
	                current.next = current.next.next;
	            } 
	           	current = current.next;
	        }
	        return head;
	    }
	 
	 
	 //solution2: use hash set, this can be used for unsorted array as well.
	 //need to revisit this
	 public static ListNode deleteDuplicates2(ListNode head) {
	        if (head == null || head.next == null)
	            return head;
	        HashSet<Integer> distinct = new HashSet<>();
	        ListNode prev = null;
	        ListNode curr = head;
	        ListNode next = head.next;
	        while(curr.next != null) {
	            if (distinct.contains(curr.val)) {
	                prev.next = next;
	                next = next.next;
	                curr = curr.next;
	            } else {
	                distinct.add(curr.val);
	                prev = curr;
	                curr = next;
	                next = next.next;
	            }
	        }
	        if (distinct.contains(curr.val))
	            prev.next = null;
	        return head;
	    }

	 public static void main(String[] args) {
		 System.out.println("First testing");
		 ListNode list = new ListNode(1);
		 list.next = new ListNode(1);
		 list.next.next = new ListNode(1);
		 ListNode newList = deleteDuplicates2(list);
		 ListNode.display(newList);
		 //TODO add some tests
		 
		 System.out.println("Second testing");
		 ListNode list1 = new ListNode(1);
		 list1.addNode(1).addNode(3).addNode(4);
		 ListNode newList1 = deleteDuplicates(list1);
		 ListNode.display(newList1);
	 }
}