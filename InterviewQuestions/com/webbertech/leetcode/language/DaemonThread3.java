package com.webbertech.leetcode.language;
/*
 * Understand what daemon thread is.
 * It is usually used for service thread.

 * When jvm terminates Daemon thread. 
 * It will not do the finally {} block and jvm will not wait for it to finish.
 * 
*/

public class DaemonThread3 extends Thread{

    public static void main(String a[]) throws InterruptedException {
    	
    	       Thread daemonThread = new Thread(new Runnable(){
    	            @Override
    	           public void run(){
    	               try{
    	               while(true){
    	                   System.out.println("Daemon thread is running");
    	               }
    	               }catch(Exception e){
    	                 
    	               }finally{
    	                   System.out.println("Daemon Thread exiting"); //never called
    	               }
    	           }
    	       }, "Daemon-Thread");
    	     
    	       daemonThread.setDaemon(true); //making this thread daemon
    	       daemonThread.start();
    	}

  
}