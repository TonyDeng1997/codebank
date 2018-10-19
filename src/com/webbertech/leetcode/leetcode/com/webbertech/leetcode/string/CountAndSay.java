package com.webbertech.leetcode.string;

import java.util.ArrayList;
import java.util.LinkedList;

/*Leetcode 38
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

solution: 
   first set a var to record last visited element, and make count variable to count
   consecutive elements, if the current element is different than the last-visited element,
   use StringBuilder to prepend the count to the lastVisitedElement, and reset the count to 0. 
 
 Cant not understand the output
*/

public class CountAndSay {

	public String countAndSay(int n) {
		String num = String.valueOf(n);
	    if (num.length()==1) {
	    	return "1"+String.valueOf(n);
	    }
		char lastVisited = num.charAt(0);
	    StringBuilder res = new StringBuilder();
	    int count=1;
	    for(int i=1;i<num.length();i++) {
	    	if (num.charAt(i) == lastVisited) {
	    		count++;
	    	} else {
	    		res.append(count);
	    		res.append(String.valueOf(lastVisited));
	    		count=1;
	    		lastVisited = num.charAt(i);
	    	} 
	    }
	    res.append(count);
	    res.append(String.valueOf(lastVisited));
	    return res.toString();
		
	}
	
	 public String countAndSay1(int n) {
	        if(n <= 0) return "";
	        String init = "1";
	        while(n-- > 1){
	            init = say(init);
	        }
	        return init;
	    }
	    public String say(String str){
	        if(str.length() < 1) return "";
	        int count = 1;
	        StringBuilder sb = new StringBuilder();
	        char c = str.charAt(0);
	        if(str.length() == 1){
	            sb.append(count);
	            sb.append(c);
	            return sb.toString();
	        }
	        for(int i = 1; i < str.length(); i ++){
	            if(str.charAt(i) == str.charAt(i - 1)){
	                count ++;
	            }else{
	                sb.append(count);
	                sb.append(c);
	                count = 1;
	                c = str.charAt(i);
	            }
	        }
	        sb.append(count);
	        sb.append(c);
	        return sb.toString();
	    }
	


	public static void main(String[] args) {
		CountAndSay obj = new CountAndSay();
		System.out.println(obj.countAndSay1(1));
		System.out.println(obj.countAndSay(11));
		System.out.println(obj.countAndSay(21));
		System.out.println(obj.countAndSay(1211));
	}
}
