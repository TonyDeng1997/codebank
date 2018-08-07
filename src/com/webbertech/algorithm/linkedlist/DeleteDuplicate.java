package com.webbertech.algorithm.linkedlist;

public class DeleteDuplicate {
        
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node removedDuplicated(Node current) {
		Node head = current;
		while(current !=null) {
		     Node runner = current;
		      while(runner.next != null) {
		              if(runner.next.data == current.data) {
		                 runner.next = runner.next.next;
		               } else {
		                   runner = runner.next;
		                }
		     } 
		     current = current.next;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		Node head = new Node(3);
		head.next = new Node(1);
		head.next.next = new Node(1);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(3);
		DeleteDuplicate dd = new DeleteDuplicate();
		Node node= dd.removedDuplicated(head);
		
	}
	
}
