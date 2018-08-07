package com.webbertech.realinterview;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/* ICIMS interview questions
 * 
 * Array A is weight of customer
 * Array B is target floor customer is going.
 * M is the max number of people in the elevator
 * X is the total floors
 * Y is the max weight of users in the elevator
 * 
 * Time Complexity: No more than nlogn+m.
 * 
 * write a function to return how many stops the elevator will stops.
 * 
 * The final trip when the elevator is done all the requests, 
 * it will go to the first floor, and this will be counted too.
 * 
 * All users stand in a queue, so you can not shift their order.
 * 
 * Solution:
 * 
 * */

public class HotelEvalator {

	public static int solution(int[] A, int[] B, int M, int X, int Y) {
		// write your code in Java SE 8

		if (A == null || B == null || A.length != B.length || X == 0 || Y == 0) {
			throw new IllegalArgumentException();
		}

		if (A.length == B.length && A.length == 0) {
			return 0;
		}

		List<Integer> dest;
		int deliveryStops = 0;
		int groupStops = 0;
		try {
			dest = getGroups(A, B, M, X, Y);

			deliveryStops = getDeliveryStops(B, M, dest);
			groupStops = groupFloorStops(A, B, M, X, Y);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return deliveryStops + groupStops;
	}

	/*
	 * @return return the number of stops in the ground floor. Everytime it
	 * picks up the next group and the last final trip to the ground, this
	 * number is decided by how many groups.
	 */
	static int groupFloorStops(int[] A, int[] B, int M, int X, int Y) throws Exception {
		List<Integer> list = getGroups(A, B, M, X, Y);
		// If there is only one group, the final trip to the group is counted
		if (list.size() == 1) {
			return list.size() + 1;
		}
		return list.size();
	}

	/*
	 * Not include the ground stops, just in the middle of the stops Check
	 * unique numbers in each group. This worse case is a little aweful, need to
	 * revisit and change it
	 */
	static int getDeliveryStops(int[] B, int M, List<Integer> destination) throws Exception {
		int count = 0;
		for (int i : destination) {
			count += uniqueNumber(B, M, i);
		}
		return count;
	}

	static int uniqueNumber(int[] B, int M, int i) throws Exception {
		HashSet<Integer> set = new HashSet<>();
		int count = 0;
		while (i > 0) {
			if (B[i] > M) {
				throw new Exception("Dest is larger than the M");
			}
			if (!set.contains(B[i])) {
				set.add(B[i]);
				count++;
			}
			i--;
		}
		return count;
	}

	/*
	 * For the same group of passengers that put in one go put their B's index
	 * into the list. X is max number Y is max weight
	 * 
	 * @return the last index of the user that belongs in one group. If there
	 * are two indexes in it, then there will be two groups
	 */

	static List<Integer> getGroups(int[] A, int[] B, int M, int X, int Y) throws Exception {
		int totalWeight = 0;
		ArrayList<Integer> users = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > Y) {
				throw new Exception("User weight exeed Y" + A[i]);
			}
			if (count < X && totalWeight + A[i] < Y) {
				totalWeight = totalWeight + A[i];
				count++;
			} else {
				// reset weight
				totalWeight = 0;
				// reset counter
				count = 0;
				// save the last index of people in the queue
				// to be in the same group
				users.add(i - 1);
			}
			if (i == A.length - 1) {
				users.add(i);
			}
		}
		return users;
	}

	public static void main(String[] args) throws Exception {
		int[] A = { 40, 40, 100, 80, 20 };
		int[] B = { 3, 3, 2, 2, 3 };
		System.out.println(solution(A, B, 3, 5, 200));

		int[] A1 = { 60, 80, 40 };
		int[] B1 = { 2, 3, 5 };
		System.out.println(solution(A1, B1, 5, 2, 200));

	}

}
