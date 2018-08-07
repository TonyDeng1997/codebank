package com.webbertech.realinterview;
import java.util.Arrays;

/* Given an array, each contains the bike number, and a[num] means 
 * that bike parking slot is being taken. Return the max distance from
 * two used bike parking slot. -1, 0 is the bike lot number. -1 to 0 means distance is 1.
 * For the next bike you want to park, you will need to find between two used bike parking slot.
 * But the location you choose to the two used bike slot, the distance has to be max.
 * 
 * For example, the following array should return 2. And lot 5 or 6 is the place you should choose.
 *  
 *  -1, 0 , 2, 3 ,8, 10, 11, 12
 *  
 *  A[-1] = 10
 *  A[0]  = 8
 *  A[2]  = 7
 *  A[3] = 11
 *  A[8] = 3
 *  A[10] =2
 *  A[11] = 1
 *  A[12] = 6
 *  
 *  A[num]'s value is the bike id.
 *  
 *  You return 2, because index 5 or 6 is the place you want to go, 
 *  because the distance between index 5 and 6 to 8 and 10 is 2, which is the max.
 *  
 *  Solution: This problem is to find the longest gap, and actually
 *  since the function is not returning the index of the parking slot, so 
 *  all you need to do is to find the longest gap/distance between the array numbers.
 *  Also the bike id does not matter to you which is the A[num]'s value.
 */

public class BikeRack {
	  
	  public static int solution(int[] A) {
	    int maxDistance =0;
		  Arrays.sort(A);
		  for(int i=1;i<A.length;i++) {
			  int distance = A[i]-A[i-1];
			  if (distance>maxDistance) {
				  maxDistance= distance;
			  }
		  }
		  return maxDistance/2;
		  
	  }
	  
	  public static void main(String[] args) {
		  int[] A={10,0,8,2,-1,12,11,3};
		  System.out.println(solution(A));
	  }
}
