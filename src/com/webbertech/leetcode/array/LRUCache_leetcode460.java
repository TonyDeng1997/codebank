package com.webbertech.leetcode.array;

import java.util.ArrayList;

/* Leetcode 460  

Design and implement a data structure for Least Frequently Used (LFU) cache. 
It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists 
in the cache, otherwise return -1.

put(key, value) - Set or insert the value if the key is not already present. 
When the cache reaches its capacity, it should invalidate the least frequently 
used item before inserting a new item. For the purpose of this problem, when 
there is a tie (i.e., two or more keys that have the same frequency), the least 
recently used key would be evicted.

Follow up:
Could you do both operations in O(1) time complexity?

Example:
LFUCache cache = new LFUCache(2); // capacity
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 * 
 * Solution:
 * 
 * About LRU, https://www.cs.jhu.edu/~yairamir/cs418/os6/sld020.htm
 */
class LRUNode {
	int key;
	int value;
	LRUNode prev;
	LRUNode next;
	
	public LRUNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

/*Solution1: use a linklist/arraylist to maintain the cache, 
keep the newly added element in the head, and the least used in the tail.
the list 's element is a class object node contain key and value.
Always had the most recent node in the head and keep the least recently used in the tail.
*/
public class LRUCache_leetcode460 {
	LRUNode head = null;
	LRUNode tail = null;
	int size =0;
	int capacity=0;
	public LRUCache_leetcode460(int capacity) {
        this.capacity = capacity;
        head = new LRUNode(-1,-1);
    }
    
    public int get(int key) {
        LRUNode curr = head;
        while(curr!=null) {
        	if (curr.key == key) {
        		return head.value;
        	} 
            curr = curr.next;		
        }
        return -1;
    }
    
    public void put(int key, int value) {
    	// if it does not exist, page fail, then add it to the head of the list
        if (get(key) == -1 && this.size< this.capacity) {
        	LRUNode curr = head;
        	LRUNode temp = curr.next;
        	LRUNode node = new LRUNode(key,value);
        	node.prev = curr;
        	curr.next = node;
        	node.next = temp;
        	size++;
        }
        
        // page hit, then move that node to the front
        if (get(key) != -1 && this.size <= this.capacity) {
        	LRUNode curr = head;
        	while(curr!=null) {
        		if (curr.key == key) {
        			break;
        		}
        	}
        	
        	LRUNode rest = head;
        	curr.next = rest;
        	rest.prev = curr.next;
        	head = curr;
        }
        
        //replace the tail with the current node
        if (this.size > this.capacity) {
        	LRUNode node = new LRUNode(key,value);
        	tail.prev.next = node;
        	node.prev = tail.prev;
        	tail = node;
        }
    }
    
    public static void main(String[] args) {
    	LRUCache_leetcode460 cache = new LRUCache_leetcode460(2); // capacity
    	cache.put(1, 1);
    	cache.put(2, 2);
    	int res= cache.get(1);       // returns 1
    	System.out.println(res);
    	cache.put(3, 3);    // evicts key 2
    	res = cache.get(2);       // returns -1 (not found)
    	System.out.println(res);
    	res = cache.get(3);       // returns 3.
    	System.out.println(res);
    	cache.put(4, 4);    // evicts key 1.
    	res = cache.get(1);       // returns -1 (not found)
    	System.out.println(res);
    	res = cache.get(3);       // returns 3
    	System.out.println(res);
    	res = cache.get(4);       // returns 4
    	System.out.println(res);

    }
}
