package com.webbertech.java;

import java.util.ArrayList;
import java.util.List;

public class MethodReference {

	public MethodReference() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {
	      List names = new ArrayList();
	      names.add("Mahesh");
	      names.add("Suresh");
	      names.add("Ramesh");
	      names.add("Naresh");
	      names.add("Kalpesh");
	      names.forEach(System.out::println);
	}
}
