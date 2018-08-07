package com.webbertech.crackCodingInterview;

import java.util.Random;

public class SmallestKUniqueArray {

	/*selection rank algorithm O(n) without dup, find the kth smallest element in O(n) time
	 * 
	 * solution:
	 * 
	 * 1/ find a pivot, partition elements around the pivot and keep track of 
	 *    the number of elements on the left side of the partition
	 * 
	 * 2/ if there are exactly i elements on the left, then you just return the biggest element on the left.
	 * 
	 * 3/ if there are less than i elements on the left, repeat the algorithm on the right, and look for the element with rank i - leftSize
	 */
	
	
	
	/*  see how this is working: 5 3 7 1 6, pivot: 3, say left is 5 and right is 6.
	 *  
	 *  so it became 6 3 7 1 5 , right index is at 1
	 *  1 3 7 6 5, right index is at 6
	 *  another round, it is 1 3 7 6 5, left index is at 3, right index is at 7
	 *  another round, it is still 1 3 7 6 5 but, left index is 7 and right index is 3, 
	 *  it breaks out from while loop
	 *  
	 *  @param left left index
	 *  @param right right index
	 *  @return the index of the left, where in this index everything on the left is less than the pivot
	 * */
	int partition(int[] array, int left, int right, int pivot) {
		while (left <= right) {
			if (array[left] > pivot) {
				swap(array, left, right);
				right--;
			} else if (array[right] <= pivot) {
				swap(array,left, right);
				left++;
			} else {
				//left and right are in correct place, expand both size
				left++;
				right--;
			}
			
		}
		return left-1;
	}
	
	void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;		
	}
	
	int max(int[] array, int left, int right) {
		int max = Integer.MIN_VALUE;
		for (int i=left;i<=right;i++) {
			max = Math.max(array[i],max);
		}
		return max;
	}

	//get random integer from the range
	int randomIntInRange(int min, int max) {
		 Random rand = new Random();
		 int res= rand.nextInt(max-min+1)+min;
		 return res;
	}
	
	//get rank how to use this?
	int rank(int[] array, int rank) {
		return rank(array,0, array.length-1, rank);
	}

    //get element with rank between left and right
	/*
	 * How this is working? Take original array {5, 3, 7, 1, 6}
	 * if the pivot is 3. after that array is  1 3 7 6 5, leftEnd = 1, leftSize = 2, rank = 2
	 * So it hit the rank(array, leftEnd+1, right, rank-leftSize), then this call is rank (array, 2, 4, 0)
	 * In this call, say pivot is 7., leftEnd is 4, Rank = 0, call rank(array, left, leftEnd, rank) again,
	 * 
	 * in this call, left = 2, leftend = 4, and rank = 0,
	 * after this call, it is 1 3 6 5 7, leftEnd = 4, and rank = 0
	 *
	 * ...
	 * 
	 * */
	int rank(int[] array, int left, int right, int rank) {
		int pivot = array[randomIntInRange(left, right)];
		int leftEnd = partition(array, left, right, pivot); //O(n)
		int leftSize = leftEnd- left +1;
		if (rank == leftSize -1) {
			return max(array, left, leftEnd); //terminating condition where it is 1 3 5 7 6 for example, and left=leftEnd =2
		} else if (rank < leftSize) {
			return rank(array, left, leftEnd, rank);
		} else { //if rank > leftSize
			return rank(array, leftEnd+1, right, rank-leftSize);
		}
	}
	
	int[] smallestK(int[] array, int k) {
	   if (k<=0 || k> array.length) {
		   throw new IllegalArgumentException();
	   }	
	   
	   //why this is k-1, this is why the above condition checks for k > array.length but not array.length-1
	   int threshold = rank(array, k-1);
	   int[] smallest = new int[k];
	   int count =0;
	   for (int a: array) {
		   if (a <= threshold) {
			   smallest[count] = a;
			   count++;
		   }
	   }
	   return smallest;
	}
	
	public static void main(String[] args) {
		int[] array = {5, 3, 7, 1, 6};
		SmallestKUniqueArray smallestK = new SmallestKUniqueArray();
		//expecting 5
		int k =3;
		int[] a ;
		a = smallestK.smallestK(array, k);
		
		for(int i: a) {
			System.out.println(i);
		}
	}
}

