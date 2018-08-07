package com.webbertech.algorithm.linkedlist;

//doubly linkedlist implementation

//ref: http://hg.openjdk.java.net/jdk7/jdk7/jdk/file/9b8c96f96a0f/src/share/classes/java/util/LinkedList.java

//TODO how to prevent it to be used by concurrent version

public class LinkedList <T> implements ILinkedList <T> {

	private Node<T> first, last;
	private int size;
	
	@Override
	public boolean add(T data) {
		if (data == null) 
			return false;
		else {
			 Node<T> node = new Node(null, data, null);
		 if(size == 0) {
			 first = last  = node;
		 } else {
			 last.next = node;
			 node.prev = last;
			 last = last.next;
		 }
		 size++;
		 return true;
		} //end of else
	}
	
	
	
	@Override
	public void add(int index, T data) {
	   if(index < 0 || data == null) {
		   return;
	   }
	   
	   if (index == 0)
		   addFirst(data);
	   else if (index == size)
		   addLast(data);
	   else {
		   Node<T> cur = first;
		   Node<T> newNode = new Node(null, data, null);
		   for(int i =0;i< index -1; i++) {
			   cur = cur.next;
		   }
		   newNode.next=cur;
		   cur.prev=newNode;
		   size++;	
	   }
            
	}

    @Override
	public void addFirst(T data) {
		if (data == null)
			return;
		Node<T> node = new Node<>(null, data, null);
		first.next = node;
		node.prev = first;
		first = first.next;
		size++;
	}
	
    @Override
	public void addLast(T data) {
		if (data == null)
			return;
		Node<T> node = new Node<>(null, data, null);
		last.next = node;
		node.prev = last;
		last = last.next;
		size++;
	}
	
    @Override
	public T get(int index) {
		if (index >= size || index < 0) { 
			  throw new IndexOutOfBoundsException();
		}
		
		if (index == 0)
			return first.getData();
		else if (index == (size -1)) {
			return last.getData();
		} else {
		
	   	 Node<T> node = first;
	   	 for(int i=0;i<index;i++) {
	   		node = node.next;
	     }
		 return node.getData();
		}
	}
	
	@Override
	public int getSize() {
	   return size;	
	}
	
	@Override
	public T getLast() {
	  if (size <= 0 ) {
		  return null;
	  }	else {
		  return last.getData();
	  }
	}
	
	@Override
	public T getFirst() {
     if (size <=0 ) {
    	 return null;
     } else {
        return first.getData();	 
     }
   }
	
	//TODO
	@Override
	public boolean contains(Object o) {
		return false;
	}
	
	//TODO
	@Override
	public int indexOf(Object o) {
		return 0;
	}
	
	//TODO
	@Override
	public T remove(int index) {
		 
		 return null;
	}
	 
	//TODO
	@Override
	public boolean 	remove(Object o) {
		return false;
	}
	
	//TODO
	@Override
	public T removeFirst() {
		return null;
	}
	
	//TODO
	@Override
	public T removeLast() {
		return null;
	}
	
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println("list size: " + list.getSize());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		//check exception
		try {
			System.out.println(list.get(4));
		} catch (IndexOutOfBoundsException e) {
		   e.printStackTrace();	
		}
		
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println("adding first and last node");
		list.addFirst(-1);
		list.addLast(100);
		System.out.println("getting first");
		System.out.println(list.getFirst());
		
		System.out.println("getting last");
		System.out.println(list.getLast());
		
		//getting size
		System.out.println("getting size");
		System.out.println(list.getSize());
		
		
		System.out.println("testing my list to add(index,data)");
		//testing public void add(int index, T data)
		
		list.add(0, 1);
		System.out.println(list.getSize());
		list.add(list.getSize(),1000);
		
		System.out.println("getting size of my list, it should be now: 1,-1,1,2,3,100,1000");
		System.out.println(list.getSize());
		System.out.println(list.get(0));
		System.out.println(list.get(list.getSize()-1));
		
	}


}
