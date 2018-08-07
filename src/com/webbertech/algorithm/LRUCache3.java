package com.webbertech.algorithm;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

//https://www.careercup.com/question?id=17230678

/*
 * Here the map is the buffer frame, size you can set it
 * the queue is to used to save the page requests that is in the past
 * 
 * Tested, working, this is the best option
 * */

public class LRUCache3 <Key, Value> {

	    private final int maxSize;
		private ConcurrentHashMap<Key, Value> map;
		private ConcurrentLinkedQueue<Key> queue;
		 
		public LRUCache3(final int maxSize) {
		    this.maxSize = maxSize;
		    map = new ConcurrentHashMap<Key, Value>(maxSize);
		    queue = new ConcurrentLinkedQueue<Key>();
		}
		 
		/**
		 * @param key - may not be null!
		 * @param value - may not be null!
		 */
		public void put(final Key key, final Value value) {
		    if (map.containsKey(key)) {
		        queue.remove(key); // remove the key from the FIFO queue
		    }
		 
		    while (queue.size() >= maxSize) {
		        Key oldestKey = queue.poll();
		        if (null != oldestKey) {
		            map.remove(oldestKey);
		        }
		    }
		    queue.add(key);
		    //queue.offer(key);
		    map.put(key, value);
		}
		 
		/**
		 * @param key - may not be null!
		 * @return the value associated to the given key or null
		 */
		public Value get(final Key key) {
		    return map.get(key);
		}
	
		public void showBufferFrame() {
			Set<Map.Entry<Key, Value>> m = map.entrySet();
			Iterator<Value> it = map.values().iterator();
			while (it.hasNext()) {
				System.out.print (it.next() + "\t");
			}
			
			System.out.println();
		}
		
	public static void main(String[] args) {
		
		LRUCache3 lruCache = new LRUCache3(3);
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
