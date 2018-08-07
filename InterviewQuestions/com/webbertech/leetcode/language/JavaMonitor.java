package com.webbertech.leetcode.language;

// ref: http://www.programcreek.com/2009/02/notify-and-wait-example/

class ThreadB extends Thread{
   int total;
   @Override
   public void run(){
	   System.out.println("b thread started");
       synchronized(this){
           for(int i=0; i<100 ; i++){
               total += i;
           }
           System.out.println("Computing is done!");
           notify();
           System.out.println("Check me");
       }
   }
}

public class JavaMonitor {
	  public static void main(String[] args){
	        ThreadB b = new ThreadB();
	        b.start();
	
	        synchronized(b){
	            try{
	                System.out.println("Waiting for b to complete...");
	                b.wait();
	                System.out.println("waiting is done!");
	            }catch(InterruptedException e){
	                e.printStackTrace();
	            }
	 
	            System.out.println("Total is: " + b.total);
	        }
	    }
}
