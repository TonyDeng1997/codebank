package com.webbertech.crackCodingInterview;


//P554

public class MajorityElement {


static boolean validateMajorityElement(int[] array, int elem) {
	int count=0;
	for (int i: array) {
		if (i == elem) {
   		count++; 
		}
   	}
  return count > array.length/2;
}

//find the majority element in an array in O(n^2) and in O(1) space
/*this is to calculate the frequency of the elements, 
	majority meaning the counts are more than half
*/ 

//this is N^2, too slow
static int getMajorityElement(int[] array) {
  for (int element: array) {
        if ( validateMajorityElement(array, element)) {
           return element;   
        }
  }
  return -1;
}


/*  solution 2:  use this array as an example to play with it
 *  int[] a = {0,0,3,3,7,7,7,7,7};
 *  int[] b = {3,0,3,0,1,2,7,7,7,7,7};
 *  int[] c = {7,3,0,7,3,0,7,1,2,7,7,7};
 *  
 *  The most possible candidate for being the most frequent element can be seen in the following
 *  algorithm, you can get it with the above array. The algorithm is very elegant.
 *  
 *  the idea is that, for each element increase by 1, if the next element is different, 
 *  then decrease 1. This way, in every pair, if they are different, the count will be set to 0.
 *  We don't care what they are now, even one of them is the actual most frequent element we always
 *  check every pair, element by element. If in some case, that two in the pair are the same say 7,
 *  then unless the next two are different like 7,7,1,2 the count will then be set to 0,
 *  and the majority will need to change, otherwise such as 7,7,1, the counter is not 0 and it will
 *  not change majority.
 *  
*/
static  int getCandidate(int[] array) {
	  int majority = 0;
	  int count = 0;
	  for (int n: array) {
		  if (count == 0) { //if no majority then set it to the current number
			  majority = n;
		  }
		  
		 /* if n was found before, and it seems
		  * to be majority, then the count increase 
		  */ 
		  if (n == majority) { 
			  count++;
		  } else {
			  count--;
		  }
	  }
	  return majority;
  }

//part of solution 2
static int findMaorityElement(int[] array) {
	int candidate = getCandidate(array);
	return validateMajorityElement(array, candidate)? candidate: -1;
}  
  
 public static void main(String[] args) {
	/*
	 int[] a = {0,0,3,3,7,7,7,7,7};
	 System.out.println(getMajorityElement(a));
	 System.out.println(findMaorityElement(a));
	 //get candidate
	 System.out.println(getCandidate(a));
	 int[] b = {3,0,3,0,1,2,7,7,7,7,7};
	*/ 
	 
	 int[] c = {7,3,0,7,3,0,7,1,2,7,7,7};
	 System.out.println(getCandidate(c));
 }
	
}
