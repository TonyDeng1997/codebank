package com.webbertech.languageAPI;
//practise whiteboard

import java.util.ArrayList;

public class SievePrime {
   
	
	//n is the integer to find all the primes in n.
	static boolean[] nPrime(int n, int start) {
		
		if (start <2) 
			start = 2;
		
		boolean[] prime = new boolean[n+1];
	
		  for (int k=0;k<=n;k++) {
			  prime[k] = true;
		  }  
		
		
			for (int i=start;i<= Math.sqrt(n);i++) {
					if (isPrime(i)) {
						for (int j=i;i*j<=n;j++) {
							prime[i*j]=false;
					    }
			       }
		      
		   }
		return prime;
	}
	
	static boolean isPrime(int n) {
		if (n < 2) return false;
		if (n == 2) return true;
	   for(int i = 2; i<= Math.sqrt(n);i++) {
		   if (n%i == 0)
			   return false;
	   }
	   return true;
	}
	
	
	/*
	 * we want nth prime number. 2,3,5,7,..
	 * sieve method will get n numbers, but the actually scanning is from 2 to <= sqrt(n), so it is not enough.
	 * The question here is that what n we need to pass to sieve
	 * */
	
	static boolean isEven(int n) {
	  return n%2==0;	
	}
	
	static int getMaxCandidate(int n) {
		int count =1;
		int i = 2;
		while(count!=n) {
			i++;
			if(!isEven(i)) {
				count++;
			}
		}
		return i;
	}
	
	 static ArrayList nThPrime(int n) {
		ArrayList a = new ArrayList();
		boolean[] primeQ;
		
		while (a.size() < n) {
			int start = -1;
			if (a.isEmpty()) start =2;
			else start = (int)a.get(a.size()-1);
			int maxSize = 2*n-a.size();
			primeQ = nPrime(2*n-a.size(),start); // still need n + n -a.size() primes
			for(int i=start;i<=2*n;i++) {
				if (primeQ[i]) {
					a.add(i);
				}
			}
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		
		System.out.println(isPrime(2));
		System.out.println(isPrime(3));
		System.out.println(isPrime(4));
		
		/*
		boolean[] a =nPrime(4);
		
		for (boolean x: a) {
			System.out.print(x + "\t");
		}
		*/
		
		System.out.println(getMaxCandidate(4));
		System.out.println(nThPrime(19));
	}
}
