package com.webbertech.algorithm.basics;

public class DemoSimulation {
  // used in each iteration of n^2 sort
  static void display(int[] a, int i) {
	   int n = a.length;
	  System.out.print("debug: ");
	   System.out.print(i+": " + (n-i) +": ");
	   for(int k: a) {
	    	System.out.print(k+" ");
	   }
	   System.out.println();
  }
  
  //show all the elements
  static void displayArray(int[] a) {
	   for(int k: a) {
	    	System.out.print(k+" ");
	   }
	   System.out.println();
 }
} 
