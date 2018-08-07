package com.webbertech.algorithm.basics;

public class MergeSort {
    /* divide and conquer
     * Step 1 âˆ? if it is only one element in the list it is already sorted, return.
	   Step 2 âˆ? divide the list recursively into two halves until it can no more be divided.
	   Step 3 âˆ? merge the smaller lists into new list in sorted order.
     * */
	
	//make sure of helper array
	private static int[] helper;
	
	static void mergeSort(int[] a) {
		 //initialized a helper array
		 helper = new int[a.length];
         mergeSort(a, 0, a.length - 1);
	} 
	
	
	//recursive divide it to subarray, until it is 2 elements
	static void mergeSort(int[] a, int low, int high) {
    	if (low < high) {
               // Get the index of the element which is in the middle
               int middle = low + (high - low) / 2;
               // Sort the left side of the array
               mergeSort(a, low, middle);
               // Sort the right side of the array
               mergeSort(a, middle + 1, high);
               // Combine them both
               merge(a, helper, low, middle, high);
       }
    }
    
	private static void merge(int[] numbers, int[] helper, int low, int middle, int high) {
        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
                helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from 
        // either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
                if (helper[i] <= helper[j]) {
                        numbers[k] = helper[i];
                        i++;
                } else {
                        numbers[k] = helper[j];
                        j++;
                }
                k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
                numbers[k] = helper[i];
                k++;
                i++;
        }
    }
	
	public static void main(String[] args) {
		int[] a = {6,5,4,3,2,1};
		mergeSort(a);
		DemoSimulation.displayArray(a);
	}
}