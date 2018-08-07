package com.webbertech.crackCodingInterview;

import java.util.ArrayList;

//P496

/*
 * Given an array, sort from n to m so that the whole array is sorted.
 * Minimize the n-m sequence.
 * 
 *  Example: 1,2,4,7,10,11,7,12,6,7,16,18,19
 *  output {3,9} index 
 *   
 *   find the increasing subarray,  1,2,4,7,10,11,
 *   then find the middle subarray 7,12
 *   then find the increasing subarray in the second part: 6,7,16,18,19
 *   
 *   Then we use the middle subarray(7,12), any element in the left should be smaller than 7,
 *   if we find anything >= 7, we take the index, the same for the right subarray,
 *   any thing <= 12, will be the index for the output
*/

public class SubSort {
	
	static class Index {
		int left;
		int right;
	}
	
	public static Index getIndexRange(int[] data) {
       	 	ArrayList<Integer> left= new ArrayList<>();
       	    ArrayList<Integer> mid= new ArrayList<>();
       	    ArrayList<Integer> right= new ArrayList<>();
       	    Index index = new Index();
       	    
		    int i;
		    
		    int leftInOriginal; //where the right array index starts 
		    int rightInOriginal; //where the right array index starts 
		    
       	 	for(i=1;i< data.length;i++) {
       		   if (data[i]>data[i-1]) {
       			  left.add(data[i-1]);
       		   } else {
       			   //if i is smaller number but i-1 is still qualified
       			 left.add(data[i-1]);
       			 //increment 1 so that the mid array will be good
    			 i++;
       			   break;
       		   }
       		}
       	 
       	    leftInOriginal = i-1;
       	 	
       	 	//get the middle
       		for(;i< data.length;i++) {
        		   if (data[i]>data[i-1]) {
        			  mid.add(data[i-1]);
        		   } else {
        			 mid.add(data[i-1]);
        			 i++;
        			   break;
        		   }
            }
       	 	
       		rightInOriginal = i-1;
       		//all just add the rest of to the right sack?
       		for(;i< data.length;i++) {
        		   if (data[i]>data[i-1]) {
        			  right.add(data[i-1]);
        		   }
        		   if (i == data.length -1) {
        			   right.add(data[i]);
        		   }
        			   
        		}
       	 	
       		
       		 //looking for the left index
             for (int leftIndex=0;leftIndex< leftInOriginal; leftIndex++) {
            	 if (data[leftIndex] >= mid.get(0)) {
            		 index.left = leftIndex;
            		 break;
            	 }
             }
          
             
             //looking for the right index
             int lastNumOfMid = mid.get(mid.size()-1); //which should be 12
             for (int rightIndex= rightInOriginal; rightIndex < data.length; rightIndex++) {
            	
            	 if (data[rightIndex] > lastNumOfMid) {
            		 index.right =  rightIndex-1; //not inclusive for 16
            		 break;
            	 }
             }
             
             System.out.println(index.left+" "+ index.right);
       	 	
       	 	return index;
	}
	
	public static void main(String[] args) {
		int[] data =  {1,2,4,7,10,11,7,12,6,7,16,18,19};
		getIndexRange(data);
	}
}
