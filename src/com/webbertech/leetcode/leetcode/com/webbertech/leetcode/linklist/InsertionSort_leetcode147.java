package com.webbertech.leetcode.linklist;

import com.webbertech.leetcode.util.ListNode;

/*
 * 147 Insertion sort of a link list
 * 
 * Solution:
 * first need to understand what insertion sort is.
 * 
 * public static int[] doInsertionSort(int[] input){
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
- See more at: http://www.java2novice.com/java-sorting-algorithms/insertion-sort/#sthash.syWbo18U.dpuf


 * */

public class InsertionSort_leetcode147 {
	  public static ListNode insertionSortList(ListNode head) {
		  if (head == null|| head.next == null ) return head;
		  ListNode p1 = head;
		  ListNode p2 = null;
	     while (p1.next !=null && p1.next.next!=null) {
	    	 p2= p1.next;
	    	 if (p1.val> p2.val) {
	    		 ListNode temp = insertionSortList(p2.next);
	    		 p2.next = p1;
	    		 p1.next = temp;
	    	 }
	     }
	     return p2;
	  }
	  
	  public static void main(String[] args) {
		  ListNode head = new ListNode(1);
		   head.next = new ListNode(2);
		   head.next.next = new ListNode(3);
		   head.next.next.next = new ListNode(4);
		   head.next.next.next.next = new ListNode(5);
		   head.next.next.next.next.next = new ListNode(6);		  
	  }
}
