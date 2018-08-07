package com.webbertech.leetcode.array;
import java.util.ArrayList;
/*
 * Leetcode 88
 * 
 * Given two sorted integer arrays nums1 and nums2, 
 * merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n)
to hold additional elements from nums2. The number of elements initialized in nums1 
and nums2 are m and n respectively.

Solution: like a normal merge to a list of extra space, and copy that list into array1.
 * */

public class MergeTwoSortedArray_leetcode88 {
	//assuming both are in accending order
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	if (n==0) {
    		return;
    	}
        ArrayList<Integer> a = new ArrayList<>();
        int i=0,j=0;
    	while(i<m && j<n) {
    		if (nums1[i]<nums2[j]) {
    			a.add(nums1[i]);
    			i++;
    		} else {
    			a.add(nums2[j]);
    			j++;
    		}
    	}
    	while(i<m) {
    		a.add(nums1[i]);
    		i++;
    	}
    	while(j<n) {
    		a.add(nums2[j]);
    		j++;
    	}
    	for(int k=0;k<m+n;k++) {
    		nums1[k] = a.get(k);
    	}
    }
    
    public static void main(String[] args) {
    	int[] a = {1,2,3,4,5,0};
    	int[] b={3};
    	merge(a,5,b,1);
        for(int i=0;i<a.length;i++) {
        	System.out.println(a[i]);
        }
    }
}