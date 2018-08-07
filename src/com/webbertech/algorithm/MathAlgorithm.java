package com.webbertech.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MathAlgorithm {
	//GCD using recursion, the algorithm is to use reminder
	public final static int gcd(int a, int b) {
		
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		
		if (max % min == 0) return min;
		else {
			return gcd(min, max%min);
		}
	}
	
	//GCD non-recusion
	public final static int gcd1(int a, int b) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		if (max % min == 0) return min;
		else {
			
			while(max % min != 0) {
				max = min;
				min = max % min;
			}
			return min;
		}
		
	}
	
	//solution1: lowest common multiple = |a*b|/gcd(a,b)
	public final static int lcm(int a, int b) {
		return 0;
	}
	
	//solution2: basic method
	/*if a%b==0 (a>b), then return a,
	 * else
	 *   for ( i =2, i<=b;i++ )
	 *   { if ( a*i %b == 0) 
	 *       return a*i
	 *   } 
	 *  
	 */
	public final static int lcm1(int a , int b) {
		
		int max = Math.max(a,b);
		int min = Math.min(a,b);
		if (max % min == 0)
			 return max;
		
		else {
			int i;
			for (i=2;i<= min; i++)
			{
				if (max*i % min == 0)
					break;
			}
			
			return max*i;
		}
	
	}
	
	//perfect square, like 4,9,16
	public int sqrt(int n) {
		for(int i=1;i*i<=n ;i++) {
	         if(i*i == n)
	        	 return i;
		}
		return -1;
	}
	
	
	//a^b
	public int exp(int a, int b) {
		if(a == 0) return -1;
		if(b == 0) return 1;
		if (b==1) return a;
		else return a*exp(a,b-1);
	}
	
	
	//hanoi
	public void move(int n, char a, char b, char c){
	        if(n == 1){
	            System.out.println("Disk " + n + " From " + a + " To " + c);
	        }
	        else{
	            move(n-1,a,c,b);
	            System.out.println("Disk " + n + " From " + a + " To " + c);
	            move(n-1,b,a,c);
	        }
	}
	
	
	//factorial
	public int factorial(int n) throws Exception {
		if (n <= 0) 
			throw new Exception();
		else if (n ==1 ) return 1;
		else return n * factorial(n-1);
		
	}
	
	
	//fibonacci using recurssion
	public int fibonacci(int n) throws Exception {
		  if(n<=0) throw new Exception();
		   if(n==1 || n==2) 
			   return 1;
		   else  
			   return fibonacci(n-1)+fibonacci(n-2);
	}
	
	
	//Question 4
	/*algorithm: cm for multiple numbers
	 * 对216、384和210来说：

        216=2^3 \times 3^3，384=2^7 \times 3^1，210=2^1 \times 3^1 \times 5^1 \times 7^1。
                          就可以得到最小公倍数：
         [216, 384, 210]=2^7 \times 3^3 \times 5^1 \times 7^1 = 120960。
 	*/
	
	
	//Question 5
	//http://mathworld.wolfram.com/PrimeFactorizationAlgorithms.html
	//The fastest-known fully proven deterministic algorithm is the Pollard-Strassen method
	//integer factorization (prime factorization)
	//need to study the following algorithm
	//https://en.wikipedia.org/wiki/Pollard's_rho_algorithm 
	
	
	
	//Question 6
	//nth prime number
	
	public  boolean isPrime(int n) {
	
		for(int i=2; i*i <= n;i++) {
			if(n%i==0) {
	          return false;
			} 
		}
		return true;
	}
	
	public  boolean isPrime1(int n) {
		
		for(int i=2; i <= Math.sqrt(n);i++) {
			if(n%i==0) {
	          return false;
			} 
		}
		return true;
	}
	

	
	public int nPrime(int n) throws Exception  {
		int count =0;
		if (n <=0)
				throw new Exception();
		
		int prime=2;
		
		for(int i=2; count< n;i++ ){
			if(isPrime(i)) { 
				prime = i;
				count++;
			}
			
		}
		return prime;
	}
	
	
	
	//sieve implementation: get all the primes up to N 
	/* http://introcs.cs.princeton.edu/java/14array/PrimeSieve.java.html */
	public void PrimeSieve(int num) {
	        int N = num;

	        // initially assume all integers are prime
	        boolean[] isPrime = new boolean[N + 1];
	        int [] number = new int[N+1];
	       
	        for (int i = 2; i <= N; i++) {
	            isPrime[i] = true;
	            number[i] = i;
	        }

	        // mark non-primes <= N using Sieve of Eratosthenes
	        for (int i = 2; i*i <= N; i++) {
	            // if i is prime, then mark multiples of i as nonprime
	            // suffices to consider mutiples i, i+1, ..., N/i
	            if (isPrime[i]) {
	                for (int j = i; i*j <= N; j++) {
	                    isPrime[i*j] = false;
	                }
	            }
	        }

	        // count primes
	        int primes = 0;
	        for (int i = 2; i <= N; i++) {
	            if (isPrime[i]) {
	            	 primes++;
	            	 System.out.println(number[i] + "\t");
	            }
	        }
	        System.out.println("The number of primes <= " + N + " is " + primes);
	        System.out.println();
	}
	
	
	
	//1. create array N+1
	//2. preassume all are true for prime numbers
	//3. filter out non-prime number and set them to false
	
	//this one is better
	public void PrimeSieve1(int num) {
        int N = num;

        // initially assume all integers are prime
        boolean[] isPrime = new boolean[N + 1];
        int[] number = new int[N+1];
       
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
            number[i] = i;
        }

        // mark non-primes <= N using Sieve of Eratosthenes
        for (int i = 2; i <= Math.sqrt(N); i++) {
            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., N/i
            if (isPrime[i]) {
                for (int j = i; i*j <= N; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        // count primes
        int primes = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
            	 primes++;
            	 System.out.println(number[i] + "\t");
            }
        }
        System.out.println("The number of primes <= " + N + " is " + primes);
        System.out.println();
}
	
	
	//for example, {12, 3, 4, 1, 6, 9}, find triplet that sum to 24
	//step 1, sort the array, it is O(nlogn)
	//step 2, 
	public static void findTripleNumbers(int[] array, int sum) {
		   	 Arrays.sort(array);  //nlogn
		   	 //array.length-2 will be for l, 
		   	 //and r starts from array.length-1 if it doesn't move
		  
		  for(int i=0; i< array.length-2; i++) {
			  int l= i+1;
			  int r= array.length-1;
			  while(l<r) {
				  if(array[i] + array[l] + array[r] == sum) {
					  System.out.println(array[i] + " " + array[l] + " " + array[r]);
					  break;
				  } else if (array[i] + array[l] + array[r] < sum) {
					  l++;
				  } else {
					  r--;
				  }
			  }
		  }
	 }
	
	
	
	public static void  main(String[] args) throws Exception {
		/*
		System.out.println(lcm1(15,25));
		System.out.println(lcm1(15,5));
		System.out.println(lcm1(15,3));
		System.out.println(lcm1(15,10));
		
		
		System.out.println(gcd(10,5));
		System.out.println(gcd(15,5));
		System.out.println(gcd(25,15));
		System.out.println(gcd(4,7));
	
		
		System.out.println(gcd(10,5));
		System.out.println(gcd(15,5));
		System.out.println(gcd(25,15));
		System.out.println(gcd(4,7));
		/*
		System.out.println(isPrime(1));
		System.out.println(isPrime(2));
		System.out.println(isPrime(3));
		System.out.println(isPrime(4));
		System.out.println(isPrime(8));
		System.out.println(isPrime(9));
		*/
		
		/*
		System.out.println(new MathAlgorithm().nPrime(1));
		System.out.println(new MathAlgorithm().nPrime(2));
		System.out.println(new MathAlgorithm().nPrime(3));
		System.out.println(new MathAlgorithm().nPrime(4));
		
		System.out.println(new MathAlgorithm().exp(2,4));
		new MathAlgorithm().move(3, 'a','b','c');
		System.out.println(new MathAlgorithm().factorial(5));
		System.out.println(new MathAlgorithm().fibonacci(6));
		*/
		
		/*
		new MathAlgorithm().PrimeSieve1(13);
		Scanner sc = new Scanner(System.in);
			int num1= Integer.parseInt(sc.nextLine());
			int num2= Integer.parseInt(sc.nextLine());		
			System.out.println(num1+num2);
			if(sc == null) throw new IllegalArgumentException();
		*/
		
		// test1
		/*
		int[] data= {12, 3, 4, 1, 6, 9};
		findTripleNumbers(data, 24);
	    */
		
		
		/* test 2: find all the triplets instead of just one!
		int[] data = new int[100];
		for(int i=0;i<100;i++) {
			data[i] = i+1;
		}
		findTripleNumbers(data, 100);
		*/
		
		//test 3: 
		int[] data= {12, 3, 4, 1, 6, 9, 25};
		findTripleNumbers(data, 24);
	}
	
}
