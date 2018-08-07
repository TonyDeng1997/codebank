package com.webbertech.leetcode.language;

public class ShiftOperator {

/*Shift Operator Usage
 * 
 * 3<<2, how to understand this,
 * the operand is always on the left.
 * num<<1 , num>>2, num>>>3
 * 
 * java����������λ�����

	<<:     �����������num << 1,�൱��num����2
    
    >>:     �����������num >> 1,�൱��num����2
    
    >> will take care of the sign bit, 0 for positive number and 1 for negative number
     
	>>>:     �޷������ƣ����Է���λ����λ����0����
	
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
