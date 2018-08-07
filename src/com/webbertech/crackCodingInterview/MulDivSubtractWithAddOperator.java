package com.webbertech.crackCodingInterview;

//implement multiplication, division, subtraction using add operator

public class MulDivSubtractWithAddOperator {

	/* using a flip method */
	static int negate(int a) {
		
		/*initial the neg value to 0, because it will be -a eventually
		 * it could be positive or negative based on the number it adds
		 */
		int neg=0;
		//if a < 0, we want to increase a until a =0
		//if a > 0, we want to decrease a until a =0
		//the number of increase or decrease is the negated value
		int newSign =0;
		newSign = a > 0 ? -1: 1; //if a > 0, we minus 1, else we increase 1
		
		while (a!=0) {
			neg += newSign; //as long as a is not increase/decrease to 0, we accrue this number
			a += newSign; // if a > 0, it will go down, else it will go up
		}
		
		//System.out.println(neg);
		return neg;
	}
	
	static int subtract(int a, int b) {
			System.out.println(a+ negate(b));
		return a+ negate(b);
	}

	static int abs(int num) {
		int a =0;
		if (num <0) {
			a = negate(num);
			return a;
		}
		return num;
	}
	
	static int multiple(int a, int b) {
		if (abs(a)>abs(b)) {
			return multiple(b,a);
		}
		int sum =0;
		for(int i=0;i< abs(b);i++) {
			sum += a;
		}
		
		if (a>0 && b<0 || a<0 && b<0) {
			sum = negate(sum);
		}
		System.out.println(sum);
		return sum;
	}
	

	static int divide(int a , int b) {
		if(b ==0) 
			throw new ArithmeticException();
		int x =0;
		
		while(multiple(abs(b),x) != abs(a)) {
			x++;
		}
		
		/*
		 *  or you can use 
		 *  int product =0;
		 *  while (product + abs(b)<= abs(a)) {
		 *  	product += abs(b);
		 *      x++
		 *  }
		 * *
		 */
		
	
		if(a>0 && b<0|| a<0 && b>0) {
			x = negate(x);
		}
		System.out.println(x);
		return x;
	}
	
	
	
	/*
	 * This is an optimal solution
	 * 
	 * */
	
	static int  negate1(int a) {
		/*initial the neg value to 0, because it will be -a eventually
		 * it could be positive or negative based on the number it adds
		 */
		int neg=0;
		//if a < 0, we want to increase a until a =0
		//if a > 0, we want to decrease a until a =0
		//the number of increase or decrease is the negated value
		int newSign =0;
		newSign = a > 0 ? -1: 1; //if a > 0, we minus 1, else we increase 1
		
		while (a!=0) {
			neg += newSign; //as long as a is not increase/decrease to 0, we accrue this number
			a += newSign; // if a > 0, it will go down, else it will go up
		}
		
		//System.out.println(neg);
		return neg;
	}
	
	public static void main(String[] args) {
		//negate(-2);
		//negate(3);
		//subtract(2,3);
		//subtract(-2,3);
		
		
		multiple(2,3);
		multiple(2,-3);
		multiple(-2,3);
		multiple(-2,-3);
		/*
		divide(4,2);
		divide(-4,2);
		divide(4,-2);
		*/
	}
}
