package com.webbertech.leetcode.design;

/*
 * Design an online book reading system.
 * 
 * Very vague and rough, then define some behaviors
 * 
 * 1/ create user membership and extension
 * 2/ searching the database for books
 * 3/ reading a book
 * 4/ Only one active user at a time
 * 5/ Only one active book by this user
 * */

class Book {
	String serialNo;
	String Location;
	boolean occupied;
	void setOccupied() {
		occupied = true;
	}
	
	void setFree() {
		occupied = false;
	}
}
 
class User {
	String name;
	String uuid;
	String age;
	String email;
	boolean reading;
	Book curBook;
	boolean searchBook(Book book) {return true;}
	void startReading(Book book) {
		reading = true;
		curBook = book;
		book.setOccupied();
	}
	
	void finishReading(Book book) {
		reading = false;
		book.setFree();
	}	
}


//TODO: p316, this really depends on the requirements
public class OnlineBookReader {

   void register(User u ) {};
   boolean isActiveUser(User u){return false;};

	
}
