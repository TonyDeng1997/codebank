package com.webbertech.crackCodingInterview;

//P473
/*Find the number of trailing zeroes 
  For example: 23! has four trailing zeroes
   
  In[4]:= Table[{n,n!},{n,Range[10]}]//Column
  Out[4]= {1,1}
		  {2,2}
	      {3,6}
		  {4,24}
		  {5,120}
	 	  {6,720}
		  {7,5040}
		  {8,40320}
		  {9,362880}
		  {10,3628800}
		  
		  http://www.purplemath.com/modules/factzero.htm
		  
Example: Find the number of trailing zeroes in the expansion of 1000!
Okay, there are 1000 ¡Â 5 = 200 multiples of 5 between 1 and 1000. The next power of 5, namely 25, 
has 1000 ¡Â 25 = 40 multiples between 1 and 1000. The next power of 5, namely 125, will also fit in the expansion, 
and has 1000 ¡Â 125 = 8 multiples between 1 and 1000. The next power of 5, namely 625, also fits in the expansion, 
and has 1000 ¡Â 625 = 1.6... um, okay, 625 has 1 multiple between 1 and 1000. (I don't care about the 0.6 "multiples", 
only the one full multiple, so I truncate my division down to a whole number.)
In total, I have 200 + 40 + 8 + 1 = 249 copies of the factor 5 in the expansion, and thus:
249 trailing zeroes in the expansion of 1000!

Example: Find the number of trailing zeroes in 101!
Okay, how many multiples of 5 are there in the numbers from 1 to 101? There's 5, 10, 15, 20, 25,...

Oh, heck; let's do this the short way: 100 is the closest multiple of 5 below 101, and 100 ¡Â 5 = 20, so there are twenty multiples of 5 between 1 and 101.

But wait: 25 is 5¡Á5, so each multiple of 25 has an extra factor of 5 that I need to account for. How many multiples of 25 are between 1 and 101? Since 100 ¡Â 25 = 4, there are four multiples of 25 between 1 and 101.
Adding these, I get 20 + 4 = 24 trailing zeroes in 101!

Example : Find the number of trailing zeroes in 23!
How many multiples of 5 are between 1 and 23? There is 5, 10, 15, and 20, for four multiples of 5. Paired with 2's from the even factors, this makes for four factors of 10, so:
*/

public class FactorialZero {
 
	
	static double getMultiplesOfFive(int factorial, double number) {
	   	return factorial/number;
	}
	
	//test it with 23 and 101, 1000, answer will be 4, 24, 249
	static int getTrailZeros(int factorial) {
		int multiple=1;
		int count= 0;
		while(factorial > Math.pow(5, multiple)) {
            count+= getMultiplesOfFive(factorial, Math.pow(5, multiple));
            multiple++;
		}
		return count;
	}
	 
	public static void main(String[] args) {
		System.out.println(getTrailZeros(1000));
	}
}
