package com.webbertech.leetcode.math;
import java.math.BigInteger;

//think about old fashion, it has one major problem, that it will overflow

public class ReverseInteger {
	public static int reverse(int x) {
      
        /*  int quotient;
        int residual;
        
        LinkedList<Integer> list = new LinkedList<>();
        quotient= x/10;
        if (quotient==0) {
            return x;
        }
        residual = x%10;
        while(quotient >0) {
            
            list.add(residual);
            residual = quotient%10;
           
            quotient= quotient/10;
            
        }
        list.add(residual);
        int num=0;
        for(int i=0;i<list.size();i++) {
            num +=Math.pow(10,(list.size()-i-1))*list.get(i);
        }
        */
        boolean positive = true;
        String num = String.valueOf(x);
        if (num.length()==1 ) {
        	return x;
        }
        else if (num.charAt(0) == '-') {
        	num = num.substring(1);
        	positive = false;
        }
        StringBuffer sb = new StringBuffer(num);
        
        BigInteger bigNum = null;
        BigInteger maxInt = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        BigInteger minInt = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        if (positive) {
           bigNum = new BigInteger(sb.reverse().toString());
           if (bigNum.max(maxInt).equals(maxInt)) {
               return bigNum.intValue();        	
           }  else return 0;
        } else {
        	bigNum = new BigInteger("-"+sb.reverse().toString());
        	if (bigNum.min(minInt).equals(minInt)) {
        		return bigNum.intValue();
        	} else return 0;
        }
        
     
              
     
    }
	
	public static void main(String[] args) {
		System.out.println(reverse(1));	
	   System.out.println(reverse(123));	
	   System.out.println(reverse(-123));
	   System.out.println(reverse(1534236469));
	   
	}
}
