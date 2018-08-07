package com.webbertech.algorithm.hashtable;
/*
 * use an ArrayList to store linkedlist, just like using array,
 * use doubly linkedlist
 * */
import java.util.ArrayList;
public class LinkedListHashtable<K, V> {
   
	//node for implement a linkedlist
    private static class LinkedListNode<K,V> {
    	public LinkedListNode<K,V> next;
    	public LinkedListNode<K,V> prev;
    	public K key;
    	public V value;
    	
    	public LinkedListNode(K k, V v) {
    		this.key = k;
    		this.value = v;
    	}
    }
    
    private ArrayList<LinkedListNode<K,V>> arr;
    
    public LinkedListHashtable(int capacity) {
    	//use ArrayList as a list to store linkedlists at any size   	
    	arr = new ArrayList<LinkedListNode<K,V>>();
    	arr.ensureCapacity(capacity);   //optional optimization
    	
    	//is this necessary
    	for (int i=0; i< capacity; i++) {
    		arr.add(null);
    	}
   }
    
    //core method
    public void put(K key, V value) {
	   
		//if node exits, just update its value
		LinkedListNode<K,V> node = getNodeForKey(key);
		if (node!=null) {
			node.value = value;
			return;
		}
		
		//try to understand the structure of the hashtable
		node = new LinkedListNode<>(key,value);
		int index = this.getIndexForKey(key);
		if (arr.get(index) != null) {
			node.next = arr.get(index);
			node.next.prev = node;
		} 
		arr.set(index, node);
	}

	public V get(K key) { 
		LinkedListNode <K, V> node = getNodeForKey(key);
		
		return node == null? null : node.value;
	}

	 public LinkedListNode<K,V> getNodeForKey(K key) {
		int index = getIndexForKey(key);
		LinkedListNode<K,V> current = arr.get(index);
		while (current != null) {
			if(current.key == key) {
				return current;
			}
			
			current = current.next;
		}
		
		return null;
	}
	
	public void remove(K key) {
		LinkedListNode<K,V> node = getNodeForKey(key);
		if (node.prev != null) {
			 node.prev.next = node.next;
		} else {
			int hashKey = getIndexForKey(key);
			arr.set(hashKey, node.next);
		}
		
		if (node.next != null) {
			node.next.prev = node.prev;
		}
	}
	 
	public int getIndexForKey(K key) {
	     /*
	      * The following hashing will increase large index in the array
	      * 
	      * value: 100 index: 7
			value: 90 index: 5
			value: 10 index: 1
			value: 110 index: 9
			value: 10 index: 9
			value: 99 index: 2
			value: 99 index: 3
	      * 
	      * */
			return Math.abs(key.hashCode() % arr.size());
         
		 /*
		  *  I tried to use bit operation to do the mod, this way I can create more collision, and 
		  *  test linkedlist better
		  *  
		  *  value: 100 index: 1
			 value: 90 index: 1
			 value: 10 index: 1
			 value: 110 index: 9
			 value: 10 index: 1
			 value: 99 index: 8
			 value: 99 index: 1
            return key.hashCode() & (arr.size() -1);
		  */
		
		
		
	}
	
	public static void main(String[] args) {
		LinkedListHashtable<String, Integer> map = new LinkedListHashtable<>(10);
		
		map.put("KING", 100);
		map.put("CLARK", 90);
		map.put("BLAKE",10);
		map.put("FORD",110);
		map.put("SMITH",10);
		map.put("WARD",99);
		map.put("JONES",99);
		
		//see if their index collides, that will be the most interesting part
		System.out.println("value: " + map.get("KING") + " index: " + map.getIndexForKey("KING"));
		System.out.println("value: " + map.get("CLARK") + " index: " + map.getIndexForKey("CLARK"));
		System.out.println("value: " + map.get("BLAKE") + " index: " + map.getIndexForKey("BLAKE"));
		System.out.println("value: " + map.get("FORD") + " index: " + map.getIndexForKey("FORD"));
		System.out.println("value: " + map.get("SMITH") + " index: " + map.getIndexForKey("SMITH"));
		System.out.println("value: " + map.get("WARD") + " index: " + map.getIndexForKey("WARD"));
		System.out.println("value: " + map.get("JONES") + " index: " + map.getIndexForKey("JONES"));
		
    }
}