package com.webbertech.algorithm;

import java.util.ArrayList;
import java.util.List;

public class HarderAlgorithm {

	
   
	static int Add(int x, int y) {
	    // Iterate till there is no carry  
	    while (y != 0)
	    {
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	 
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y; 
	 
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;
	    }
	    return x;
	}
	
	//using recursive
	static int Add1(int x, int y)
	{
	    if (y == 0)
	        return x;
	    else
	        return Add( x ^ y, (x & y) << 1);
	}
	
	
	//swap two numbers without a temp variable
	static void swap1(int a, int b) {
		a += b;
		b = a - b; // b is a's original value
		a = a - b; // a+b-b equals b's value
		System.out.println("a is:" + a);
		System.out.println("b is:" + b);
	}
	
	
	//Multiplication and division can also be used for swapping, only for integer tho
	// and beware of the types
	static void swap2(int x,  int y) {
		 x = x * y;  // x now becomes 50
		  y = x / y;  // y becomes 10
		  x = x / y;  // x becomes 5
		 System.out.println("x is:" + x);
		 System.out.println("y is:" + y);
	}
	
	
	//bitwise xor
	static void swap3(int x, int y) {
		 // Code to swap 'x' (1010) and 'y' (0101)
		  x = x ^ y;  // x now becomes 15 (1111)
		  y = x ^ y;  // y becomes 10 (1010)
		  x = x ^ y;  // x becomes 5 (0101)
		 System.out.println("x is:" + x);
		 System.out.println("y is:" + y);
	}
	 
	
	
	//remove duplicate and move up
	//TODO need to read this
	private static void removeAdjPairs(int[] arr) {
		// TODO Auto-generated method stub
		int j = 0,len=arr.length;
		for (int i = 1; i < arr.length; i++) {
			while(j >= 0 && arr[j] == arr[i] ) {
				len--;
				i++;
				j = j <= 0 ? 0 : j - 1;
			}
			
				arr[++j]=arr[i];
		}
		for (int i = 0; i < len; i++) {
			System.out.println(arr[i]);
		}
	}
	
	
	/**
	 * Given 78 cents (target) you need to tell how many ways it is possible to make
	 * the change using 25 cents(quarter), 10 cents(nickel), 5cents(dime),
	 * 1cents(penny)
	 * 
	 */
	//TODO
	 private static List<Integer> findChange(int num) {
	        List<Integer> list = new ArrayList<Integer>();
	        int sub = num;
	        while((sub - 25) > 0) {
	            sub = sub - 25;
	            list.add(25);
	        }
	        while((sub -10) > 0) {
	            sub = sub -10;
	            list.add(10);
	        }
	        while((sub-5) > 0) {
	            sub = sub -5;
	            list.add(5);
	        }
	        while((sub-1) >= 0) {
	            sub = sub -1;
	            list.add(1);
	        }
	        return list;
	    }
	
	
	 //{50,25, 20, 10, 5,2,1} coins
	 //if the change is 40, you will give two 20, not 25, 10, 5
	 public static int optimalPay(int [] coins , int money){
			int [] dp = new int [money+1];
			dp [0] = 0;
			dp [1] = 1; 
			for (int i = 2; i<=money;++i){
			dp[i] = i;
			   for (int j= 0; j<coins.length;++j){			
				 if (i>=coins[j]){
					dp[i]= dp[i-coins[j]]+1<dp[i]? dp[i-coins[j]]+1:dp[i];   
				 }
			   }			
			}
					
			return dp[money];
	}
	 
	public static void main(String[] args) {
		
		//need to study the following
		System.out.println( Add(2, 4));
		System.out.println( Add(-2, 4));
		
		//System.out.println( Add(15, 32));
		//System.out.println( Add(-15, 32));
		
		int a=1, b=2;
		swap1(a,b);
		System.out.println(a + " " + b);
		
		int[] arr = { 1, 1, 2, 3,3, 4, 5 };
		
		removeAdjPairs(arr);
		
		 System.out.println(findChange(91).toString());
	        System.out.println(findChange(78).toString());
	        System.out.println(findChange(36).toString());
	        System.out.println(findChange(49).toString());
	        
	     int[] coins = {50,25, 20, 10, 5,2,1};
	    System.out.println( optimalPay(coins, 40));
		
	}
	
	
}
