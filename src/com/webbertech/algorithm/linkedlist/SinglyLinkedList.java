package com.webbertech.algorithm.linkedlist;

//singly linkedlist
//Need to figure out nested class generic, and interface generic

public class SinglyLinkedList <T> implements ILinkedList <T> {

	protected Node <T> first, last;
	protected int size;
	
	//protected inner class can be accessed by subclass in the same package
	protected class Node <E extends T> {
		E item;
		Node<E> next;
		
		Node(E item, Node <E> next) {
			this.item = item;
			this.next = next;
		}
	}

	
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
			size ++;
			return true;
		}
	}
	
	public int getSize() {
		return size;
	}


	@Override
	public void add(int index, Object data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFirst(T data) {
		if (size == 0) {
			Node<T> node = new Node<T>(data,null);
	        first = last = node;
		} else {
			Node<T> node = new Node<T>(data,null);
			node.next = first;
			first = node;
		}
	}

	@Override
	public void addLast(T data) {
		if (size == 0) {
			Node<T> node = new Node<T>(data,null);
			first = last = node;
	    } else {
	    	Node<T> node = new Node<T>(data,null);
	    	last.next = node;
	    	last = last.next;
	    }
	}

	@Override
	public boolean contains(T item) {
		
		Node<T> node = first;
		while (node != null) {
			if(node.item == item) {
				return true;
			} else
				node = node.next;
		}
		return false;
	}


	@Override
	public int indexOf(T item) {
		if (size < 0) throw new IndexOutOfBoundsException();
		else {
			Node<T> node= first;
			for (int i=0;i< size;i++) {
	           	if (node.item == item) {
	           		return i;
	           	} else {
	           		node = node.next;
	           	}
			}
		}
		return -1;
	}


    //should index from 0
	@Override
	public T get(int index) {
		if (index < 0 || index > size -1 ) {
			return null;
		}
		
	    if (first == null) 
	    	return null;
		
		Node<T> node = first;
		
		for(int i=0; i< index; i++)
		{
			node = node.next;
		}
		
		return node.item;
	}

	


	@Override
	public T getLast() {
		if ( size <= 0) {
			return null;
		} else {
			return last.item;
		}
	}

	@Override
	public T getFirst() {
		if ( size <= 0) {
			return null;
		} else {
			return first.item;
		}
	}

	@Override
	public T removeFirst() {
		
		Node<T> node = null ;
		 if (first == null)
             return null;
		 else  {
			 if (first == last) {
                 first = null;
                 last = null;
             } else { 
            	node = first;
            	 first = first.next;
            	 
             }
			 return node.item;
		 }
			 
	}
	

	
	@Override
	public T removeLast() {
		if (size == 0 ) return null;
		Node<T> node = first;
		if (node == last) {
			first = last = null;
			return first.item;
		} else {
		
			while(node.next != last) {
				node = node.next;	
			}
			node.next =null;
			Node <T> removedNode = last;
			last = node;
			return  removedNode.item;
		}
		
	}

	
	
	//NEED TO PAY ATTENTION 
	@Override
	public T remove(int index) {
		if ( index < 0 || index > size-1 ) {
			return null;
		} 
	
	    if (index == 0 && first != null )
	    {
	    	Node<T> node = first;
	    	T item = node.item;
	    	first = first.next;
	    	size--;
	    	return item;
	    } else {
	   
	    	Node <T> node = first;
	    	for (int i =0 ;i< index-1 ;i++) {
	    		node = node.next;
	    	}
	    	//to be deleted is node.next, not node
	    	T item = node.next.item;
	    	node.next = node.next.next;
	    	size--;
	       return item;
	    }
	 
	}
    
	
   
	//Pay attention to this 
	@Override
	public boolean remove(T o) {
		Node<T> node;
		if (o == null) {   
			throw new NullPointerException();
		}
		
		if (first != null)
		{ 
		  node = first;
		  if (node.item == o) {
		    first =first.next;
		    size--;
		    return true;
		  }
		  while (node.next != null && node.next.item != o) {
			 	node = node.next;
			}
		  if (node.next == null)
			  return false;
		  else if (node.next.item == o ) {
			  //remove it
	         node.next = node.next.next;
	         size--;
	         return true;
		  }
	 }
		  
		
		return false;
	}

	
	public void print() {
		if(first != null) {
		  Node<T> node = first;
		  while( node != null) {
			  System.out.print(node.item + "\t");
			   if (node.next != null) 
			      node = node.next;
			   else break;
		  } 
		}
	}
	
	public void print(Node head) {
		if(head != null) {
		  Node<T> node = head;
		  while( node != null) {
			  System.out.print(node.item + "\t");
			   if (node.next != null) 
			      node = node.next;
			   else break;
		  } 
		}
	}
	
	public Node getHead() {
		return first;
	}
	
	
	//solution 1: use array, reverse array and feed back to a linkedList, space consuming
	
	//solution 2: generic
	public Node reverse(Node head) {
		
		if (head == null )
			return null;
		else if (head.next == null)
			return head;
		else {
			Node p = head;
			Node q = p.next;
			Node r = null;
			head.next = null;
		
			//think q is the last, and r=q.next is null,
			//after the last step, q == null, p is the last node points to left.
			//p is the head now. 
			//when it gets out of the while, this is the list: n,n-1,,,.., p (q=r=null)
			while (q!=null) {
				r = q.next;
				q.next = p;
				p = q;
				q = r;
			}
			head = p;
			return  head;
		 }
	}
	
	
	
	//solution 3: inserting every node from the 3rd node to the last node between 
	// first and second node, finally move first node to the end.
	public Node reverse1(Node head) {
		if (head == null ) return null;
	
		Node p = head.next;
	   Node q;
		while (p.next != null ) {
		   q = p.next;
		   p.next = q.next;
		   
		   //why cant be  q.next = p;
		   q.next = head.next;
		   head.next = q;
		}
		p.next = head;
		head= p.next.next;
		p.next.next=null;
		return head;
	}

	
	//solution 4: recursion
	//http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
	public Node reverse2(Node curr,  Node prev) {
		
		//why the following has to be first?
		
		 /* If last node mark it head*/
        if (curr.next == null) {
            first = curr;
 
            /* Update next to prev node */
            curr.next = prev;
            return null;
        }
 
        /* Save curr->next node for recursive call */
        Node next1 = curr.next;
 
        /* and update next ..*/
        curr.next = prev;
 
       // reverse2(next1, curr);
        reverse2(next1, curr);
        return first;
	}
	
	
	
	//find the kth node from the end in one single pass
	public Node getKthNodeFromEnd(Node head, int k) {
		if (head == null) 
			return null;
		Node fast , slow;
        fast = slow = head;
		for (int i =0; i<k; i++) 
		{
			fast = fast.next;
		}
		
		//another variation of this is to remove the kth node,
		//which is that when fast != last, then slow is one node before the node
		//to be deleted
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	
	
	
	//pay attention to the loop condition
	//find the mid position node in one single pass
	public Node midNode(Node head) {
		if (head == null)
			return null;
		Node fast , slow;
		fast = slow = head;
		
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	
	public static void main(String[] args){
		SinglyLinkedList s = new SinglyLinkedList();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);
		
		System.out.println("Testing size");
		System.out.println(s.size);
		
		System.out.println("Testing get(int idx) method");
		System.out.println(s.get(0));
		System.out.println(s.get(1));
		System.out.println(s.get(2));
		
		System.out.println("Testing getFirst() and getLast()");
		System.out.println(s.getFirst());
		System.out.println(s.getLast());
		
		System.out.println("Testing contains(T item)");
		System.out.println(s.contains(1));
		System.out.println(s.contains(7));
		
		System.out.println("Testing indexOf(T item)");
		System.out.println(s.indexOf(0));
		System.out.println(s.indexOf(3));
		System.out.println(s.indexOf(4));
		
		System.out.println("Show all memebers");
		s.print();
		
		System.out.println("\ntesting\n");
		s.print(s.reverse(s.getHead()));
		
		
		/* working fine
		System.out.println("");
		System.out.println("Removing first");
		s.removeFirst();
		s.print();
		
		System.out.println("");
		System.out.println("Removing last");
		s.removeLast();
		s.print();
		*/
		
		
		/*
		System.out.println("\nTesting removing items");
		
		System.out.println(s.remove(0));
		s.print();
		System.out.println();
		
		
		System.out.println(s.remove(1));
		s.print();
		System.out.println();
		
		System.out.println(s.remove(2));
		s.print();
		System.out.println();
		
		System.out.println(s.remove(5));
		s.print();
		
		
		System.out.println();
		System.out.println("Testing removing an object by content");
		s.remove("a");
		s.print();
		
		System.out.println();
		s.remove("f");
		s.print();
		*/
		
		
		
		//reverse a singly linkedlist
		/*
		System.out.println();
		System.out.println("testing reversing a linkedlist");
	    
		//s.print(s.reverse1(s.getHead()));
		//s.print(s.reverse2(s.getHead(),null));
		
		
		SinglyLinkedList s1 = new SinglyLinkedList();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		s1.add(5);
		s1.add(6);
		s1.add(7);
		s1.add(8);
		s1.add(9);
		s1.add(10);
		System.out.println("\n");
		s1.print();
        System.out.println();
		
       // System.out.println("\n" + s1.getKthNodeFromEnd(s1.getHead(),3).item);
	

		/*
			System.out.println("\ntesting midNode");
			System.out.println(s1.midNode(s1.getHead()).item);
		*/
	}

}
