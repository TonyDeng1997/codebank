package com.webbertech.crackCodingInterview;

import java.util.Arrays;

/*P414
 * 
 * In an integer array, if a number is greater than the adjacent numbers, it is called a peak,
 * if it is smaller than the adjacent numbers, it is called a called a valley.
 * Given an array write a method to alternate the numbers with peak and valley.
 * 
 * Input: {5,3,1,2,3}
 * Output: {5,1,3,2,3}
 */
public class PeaksAndValleys {
	
	/*Solution1: O(nlogn)
	 * 1/ Sort the array
	 * 2/ Swap every two numbers. 
	 * */
	
	void sortValleyPeak(int[] array) {
		Arrays.sort(array);
		for(int i=1;i<array.length;i+=2) {
			//if (i == array.length-2) break; //not even numbers in the array
			swap(array, i, i-1);
		}
	}
	
	void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	
	//solution 2: P415
	  /*
     * The core algorithm is to take 3 numbers, and swap i and max(i-1, i, i+1), 
     * thus i starts from 1.
     * */
    void sortValleyPeak1(int[] array) {
            for(int i=1;i<array.length;i+=2) {
                    int biggestIndex = maxIndex(array, i-1, i, i+1);
                    if (i != biggestIndex) {
                            swap(array, i, biggestIndex);
                    }
            }
    }

    int maxIndex(int[] array, int a, int b, int c) {
            int len= array.length;

            int aValue = a >=0 && a < len ? array[a] : Integer.MIN_VALUE;
            int bValue = a >=0 && a < len ? array[b] : Integer.MIN_VALUE;
            int cValue = a >=0 && a < len ? array[c] : Integer.MIN_VALUE;

            int max = Math.max(aValue, Math.max(bValue, cValue));
            if (aValue == max) return a;
            else if (bValue == max) return b;
            else return c;
    }
	
	public static void main(String[] args) {
		int[] array = {5,3,1,2,3};
		PeaksAndValleys p = new PeaksAndValleys();
		p.sortValleyPeak(array);
		for(int num: array) {
			System.out.println(num);
		}
	}
}