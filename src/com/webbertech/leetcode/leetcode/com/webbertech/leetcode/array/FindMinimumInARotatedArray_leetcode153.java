package com.webbertech.leetcode.array;

/* Leetcode 153 Find Minimum in Rotated Sorted Array.
 * Suppose an array sorted in ascending order is rotated at some pivot 
 * unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). 
 * Find the minimum element. You may assume no duplicate exists in the array.
 * 
 * Solution: There are two cases:
 * 
 * 1/ the array is sorted ok, then the smallest is the in the left or the right most.
 *    descending in order or ascending in order, the counter is either n-1 or 0 to tell this.
 * 2/ If there is a flip, there are two cases:
 *    a. the array is decresing.
 *    b. the array is increasing.
 *    
 *    Start i =1 to n, and compare with i-1, and find this flip.
 *    First of all, we will need to be able to tell if the
 *    array is increasing or decreasing.
 *    
 *    In the second two 
 *   
 *    Leetcode passed.
 *    
 * */

public class FindMinimumInARotatedArray_leetcode153 {
    
	public static int findMin(int[] nums) {
		int count = 0; // use this to detect if the array is sorted in order
      
        int len = nums.length;
        
		for(int i=1;i< len;i++) {
    	   if (nums[i]> nums[i-1]) {
    		   count++;
    	   }
        } 
		// meaning the array is ascending and in order
		if (count == len-1) {
			return nums[0];
		} else if (count == 0) {
			// it is in descending order and in order
			return nums[len-1];
			
		} 
		
		// rotate it until it is in order, this is O(n)
		do {
			rotate(nums);
		}
		while(inOrder(nums) == -1);
		
		if (inOrder(nums) == 0) {
			return nums[0];
		}
		
		return nums[len-1];
	    	
    }
	
	static int inOrder(int[] nums) {
		int order = -1;  // -1 is initial, 0 is accending, 1 is descending
		int len = nums.length;
		int count =0;
		for(int i=1;i<len;i++) {
			if (nums[i] > nums[i-1]) {
				count++;
			}
		}
		
		if (count == len-1) {
			order = 0; 
		}
		
		count = 0; // reset and check descending
		
		for(int i=1;i<len;i++) {
			if (nums[i] < nums[i-1]) {
				count++;
			}
		}
		
		if (count == len-1) {
			order = 1;
		}
		
		return order;
	}
	
	//rotate 1 a time
	static void rotate(int[] nums) {
		int len = nums.length;
		int temp = nums[len-1];
		for (int i=len-1;i>0;i--) {
			nums[i] = nums[i-1];
		}
		nums[0] = temp;
	}
	
	
/*Solution2 Binary search
The minimum element must satisfy one of two conditions: 
1) If rotate, A[min] < A[min - 1]; 

2) If not, A[0]. Therefore, we can use binary search: 
check the middle element, if it is less than previous one, then it is minimum. 
If not, there are 2 conditions as well: If it is greater than both left and right element, 
then minimum element should be on its right, otherwise on its left.
* */
    public static int findMin2(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int low = 0, high = num.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            /*
             * In accending order, mid is always larger than mid-1,
             * so if you find a flip, then that is the number to return
             * */
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
        
            /*
             * If the mid is larger than both of the numbers in the head and tail,
             * then the min is in the right of mid.
             * Else if min is not both larger than two ends, then the min
             * is on the left of the mid, think about example,
             * 7,0,1,2,4,5,6, 2 is not larger than 7 and 6, then high = 1, and low is 7.
             * */
            if (num[mid]>= num[low] && num[mid] > num[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return num[high];
    }

	public static void main(String[] args) {
      int[] a = {7,0,1,2,3,4,5,6};
      int[] b = {0,7,6,5,4,3,2,1};
      int[] c = {2,3,1};
      int[] d = {1,2,3};
      
      System.out.println(findMin(a));
      System.out.println(findMin(b));
      System.out.println(findMin(c));
      
      System.out.println(inOrder(a));
      System.out.println(inOrder(b));
      System.out.println(inOrder(c));
      System.out.println(inOrder(d));
      
      /*
      rotate(a);
      for (int i: a) {
    	  System.out.println(i);
      }
      */
	}
}