package com.webbertech.crackCodingInterview;

//P398
/*Given a sorted array and rotated it many times so it looks like:
 15, 16, 19 ,20, 25, 1, 3, 4,5,7,10,14, also assuming the sorted array is in increasing order

* Input: 5, ouput: 8 (the index of 5 in the array)
* 
* solution: use a modified binary search
* 
*  Use two arrays to demo the algorithm
*  
*  array1: {10, 15, 20, 0, 5}, 
*  array2: {50, 5, 20, 30, 40}
*  search for 5
*  
*  1/ find the mid element, and see if it matches
*  2/ if not, check the first element in the left say A
*  3/ if A > mid-1, the right subarray is in order and check if mid+1 < 5 use binary search 
*      right sub arrray, else search left
*  4/ if A < num < mid-1 , then search left
*/

//TODO, replace the linearSearch, and try to use the binary search 
public class SearchRotatedArray {

	int getIndex(int[] data, int num) {
		int mid = data.length/2;
		int index =0;
		if (data[mid] == num) {
			return mid;
		} else if (data[0] > data[mid-1] ) {
			if ( data[mid+1] > num || data[data.length-1] < num ) {
				//this left subarray is not binary array
				index= linearSearch(data,0,mid-1, num);
			} else {
				//search right using binary search
				index = binarySearch(data, mid+1,data.length-1, num);
			} 
		} else if (data[0]<= data[mid-1]) {
			if (data[0] > num) {
				//search right
				index= linearSearch(data, mid+1, data.length-1, num);
			} else {
				//search left in binary search
				index= binarySearch(data, 0, mid-1, num);
			}
		}
		return index;
	}
	
	int linearSearch(int[] data, int left, int right, int num) {
		int i = 0;
		for (i=left; i<=right;i++) {
			if(data[i] == num)
			 break;
		}
		return i;
	}
	
	int binarySearch(int[] data, int left, int right, int num) {
		int mid = (right+left)/2;
		if (data[mid] == num) {
			return mid;
		} else if (data[mid] > num ) {
			return binarySearch(data, left, mid-1, num);
		} else {
			return binarySearch(data, mid+1, right, num);
		}
	}
	
	public static void main(String[] args) {
		SearchRotatedArray s = new SearchRotatedArray();
		/*
		int[] data ={1,2,3,4,5,6,7,8,9,10};
		System.out.println(s.binarySearch(data, 0, 9, 3));
		System.out.println(s.linearSearch(data, 0, 9, 3));
		*/
		int[] data1 = { 15, 16, 19 ,20, 25, 1, 3, 4,5,7,10,14};
		System.out.println(s.getIndex(data1, 3));
		
		int[] data2 ={2,2,2,3,4,2};
		System.out.println(s.getIndex(data2, 2));
		
	}
}
