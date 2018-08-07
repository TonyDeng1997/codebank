package com.webbertech.algorithm.basics;


public class HeapSort {
		
//ref: also in algorithm cheatsheet
//C implementation: http://www.geeksforgeeks.org/a-data-structure-question/
//http://javabypatel.blogspot.in/2015/11/heap-sort-algorithm.html
	
public void sort(int[] data) {
	int size = data.length;
	
	System.out.println(size/2);
	
	/* the following did heapify(1, data, 5) and heapify(0, data, 5) 
	 * original: 4 10 3 5 1
	 * first pass is not doing anything
	 * second pass is to compare index 0 with 1 and 2, 
	 * so 10 4 3 5 1, then the recursive heapify(1, data, 5) is called again,
	 * because largestElementIndex is 1, so  4 will be compared with 5 and 1.
	 * another swap happens, so it became 10 5 3 4 1
	 * 
	 * The core of the algorithm is that:
	 * once a swap happens, all the elements from that largestElementIndex to the end of the array
	 * will be scanned and other swap could happen.
	 */
	for (int i = size / 2 - 1; i >= 0; i--) {
		   System.out.println("\ninside init");
		   heapify(i, data, size);
		   display(data);
	}
		 
	System.out.println("\ndebug before the sort");
	display(data);
	
	/*after above step, the largest is data[0] which is 10
	 * because we have 10	5	3	4	1, we know the first one is the largest.
	 * And we want to sort it in ascending order, so the largest should be in the end
	 * of the array. So we swap with the last element.
	 * 
	 * so it becomes 1 5 3 4 10
	 * 
	 * size reduce 1 because we already put the largest number in the end
	*/
	for(int i=data.length-1;i>=0;i--) {
		   int temp = data[0];
		   data[0]=data[i];
		   data[i]=temp;
		 
		   //reduce the heap window by 1
		   size  = size-1;
		 
		   //call max heapify on the reduced heap
		   heapify(0, data, size);
	}
}
		 

private int leftChild(int i){ 
		  return 2 * i + 1; 
}
		 

private int rightChild(int i) { 
		  return 2 * i + 2; 
}
		 

 private void display(int[] data) {
	 for(int i: data) {
		 System.out.print(i+ "\t");
	 }
 } 

/*
 * 1/ recursion
 * 2/ it simulate a binary tree structure in a one dimensional array
 * */

private void heapify(int i, int[] data, int size) {
	int largestElementIndex = i;
	int leftChildIndex = leftChild(i);
	if (leftChildIndex < size && data[leftChildIndex] > data[largestElementIndex]) {
			   largestElementIndex = leftChildIndex;
	}
			 
	int rightChildIndex = rightChild(i);
	if (rightChildIndex < size && data[rightChildIndex] > data[largestElementIndex]) {
		   largestElementIndex = rightChildIndex;
	}
			 
	if (largestElementIndex != i) {
			   int swap = data[i];
			   data[i] = data[largestElementIndex];
			   data[largestElementIndex] = swap;
			 
			   // Recursively heapify the affected sub-tree
	        heapify(largestElementIndex, data, size);
	}
}
	

public static void main(String[] args) {
		  int[] array = new int[]{4, 10, 3, 5, 1};
		   
		  new HeapSort().sort(array);
		   
		  for (int i : array) {
		   System.out.print(i + " ");
		  } 
}
		 
		
	
		 
}

