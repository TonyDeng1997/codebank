package com.webbertech.crackCodingInterview;

import java.util.Random;

/*
 * P570 Given an integer array with duplicate elements, find the smallest k elements 
 * 
 * Selection rank algorithm : different from the other rank algorithm.
 * When we partition the array around the pivot, we partition it into three chunks: less than pivot, equal to pivot 
 * and greater than the pivot.
 * 
 * */

public class SmallestKDupArray {
 
	 class PartitionResult {
		 int leftSize, middleSize;
		 public PartitionResult(int left, int middle) {
			 this.leftSize = left;
			 this.middleSize = middle;
		 }
	 }
	 
	 int[] smallestK(int[] array, int k) {
		 if (k<=0 || k>array.length) {
			 throw new IllegalArgumentException();
		 }
		 
		 //get item with rank k-1
		 int threshold = rank(array, k-1);
		 
		 //copy elements smaller than the threshold element
		 int[] smallest = new int[k];
		 
		 int count=0;
		 for (int a: array) {
			 if (a<threshold) {
				 smallest[count] = a;
				 count++;
			 }
		 }
		
		 //if there is still room left, this must be for elements equal to the threshold elements, copy those in
		 while(count<k) {
			 smallest[count] = threshold;
			 count++;
		 }
		 return smallest;
	 }
	 
	  //find value with rank k in array
	    int rank(int[] array, int k) {
	        if (k >= array.length) {
	        	throw new IllegalArgumentException();
	        }   	
	        return rank(array, k , 0, array.length-1);
	    }
	    
	    
		//get random integer from the range
		int randomIntInRange(int min, int max) {
			 Random rand = new Random();
			 int res= rand.nextInt(max-min+1)+min;
			 return res;
		}
		
	    //find value with rank k in sub array between start and end
	    int rank(int[] array, int k, int start, int end) {
	    	int pivot = array[randomIntInRange(start, end)];
	    	PartitionResult partition = partition(array, start, end , pivot);
	    	int leftSize = partition.leftSize;
	    	int middleSize = partition.middleSize;
	    	
	    	//search portion of array
	    	if (k < leftSize) {
	    	    return rank(array, k, start, start+leftSize-1);
	    	} else if (k < leftSize + middleSize) { //rank k is in the middle
	    		return pivot; //middle is all pivot values
	    	} else {
	    		return rank(array, k-leftSize-middleSize, start+leftSize+middleSize, end);
	    	}
	    }
	    
	    //partition result into < pivot, equal to pivot, and bigger than pivot
	    PartitionResult partition(int[] array, int start, int end, int pivot) {
	    	int left = start; //right edge of the left side
	    	int right = end; //left edge of the right side
	    	int middle = start; //right edge of the middle
	    	
	    	while (middle<=right) {
	    		if (array[middle] < pivot) {
	    			swap(array, middle, left);
	    			middle++;
	    			left++;
	    		} else if (array[middle] > pivot) {
	    			//middle is bigger than the pivot, right could have any value. Swap them.
	    			//then we know that the enw right is bigger than the pivot. Move right by one
	    			swap(array,middle, right);
	    			right--;
	    		} else if (array[middle] == pivot) {
	    			//middle is equal to the pivot. move by one
	    			middle++;
	    		}
	    	}
	    	//return size of left and middle
	    	return new PartitionResult(left-start, right-left+1);
	    }
	    

		void swap(int[] array, int left, int right) {
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;		
		}
		
		
		public static void main(String[] args) {
			int[] array = {5, 3, 3, 7, 1, 1, 6};
			SmallestKDupArray smallestK = new SmallestKDupArray();
			//expecting 5
			
			//int k =3; test when k is 3
			
			int k = 4;
			int[] a ;
			a = smallestK.smallestK(array, k);
			
			for(int i: a) {
				System.out.println(i);
			}
		}
}	    
