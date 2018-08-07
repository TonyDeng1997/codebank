package com.webbertech.realinterview;

/*
 * Interview questions of ICIMS.
 * Correct the following code in 3 lines. 
 * 
 * Solution:
 * 
 * In the while, there should be a case to stop the while when a[m] == x,
 * other wise, for example if the a[m] == x ,and it keeps recalculating 
 * the m, it will be dead loop.
 * */

public class BinarySearch {
    static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
      
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	int[] A={1,2,5,9,9};
    	
    	System.out.println(solution(A, 9));
    }
}
