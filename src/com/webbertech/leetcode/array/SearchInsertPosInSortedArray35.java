package com.webbertech.leetcode.array;

/*Leetcode 35 Search Insert Position
 * 
 * Given a sorted array and a target value, return the index if the
 * target is found. If not, return the index where it would be if it 
 * were inserted in order.
You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 â†? 2
[1,3,5,6], 2 â†? 1
[1,3,5,6], 7 â†? 4
[1,3,5,6], 0 â†? 0

solution: binary search, since this is sorted array, but need to see the logic, it is to raise low and lower high to control the logic
to jump.
Accepted.
 * */

public class SearchInsertPosInSortedArray35 {
	public static int searchInsert(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(A[mid] == target) {
            	return mid;
            }
            else if(A[mid] > target) {
            	high = mid-1;
            }
            else {
            	low = mid+1;
            }
        }
        return low;
	}
	
	
	public static void main(String[] args) {
		int a[] = {1,3,5,6};
		System.out.println(searchInsert(a,2));
	}
}