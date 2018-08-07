package com.webbertech.languageAPI;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaException {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
    	 try{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				String a = br.readLine();
				String b = br.readLine();
				Integer n1 ;
				Integer n2;
				try {
					n1 = Integer.parseInt(a);
					n2 = Integer.parseInt(b);
				} catch (NumberFormatException e) {
					System.out.println("java.util.InputMismatchException");
					throw new java.util.InputMismatchException();
				}
				
        
				if (n2 == 0) {
					System.out.println("java.lang.ArithmeticException: / by zero");
					throw new java.lang.ArithmeticException();
				}
        
				System.out.println((Integer)n1/(Integer)n2);
    	} catch (Exception e) {
    		  
    	  }
    }
}