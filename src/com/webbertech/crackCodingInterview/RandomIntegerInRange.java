package com.webbertech.crackCodingInterview;

import java.util.Random;

public class RandomIntegerInRange {
 
	//solution 1: randomNum = minimum + (int)(Math.random() * maximum); 
	
	static int getRandomNumberInRange(int min, int max) {
		 Random rand = new Random();
		 int res= rand.nextInt(max-min+1)+min;
		 return res;
	}
	
	public static void main(String[] args) {
		System.out.println(getRandomNumberInRange(5,10));
	}
}
