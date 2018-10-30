package com.webbertech.leetcode.matrix;

import java.util.PriorityQueue;

/*
 * Leetcode 378 Kth smallest element in sorted squared matrix
 * 
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

Note:
You may assume k is always valid, 1 ? k ? n2.
**/

/*
 * Solution: note that the matrix, the first element of each row or column of the next row or column
 * is not necessary to be larger than the last element of the previous row or column.
 * For example the last element of the first column is 12, and the first element of the second column is 5, and ..etc.
 * So the kth smallest is not n[n/k][n%k-1].
 * 
 * Thought 1, make it in a one-dimensional array, and sort it in nlogn or use the Kth smallest algorithm using partition algorithm method.
 * Thought 2, build a binary search tree from the array, and use lgn to search for it. But building the tree will be n.
 * Then use inorder traversal to get an array, then return the kth element.
 * 
 * solution: 
 * https://discuss.leetcode.com/topic/52948/share-my-thoughts-and-clean-java-code
 * 
 *
 * */

public class KthSmallestElementInMatrix_leetcode378 {

	
	/*
	 *  solution1:
 * 
 *  Binary Search
	We are done here, but let's think about this problem in another way:
	The key point for any binary search is to figure out the "Search Space". 
	For me, I think there are two kind of "Search Space" 
	-- index and range(the range from the smallest number to the biggest number). 
	Most usually, when the array is sorted in one direction, we can use index as "search space", 
	when the array is unsorted and we are going to find a specific number, we can use "range".

	Let me give you two examples of these two "search space"

    index -- A bunch of examples -- https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ ( the array is sorted)
    range -- https://leetcode.com/problems/find-the-duplicate-number/ (Unsorted Array)

	The reason why we did not use index as "search space" for this problem is the matrix is sorted in two directions, we can not find a linear way to map the number and its index.


    How this works, with the following example,
    
    matrix = [
   	[ 1,  5,  9],
   	[10, 11, 13],
   	[12, 13, 15]
	],
	k = 8,

    1/ First it finds, the mid element of the whole matrix which is 8.
    2/ Then it checks each row, starting from the last element, because 
       that is the largest number in a row and compare it with the mid
       element 8, if it is larger, then go to the previous number in that 
       row. Until it is equal or less than the mid element 8.
    3/ After scanning the first row, the count is 2. Second, third row, count are all 0.
    4/ set lo = mid+1. Then count for scanning three rows are: 3,0,0. 
       set lo = 10. Then count is : 3+1
       set lo = 11. Then count is : 3+2.
       set lo = 12. Then count is: 3+2+1.
       set lo = 13. Then count is: 3+3+2 == 8.
       return lo.
	**/
	
	
	public static int kthSmallest(int[][] matrix, int k) {
		int lo = matrix[0][0];
		int hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int count = 0, j = matrix[0].length - 1;
			// The following is to check each row how many elements are equal or less than the mid
			for (int i = 0; i < matrix.length; i++) {
				while (j >= 0 && matrix[i][j] > mid) {
					j--;
				}
				count += (j + 1);
			}
			if (count < k) {
				lo = mid + 1;
			}
			else {
				hi = mid;
			}
		}
		return lo;
	}
	
	 //TODO
	  public  static int kthSmallest2(int[][] matrix, int k) {
	        int n = matrix.length;
	        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
	        for(int j = 0; j <= n-1; j++) pq.offer( new KthSmallestElementInMatrix_leetcode378.Tuple(0, j, matrix[0][j]));
	        for(int i = 0; i < k-1; i++) {
	            Tuple t = pq.poll();
	            if(t.x == n-1) continue;
	            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
	        }
	        return pq.poll().val;
	    }
	
	  
	 static class Tuple implements Comparable<Tuple> {
		    int x, y, val;
		    public Tuple (int x, int y, int val) {
		        this.x = x;
		        this.y = y;
		        this.val = val;
		    }
		    
		    @Override
		    public int compareTo (Tuple that) {
		        return this.val - that.val;
		    }
		}
	  
	  
	public static void main(String[] args) {
		int[][] a={{1,5,9},{10,11,13},{12,13,15}};
		System.out.println(kthSmallest(a,8));
	}
}
