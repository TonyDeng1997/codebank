package com.webbertech.languageAPI;

import java.io.*;
import java.util.*;

public class DiagonalDifference {

	    static int getDiagonalAbs(int[][] data) {
	        int len = data.length;
	        if (len != data[0].length) {
	            throw new IllegalArgumentException();
	        }
	        
	        int diag1 = 0;
	        int diag2 = 0;
	        for (int i=0;i<len;i++) {
	                diag1 += data[i][i];
	                diag2 += data[i][len-i-1];
	         }

	         return Math.abs(diag1-diag2);
	    }
	    
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	      //  int[][] data = {{11 ,2, 4}, {4, 5, 6},{10, 8, -12}};
	      //  System.out.println(getDiagonalAbs(data));
	        
	        final Scanner in = new Scanner(System.in);
	        in.useLocale(new Locale("en", "US"));
	         Integer dimension=0;
	        System.out.println("enter dimension:");
	        if (in.hasNextLine()) {
	        	dimension = Integer.valueOf(in.next());
	        }
	        
	        int[][] matrix = new int[dimension][dimension];
	        
	           for (int j=0;j<dimension;j++) {
	        	   for (int k=0;k<dimension;k++) {
	        		  if (in.hasNextInt()) {
	        			  matrix[j][k] = in.nextInt();
	        		   	
	        		  }
	        	   }
	        
	           } 
	           System.out.println(getDiagonalAbs(matrix));
	      
	    }
}

