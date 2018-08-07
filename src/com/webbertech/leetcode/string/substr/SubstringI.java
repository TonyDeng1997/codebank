package com.webbertech.leetcode.string.substr;

import java.util.ArrayList;
import java.util.List;

//Iterative way to get all substrings
public class SubstringI {

	static List<String> allSubstring(String str) {
		List<String> list = new ArrayList<>();
		if (str.equals("")) {
			return list;
		}
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
			      list.add(str.substring(i, j));
			}
		}
		return list;
	}

	//Solution2 is optimized
	static List<String> allSubstringII(String str) {
		List<String> list = new ArrayList<>();
		if (str.equals("")) {
			return list;
		}

		for (int c = 0; c < str.length(); c++) {
			 /* 
			  substring always start from c, because the outer loop 
			  controls the starting index
			  the ending index of substring is c+i, i starts from 1.
			  substring is from start to end-1
			  for example, c=0, c+i= 1, substring is to take from 0 to 0
			  how to remember the inner loop index's upper bound?
			  c+i = 
			 * 
			 */
			for (int i = 1; i <= str.length() - c; i++) {
				System.out.print("("+c +","+ (c+i) +")"+ "\t");
              list.add(str.substring(c, c+i));
			}
		}
        return list;
	}

	
	public static void main(String[] args) {
		List<String> list = allSubstring("abc");
		for (String str : list) {
			System.out.println(str);
		}
	
	}
}
