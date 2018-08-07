package com.webbertech.languageAPI;


public class MaxHeap {

	//size will change, max heap, the largest will be in the index 0
	void heapify(int i, int[] data, int size) {
		int maxIndex = i;
		int leftChildIndex= leftChild(i);
		if (leftChildIndex < size && data[leftChildIndex] > data[maxIndex]) {
			maxIndex = leftChildIndex;
		}
		
		int rightChildIndex= rightChild(i);
		if (rightChildIndex < size && data[rightChildIndex] > data[maxIndex]) {
			maxIndex = rightChildIndex;
		}
		
		if (maxIndex != i) {
			   int swap = data[i];
			   data[i] = data[maxIndex];
			   data[maxIndex] = swap;
			 
			   // Recursively heapify the affected sub-tree
	        heapify(maxIndex, data, size);
	}
		
	}
	
	private int leftChild(int i){ 
		  return 2 * i + 1; 
}
		 

private int rightChild(int i) { 
		  return 2 * i + 2; 
}

    void heapSort(int[] data) {
    	int size = data.length;
    	for(int i= size/2-1;i>=0;i--) {
    		heapify(i, data, size);
    	}
    	
    	 for (int i : data) {
  		   System.out.print(i + " ");
  		  }
    	 System.out.println();
    	 
    	for (int i= data.length-1 ;i>=0;i--) {
    		   int temp = data[0];
    		   data[0]=data[i];
    		   data[i]=temp;
			size = size-1;
			heapify(0, data, size);
		}
    }	
	
    public static void main(String[] args) {
		  int[] array = new int[]{4, 10, 3, 5, 1};
		   
		  new MaxHeap().heapSort(array);
		    
		  for (int i : array) {
		   System.out.print(i + " ");
		  }
		  
}
	
}
