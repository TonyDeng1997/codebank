package com.webbertech.java;


/*
 * Race condition happens when multiple threads enter the critical section
 * and try to alter the values, however, for performance improvement,
 * they can be more granular
 * 
 * */
public class PreventRacecondition {

	private int sum1 = 0;
	private int sum2 = 0;
	
	// This protects two statements, and this is the critical section
	public void add(int val1, int val2){
        synchronized(this){
            this.sum1 += val1;   
            this.sum2 += val2;
        }
    }
	
	private Integer sum1Lock = new Integer(1);
	private Integer sum2Lock = new Integer(2);

	public void addImroved(int val1, int val2){
	        synchronized(this.sum1Lock){
	            this.sum1 += val1;   
	        }
	        synchronized(this.sum2Lock){
	            this.sum2 += val2;
	        }
	}
	
	public static void main(String[] args) {
		// TODO skip now
	}

}
