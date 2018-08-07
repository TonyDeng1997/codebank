package com.webbertech.algorithm.basics;

import java.util.ArrayList;
import java.util.List;

/*
 * Implement a hashtable
 * Using linkedlist/chaining to handle collisions
 * 
 * int hashCodeOfKey(K key) {
 *   return key.toString().length() % items.length; 
 * }
 * 
 *   jim and bob will map to the same 
 *   key, and it is very hard to align the value of "jim" and job in which node in 
 *   the list.  
 *   So what we are gonna have is the linkedlist of a cell
 **/

class Node<K, V> {
	K key;
	V val;
	Node<K, V> prev;
	Node<K, V> next;

	Node(K k, V v) {
		key = k;
		val = v;
	}
}

/*
 * The idea is to use a ArrayList to simplify the design. Normally it can use an
 * array and it reqires dynamically handle the size
 */

public class Hashtable<K, V> {
	ArrayList<Node<K, V>> list;

	// fill the array with null at the size of capacity
	public Hashtable(int capacity) {
		list = new ArrayList<>();
		list.ensureCapacity(capacity);
		for (int i = 0; i < capacity; i++) {
			list.add(null);
		}
	}
	
	// The same key decides the bucket, and in that index, there is a linklist to handle 
	// collided elements that with the same key but different values.
	private Node<K, V> getNodeForKey(K key) {
		int index = getIndexForKey(key);
		Node<K, V> res = list.get(index);
		// since we find the node, we still want to make sure that
		// the node contains the key, or there is a collision that
		// it does not contain the key, then we will search the linklist
		// for the right node
		while (res != null) {
			if (res.key == key) {
				return res;
			}
			res = res.next;
		}
		return null;
	}

	/*
	 * hash function, the core in this design Hash collision might 
	 * still exist.
	 */
	private int getIndexForKey(K key) {
		return key.hashCode() % list.size();
	}

	// If node exists, update the node value,
	// if does not exist, then find the index and
	// find the existing node in this index,
	// and link the new node to the existing node.
	void put(K k, V v) {
		Node<K, V> n = getNodeForKey(k);
		if (n != null) {
			n.val = v; // update the node
		} else {
			int index = getIndexForKey(k);
			Node<K, V> newNode = new Node<K, V>(k, v);
			Node<K, V> ext = list.get(index);

			// if there is a collision, then link the node to
			// the existing node.
			if (ext != null) {
				ext.next = newNode;
				newNode.prev = ext;
			} else {
				list.set(index, newNode);
			}
		}
	}

	public V getValue(K k) {
		Node<K, V> res = getNodeForKey(k);
		if (res != null) {
			return res.val;
		}
		return null;
	}

	public void remove(K key) {
		Node<K, V> n = getNodeForKey(key);

		if (n != null) {
			n.prev.next = n.next;
		} else {
			// No head node
			// it is the head node then set it
			list.set(getIndexForKey(key), n);
		}
	}

	public static void main(String[] args) {
		// test the hashcode
		// System.out.println("jim".hashCode());
		// System.out.println("bob".hashCode());

		Hashtable<Integer, String> t = new Hashtable<>(10);
		t.put(1, "xiaofeng");
		t.put(2, "li");
		t.put(3, "lin");
		t.put(4, "wang");

		System.out.println(t.getValue(1));
		System.out.println(t.getValue(3));
	}
}