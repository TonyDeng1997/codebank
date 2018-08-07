package com.webbertech.algorithm.linkedlist;


public class SinglyCircularLinkedList<T> extends SinglyLinkedList <T> {
   
	@Override
	public boolean add(T data) {
		if (data == null) return false;
		else if (size == 0) {
			first = last = new Node<T>(data,null);
			size++;
			return true;
		} else {
			Node<T> node =new Node<T>(data, null);
			last.next = node;
			last = last.next;
			//indicates it is a circle
			last.next = first;
			size ++;
			return true;
		}
	}
	
	public static void main (String[] args) {
		
	}
}
