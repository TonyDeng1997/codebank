package com.webbertech.languageAPI;

import java.util.Random;

/*
 * A URL character can be one of the following
1) A lower case alphabet [¡®a¡¯ to ¡®z¡¯], total 26 characters
2) An upper case alphabet [¡®A¡¯ to ¡®Z¡¯], total 26 characters
3) A digit [¡®0¡ä to ¡®9¡¯], total 10 characters

There are total 26 + 26 + 10 = 62 possible characters.

http://www.geeksforgeeks.org/how-to-design-a-tiny-url-or-url-shortener/
int num is some number from database.
 * */

public class TinyURL {
   
	static String encode(String str, int num) {
	    int base = 62;
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			sb.append(str.charAt(num%base));
			num /= base;
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println(encode(alphabet,new Random().nextInt(1000)));
		System.out.println(encode("/jobs/getAllJobs",128));
	}
}
