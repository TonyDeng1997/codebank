package com.webbertech.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;

/* give two integer arrays, get all pairs which sums to less than K = 5
 * O(M*LogN) solution
 */

public class SumLessThanK {

	 class Node {
		 int first;
		 int second;
		 Node(int first, int second) {
			 this.first = first;
			 this.second = second;
		 }
	 }
	
	  ArrayList<Node> findPairs(int[] a1, int[] a2, int k) {
		 //Arrays.sort(a1); to optimize remove this line
		  Arrays.sort(a2);
		 int result = 0;
		 ArrayList<Node> list = new ArrayList<>();
		 for(int i=0;i<a1.length;i++) {
			 int index = Arrays.binarySearch(a2, k-a1[i]); //it is not responsible for sorting.
			 if (index >= 0) {
				 result += index;
			 } else {
				 //Arrays.binarySearch will return index = -insertionPoint-1
				 // insertionPoint = index+1
				 // result = result - insertionPoint = result -1-index, toDo think through this
				 result = result-1-index;
				 if (-(index+1) >0) {
					 addNodes(list, a1, i, a2, -(index+1));
				 }
				 
			 }
		 }
		 //return result
		 return list;
	 }
	 
	  //add the pair a[i] and all the nodes from a2[0] to a2[index] because a2 is sorted
	  void addNodes(ArrayList<Node> list, int[] a1, int i, int[] a2, int index) {
		  for (int j =0; j< index; j++) {
			  list.add(new Node(a1[i], a2[i]));
		  }
	  }
	 
	 public static void main(String[] args) {
		 int[] a1 = {2,4,1,1, 5,6};
		 int[] a2 = {3, 5, 1, 7, 9}; 
		 SumLessThanK s = new SumLessThanK();
		 System.out.println(s.findPairs(a1, a2, 5).size());
	 }
}