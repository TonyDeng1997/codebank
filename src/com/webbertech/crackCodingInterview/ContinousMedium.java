package com.webbertech.crackCodingInterview;

import java.util.Comparator;
import java.util.PriorityQueue;

//use two priority queue to simulate MaxHEAP and MinHEAP
//keep MaxHeap equal or 1 element more than MinHeap
//Let MaxHeap store the values lower than medium
//Let MinHeap store the values higher than the medium
//new number is less or equal than the top of maxHeap(medium) will be in maxHeap
// other wise in minHeap
// use : 1 2 3 3 4 to test

//new number should be compared to both the peek() of the maxHeap and minHeap
//see comments below

public class ContinousMedium {

	private PriorityQueue<Integer> MaxQueue, MinQueue;
	
    static class MyComparator<T extends Number> implements Comparator<T> {

		public int compare(T x, T y) {
	        if ((Integer)x > (Integer)y) {
	        	return -1;
	        } else if ((Integer)x < (Integer)y) {
	        		return 1;
	        }
			return 0;
		}
    }  
    
	public ContinousMedium() {
		MaxQueue = new PriorityQueue<>(new MyComparator<Integer>());
		MinQueue = new PriorityQueue<>();
	}
	
	void addNewNumber(int num) {
		
		if (MaxQueue.size() == MinQueue.size()) {
             if (MinQueue.peek()!=null && num > MinQueue.peek() ) { 
            	 //because MinQueue is to store values larger than the medium
            	 //so if it is greater than the peek(), yes MinQueue wants it,
            	 //but in return, one min element will go to MaxQueue
            	 MaxQueue.offer(MinQueue.poll());
            	 MinQueue.offer(num);
             } else {
            	 MaxQueue.offer(num);
             }  
             
		} else {
			//this case is that MaxQueue size not the same as MinQueue
			//because we want to keep the length diff at only 1, 
			//so we need to check with it with MaxQueue, if it doesn't need it
			//give it to MinQueue, is not a bad idea, if ask MinQueue first
			//and MinQueue want it, then the size will be the same as MaxQueue
			//but then you still have to consult MaxQueue to adjust it
			if (num < MaxQueue.peek()) {
				MinQueue.offer(MaxQueue.poll());
				MaxQueue.offer(num);
			}
			
			MinQueue.offer(num);
		}
		
	}
	
	
	//use peek, don't use poll
	double getMedium() {
	 	if (MaxQueue.size() == MinQueue.size()) {
	    	return (MaxQueue.peek() + MinQueue.peek())/2;
	 	} else {
	 		return MaxQueue.peek();
	 	}
	}
 
    
    
    public static void main(String[] args) {
    	ContinousMedium cm = new ContinousMedium();
       
    	cm.addNewNumber(1);
    	cm.addNewNumber(2);
    	cm.addNewNumber(3);
    	cm.addNewNumber(4);
    	cm.addNewNumber(4);
    	cm.addNewNumber(5);
    	System.out.println(cm.getMedium());
    
    	
    	/* The following test MaxHeap
        MyComparator<Integer> mc = new MyComparator<>();
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(mc);
    	pq.add(1);
    	pq.add(2);
    	pq.add(0);
    	pq.add(3);
    	System.out.println(pq.peek());
        */
    
    }
    
}
