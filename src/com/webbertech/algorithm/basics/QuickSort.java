package com.webbertech.algorithm.basics;

import java.util.Random;

//average O(nlogn), worse O(n^2)
//divide and conquer algorithm
//java7 has dual pivot Quicksort implementation in 2009
//http://me.dt.in.th/page/Quicksort/

// this is a very simple implementation
// to understand this use three numbers 4,2,3 to try this

public class QuickSort {

	 private int[] data;
	 
	 public void sort(int[] values) {
		 this.data = values;
		 quickSort(0,  values.length-1);
	 }
	
	 public void quickSort(int low, int high) {
		 int i= low;
		 int j = high;
		 int pivot = data[low+(high-low)/2];
		
		 //this while make sure that the i is low and j is high
		 while(i<=j) {
			 /*the following two while meaning that if 
			   the order is fine which is to check from 
			   both two ends and check the order to make sure
			   the left of pivot is smaller than pivot,
			   the right of pivot is larger than pivot
			   if the order is fine, then go to next index
			   from both end, until they stop, meaning that
			   the left or right is not right, then you need to 
			   swap, not to swap the wrong one(from left or right)
			   with the pivot, but just swap the left one and right one
			   note that, during the swap, one of these two numbers
			   could be the pivot number*/
			 while (data[i]< pivot) i++;
			 while (data[j]>pivot) j--;

			 /*considering three numbers: 4,2,3, 
			  * and sort it to ascending order:
			  * initial: i = 0, j=2;
			  * after above inner two whiles: i = 0, j = 1;
			  * now, it is the swap, and after that 
			  * i,j change their value: j=0, i=1, array: 2,4,3
			  */
			 if(i<=j) {
				 swap(i,j);
				 i++;
				 j--;
			 }
		 }
		 
		 /*because j < i, so it comes to the following steps,
		  * you should understand this like this way:
		  * j was the original high, although it moves downward,
		  * the right sequence of the array is decided by the distance
		  * from low to j, if j's index isn't getting close to low,
		  * then we will need to quicksort with low and j,
		  * and it is the same for i to high.
		  *  */
		 if(low<j )
			   quickSort(low,j);
		 
		 if(i< high)
			   quickSort(i,high);
		 
	 }
	 
	 public void swap(int i, int j) {
		 int temp ;
		 temp = data[i];
		 data[i] = j;
		 data[j] =temp;
	 }
	 
	  
	  public static void main(String[] args) {
		  int[] array = new int[]{4, 10, 3, 5, 1};
		  new QuickSort().sort(array);
		   
		  /*
		   * java.util.Random num = new Random();
	  		 int[] data = {5, 0, 1, 3, 28, 7, 15, 2,  2 , 11};
		
			 new QuickSort2().quickSort(data, 0, data.length-1 );
		 * */
		  for (int i : array) {
		   System.out.print(i + " ");
		  } 
	  }
	  
}
