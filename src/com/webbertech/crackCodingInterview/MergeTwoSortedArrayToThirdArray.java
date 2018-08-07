package com.webbertech.crackCodingInterview;

//this is a simple merge of two integer arrays, this is brain refresher

public class MergeTwoSortedArrayToThirdArray {

	//both are sorted, if not merged, merge them
	static int[] merge(int[] array1, int[] array2) {
		int[] a = new int[array1.length + array2.length];
		int k =0;
		int i =0;
		int j =0;
		while(i < array1.length && j < array2.length) {
				if (array1[i] < array2[j]) {
					a[k] = array1[i];
					i++;
				} else {
					a[k] = array2[j];
					j++;
				}
			k++;
		}
		
		while (i< array1.length) {
			a[k] = array1[i];
			k++;
			i++;
		}
		
		while (j < array2.length) {
			a[k] = array2[j];
			k++;
			j++;
		}
		return a;
	}
	
	
	
	public static void main(String[] args) {
		int[] a1 = {1,3,5,7,9};
		int[] a2 = {2,4,6,8,10,12};
		
		int[] a3 = merge(a1,a2);
		for(int i: a3) {
			System.out.print(i + "\t");
		}
	}
}
