package com.webbertech.leetcode.tree;

/*
 * Leetcode 208 Implement Trie (Prefix Tree)
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * solution:
 * 
 * each node has 26 nodes array, and its only char value.
 * Root is normally with char = '' to start with.
 * The whole word is to find the node, and make next root to be the node's next.
 * 1/ for insert, don't forget to set the last node's isWord to true.
 * 2/ search vs prefix is that search returns last node's isWord
 * 
 * */

public class TrieImpl_leetcode208 {

	 private TrieNode root;
	    
     class TrieNode {
        char val;
        TrieNode[] nodes;
        boolean isWord;
        
        TrieNode(char s) {
            val = s;
            nodes = new TrieNode[26];   
        }
    }

    
    /** Initialize your data structure here. */
    public TrieImpl_leetcode208() {
        root = new TrieNode(' '); // init root node.    
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
         TrieNode ws = root;
         
          for(int i=0;i<word.length();i++) {
              char c = word.charAt(i);
              if (ws.nodes[c-'a'] == null) {
                  
                  ws.nodes[c-'a'] = new TrieNode(c);
              }        
              ws = ws.nodes[c-'a'];
          }        
          ws.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
       
        TrieNode ws = root;
         for(int i=0;i<word.length();i++) {
             char c = word.charAt(i);
           if (ws.nodes[c-'a']==null) {
               return false;
           } 
           
           ws = ws.nodes[c-'a'];
             
         }
         
         return ws.isWord;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
         for(int i=0;i<prefix.length();i++) {
             char c = prefix.charAt(i);
           if (ws.nodes[c-'a']==null) {
               return false;
           } 
           
           ws = ws.nodes[c-'a'];
             
         }
         
         return true;
    }

    public static void main(String[] args) {
    	TrieImpl_leetcode208 obj = new TrieImpl_leetcode208();
    	 String word = "a";
    	 String prefix = "a";
    	  obj.insert(word);
    	  boolean param_2 = obj.search(word);
    	 boolean param_3 = obj.startsWith(prefix);
    	 System.out.println(param_2);
    	 System.out.println(param_3);
    	
    }
}
