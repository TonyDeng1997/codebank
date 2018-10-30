package com.webbertech.leetcode.math;

/*
 * Leetcode 29. Divide Two Integers
 * 
 * you can not use multiply, mod or divide.
 * 
 * This is a native solution, take near 1 sec to calculate Integer.MAX_VALUE-1/2
 * */



public class DivideTwoInteger_leetcode29 {
	
	static int divide(int divident, int divisor) {
		boolean negative = false;
		
		if (divident >0 && divisor<0 || divident<0 && divisor >0) {
		    negative = true;	
		}
		
		if (divisor ==0) 
			return Integer.MAX_VALUE;
		else if (divident ==0) 
			return 0;
		
		
		if ((divisor == 1 && divident == Integer.MIN_VALUE ) ) 
		     return Integer.MIN_VALUE;
		
		if ((divisor == 1 && divident == Integer.MAX_VALUE ) ) 
		     return Integer.MAX_VALUE;
		
		if ((divisor == -1 && divident == Integer.MIN_VALUE ) ) 
		     return Integer.MAX_VALUE;
		
		
		if ((divisor == -1 && divident == Integer.MAX_VALUE ) ) 
		     return -Integer.MAX_VALUE;
		
		divident = divident<0? -divident:divident;
		divisor = divisor<0? -divisor: divisor;
	    
		int quotient =0;
		
		if (divident == divisor) {
			if (negative)
				return -1;
			return 1;
		}
		
		while((divident-divisor)> 0) {
			divident = divident-divisor;
			quotient++;
        }		
    
		if (negative) {
        	return -quotient;
        }
        return quotient;
		
	}
	
	//The basic logarithmic concept used here is log(a*b) = loga + logb

	public static int divide2(int dividend, int divisor) {
		   if (divisor == 0) 
			      return Integer.MAX_VALUE;
			   if (divisor == 1) {
				   return dividend;
			   }
			   double divident1 = (double) dividend;
			   double divisor1 = (double) divisor;
			   int res = (int) Math.exp(Math.log(Math.abs(divident1)) - Math.log(Math.abs(divisor1)));
			   if (divisor1>0 && divident1>0 || divisor1<0 && divident1<0) {
			      return res;
			   }

			   return -res;
	}

	public int divide3(int a, int b) {
        if (b == 0)
            return Integer.MAX_VALUE;
        //由于Integer.MINVALUE的特殊�??(其补码是它本�?)，不得不将int型转为long�?
        long dividend = (long)a;
        long divisor = (long)b;
        //符号位做和，-1表示结果为负，否则结果为正数
        long sign = (dividend >> 31) + (divisor >> 31);
        dividend = (dividend >> 31) == 0 ? dividend : (~dividend + 1);
        divisor = (divisor >> 31) == 0 ? divisor : (~divisor + 1);
        //初始判断，被除数小，直接返回0
        if(divisor > dividend)
            return 0;
        //�?始�?�归
        long quotient = recurse(dividend, divisor, divisor, 1);
        //给商加上符号
        quotient = (sign == -1) ? (~quotient + 1) : quotient;
        //判断是否溢出，如a=Integer.MINVALUE,b=-1结果是溢出的
        if(quotient >= Integer.MIN_VALUE && quotient <= Integer.MAX_VALUE)
            return (int)quotient;
        else
            return Integer.MAX_VALUE;
    }
    /*
     * 大致思路�?
     * 除数依次左移�?�?(�?2)，直至大于被除数
     * 回�??，判断，若差小于初始除数，结束，否则被除数置为两者之差，除数为初始数�?
     * 例如�?(7,2,2,1)->(7,4,2,2)->(7,8,2,4)->(3>2)->(3,2,2,1)+2->(3,4,2,1)+2->(1<2)->return 1+2=3;
     */
    public long recurse(long dividend, long divisor, long init, long quotient){
        if(dividend > divisor){
            return recurse(dividend, divisor << 1, init, quotient << 1);
        } else if(dividend == divisor){
            return quotient;
        } else{
            if(dividend-(divisor >> 1) < init)
                return quotient>>1;
            else
                return recurse(dividend - (divisor >> 1), init, init, 1) + (quotient >> 1);
        }
    }
	
    public int divide4(int a, int b) {
        if(a==Integer.MIN_VALUE){
            if(b==-1) return Integer.MAX_VALUE;
        }

        long x = a < 0 ? -(long)a : (long)a;
        long y = b < 0 ? -(long)b : (long)b;

        int res = recurse(x, y, 1);
        if(a < 0 && b < 0) return res;
        if(a < 0 || b < 0) return -res;
        return res;
    }

    public int recurse(long x, long y, int count) {
        if(x <= 0 || count==0) return 0;
        if(y > x) return recurse(x, y >>> 1, count >>> 1); //overshot, so divide and try again.
        else return recurse(x-y, y+y, count+count)+count;
    }
    
	public static void main(String[] args) {
		
		System.out.println(divide(22,3));
		
		System.out.println(divide(22,-3));
		System.out.println(divide(-22,3));
		System.out.println(divide(1,0));
		System.out.println(divide(0,1));
		System.out.println(divide(1,2));
		System.out.println(divide(1,1));
		System.out.println(divide(1,-1));
		System.out.println(divide(5,2));
		System.out.println(divide(5,-2));
		System.out.println(divide(-2147483648,-1));
		System.out.println(divide(-2147483648,1));
		System.out.println(divide(2147483647,-1));
		System.out.println(divide(2147483647,1));
		long time= System.currentTimeMillis();
		System.out.println(divide2(2147483647,2));
		System.out.println(divide2(-2147483648,2));
		System.out.println(System.currentTimeMillis()-time);
	}
}
