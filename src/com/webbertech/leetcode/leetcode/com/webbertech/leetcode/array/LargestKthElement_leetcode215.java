package com.webbertech.leetcode.array;
import java.util.Arrays;
import java.util.PriorityQueue;
/*
 * Leetcode 215
 * 
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, 
 * not the kth distinct element. 
For example,
Given [3,2,1,5,6,4] and k = 2, return 5. 
Note: 
You may assume k is always valid, 1 <= k <=array's length.
 * 
 * 
 * Solution: This solution makes use of the nlogn but without much improvement
 * 
 * */

public class LargestKthElement_leetcode215 {
	
	//solution1: simplest
	//O(N lg N) running time + O(1) memory
	public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
	
	
	// solution2: A little better than the previous one
	/* O(N lg K) running time + O(K) memory using priority queue
	 * An unbounded priority queue based on a priority heap. 
	 * The elements of the priority queue are ordered according to
	 * their natural ordering, or by a Comparator provided at queue
	 * construction time, depending on which constructor is used. 
	 * A priority queue does not permit null elements. 
	 * A priority queue relying on natural ordering also does not permit 
	 * insertion of non-comparable objects 
	 * (doing so may result in ClassCastException). 
	 * */
	public static int findKthLargest2(int[] nums, int k) {
	    final PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int val : nums) {
	        pq.offer(val);
	        if(pq.size() > k) {
	            pq.poll();  //remove head
	        }
	    }
	    return pq.peek(); //return head
	}
	
	/*
	 * Solution: this is quick sort method --- generic
	 * 
	 *  O(N) best case / O(N^2) worst case running time + O(1) memory
    	The smart approach for this problem is to use the selection algorithm 
    	(based on the partion method - the same one as used in quicksort).
    	
    	3,2,1,5,6,4, k = 2
	 * */
	public static int findKthLargest3(int[] nums, int k) {
		// the second largest number in array with 6 elements, is 4th largest number, index is 4.
		k = nums.length - k;
        int lo = 0;
        int hi = nums.length-1;  //pay attention here, if you change to nums.length it will fail for input ([1], 1)
        while (lo < hi) {
        	// j is the pivot
            final int j = partition(nums, lo, hi);  // 5,2,3,1,6,4, j=2
            System.out.println("debugging");
            System.out.println(j + " "+ lo + " " + hi);
            if(j < k) {
                lo = j + 1; //lo=3
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
	
	/*
	 * use two smaller function to make logic clear.
	 * write comment here.
	 * 
	 * for example the array is like : 3,2,1,5,6,4, k = 3
	 * 
	 * i = 0, j = 7
	 * while ... i = 3 a[3] == 5
	 * while ... j = 2 a[2] == 1
	 * 3,2,5,1,6,4
	 * swap, 5,2,3,1,6,4
	 * return 2
	 * */
	private static int partition(int[] a, int lo, int hi) {
        int i = lo;   //3
        int j = hi+1; //5
        //5,2,3,1,6,4
        while(true) {
        	/*i and j both compares with pivot, assuming the left most is the pivot
        	  For any i it is supposed to be smaller than lo(pivot) and i will increase.
        	  For any j it is supposed to be larger than lo(pivot), and j will decrease. 
        	*/
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

	// very simple
    private static void swap(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // very simple
    private static boolean less(int v, int w) {
        return v < w;
    }

	
	public static void main(String[] args) {
		int[] num = {3,2,1,5,6,4};
		int k = 2;
		System.out.println(findKthLargest3(num,k));
	}	
}