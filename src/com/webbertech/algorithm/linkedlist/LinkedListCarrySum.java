package com.webbertech.algorithm.linkedlist;


public class LinkedListCarrySum {
	
	private static class Node {
		
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
		
		public Node() {}
	}
	

	
	//input two linked list : L1: (7, 1, 6) +  L2: (5, 9, 2)  , the number is 617+ 295 = 912
	//output: linked list 2 ->1 ->9, that is 912

	static Node sumList(Node n1, Node n2) {
		int sum = 0;
		int carryBit = 0;
		int value = 0;
		Node newHead = new Node();
		Node current = newHead;
		
		while(n1!=null && n2!=null) {
			sum = n1.data + n2.data + carryBit;
			carryBit = sum / 10;
			value = sum % 10;
			current.next=new Node(value);
			current = current.next;
			n1 = n1.next;
			n2 = n2.next;
		}
		
		newHead= newHead.next;
		return newHead;
	}
	
	//input one linked list :  (7 -> 1 -> 6) -> (5 -> 9 -> 2)  , the number is 617+ 295 = 912
	//output: linked list 2 ->1 ->9, that is 912

	
	static Node sumHalves(Node n1) {
		if (n1 == null)
			throw new IllegalArgumentException();
		
		Node fast= n1; 
	    Node slow = n1;
		
		//find middle node
		while(fast != null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		//first pointer in the second half
		Node mid = slow;
		Node newNode = new Node();
		Node current = newNode;
		Node firstPart= n1;
		int sum =0;
		int carryBit =0;
		int value=0;
		while (mid!=null) {
			sum = firstPart.data + mid.data + carryBit;
			carryBit = sum / 10;
			value = sum % 10;
			current.next = new Node(value);
			current = current.next;
			mid = mid.next;
			firstPart = firstPart.next;
		}
		
		newNode = newNode.next;
		return newNode;
	}
	
	
	public static void display(Node node) {
		 while(node!=null) {
			 System.out.print(node.data + " ");
			 node = node.next;
		 }
		 System.out.println();
	}
	
	//for followup question reverse the linked list
	
	public static Node reverse(Node node) {
		if (node == null)
			throw new IllegalArgumentException();
		
		Node p = node;
		Node q = p.next;
		Node r = null;
		
		//p will be the tail node, to set its next to null
		p.next = null;
		while(q !=null ) {
			r = q.next;
		     q.next = p;
		    p= q;
		    q = r;
		}
		
		return p;
	}
 	
	public static void main(String[] args) {
		Node n1 = new Node(7);
		 n1.next = new Node(1);
		 n1.next.next = new Node(6);
		 
		 Node n2 = new Node(5);
		 n2.next = new Node(9);
		 n2.next.next = new Node(2);
		 
		 Node node = sumList(n1,n2);
		 
		 display(node);
		 
		 Node n3 = new Node(7);
		 n3.next = new Node(1);
		 n3.next.next = new Node(6);
		 n3.next.next.next = new Node(5);
		 n3.next.next.next.next = new Node(9);
		 n3.next.next.next.next.next = new Node(2);
		 
		 display(sumHalves(n3));
		 
		 display(reverse(sumHalves(n3)));
	}

}
