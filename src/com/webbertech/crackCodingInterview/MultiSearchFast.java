package com.webbertech.crackCodingInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*P578
 * Given a string b and an array of smaller strings T. Design a method to search b for each small string
 * in T.
 * 
 * Input: T = {"is", "ppi", "hi", "sis", "i", "ssippi"}
 *        b = "mississipi"
 *        
 * This question is to find out each small string in T's starting index in b.
 * Easiest way is brute force string matching. 
 * 
 *  k is the length of the longest string in T.
 *  b is the length of b
 *  t is the number of strings in T
 *  
 *  Brute force is O(kbt)
 * 
 *  In this solution it is going to use Trie. The complexity will be O(bk+kt)
 * */

class TrieNode {
	private HashMap<Character, TrieNode> children;
	private ArrayList<Integer> indexes;
	private char value;
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		indexes = new ArrayList<Integer>();
	}
	
	public void insertString(String s, int index) {
		indexes.add(index);
		if (s!=null && s.length() > 0) {
			value = s.charAt(0);
			TrieNode child = null;
			if (children.containsKey(value)) {
				child = children.get(value);
			} else {
				child = new TrieNode();
				children.put(value,child);
			}
			String remainder = s.substring(1);
			child.insertString(remainder, index+1);			
		} else {
			children.put('\0', null);
		}
	}
	
	public ArrayList<Integer> search(String s) {
		if (s==null || s.length() ==0) {
			return indexes;
		} else {
			char first = s.charAt(0);
			if (children.containsKey(first)) {
				String remainder = s.substring(1);
				return children.get(first).search(remainder);
			}
		}
		return null;
	}
	
	public boolean terminate() {
		return children.containsKey('\0');
	}
	
	public TrieNode getChild(char c) {
		return children.get(c);
	}
}

class Trie {
	private TrieNode root = new TrieNode();
	
	public Trie(String s) {
          insertString(s,0);		
 	}
	
	public ArrayList<Integer> search(String s) {
		return root.search(s);
	}
	
	public TrieNode getRoot() {
		return root;
	}
	
	public void insertString(String s, int location) {
		root.insertString(s, location);
	}
}

class HashMapList<T, E> {
	HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();
	
    public void put(T key, E item) {
    	if (!map.containsKey(key)) {
    		map.put(key, new ArrayList<E>());
    	}
    	
    	map.get(key).add(item);
    }
    
    public void put(T key, ArrayList<E> items) {
    	map.put(key, items);
    }
    
    public ArrayList<E> get(T key) {
    	return map.get(key);
    }
    
    public boolean containsKey(T key) {
    	return map.containsKey(key);
    }
    
    public boolean containsKeyValue(T key, E value) {
    	ArrayList<E> list = get(key);
    	if (list == null) return false;
    	return list.contains(value);
    }
  
    public Set<T> keySet() {
    	return map.keySet();
    }
    
    @Override
    public String toString() {
    	return map.toString();
    }
} 

public class MultiSearchFast {
  
	HashMapList<String, Integer> searchAll(String big, String[] smalls) {
		HashMapList<String, Integer> lookup  = new HashMapList<String, Integer>();
		TrieNode root = createTreeFromStrings(smalls, maxLen).getRoot();
		
		for(int i=0; i< big.length();i++) {
			ArrayList<String> strings = findStringAtLoc(root, big, i);
			insertIntoHashMap(strings, lookup, i);
		}
		return lookup;
	}
	
	// insert each string into trie (provided string is not longer than maxLen)
	Trie createTreeFromStrings(String[] smalls, int maxLen) {
		Trie tree = new Trie("");
		for(String s: smalls) {
			if (s.length() <= maxLen) {
				tree.insertString(s,0);
			}
		}
		return tree;
	}
	 
	// Find strings in trie that start at index "start" within big
	ArrayList<String> findStringAtLoc(TrieNode root, String big, int start) {
		ArrayList<String> strings = new ArrayList<>();
		int index = start;
		while (index < big.length()) {
			root= root.getChild(big.charAt(index));
			if (root == null) 
				break;
			if (root.terminate()) {
				//is complete string, add to list
				strings.add(big.substring(start, index+1));
			}
			index++;
		}
		return strings;
	}
	
	public static void main(String[] args) {
		
	}
}

