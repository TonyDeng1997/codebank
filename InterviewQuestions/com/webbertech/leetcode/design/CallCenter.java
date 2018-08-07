package com.webbertech.leetcode.design;

/*
 * Three types of employee, respondent, manager and director.
 * 1/ allocate to free respondent
 * 2/ else allocate to manager
 * 3/ else allocate to director 
 * */
import java.util.Date;
import java.util.List;

class Call {
	String callId;
	Employee assignee;
	Caller caller;
	Rank rank; //optional, the minimal rank of the assignee
    Call(Caller c) {
    	this.caller = c;
    }	
    
    void setAssignee(Employee e){
    	assignee = e;
    } 
    
    void setRank(Rank r) {
    	rank =r;
    }
    
    Rank getRank() {
    	return rank;
    }
    
    void disconnect() {} // not sure
    void reply(String message) {} // not sure
}

class Caller {
	String name;
	Date time;	
}

enum Rank {
   RESPONDENT, MANAGER, DIRECTOR;
	
	int getValue(){
		return this.ordinal(); 
	}
}

abstract class Employee {
	boolean free;
    Rank rank;
    
	void acceptCall(Call c) {};
	void callCompleted(){};
	void redirectCall(Call c) {};
	
	boolean isFree() { return free;}
	Rank getRank() {return rank;};
}

class Respondent extends Employee {
    void setRank() {
    	rank = Rank.DIRECTOR;
    }
}

class Manager extends Employee {
    void setRank() {
    	rank = Rank.MANAGER;
    }
}

class Director extends Employee {
    void setRank() {
    	rank = Rank.DIRECTOR;
    }
}


// pay attention to this, this is the central piece of code
// usually the centralized code will have some 
public class CallCenter {
	// for different level of employees, they have their own queue.
	List<List<Employee>> empList;
	List<List<Call>> callQueue;
	
	Employee getAssigneeForCall(Call c ){ return null;};
	
	  void dispatchCall(Caller c) {
	      Call call = new Call(c);
	      dispatchCall(call);
	  }
	  
    void dispatchCall(Call call) {
    	Employee e = getAssigneeForCall(call);
    	if (e != null) {
    		e.acceptCall(call);
    		e.callCompleted();
    	} else {
             call.reply("wait for free employee to reply");
             callQueue.get(call.getRank().getValue()).add(call);
    	}
    }
}