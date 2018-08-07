package com.webbertech.crackCodingInterview;

import java.util.ArrayList;
import java.util.List;



//{0,4,1,2,1,1,2}, find all pairs that sum to 4
//solution: use hash map or ArrayList
public class PairWithSum {

	class Pair{
		int num1;
		int num2;
		
		public Pair(int a, int b) {
			this.num1 = a;
			this.num2 = b;
		}
	}
	
	public List<Pair> get(int[] arr1,int sum) {
	   
	   List<Integer> list = new ArrayList<>();
	   List<Pair> pairs = new ArrayList<>();
	   for(int i=0;i<arr1.length;i++) {
		   list.add(arr1[i]);
	   }
	   
	   for (int j=0;j< arr1.length;j++) {
		   if (list.contains(sum-arr1[j])) {
			   pairs.add(new Pair(arr1[j],sum-arr1[j]));
		   }
	   }
	   
	   return pairs;
	}
	
	//{0,4,1,2,1,1,2}
	public static void main(String[] args) {
		PairWithSum pws = new PairWithSum();
		int[] arr1 = {0,4,1,2,1,1,2};		
		List<Pair> pairs = pws.get(arr1,4);
		
		for(Pair p: pairs) {
			System.out.println(p.num1 + " " + p.num2);
		}
	}
}
