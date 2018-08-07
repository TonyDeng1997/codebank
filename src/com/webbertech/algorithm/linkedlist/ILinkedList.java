package com.webbertech.algorithm.linkedlist;

//try to define what to do with implementation,
//also needs to be familiar with what is the actual API of LinkedList of JAVA 8

public interface ILinkedList <T> {
	boolean add(T data);
	void add(int index, T data);
	void addFirst(T data);
	void addLast(T data);
	boolean contains(T data);
	T get(int index);
	int 	indexOf(T data);
	T 	remove(int index);
	boolean 	remove(T data);
	T 	removeFirst();
	T 	removeLast();
	int 	getSize();
	T getLast();
	T getFirst();
	
}
