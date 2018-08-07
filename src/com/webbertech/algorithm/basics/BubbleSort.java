package com.webbertech.algorithm.basics;

public class BubbleSort {
	
	   //outer loop controls how many times to iterate
	   // the inner loop goes in one loop to shift/bubble all the elements.
	   public static void bubbleSort(int[] a) {
		   int n = a.length;
		   int temp = 0;
		   for (int i=0;i<n;i++) {
			   //n-i because the largest is moved to the end.
			   for (int j=1;j<n-i;j++) {
				   if (a[j-1]>a[j]) {
					    temp = a[j-1];
					   a[j-1] = a[j];
					   a[j] = temp;
				   }
			   }
			   DemoSimulation.display(a,i);
		   }
	   }
	   
       public static void main(String[] args) {
    	    int[] a= {6,5,4,3,2,1};
    		bubbleSort(a);
    	    for(int i: a) {
    	    	System.out.print(i+" ");
    	    }
       }
}
