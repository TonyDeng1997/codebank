package com.webbertech.leetcode.design;

import java.util.Iterator;

/*
 * Implement a CircularArray class and supports an array-link data structure
 * which can be efficiently rotated. use generic type if possible, and should 
 * support iteration via standard for (Obj o: circularArray) notation
 * 
 * solution: instead of actually rotate the array we can just move the head index of the array.
 
 * */

public class CircularArray<T> implements Iterable<T>{
    private T[] items;
    private int head =0;
    
    public CircularArray(int size) {
    	items = (T[]) new Object[size];
    }
    
    //Every time you call rotate, you update head. 
    public void rotate(int shiftRight) {
    	head = convert(shiftRight);
    }
    
    private int convert(int index) {
    	if (index < 0) {
    		index+=items.length;
    	}
    	return (head+index)% items.length;
    }
    
    //Get the convert
    public T get(int i) throws Exception {
    	if (i> items.length || i< 0)
    		throw new Exception("new exception");
    	return items[convert(i)];
    }
    
    public void set(int i, T item ) {
    	items[convert(i)] = item;
    }

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new CircularArrayIterator<T>(this);
	}
	
	private class CircularArrayIterator<T1>  implements Iterator<T1> {
		
		private int _current = -1;
		private T1[] _items;
		
		//iterator class's constructor
		public CircularArrayIterator(CircularArray<T1> array) {
			_items = array.items;
		}

		@Override
		public boolean hasNext() {
			return _current< _items.length;
		}

		@Override
		public T1 next() {
			_current++;
			
			return _items[convert(_current)];
		}
		
	}
}


