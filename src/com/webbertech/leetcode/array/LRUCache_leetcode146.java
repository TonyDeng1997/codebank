package com.webbertech.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*Leetcode 146
 * 
 *  Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item. 

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

Solution: 
Keep a map to make put and get in O(1). Use a linklist/queue/Deque/Arraylist
to maintain the window size and make sure that:

1/ if it is oversize, the head element in the list will be removed.
2/ otherwise it is added to the map and list. New element is added to the tail of the list.
   Thus this list servers like a queue. Last in First Out.
3/ For the get method, if it is in the list already, then remove from the list, 
and add it back to the tail of the list.
 * */
public class LRUCache_leetcode146 {
	Map<Integer, Integer> map;
	Deque<Integer> list;
	int max;

	public LRUCache_leetcode146(int capacity) {
		max = capacity;
		map = new HashMap<>();
		list = new ArrayDeque<>(capacity);
	}

	//get operation will move the element to the tail of the list
	public int get(int key) {
		if (map.containsKey(key)) {
			int value= map.get(key);
			//remove the object from the list and add it to the tail
			list.remove(key);
			list.offer(key);
			return value;
		}
		return -1;
	}

	
	// Use a list to keep the LRU
	public void put(int key, int value) {
		if (map.containsKey(key)) {
			//Remove from the list because we will update the key in the window to the front of the list
			list.remove(key);
		}

		// if oversize, invalidate the
		while (list.size() >= max) {
			Integer oldkey = list.poll(); // remove the oldest in the head from the list
			if (null != oldkey) {
				map.remove(oldkey);
			}
		}

		list.offer(key);
		map.put(key, value);
	}

	public static void main(String[] args) {
		LRUCache_leetcode146 cache = new LRUCache_leetcode146(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
	}
}
