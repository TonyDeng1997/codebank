package com.webbertech.leetcode.array;
/*leetcode 66
 * Given a non-negative number represented as an array of digits, 
 * plus one to the number.
   The digits are stored such that the most significant digit 
   is at the head of the list.
 * 
 * This question is very simple, but pay attention to the details.
 * 
 * */

public class PlusOne_leetcode66 {

	// solution 1: very simple
	// if last bit is less than 9, then add 1 to the last index and return
	// for example, 1,2,3,4,5,9
	// for example, 1,9,9,9,9,9
	// for example, 9,9,9 
	// binary digits sequence like 10101 is the same thing. See the detail handling
	public static int[] plusOne(int[] digits) {
		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		//since in the loop it does not return, that means that all the digits are 9,
		// then it will be 1,0,0,0 (int[] digits length's 0), construct a new array with 1 extra bit.
		// set the first bit to 1, all other digits are 0.
		int[] newNumber = new int[n + 1];
		newNumber[0] = 1;
		return newNumber;
	}

	// solution2 : very close the the first one
	public static int[] plusOne2(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] += carry;
			if (digits[i] <= 9) // early return
				return digits;
			digits[i] = 0;
		}
		int[] ret = new int[digits.length + 1];
		ret[0] = 1;
		return ret;
	}

	// solution3:
	public static int[] plusOne3(int[] digits) {
		int n = digits.length;
		int carrier = 1;
		for (int i = n - 1; i >= 0; i--) {
			int tmp = digits[i] + carrier;
			digits[i] = tmp % 10;
			carrier = tmp / 10;
		}
		if (carrier == 0)
			return digits;
		int[] result = new int[n + 1];
		result[0] = carrier;
		System.arraycopy(digits, 0, result, 1, n);
		return result;
	}

	// solution 4: recursion
	public int[] plusOne4(int[] digits) {
		return helper(digits, digits.length - 1);
	}

	private int[] helper(int[] digits, int index) {
		if (digits[index] < 9) {
			digits[index]++;
			return digits;
		} else {
			if (index != 0) {
				digits[index] = 0;
				return helper(digits, index - 1);
			} else {
				int[] res = new int[digits.length + 1];
				res[0] = 1;
				return res;
			}
		}
	}

	public static void main(String[] args) {
		int[] num1 = { 1, 2, 3, 4, 5, 6 };
         for(int i: plusOne(num1)) {
           System.out.println(i);	 
        	 
         }
		//int[] num2 = { 1, 2, 3, 4, 9 };
	}

}