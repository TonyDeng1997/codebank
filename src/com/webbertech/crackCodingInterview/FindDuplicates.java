package com.webbertech.crackCodingInterview;


/*P406
 * 
 *  Find duplicates in memory constraint condition.
 *  Given an array of integer from 1 to N, N is at most 32,000. The
 *  array may have duplicate entries and you don't know what N is.
 *  Given that the RAM you have is 4K, how can you print out all the duplicates.
 *  
 */

/*
 * solution: bit operation
 * 4K bytes RAM = 8 *4 * 2^10 bytes it is bigger than 32000 numbers.
 * If use integer or double, it is 4 or 8 bytes each.
 * So we can only use bit vector to track the array.
 * 
 * */

//try to understand BitSet in java, it is a set data structure of bit
//try to understand this algorithm, it simply check if a set contains a number
public class FindDuplicates {

	void checkDuplicates(int[] array) {
		java.util.BitSet bs = new java.util.BitSet(32000);
		for(int i=0;i< array.length;i++) {
			int num = array[i];
			//int num0 = num -1;
			if (bs.get(num)) {
				System.out.println(num);
			} else {
				bs.set(num);
			}
		}
	}
	
	public static void  main(String[] args) {
	   int[] array = {1,1,2,3,4,5,6,7,7};
	   FindDuplicates f = new FindDuplicates();
	   f.checkDuplicates(array);
	}
}

//the following worth trying, try to understand it
//Need to revisit tihs
class BitSet {
	int[] bitset;
	
}