package com.webbertech.algorithm;

import java.util.ArrayDeque;

public class MathParser {

	/*
	 *  (1+2) * 3 + 4*5
		2*2 +3 + 4*5
		(2*3+1)/2 + 4 
		((1+2)*2-4) * 2
		
	   Algorithm: two stack numStack and opStack
	     opStack will store (, ), +, -, *, /, ^..etc
	     0/ method: build string: pop and concat everything from number stack and then concat all the signs from opStack except
	        the (
	     1/ when hit ), build String in step 0,  discard '('
	     2/ if incoming is operator with lower or equal precedence than the operator in the opStack, then :
	         a. build string in step 0,
	         b. push the new operator into opStack  
		
	 * */
	 private  ArrayDeque<Character> opStack;
	 private  ArrayDeque<String> numStack;
	 
	 public MathParser() {
		 opStack = new ArrayDeque<>();
		 numStack = new ArrayDeque<>();
	 }
	 
	 int precedence(char ch) {
	   int res =0;
		 if (ch == '+' || ch == '-')
		   res=1;
	   else if (ch == '*' || ch == '/')
	       res=2;
		 
		 return res;
	 }
	 
	  StringBuilder formString(StringBuilder s) {
		  while (!numStack.isEmpty()) {
   			s.append(numStack.pop());
   	    	}
   		 
		   while (!opStack.isEmpty() && opStack.peek()!= '(') {
   	    	 
   	    		s.append(opStack.pop());
   	       }
   	     	      return s;
	   }
	 
	  String getPostFix(String expr) {
	   char[] charArray = expr.toCharArray();
	   StringBuilder s = new StringBuilder();
	   
	    for (char ch : charArray) {
	    	if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/' ) {
	    		
	    		// if push + , but opStack has *, rule: incoming sign has lower precedence, then build the string
	    		if (!opStack.isEmpty()&& precedence(ch) <= precedence(opStack.peek())) {
	    			 s =formString( s);
	    		} 
	    		
	    		opStack.push(ch);
	    	} else if (ch >= '0' && ch <= '9') {
	    		numStack.push(String.valueOf(ch));
	    	} 
	    	 else if (ch == ')') {
	    		 s= formString(s);
	    		  //discard '('
	    	   		opStack.pop();
	    	}
	    }
	 
	    s= formString(s);
	   	   
	  
	    return s.toString();
	 }
	 
	 public static void main (String[] args) {
		 MathParser parser = new MathParser();
		 
		 /*
		  * The following is not right, because think (1+2) == a
		  * then it is: (a*2-4)
		  * */
		   System.out.println( parser.getPostFix("(1+2)*3+4*5"));
		  System.out.println( parser.getPostFix("((1+2)*2-4)*2"));
		 
		  System.out.println( parser.getPostFix("2*3-4"));
		 
		  System.out.println( parser.getPostFix("1*2+3+4*5"));
		  
		  System.out.println( parser.getPostFix("(2*3+1)/2+4"));
	 }
	 
	 
}
