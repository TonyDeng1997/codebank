package com.webbertech.leetcode.math;

/*
 * Leetcode 119 Pascal's Triangle II
 * 
 * Given an index k, return the kth row of the Pascal's triangle.

	For example, given k = 3,
	Return [1,3,3,1].
	
	Solution accepted.
 * */
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_leetcode119 {

	 public List<Integer> getRow(int rowIndex) {
	        ArrayList<Integer> row = new ArrayList<>();
	    	
	    	if (rowIndex<0) { 
		    	return row;	
		    }
		    
		    if (rowIndex ==0) {
		    	row.add(1);
		    	return row;
		    }
	    	
		    if (rowIndex == 1) {
		    	row = new ArrayList<>();
		    	row.add(1);
		    	row.add(1);
		    	return row;
		    }
	    	
		    //if numRows == 3, if first got the list of lists of numRows ==2 and then add its own
	    	List<Integer> res = getRow(rowIndex-1); 
		    
		    row = new ArrayList<>();
		    row.add(res.get(0));
		    for(int i=1;i< res.size();i++) {
		    	row.add(res.get(i)+res.get(i-1));
		    }
		    row.add(res.get(res.size()-1));
		    return row;
	    }
}
