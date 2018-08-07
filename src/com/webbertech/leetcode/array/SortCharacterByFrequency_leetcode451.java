package com.webbertech.leetcode.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


/*
 * Leetcode 451 Sort Characters By Frequency  
 * 
 * Given a string, sort it in decreasing order based on the 
 * frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. 
Therefore "eetr" is also a valid answer.

Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

*/

public class SortCharacterByFrequency_leetcode451 {

	/*
	 * 1/ We could build a freqency map by O(n), 
	 * 2/ Sort values in the map O(nlogn), treeMap?
	 * 
	 * static <K,V extends Comparable<? super V>>
	SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
        new Comparator<Map.Entry<K,V>>() {
            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                int res = e1.getValue().compareTo(e2.getValue());
                return res != 0 ? res : 1;
            }
        }
    );
    sortedEntries.addAll(map.entrySet());
    return sortedEntries;
   }
   
   see the following implementation using priority queue.
   
	 * 3/ Generate the string based on the map.
	 * */
	
	
	// Solution1, nlogn using priority queue
	public static String frequencySort(String s) {
		   Map<Character, Integer> map = new HashMap<>();
	        for (char c : s.toCharArray()) {
	            if (map.containsKey(c)) {
	                map.put(c, map.get(c) + 1);
	            } else {
	                map.put(c, 1);
	            }
	        }
	        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
	            new Comparator<Map.Entry<Character, Integer>>() {
	                @Override
	                public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
	                    return b.getValue() - a.getValue();
	                }
	            }
	        );
	        pq.addAll(map.entrySet());
	        StringBuilder sb = new StringBuilder();
	        while (!pq.isEmpty()) {
	            Map.Entry e = pq.poll();
	            for (int i = 0; i < (int)e.getValue(); i++) {
	                sb.append(e.getKey());
	            }
	        }
	        return sb.toString();
	}
	
	//solution2: O(n) using bucket sort
	
	public static String frequencySortII(String s) {
		
		// build a map
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        /* Core logic, use an array of list, for the characters that have 
         * the same frequency, they will be put in one bucket.
         * For example, tree, t=1, r=1, e=2, then t,r is in one bucket.
         * the length of the array is length+1, the reason is that,
         * eeee, e=4, then it will be n[4], then the length is from 0-5, which is 5.
         * That is length+1. 
         * */ 
        List<Character> [] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >=0; pos--) {
            if (bucket[pos] != null) {
                for (char num : bucket[pos]) {
                    for (int i = 0; i < map.get(num); i++) {
                        sb.append(num);
                    }
                }
            }
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		System.out.println(frequencySortII("tree"));
	}
}
