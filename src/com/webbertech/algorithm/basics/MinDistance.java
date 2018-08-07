package com.webbertech.algorithm.basics;

import java.util.Arrays;


public class MinDistance {

	public static void main(String[] args) {
		
		int[] a={9, 2, 1,28,30};
		int[] b={9,3,14};
		
		//expected output is 1
		
	    int minLength = Math.min(a.length,b.length );
		
	    Arrays.sort(a);
	    Arrays.sort(b);
	    
	    //1,2,4,4,4,4,9
	    //3,8,9
	    
	    int min = Math.abs(a[0]-b[0]);
	    for(int i=0;i<a.length;i++) {
	    	for(int j=0;j<b.length;j++) {
	    		if(Math.abs(b[j]-a[i])< min)
	    		{
	    			
	    		}
	    	}
	    		
	    }
	    
	}
}
