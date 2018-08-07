package com.webbertech.crackCodingInterview;

/*P578
 * Given a string b and an array of smaler strings T. Design a method to search b for each small string
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
 *  In this solution it is going to use Trie. The complexity will be O(b^2+kt)
 * */


public class MultiSearchMediumFast {

}
