package com.webbertech.algorithm.bitoperation;

public class CountBits {

	//count how many 1s in a binary format?
	// how to make integer A to B? how many flips? count the 1s in A^B
	
	/*for example -7, will return 4;
	 * 1 will return 1; 
	 * 2 will return 1;
	 * 3 will return 2
	 */
	
	 int countOnesForPositiveNumbers(int num) {
		int count =0;
	    for(int i=num;i!=0;i=i>>1) {
	    	count += (i & 1);
	    	
	    	/*
	    	 * if(i&1==1)
	    	 *    count++;
	    	 * */
	    	System.out.println(count);
	    }	
	    return count;
	}
	
	
    //negative and positive
	int countOnesForAllNumbers(int num) {
	   int count=0;
	   for(int c=num;c!=0;c=c & (c-1)) {
		   count++;
	   }
	   
	   return count;
	}
	
	 
	 //TODO: Need to do this when I have time
	int countOnesForNegativeNumbers(int num) {
			int count =0;
			
			long unsignedValue = num & 0xffffffffl; //f is 8 bits, so total 64 bits
			
			System.out.println(unsignedValue);
			  for(long i=unsignedValue;i!=0;i=i>>1) {
			    	count += (i & 1);
			   }
		    return count;
	}
	
	
	 
	public static void main(String[] args) {
		CountBits cb = new CountBits();
		 //System.out.println(cb.countOnesForPositiveNumbers(-1));
		 
		 System.out.println(cb.countOnesForAllNumbers(-1));
		 System.out.println(cb.countOnesForAllNumbers(-7));
	    //System.out.println(countOnes(-1));
		
		//works great for positive number
		// System.out.println(countOnes(1));	
	   // System.out.println(countOnes(2));
	   // System.out.println(countOnes(3));
		 
		 System.out.println(cb.countOnesForNegativeNumbers(-1));
	}
	
}
