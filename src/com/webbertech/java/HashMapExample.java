package com.webbertech.java;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapExample {
	public static void main(String args[]) {
	
			HashMap<Integer, String> hm = new HashMap<Integer, String>();
	
			hm.put(100, "Amit");
			hm.put(100, "Amitxxxx");
			hm.put(101, "Vijay");
			hm.put(102, "Rahul");
			hm.put(null, "Rahul");
			hm.put(null, "Rahulxxx");
			
			for (Entry<Integer, String> m : hm.entrySet()) {
				System.out.println(m.getKey() + " " + m.getValue());
			}
			System.out.println(hm.size());
		}
}

