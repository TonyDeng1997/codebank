package com.webbertech.crackCodingInterview;
/*
 * P400
 * you are given a array-like data structure, which has no size method.
 * But it has elementAt(i) method that returns at O(1). If i is out of bound, it will
 * return -1. Given Listy contains sorted positive integers, find the index at which an
 * element x occurs.
 * 
 * solution 1: if it is linear, this question has no meaning
 * 
 * solution 2: say , 1 2 3 4 5 6 7 8 9 10
 *  search for x = 7, first dont' do increase by 1, that is O(n), 
 *  instead index*=2;, so when list.elementAt(index) == -1 , stop.
 *  search the index/2 to index this range with binary search.
 * */


import java.util.Arrays;
import java.util.List;

public class SortedSearchNoSize {
    static int search(List<Integer> list, int value) {
	   int index = 1;
	   while((Integer)list.get(index) != -1 && (Integer)list.get(index) < value) {
		   index *=2;
	   }
	   //notice index/2
	   return binarySearch(list, value, index/2, index);   
   }
   
   static int binarySearch(List<Integer> list, int value, int low, int high) {
       int mid = (high + low)/2;
       if ((Integer)list.get(mid) == value) {
    	   return mid;
       } 
       if ((Integer)list.get(mid) > value) {
    	   return binarySearch(list, value, low, mid-1);
       } else {
    	   return binarySearch(list,value, mid+1, high);
       }
   }
   
   public static void main(String[] args) {
	    List<Integer> list =  Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	    System.out.println(search(list, 7));
   }
}
