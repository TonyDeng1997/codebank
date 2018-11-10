package com.webbertech.leetcode.linklist;

import java.util.Stack;

import com.webbertech.leetcode.util.ListNode;

/*
 * Leetcode 143 Reorder List
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

Solution: this is pretty simple, 
1/ reverse the list, and get its head node
2/ loop through two list, because they are equal length, copy the original list to make a new list.
3/ link the first node to the second list node and link back to the next.

Solution2: Use a stack, push the second half into a stack.
 *
 * 
 * 
Solution3: 
1/reverse the second half of the list
 * */


public class ReorderList_leetcode143 {

	
public static void reorderList(ListNode head) {
	if (head == null|| head.next == null) {
		return;
	}
	
	
	// start from solution 2, use stack for extra space
	/*
	ListNode slow = head;
	ListNode fast = head;
	
	while(fast!=null && fast.next !=null) {
       fast = fast.next.next;
       slow = slow.next;
    }
	
	Stack<ListNode>  stack = new Stack<>();
	while (slow!=null) {
		stack.push(slow);
	}
	
	ListNode cur = head;
	while(cur!=null) {
		if (!stack.isEmpty()) {
			ListNode curNext = cur.next;
			ListNode newNode = stack.pop();
				cur.next = newNode;
		      if(newNode!=curNext) {
				newNode.next = curNext;
		      }
		}
	}
	end of solution 2
	*/ 

	//solution 3, reverse second half of the list
	
	//Find the middle of the list
    ListNode p1=head;
    ListNode p2=head;
    while(p2.next!=null&&p2.next.next!=null){ 
        p1=p1.next;
        p2=p2.next.next;
    }
    
    //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
    ListNode preMiddle=p1;
    ListNode preCurrent=p1.next;
    while(preCurrent.next!=null){
        ListNode current=preCurrent.next;
        preCurrent.next=current.next;
        current.next=preMiddle.next;
        preMiddle.next=current;
    }

  //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
    //not quite understand
    p1=head;
    p2=preMiddle.next;
    while(p1!=preMiddle){
        preMiddle.next=p2.next; // use preMiddle.next to preserve
        p2.next=p1.next;
        p1.next=p2;
        p1=p2.next;        // p1 is the next of the p2.
        p2=preMiddle.next; // p2 is its own next
    }
}

   public static void main(String[] args) {
	   ListNode head = new ListNode(1);
	   head.next = new ListNode(2);
	   head.next.next = new ListNode(3);
	   head.next.next.next = new ListNode(4);
	   head.next.next.next.next = new ListNode(5);
	   head.next.next.next.next.next = new ListNode(6);
	  
	   reorderList(head);
   }
}
