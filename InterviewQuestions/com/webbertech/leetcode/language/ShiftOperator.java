package com.webbertech.leetcode.language;

public class ShiftOperator {

/*Shift Operator Usage
 * 
 * 3<<2, how to understand this,
 * the operand is always on the left.
 * num<<1 , num>>2, num>>>3
 * 
 * java中有三种移位运算符

	<<:     左移运算符，num << 1,相当于num乘以2
    
    >>:     右移运算符，num >> 1,相当于num除以2
    
    >> will take care of the sign bit, 0 for positive number and 1 for negative number
     
	>>>:     无符号右移，忽略符号位，空位都以0补齐
	
	>>> will move 0 to left most bit/sign bit, so only good for 32/64 bit positive
	number

	
	
 * */
	
 
	
	public static void main(String[] args) {
		//The following two are the same thing
		System.out.println(1<<30);
		System.out.println((int)Math.pow(2, 30));
		
		System.out.println(24>>2); // it is equivalent to 24/(2 to the power of 2)
		System.out.println(24>>4); // it is equivalent to 24/(2 to the power of 4)
		
		System.out.println(24<<2); // 24* (2^2), 
		System.out.println(24<<4); // 24* (2^4)
		
		
		int key = new ShiftOperator().hashCode();
		System.out.println(key);
		int new_hash = key ^ (key>>>16);
		System.out.println(new_hash);
		
	}
}
