package com.webbertech.algorithm.linkedlist;

//doubly node for doubly linkedlist
public class Node <T> {
  private T item;
  Node<T> next;
  Node<T> prev;
  
  Node(Node<T> prev, T element, Node<T> next) {
      this.item = element;

      this.next = next;

      this.prev = prev;

  }
  
  public void setData(T data) {
	  this.item = data;
  }
  
  public T getData() {
	  return this.item;
  }
  
  public void setNext(Node<T> node) {
	  this.next = node;
  }
  
  public Node<T> getNext() {
	  return this.next;
  }
}
