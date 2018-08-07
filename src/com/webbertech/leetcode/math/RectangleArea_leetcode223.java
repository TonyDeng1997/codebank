package com.webbertech.leetcode.math;

/*leetcode: 223. Rectangle Area
 * 
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown 

in the figure.


 * */
public class RectangleArea_leetcode223 {
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int result = (C - A) * (D - B) + (G - E) * (H - F); //Sum of areas of two rectangles
		
		if (F >= D || B >= H || E >= C || A >= G) {
			return result;
		}

		if (A == C && B == D)
			return (G-E) * (H-F);
		
		if (E == G && F == H)
			return (C-A)* (D-B);

		if (E >= A && E <= G) {
			return (C - E) * (D - F);
		}

		if (A >= E && A <= G) {

			return (B - F) * (H - F);
		}

		if (E >= A && G <= C && F >= B && H <= D) {
			return (H - F) * (G - E);
		}

		if (E >= A && G <= C && H >= D) {
			return (G - E) * (D - F);
		}

		if (A >= E && C <= G && B >= F && D <= H) {
			return (D - B) * (C - A);
		}

		if (A >= E && C <= G && D >= H) {
			return (H - B) * (C - A);
		}

		return 0;
	}
	
	public static int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
		int result = (C - A) * (D - B) + (G - E) * (H - F); //Sum of areas of two rectangles
		
		if (F >= D || B >= H || E >= C || A >= G) {
			return result;
		}
		int dx = Math.min(C, G) - Math.max(A, E); //Overlap length along x
	    int dy = Math.min(D, H) - Math.max(B, F); //Overlap length along y
	    return result - dx * dy;
	}

	public static void main(String[] args) {
		// expected 4
		System.out.println(computeArea(0, 0, 0, 0, -1, -1, 1, 1));
        // expected 17
		System.out.println(computeArea2(-2, -2, 2, 2, 3, 3,4, 4));
		
	}
}
