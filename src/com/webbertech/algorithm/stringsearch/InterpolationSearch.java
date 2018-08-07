package com.webbertech.algorithm.stringsearch;


//improved Binary search, the array is sorted, O(log(logn))
// this method is almost the same as the iterative binary search algorithm
// the only difference is the mid calculation is different
// TODO: you can write a recursive version for this
// Two tips:
// 1/ memorize the formula
// 2/ break out of the loop when you find it

public class InterpolationSearch {
	final static int MAX = 10;
	

	static int find(int[] list, int data) {
		   int lo = 0;
		   int hi = MAX - 1;
		   int mid = -1;
		   int comparisons = 1;      
		   int index = -1;

		   while(lo <= hi) {
		      System.out.printf("\nComparison %d  \n" , comparisons ) ;
		      System.out.printf("lo : %d, list[%d] = %d\n", lo, lo, list[lo]);
		      System.out.printf("hi : %d, list[%d] = %d\n", hi, hi, list[hi]);
		      
		      comparisons++;

		      // probe the mid point 
		      mid = (int)(lo + (((double)(hi - lo) / (list[hi] - list[lo])) * (data - list[lo])));
		      System.out.printf("mid = %d\n",mid);

		      // data found 
		      if(list[mid] == data) {
		         index = mid;
		         break;
		      }else {
		         if(list[mid] < data) {
		            // if data is larger, data is in upper half 
		            lo = mid + 1;
		         }else {
		            // if data is smaller, data is in lower half 
		            hi = mid - 1;
		         }
		      }               
		   }
		   
		   System.out.printf("\nTotal comparisons made: %d", --comparisons);
		   return index;
		}


	 public static void main(String[] args) {
		  int list[] = { 10, 14, 19, 26, 27, 31, 33, 35, 42, 44 };
		  int location = find(list,33);

		   // if element was found 
		   if(location != -1)
		      System.out.printf("\nElement found at location: %d" ,(location+1));
		   else
		      System.out.printf("Element not found.");
	 }
}
