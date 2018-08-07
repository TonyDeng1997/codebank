package com.webbertech.crackCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Do this without extra data structure, but using sort
 * */


public class PairWithSum2 {

	class Pair{
		int num1;
		int num2;
		
		public Pair(int a, int b) {
			this.num1 = a;
			this.num2 = b;
		}
	}
	
	//O(nlogn) in sort + O(n)  
    public ArrayList<Pair> findPairs(int[] arr, int sum) {
    	Arrays.sort(arr);
    	int i = 0;
    	int j = arr.length-1;
    	ArrayList<Pair> list = new ArrayList<>();
    	while(i<=j) {
    		if (arr[i] + arr[j] < sum) {
    			i++;
    		} else if (arr[i] + arr[j] > sum) {
    			j--;
    		}  else {
    			list.add(new Pair(arr[i], arr[j]));
    			j--;
    		}
    	}
    	return list;
    }
	
	
	
	//{0,4,1,2,1,1,2,4}
	public static void main(String[] args) {
		PairWithSum2 pws = new PairWithSum2();
		int[] arr1 = {0,4,1,2,1,1,2,4};		
		List<Pair> pairs = pws.findPairs(arr1,4);
		
		for(Pair p: pairs) {
			System.out.println(p.num1 + " " + p.num2);
		}
	}
	
	
}
