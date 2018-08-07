package com.webbertech.leetcode.math;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*  Leetcode 118
 * 
 *  Given numRows, generate the first numRows of Pascal's triangle.

	For example, given numRows = 5,	
	Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
* */

public class PascalsTriangle_leetcode118 {

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
	    if (numRows<=0) { 
	    	return res;	
	    }
	    ArrayList<Integer> row = new ArrayList<>();
    	if (numRows == 1) {
	    	row.add(1);
	    	res.add(row);
	    	return res;
	    }
    	
	    if (numRows ==2) {
	    	row = new ArrayList<>();
	    	row.add(1);
	    	res.add(row);
	    	
	    	row = new ArrayList<>();
	    	row.add(1);
	    	row.add(1);
	    	res.add(row);
	    	return res;
	    }
    	
	    //if numRows == 3, if first got the list of lists of numRows ==2 and then add its own
    	res = generate(numRows-1); 
	    
	    List<Integer> lastRow = res.get(res.size()-1);
	    row = new ArrayList<>();
	    row.add(lastRow.get(0));
	    for(int i=1;i< lastRow.size();i++) {
	    	row.add(lastRow.get(i)+lastRow.get(i-1));
	    }
	    row.add(lastRow.get(lastRow.size()-1));
	    res.add(row);
		return res;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> list = generate(4);
		Iterator<List<Integer>> it = list.iterator();
		while(it.hasNext()) {
			List<Integer> row = it.next();
			 for (Integer i: row) {
				 System.out.println(i);
			 }
			 System.out.println();
		}
	}
}
