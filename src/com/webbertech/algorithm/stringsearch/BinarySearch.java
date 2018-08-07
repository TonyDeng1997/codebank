package com.webbertech.algorithm.stringsearch;

//improved Binary search, the array is sorted
public class BinarySearch {
	final static int MAX = 10;
	

	static int find(int[] list, int data) {
		   int lo = 0;
		   int hi = list.length - 1;
		   
		   int comparisons = 0;

		   int index=-1;
		   
		   while(lo <= hi) {
		      System.out.printf("\nComparison %d  \n" , comparisons ) ;
		      System.out.printf("lo : %d, list[%d] = %d\n", lo, lo, list[lo]);
		      System.out.printf("hi : %d, list[%d] = %d\n", hi, hi, list[hi]);
		      
		      comparisons++;

		      // probe the mid point 
		      int mid = lo+ (hi-lo)/2;
		      System.out.printf("mid = %d\n",mid);
            
		      // data found 
		      if(list[mid] == data) {
		         index = mid;
		         break;
		      } else {
		         if(list[mid] < data) {
		            // if data is larger, data is in upper half 
		            lo = mid + 1;
		         }else {
		            // if data is smaller, data is in lower half 
		            hi = mid - 1;
		         }
		      }               
		   }
		   
		   System.out.printf("\nTotal comparisons made: %d\n", --comparisons);
		   return index;
		}

	
	//recursive
	static int find2(int[] list, int data) {
	   int lo= 0;
	   int hi=list.length-1;
	   return search(lo, hi, list, data);
	}

	static int search(int lo, int hi, int[] list, int data) {
		int mid = lo + (hi-lo)/2;
		if(list[mid] == data)
			return mid;
		else if(list[mid] > data) {
			
		  return search(lo,mid, list, data);	
		}
		else
			return search(mid,hi,list,data);
	}
	
	 public static void main(String[] args) {
		  int list[] = { 10, 14, 19, 26, 27, 31, 33, 35, 42, 44 };
	
		 // System.out.println(find2(list, 33));
		  System.out.println(find(list, 33));
	 }
}
