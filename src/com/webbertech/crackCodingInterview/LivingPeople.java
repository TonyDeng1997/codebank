package com.webbertech.crackCodingInterview;

import java.util.Arrays;

//P482 a little difficult to get the logic right
/*
 * Living People: Given a list of people with their birth and death years.
 * Implement a method to compute the year with the most number of people alive.
 * If a person is born in 1908 and dies in 1909, then his life format is (1908,1909),
 * both years will be counted. Assume that most people live 
 * between 1900 and 2000(inclusive)
 * */

public class LivingPeople {

	//first thing is that think about the data format for program to execute
	//OO design will be fine
	
	public class Person {
		public int birth;
		public int death;
		
		public Person(int birth, int death) {
			this.birth = birth;
			this.death = death;
		}
	}
	
	//solution0: bruteforce 
	int maxAliveYear_brute(Person[] person, int min, int max) {
		//loop through 1900 to 2000 to see during each year
		//what is the alive and update maxAlive
		  int maxAlive =0;
		  int maxAliveYear = min;
		for (int year=min; year<=max; year++) {
			 int alive=0;  
		  for (Person p : person) {
			  if (p.birth<= year && year <= p.death) {
				   alive++;
			   }	
		  }  
		  if (alive> maxAlive) {
			  maxAlive = alive;
			  maxAliveYear = year;
		  }
		}
		System.out.println(maxAliveYear);
		System.out.println(maxAlive);
		return maxAliveYear;
	}
	
	
	/*solution1: min is the 1900, max is 2000, O(nlogn), n is the number of person
	 * test data
	 * birth: 12 20 10 01 10 23 13 90 83 75
	 * death: 15 90 98 72 98  82 98 98 99 94
	 * 
	 * sort it, the algorithm does not care that the birth of death year of the
	 * same person.
	 * 
	 *  birth: 01 10 10 12 13 20 23 75 83 90
	 *  death: 15 72 82 90 94 98 98 98 98 99
	 *  
	 *  the idea is that, 01, 10, 10, 12, 13 the aliveCount is 5,
	 *  then 15 one died, aliveCount is 4, 20, aliveCount is 5.
	 *  72, aliveAcount is 4, 23, aliveCount 5
	 *  75, aliveCount is 6. 72, aliveCount is 5, 82, aliveCount is 4.
	 *  83, aliveAcount is 5. 90 one died, aliveCount 4, 90 one born, aliveCount 5.
	*/
	int maxAliveYear(Person[] person, int min, int max) {
		int[] birth= getSortedYear(person, true);
		int[] death = getSortedYear(person, false);
		int currentAlive =0;
		int maxAlive = 0;
		int birthIndex =0;
		int deathIndex =0;
		int maxAliveYear = min; // need to return this
		
		while(birthIndex < birth.length) {
			if (birth[birthIndex] <= death[deathIndex]) {
				currentAlive++;
				if (currentAlive > maxAlive) {
					maxAlive = currentAlive;
					maxAliveYear = birth[birthIndex];
				}
				birthIndex++;
			} else if (birth[birthIndex] > death[deathIndex]) {
				currentAlive--;
				deathIndex++;
			}
		}
		System.out.println(maxAliveYear);
		System.out.println(maxAlive);
		return maxAliveYear;
	}
	
	
	//copyBirthYear is used to indicate copy birth Year or death year
	//the following method can be used to copy data to generate two arrays
	int[] getSortedYear(Person[] person, boolean copyBirthYear) {
		int[] sortedYear = new int[person.length];
		for(int i=0;i<person.length;i++) {
			int copied = copyBirthYear ? person[i].birth : person[i].death; 
			sortedYear[i]= copied;
		}
		Arrays.sort(sortedYear);
		return sortedYear;
	}
	
	public static void main(String[] args) {
		LivingPeople lp = new LivingPeople();
		Person[] persons = {
				lp.new Person(1912,1915),
				lp.new Person(1920,1990),
				lp.new Person(1910,1998),
				lp.new Person(1901,1972),
				lp.new Person(1910,1998),
				lp.new Person(1923,1982),
				lp.new Person(1913,1998),
				lp.new Person(1990,1998),
				lp.new Person(1983,1999),
				lp.new Person(1975,1994)
	  	};
	 	//lp.maxAliveYear(persons, 1900, 2000);
		lp.maxAliveYear_brute(persons, 1900, 2000);
	}
}
