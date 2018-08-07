package com.webbertech.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


//https://www.careercup.com/question?id=17230678

/*
 * Here the map is the buffer frame, size you can set it
 * the queue is to used to save the page requests that is in the past
 * 
 * Solution: Similar to solution3, changed from concurrent map to HashMap, passed the test.
 * 
 * The idea is to have a hashmap with a doubly linklist.
 * This is normally achieved by using a hashmap and a linkedlist/ArrayDeque.
 * 
 * Now the window size is maintained by the map, and query is maintained by the map.
 * The Key and Value is String, Integer of the page number,
 * like map.put("7", 7).
 * 
 * Varied from solution3, it is using ArrayDeque and HashMap.
 * */


public class LRUCache4 <Key, Value> {
	    private final int maxSize;
		private Map<Key, Value> map;
		private Deque<Key> queue;
		 
		public LRUCache4(final int maxSize) {
		    this.maxSize = maxSize;
		    map = new HashMap<Key, Value>(maxSize);
		    queue = new ArrayDeque<Key>();
		}
		 
		/**
		 * @param key - may not be null!
		 * @param value - may not be null!
		 */
		public void put(final Key key, final Value value) {
		   
			// for existing one, it means a page hit not failed,
			// so remove it from the queue as we want to make sure that
			// the new element is in the tail of the queue.
			// finally we will add it to the tail 
			if (map.containsKey(key)) {
		        queue.remove(key); // remove the key from the FIFO queue
		    }
		 
		    //invalidate the old if the window size is full
		    //remove both from queue 's head and map.
		     
		    while (queue.size() >= maxSize) {
		        Key oldestKey = queue.poll();
		        if (null != oldestKey) {
		            map.remove(oldestKey);
		        }
		    }
		    
		   //then add the new one to the head of the queue
		    queue.add(key); //ArrayDeque is FIFO, poll() and offer() is used for that
		    map.put(key, value);
		}
		 
		/**
		 * @param key - may not be null!
		 * @return the value associated to the given key or null
		 */
		public Value get(final Key key) {
		    return map.get(key);
		}
	
		/*
		public void showBufferFrame() {
			Set<HashMap.Entry<Key, Value>> m = map.entrySet();
			System.out.println(((HashMap.Entry<Key, Value>) m).getKey() + " " +
			   ((HashMap.Entry<Key, Value>) m).getValue());
		}
		*/
		public void showBufferFrame() {
			Set<Map.Entry<Key, Value>> m = map.entrySet();
			Iterator<Value> it = map.values().iterator();
			while (it.hasNext()) {
				System.out.print (it.next() + "\t");
			}
			System.out.println();
		}
		
		
	public static void main(String[] args) {
		LRUCache4 lruCache = new LRUCache4(3);
		lruCache.put("7", 7);
		lruCache.put("0", 0);
		lruCache.put("1", 1);
		lruCache.showBufferFrame();
		
		lruCache.put("2", 2);
		lruCache.showBufferFrame();
		lruCache.put("0", 0);
		lruCache.showBufferFrame();
		lruCache.put("3", 3);
		lruCache.showBufferFrame();
		lruCache.put("0", 0);
		lruCache.showBufferFrame();
		lruCache.put("4", 4);
		lruCache.showBufferFrame();
		lruCache.put("2", 2);
		lruCache.showBufferFrame();
		lruCache.put("3", 3);
		lruCache.showBufferFrame();
		lruCache.put("0", 0);
		lruCache.showBufferFrame();
		lruCache.put("3", 3);
		lruCache.showBufferFrame();
		lruCache.put("2", 2);
		lruCache.showBufferFrame();
		lruCache.put("1", 1);
		lruCache.showBufferFrame();
		lruCache.put("2", 2);
		lruCache.showBufferFrame();
	}

}