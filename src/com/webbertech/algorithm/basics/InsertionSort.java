package com.webbertech.algorithm.basics;

public class InsertionSort {

	// pretty simple
	public static void insertionSort(int array[]) {  
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }  
    }  

	public static void main(String a[]) {
		//int[] arr1 = { 9, 14, 3, 2, 43, 11, 58, 22 };
		int[] arr1 = {3,2,1};
		System.out.println("Before Selection Sort");
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		System.out.println();

		insertionSort(arr1);// sorting array using selection sort

		System.out.println("After Selection Sort");
		for (int i : arr1) {
			System.out.print(i + " ");
		}
	}
}