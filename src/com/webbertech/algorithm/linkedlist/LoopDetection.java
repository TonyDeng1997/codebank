package com.webbertech.algorithm.linkedlist;

public class LoopDetection {

	public static class Node {
		
		char c;
		Node next;
		
		public Node() {}
		
		public Node(char c) {
			this.c= c;
		}
	}
	
	//A -> B -> C -> D -> E -> C
	
	
	//use fast/slow pointer
	static Node findMeetingNode(Node node) {
		if (node == null) 
			throw new IllegalArgumentException();
		
		Node fast = node;
		Node slow = node;
		
		while(fast!=null && fast.next != null) {
		
		  	fast = fast.next.next;
		  	slow = slow.next;
			if (fast.c == slow.c) {
				return fast;
			}
		}
		
		return null;
	}
	
	//if this node exists yes
	static boolean containsLoop(Node node) {
		if (node == null) 
			throw new IllegalArgumentException();
		
		Node node1 = findMeetingNode(node);
		if (node1 instanceof Node) {
			return true;
		} else {
			return false;
		}
	}

	//find out another collision point that is the entry node
	static Node findEntryNode(Node node) {
		Node fast = findMeetingNode(node); //let this be the fast pointer, but later on move one step a time
		  System.out.println(fast.c);
		Node slow = node;
		
		while(slow.c!=fast.c) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	
	public static void main(String[] args ) {
		Node node = new Node('A');
		node.next = new Node('B');
		
		Node node2 = new Node('C');
		node.next.next = node2;
		
		node2.next = new Node('D');
		node2.next.next = new Node('E');
		node.next.next.next = node2;
		
		System.out.println(containsLoop(node));
		System.out.println("The entry node is:" + findEntryNode(node).c);
	}
}
