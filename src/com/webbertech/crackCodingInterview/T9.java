package com.webbertech.crackCodingInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*P505  need to read this solution carefully
 * 
 * 1   2     3
 *     abc   def
 * 4    5     6
 * ghi  jkl  mno
 * 7	8		9
 * pqrs tuv	   wxyz
 * 
 * This is old cell phone keyboard. Use whatever data structure to implement:
 * given a list of numbers to list all the matching words
 * 
 *  input: 8733
 *  output: tree, used
 *  
 *  
 *  solution 1, and 2 are brute force and Trie, both are using recursion.
 *              These are more complicated but it worths reading. (Need to revisit the other two methods)
 *  
 *  Solution 3 which is the following, is to use hashmap
 */
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

public class T9 {
	//solution 1 brute force, so 3^4 combinations and match to see there is a word for it
	//solution 2, dictionary lookup, precompute word with numbers and put in a map
	
	//main method to lookup a number to get a list of words
	public ArrayList<String> getValidT9Words(String numbers, HashMapList<String, String> dictionary) {
		
		return dictionary.get(numbers);
    }

	//build a hash map that key: numbers and values is a list of words
	
	public HashMapList<String, String> buildDictionary(String[] words) {
		HashMapList<String, String> dictionary = new HashMapList<String, String>();
		for (String word : words) {
			String number = getNumberFromWord(word);
			dictionary.put(number, word);
		}
		return dictionary;
	}
		
	
	public String getNumberFromWord(String word) {
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Character> letterMap = createLetterToNumberMap();
		for(char c: word.toCharArray()) {
			if (letterMap.containsKey(c)) {
				sb.append(letterMap.get(c));
			}
		}
		return sb.toString();
	}
		
    public HashMap<Character, Character> createLetterToNumberMap() {
    	 HashMap<Character, Character> numberToLetterMap = new  HashMap<Character, Character>();
    	 numberToLetterMap.put('a', '2');
    	 numberToLetterMap.put('b', '2');
    	 numberToLetterMap.put('c', '2');
    	 numberToLetterMap.put('d', '3');
    	 numberToLetterMap.put('e', '3');
    	 numberToLetterMap.put('f', '3');
    	 numberToLetterMap.put('g', '4');
    	 numberToLetterMap.put('h', '4');
    	 numberToLetterMap.put('i', '4');
    	 numberToLetterMap.put('j', '5');
    	 numberToLetterMap.put('k', '5');
    	 numberToLetterMap.put('l', '5');
    	 numberToLetterMap.put('m', '6');
    	 numberToLetterMap.put('n', '6');
    	 numberToLetterMap.put('o', '6');
    	 numberToLetterMap.put('p', '7');
    	 numberToLetterMap.put('q', '7');
    	 numberToLetterMap.put('r', '7');
    	 numberToLetterMap.put('s', '7');
    	 numberToLetterMap.put('t', '8');
    	 numberToLetterMap.put('u', '8');
    	 numberToLetterMap.put('v', '8');
    	 numberToLetterMap.put('w', '9');
    	 numberToLetterMap.put('x', '9');
    	 numberToLetterMap.put('y', '9');
    	 numberToLetterMap.put('z', '9');
    	 return numberToLetterMap;
    }

	
	public static void main(String[] args) {
		T9 t9= new T9();
		String[] words = {"tree", "used"}; // should be 8733 , debug to verify this
		t9.buildDictionary(words);
		ArrayList<String> list = t9.getValidT9Words("8733", t9.buildDictionary(words));
		for(String word: list) {
			System.out.println(word);
		}
	}
	
	
}
