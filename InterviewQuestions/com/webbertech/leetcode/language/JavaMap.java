package com.webbertech.leetcode.language;
import java.util.HashMap;

import java.util.Map.Entry;

public class JavaMap {
	
  
   static void testMap() {
	   HashMap<String, Integer> map = new HashMap<>();
	   map.put("a",1);
	   map.put("b",2);
	   map.put("c",3);
	   map.remove("c");
	   for (Entry<String, Integer> entry : map.entrySet())
	   {
	       System.out.println(entry.getKey() + "/" + entry.getValue());
	   }
   }
   
   /*hashCode() method is used to put java object into some container by algorithm
    * and data structure. If the object is put in  hash-based collections, 
    * such as HashMap and HashSet. hashCode() will make them search faster.
    * 
    * Def: Objects that are equal must have the same hash code 
    *      within a running process. Whenever you implement equals, 
    *      you MUST also implement hashCode.
    *      
    * hashCode() collision.
    * 
    * Whenever two different objects have the same hash code, 
    * we call this a collision. 
    * A collision is nothing critical, it just means that 
    * there is more than one object in a single bucket, 
    * so a HashMap lookup has to look again to find the right object. 
    * A lot of collisions will degrade the performance of a system, 
    * but they won��t lead to incorrect results.
	  But if you mistake the hash code for a unique handle to an object, 
	  e.g use it as a key in a Map, then you will sometimes get the wrong object. 
	  Because even though collisions are rare, they are inevitable. 
	  
	  Do not use hashCode in distributed applications. 
	  The best advice is probably: don��t use hashCode at all, 
	  except when you create hash-based algorithms.
	  
	  http://www.javaworld.com/article/2074996/hashcode-and-equals-method-in-java-object---a-pragmatic-concept.html
	  http://tutorials.jenkov.com/java-collections/hashcode-equals.html
    * */
   
   class User {
	   String firstName;
	   String lastName;
	   
   }
   
   public static void main(String[] args) {
	   testMap();
   }

  // List<List<Integer>> list = new ArrayList<List<Integer>>();
   
   
}
