package com.webbertech.algorithm.basics;

public class Fibonacci {
	public static int fibonacci_recusion(int n) {
		if (n<1) throw new IllegalArgumentException();
		
		if (n == 1 || n ==2) {
			return 1;
		}
		return fibonacci_recusion(n-1) + fibonacci_recusion(n-2);
	}

	public static int fibonacci_array(int n) {
		int[] m = new int[n+1];

		if (n == 1 || n==2 ) {
			return 1;
		}
		
		m[0] = m[1] = m[2] = 1;
		
		// Use real number to check the boundary
		for (int i=3;i<=n;i++) {
			m[i] = m[i-1] + m[i-2];
		}
		return m[n];
	}
	
	public static int fibonacci_best(int n) {
		if (n == 1 || n ==2) {
			return 1;
		}
		
		int x=1, y=1, sum = 1;
		for (int i=3 ;i<=n;i++) {
			x = y;
			y = sum;
			sum = x+y;
		}
		
		return sum;
	}
	
	
	// The above two solutions are not ideal as before the output is calculated
	// all the information is retained in the memory

	
	public static void main(String[] args) {
		//System.out.println(fibonacci(-1));
		
		/*
		System.out.println(fibonacci_recusion(1));
		System.out.println(fibonacci_recusion(2));
		System.out.println(fibonacci_recusion(3));
		System.out.println(fibonacci_recusion(4));
		*/
		
		/*
		System.out.println(fibonacci_array(1));
		System.out.println(fibonacci_array(2));
		System.out.println(fibonacci_array(3));
		System.out.println(fibonacci_array(4));
		*/
		
		System.out.println(fibonacci_best(1));
		System.out.println(fibonacci_best(2));
		System.out.println(fibonacci_best(3));
		System.out.println(fibonacci_best(4));
	}
}
