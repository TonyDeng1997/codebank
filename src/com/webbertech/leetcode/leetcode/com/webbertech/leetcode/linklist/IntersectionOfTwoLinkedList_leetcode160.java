package com.webbertech.leetcode.linklist;

import com.webbertech.leetcode.util.ListNode;

/*Leetcode 160
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

AA:          a1 → a2
                                                                 ↘
                     c1 → c2 → c3
                                                                  ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

public class IntersectionOfTwoLinkedList_leetcode160 {

	 // generic solution
	 //solution 1, using fast and slow pointers, connect the second list to the first list, and see
	 // if the new list has a loop and then find the intersection
	 // this solution is not qualified for the requirement of this question as it modified the structure of the linked list
	
	 public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if (headA == null || headB == null) 
	            return null;
	        
	        //connect headB to the tail of headA
	        ListNode current = headA;
	        while(current!=null&& current.next!=null) {
	         	current = current.next;
                
	        }
	        current.next = headB;
	
            //fast and slow pointer	        
	        ListNode fast = headA.next.next;
	        
	        //there are only two nodes,
	        if (fast == null) {
	        	if (headA==headA.next) {
	        		return headA;
	        	} 	else 
	        		return null;
	        }
	        
	        ListNode slow = headA;
	        ListNode meetNode= null;
	        while(fast!=null&&fast.next!=null){
	           if (fast != slow) {
	               fast = fast.next.next;
	               slow = slow.next;
	           } else {
	               meetNode = fast;
	               break;
	           }
	        }
	        
	        //no cycle found
	        if (meetNode == null)
	        	return null;
	        
	        ListNode head= headA;
	        while(head!=null) {
	        	if (head == meetNode) {
	        		return head;
	        	}
	            head = head.next.next;
	            meetNode = meetNode.next;
	        }
	        
	        return null;
	    }
	 
	 
	 //solution 2: make the longer list the same length as the 
	 public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		 if (headA==null|| headB==null ) {
			 return null;
		 }
		 
		 if (headA.next==null && headB.next==null) {
		      return headA == headB? headA:null;	 
		 }
		 
		 int len1=0, len2=0;
		 
		 ListNode headA1 = headA;
		 ListNode headB1= headB;
		 while(headA1!=null) {
			 len1++;
			 headA1 = headA1.next;
		 }
		 
		 while(headB1!=null) {
			 len2++;
			 headB1 = headB1.next;
		 }
			 
		 ListNode longer = len1>=len2? headA:headB;
		 ListNode shorter = len1<len2? headA:headB;
		 
		 int step =0;
		 while(step< Math.abs(len2-len1)) {
			 step++;
			 longer = longer.next;
		 }
		 
		 while(longer!=null) {
			 if (longer==shorter) {
				 return longer;
			 }
			 longer=longer.next;
			 shorter=shorter.next;
		 }
			
		 return null;
	 }
	 
	
	 public static void main(String[] args) {
		 
		 //test1
		 System.out.println("This is test1");
		 ListNode a = new ListNode(1);
		 a.next = new ListNode(2);
		 a.next.next = new ListNode(3);
		 a.next.next.next = new ListNode(4);
		 a.next.next.next.next = new ListNode(5);
		 
		 ListNode b = new ListNode(8);
		 b.next = new ListNode(9);
		 b.next.next = new ListNode(10);
		 b.next.next.next = a.next.next;
		 System.out.println(getIntersectionNode2(a,b).val);
		 
		 //test2
		 System.out.println("This is test2");
		 a = new ListNode(1);
		 a.next = new ListNode(2);
		 b = a.next;
		 System.out.println(getIntersectionNode2(a,b).val);
		 
		 //test3
		 System.out.println("This is test3");
		  a = new ListNode(1);
		  b = a;
		 System.out.println(getIntersectionNode2(a,b).val);
		 
		 //test4
		 System.out.println("This is test4");
		 a = new ListNode(1);
		  b = new ListNode(2);
		 System.out.println(getIntersectionNode2(a,b) == null? -1:getIntersectionNode2(a,b).val);
		
		 //test 5
		 //No intersection: [1,3,5,7,9,11,13,15,17,19,21]
		 //		 [2]
		 System.out.println("This is test5");
		 a = new ListNode(1);
		 a.addNode(3).addNode(5).addNode(7).addNode(9).addNode(11).addNode(13).addNode(15).addNode(17).addNode(19).addNode(21);
		 b = new ListNode(2);
		 System.out.println(getIntersectionNode2(a,b) == null? -1:getIntersectionNode2(a,b).val);
		
		 System.out.println("This is test6");
		 a = new ListNode(1);
		 a.addNode(3);
		 
		 b= new ListNode(2);
		 b.addNode(4);
		 System.out.println(getIntersectionNode2(a,b) == null? -1:getIntersectionNode2(a,b).val);
		 
	 }
}
