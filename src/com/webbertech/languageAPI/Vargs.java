package com.webbertech.languageAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class Vargs {

    class Add {
        public void add(int ... nums) {
            int sum =0;
            int index =0;
            for (int i: nums) {
                sum+=i;
           
                if (index>=1)
                    System.out.print("+");
               System.out.print(i);
               index++;
            }
            System.out.print("="+sum+"\n");
            
           
       }
   }


		    public static void main(String[] args) {
		       try{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					int n1=Integer.parseInt(br.readLine());
					int n2=Integer.parseInt(br.readLine());
					int n3=Integer.parseInt(br.readLine());
					int n4=Integer.parseInt(br.readLine());
					int n5=Integer.parseInt(br.readLine());
					int n6=Integer.parseInt(br.readLine());
					Vargs v = new Vargs();
					Add ob=v.new Add();
					ob.add(n1,n2);
					ob.add(n1,n2,n3);
					ob.add(n1,n2,n3,n4,n5);	
					ob.add(n1,n2,n3,n4,n5,n6);
					Method[] methods=Add.class.getDeclaredMethods();
					Set<String> set=new HashSet<>();
					boolean overload=false;
					for(int i=0;i<methods.length;i++)
					{
						if(set.contains(methods[i].getName()))
						{
							overload=true;
							break;
						}
						set.add(methods[i].getName());
						
					}
					if(overload)
					{
						throw new Exception("Overloading not allowed");
					}
				 }
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
		

	
	        
         }

