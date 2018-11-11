package com.webbertech.java.concurrent;

/*
 * Object created in each thread is thread safe,
 * running on the same object instance(sared) will have race condition.
 * 
 * This example talks about the race condition and how to resolve it.
 * */

class NotThreadSafe{
    StringBuilder builder = new StringBuilder();

    public String add(String text){
        this.builder.append(text);
        return builder.toString();
    }
}

public class RaceConditionExample implements Runnable{
	  NotThreadSafe instance = null;

	  public RaceConditionExample(NotThreadSafe instance){
	    this.instance = instance;
	  }

	  public void run(){
	    System.out.println(this.instance.add("some text"));
	  }
	  
	  public static void main(String[] args) {
		 
		  /* The following two threads are accessing the same instance
		  	 It will cause race condition
		  */
		  NotThreadSafe sharedInstance = new NotThreadSafe();
		  new Thread(new RaceConditionExample(sharedInstance)).start();
		  new Thread(new RaceConditionExample(sharedInstance)).start();
		  
		  /*
		   * The following will not cause two race condition, 
		   * because they are calling different object in their own space.
		   * */
		  
		  new Thread(new RaceConditionExample(new NotThreadSafe())).start();
		  new Thread(new RaceConditionExample(new NotThreadSafe())).start();
	  }
}
