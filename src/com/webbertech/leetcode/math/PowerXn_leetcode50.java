package com.webbertech.leetcode.math;

/*leetcode 50. Pow(x, n) 
 * Implement pow(x, n). 
 * 
 * Solution1: Too slow 
 * */
public class PowerXn_leetcode50 {

	// Solution1: Too slow
	/* just think about n is negative, no need to think abut x is negative
	 * */
	public static double myPow(double x, int n) {
		double res = 1;

		if (n == 0)
			return 1;
		else if (n < 0) {
			for (int i = 0; i < Math.abs(n); i++) {
				res *= x;
			}
			res = 1 / res;
		} else { 
			for (int i = 0; i < n; i++) {
				res *= x;
			}
		}
		return res;
	}

	// solution2:
	public static double pow(double x, int n) {
		if (n == 0)
			return 1;
		//this is simple
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		// the core logic is here, using recursion
		return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
	}
	
	/* solution3: rewrite solution2, 
	 The following is accepted by leetcode, and there are many edge cases.
	 */
	public static double pow2(double x, int n) {
		double res = 0;
		if (x == 1) return x;
		if (x == -1 && (n&1) == 0) {
			return 1;
		} else if (x== -1 && (n&1) != 0) {
			return -1;
		}
		if (n>= Integer.MAX_VALUE || n<= Integer.MIN_VALUE) {
			return  res;
		}
		if (n == 0)
			return 1;
		//this is simple
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		
		// the core logic is here, using recursion
		/*
		 * Because recursion check for n, the init condition is n ==0.
		 * To quickly reduce the number of recursions, it uses n/2, but use x*x
		 * which is the same thing as pow(x,n). Why it is n/2 not n/4 because
		 * 2 is a magic number, it deals with residual of n%2.
		 * */
		if (n % 2 == 0) { 
			res= pow(x * x, n / 2); 
		} else {
			res= x * pow(x * x, n / 2);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(myPow(2, 2));
		System.out.println(myPow(2, 0));
		System.out.println(myPow(2, -2));
		System.out.println(myPow(-2, 0));
		System.out.println(myPow(-2, -2));
		System.out.println(myPow(-2, 2));
		System.out.println(myPow(8.88023, 3));

		System.out.println(myPow(-13.62608, 3));
		
		//System.out.println(myPow(0.00001, 2147483647));
		System.out.println(pow(0.00001, 2147483647));
		System.out.println(Integer.MIN_VALUE);
		System.out.println(pow(2, -2147483648));
		System.out.println(pow(1, 2147483647));
		System.out.println(pow(-1, -2147483648));
	}
}
