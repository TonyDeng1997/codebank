package com.webbertech.java.concurrent;
/*
 *  Volatile addresses memory inconsistency issue but 
 *  it has performance cost to not to use cpu cache.
 *  It means not to read/write to cpu cache, thus directly read/write
 *  to main memory.
 *  
 *  It does not address concurrency issue.
 * */
public class Volatile {
	 private int years;
	 private int months;
	 private volatile int days;

	 public void update(int years, int months, int days){
	        this.years  = years;
	        this.months = months;
	        this.days   = days;
	 }
	    
	 public void update1(int years, int months, int days){
	    	 this.days   = days;
	        this.years  = years;
	        this.months = months;
	 }
	    
	public Volatile() {
		// TODO Auto-generated constructor stub
	}
}