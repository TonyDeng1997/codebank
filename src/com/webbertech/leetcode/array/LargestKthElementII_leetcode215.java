package com.webbertech.leetcode.array;

import java.util.Random;

public class LargestKthElementII_leetcode215 {

	/*  Another solution with more improvement?
	 * 
	 *  O(N) guaranteed running time + O(1) space
		So how can we improve the above solution and make it O(N) guaranteed? 
		The answer is quite simple, we can randomize the input, 
		so that even when the worst case input would be provided the algorithm 
		wouldn't be affected. 
		So all what it is needed to be done is to shuffle the input.
	 * */
	public static int findKthLargest(int[] nums, int k) {

        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
	

    private static boolean less(int v, int w) {
        return v < w;
    }
	
	private static int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

	private static void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    
    private static void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }

	public static void main(String[] args) {
		int[] num = {3,2,1,5,6,4};
		int k = 2;
		System.out.println(findKthLargest(num,k));
	}
}
