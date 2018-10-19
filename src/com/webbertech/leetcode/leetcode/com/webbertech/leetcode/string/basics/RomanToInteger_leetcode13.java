package com.webbertech.leetcode.string.basics;

/*
 * Leetcode 13
 * 
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 * 
Symbol	I	V	X	L	C	D	M
Value	1	5	10	50	100	500	1,000

1 to 10
I, II, III, IV, V, VI, VII, VIII, IX, X.

Number	4	9	40	90	400	900
Notation	IV	IX	XL	XC	CD	CM

 * 
 * 
 * Solution: 
 * straightforward, easy question, the only 
 * thing is that you need to know what Roman 
 * numerals are.
 * 
 *  MCMLIV: 1954
 *  use an array to store numbers,
 *  
 *   [1000,100, 1000, 50, 1, 5]
 *   compare i and i+1, i is [0, length-2]
 *   if nums[i+1] is smaller, then 
 *   sum = sum + nums[i] 
 *   else
 *   sum = sum - nums[i]
 *   
 *   then finally sum = sum+ nums[length-1]
 *   
 *   The following solution is very good, need to remember this.
 *   Only need to remember, I, V, X, L, C, D, M
 *  
 * test input:
 * 
 *     MCMIV: 1904
 *     MCMLIV: 1954
 *     MCMXC: 1990
 *     MMXIV: 2014
 * */

public class RomanToInteger_leetcode13 {
    public static int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
        	return 0;
        }
        int nums[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        
        // the following is the core algorithm.
        int sum=0;
        for(int i=0;i<nums.length-1;i++) {
            if (nums[i]>=nums[i+1]) {
                sum+=nums[i];
            } else {
                sum-=nums[i];
            }
        }
        return sum+nums[nums.length-1];
    }
    
    public static void main(String[] args) {
    	System.out.println(romanToInt("IVV"));
    }
}
