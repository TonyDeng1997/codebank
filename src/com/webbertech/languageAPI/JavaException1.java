package com.webbertech.languageAPI;

import java.util.Scanner;

class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}

class myCalculator {
    
    int power(int n, int p) throws Exception {
        if (n<0 || p<0) {
       
            throw new Exception("n and p should be non-negative");
        }
      
        int res =1;
        for (int i=1;i<=p;i++) {
            res = res*n;
        }
        return res;
    }
}

public class JavaException1 {

	  
	  public static void main(String []argh)
	    {
	        Scanner in = new Scanner(System.in);

	        while(in.hasNextInt())
	        {
	            int n = in.nextInt();
	            int p = in.nextInt();
	            myCalculator M = new myCalculator();
	            try
	            {
	                System.out.println(M.power(n,p));
	            }
	            catch(Exception e)
	            {
	                System.out.println(e);
	            }
	        }

	    }
}

