package com.webbertech.leetcode.linklist;

import com.webbertech.leetcode.util.ListNode;

/*Leetcode 234 Palindrome linkedlist
 * 
 * Given a singly linked list, determine if it is a palindrome.
	Follow up:
	Could you do it in O(n) time and O(1) space?
 * */

/*solution1:
 * 
 *  1/ Iterate through and get the length in O(n).
 *  2/ Then use extra space like a stack, and push the first half into the stack.
 *  3/ When iterate from n/2+1 element to n, pop one from stack and compare
 *  
 *
 *solution2: 
 *  1/ Iterate through the list and get length in O(n)
 *  2/ If n is odd number, reverse the first half of the list [0 to n/2)
 *     If n is even number, reverse the first half from [0,n/2),
 *     say n = 4 and n = 7. 
 *  3/ compare the reverse linked list with the rest of the linked list
 *  
 *  The following is accepted
 */
public class PalindromeLinkedList_leetcode234 {
	 
	 static ListNode reverseLinkedList(ListNode node) {
		 if (node == null || node.next == null) return node;
		 ListNode p1 = node;
		 ListNode p2 = p1.next;
		 p1.next= null;
		 while(p2!=null) {
			 ListNode p3 = p2.next;
			 p2.next = p1;
			 p1 = p2;
			 p2 = p3;
		 }
			return p1; 
	 }
	 
	 static ListNode getSecondHalf(ListNode head) {
		 int count=1;
		 ListNode current = head;
		 int len = getLength(current);
		 ListNode newHead = null;
		 while(current!=null  && count< len/2) {
			 current = current.next;
			 count++;
		 }
		 if (len%2==0) {
			 newHead = current.next;
			 current.next = null;
			 return newHead;
		 } 
		 newHead = current.next.next;
		 current.next= null;
	     return newHead;	 
	 }
	 
	 static int getLength(ListNode head) {
		 if (head==null) return 0;
		 if (head.next==null) return 1;
		 int len=0;
		 while(head!=null) {
			 head = head.next;
			 len++;
		 }
		 return len;
	 }
	
	 public static boolean isPalindrome(ListNode head) {
		 if (head==null || head.next==null) {
			 return true;
		 }
		 
		 ListNode headSecondHalf = getSecondHalf(head);
	     ListNode headFirstHalf = head;
	     ListNode newFirstHalf = reverseLinkedList(headFirstHalf);
	     while(newFirstHalf!=null) {
	    	 if (newFirstHalf.val != headSecondHalf.val) {
	    		 return false;
	    	 } 
	    	 headSecondHalf = headSecondHalf.next;
	    	 newFirstHalf = newFirstHalf.next;
	     }
	     return true;
	 }
	 
	 public static void main(String[] args) {
		 /*
		 ListNode l = new ListNode(1);
		 l.addNode(2).addNode(3);
         ListNode.display(l);
         ListNode rl = reverseLinkedList(l);
         ListNode.display(rl);
         */
		 
		 ListNode l = new ListNode(1);
		 l.addNode(3).addNode(3).addNode(1).addNode(3).addNode(3).addNode(1);
		 ListNode.display(l);
		 System.out.println(isPalindrome(l));
		 
		 //test 2
		 /*
		 System.out.println(getLength(l));
		 System.out.println(getLength(getSecondHalf(l)));
		 System.out.println(getLength(l));
		 */
		 //test 3
		 //System.out.println(getSecondHalf(l).val);
		 
		 
	 }
}
