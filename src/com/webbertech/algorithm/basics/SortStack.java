package com.webbertech.algorithm.basics;

import java.util.ArrayDeque;
import java.util.Arrays;

//sort a stack and the smallest is on the top
//can not copy to an extra array but you can use extra stack
//stack method includes, push, pop, peek, isEmpty()
//5,3,6,7,1

//the solution is that s1 is unsorted, and eventually we move everything to s2 and make s2 sorted.

public class SortStack {
    
	ArrayDeque<Integer> sort(ArrayDeque<Integer> s1) {
		ArrayDeque<Integer> s2 = new ArrayDeque<Integer>();
		
		while(!s1.isEmpty()) {
			int tmp = s1.pop();
			while (!s2.isEmpty() && s2.peek() > tmp) {
				s1.push(s2.pop());
			}
			s2.push(tmp);
		}
		return s2;
	}
	
	//with extra space is not allowed
	//nlogn solution
    void sort2(ArrayDeque<Integer> s) {
	   Integer[] t = new Integer[s.size()];
	   int i=0;
	   while(!s.isEmpty()) {
		   t[i] =  s.pop();
		   i++;
	   }
	   
	   Arrays.sort(t);
	   
	   for(int elem: t) {
		   s.push(elem);
	   }
	  
	}
	public static void main(String[] args) {
		ArrayDeque<Integer> s = new ArrayDeque<Integer>();
		s.push(5);
		s.push(3);
		s.push(6);
		s.push(7);
		s.push(1);
		SortStack s1 = new SortStack();
		ArrayDeque<Integer> sorted = s1.sort(s);
		
		System.out.println(sorted.pop());
		System.out.println(sorted.pop());
		System.out.println(sorted.pop());
		System.out.println(sorted.pop());
		System.out.println(sorted.pop());
		
	}
}