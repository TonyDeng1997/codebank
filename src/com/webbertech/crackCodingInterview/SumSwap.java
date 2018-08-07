package com.webbertech.crackCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * {4,1,2,1,1,2}, {3,6,3,3}, two array, swap a pair (each from each array) to make both array's sum 
 * equal
 * 
 * simple: diff is 4: find a pair that sum to 4. Use hash set
 * */

public class SumSwap {
	
	class Pair{
		int num1;
		int num2;
		
		public Pair(int a, int b) {
			this.num1 = a;
			this.num2 = b;
		}
	}
	
	public Pair get(int[] arr1, int[] arr2) {
	   int sum1 =0, sum2=0;
	   for(int i=0;i<arr1.length;i++) {
		   sum1+= arr1[i];
	   }
	   
	   for (int j=0; j< arr2.length;j++) {
		   sum2+= arr2[j];
	   }
	   
	   int diff = Math.abs(sum1-sum2);
	   List<Integer> list = new ArrayList<>();
	   for(int i=0; i < arr1.length;i++) {
		   list.add(arr1[i]);
	   }
	   
	   for (int j=0;j< arr2[j];j++) {
		   if (list.contains(diff-arr2[j])) {
			   return new Pair(arr2[j],diff-arr2[j]);
		   }
	   }
	   
	   return null;
	}  
	
	public static void main(String[] args) {
		SumSwap ss = new SumSwap();
		int[] arr1 = {4,1,2,1,1,2};
		int[] arr2 = {3,2,6,3,3};
		Pair p = ss.get(arr1, arr2);
		System.out.println(p.num1 + " " + p.num2 );
	}
  
}
