package com.webbertech.leetcode.math;
/*Leetcode 204
 * Count the number of prime numbers less than a non-negative number, n.
 * */
public class CountPrime_leetcode204 {
	 static boolean isPrime(int n) {
		  if (n==0 || n==1) return false;
		  
		  for(int i=2;i<=Math.sqrt(n);i++) {
			  if (n%i==0) {
				  return false;
			  }
		  }
		  return true;
	  }
	
	  public  static int countPrimes(int n) {
	      if (n<=1) return 0;
	    
	      //[0,n]
	      boolean[] primes = new boolean[n+1];
	      //preset to true except the first 2, this include number n
	      for(int i=2;i<=n;i++) {
	    	  primes[i] = true;
	      }
	      
	      //if i is prime, i*2, i*3, ...i*j (i*j<=n) all are not prime
	      for(int i=2;i<=Math.sqrt(n);i++) {
	    	  int j=2;
	    	  while(isPrime(i) && i*j<=n) { //include n
	    		  primes[i*j]= false;
	    		  j++;
	    	  }
	      }
	      
	      //when count, just count 0 to n-1 , not n, because it requires all the primes numbers less than n.
	      int count=0;
	      for (int i=0; i<n; i++) {
	    	  if (primes[i]) {
	    		  count++;
	    	  }
	      }
	      return count;
	  }
	  
	  
	  //Solution 2 will beat the first solution
	  public static int countPrimes2(int n) {
		  boolean[] notPrime=new boolean[n];  // create n false in array
		  int count =0 ; //a counter for prime
		  for (int i=2;i<n;i++) {
			  if (!notPrime[i]) {
				  count++;
				  for (int j = 2; i*j< n; j++) {
					 notPrime[i*j] = true;  // don't check if i*j is prime, because it is not！
				  }
			  }
		  }
		  
		  return count;
	  }
	  
	  public static void main(String[] args) {
		  System.out.println(isPrime(2));
		  System.out.println(isPrime(3));
		  System.out.println(isPrime(4));
		  System.out.println(isPrime(5));
		  System.out.println(isPrime(15));
		  System.out.println(countPrimes(10));
		  System.out.println(countPrimes2(10));
	  }
}
