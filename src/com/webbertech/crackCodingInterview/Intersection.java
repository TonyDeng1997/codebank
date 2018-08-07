package com.webbertech.crackCodingInterview;

//given two straight line segments (start point and end point), compute
//the point of intersection if any

public class Intersection {

	class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void setLocation(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	class Line {
		double slope, yintercept;
		
		public Line(Point start, Point end) {
			double deltaY = end.y - start.y;
			double deltaX = end.x - start.x;
			slope = deltaY / deltaX;
			
		}
	}
	
	//a few condition: assuming they are on the same plane
	// same line: x1.start, x2.start, x1.end, x2.end, then intersect is x2.start to x1.end
	// crossing: slope1!=slope2
	Point findIntersect(Point start1, Point end1, Point start2, Point end2) {
		if (start1.x < end1.x) {
			swap(start1, end1);
		}
		if (start2.x < end2.x) {
			swap(start2, end2);
		}
        if (start1.x < start2.x) {
        	swap(start1, start2);
        	swap(end1, end2);
        }		
		return null;
	}
	
	void swap(Point a, Point b) {
	}
	
	public static void main(String[] args) {
		
	}
}
