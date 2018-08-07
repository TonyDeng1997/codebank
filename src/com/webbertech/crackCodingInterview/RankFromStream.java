package com.webbertech.crackCodingInterview;

/* P412 
 * you are reading a stream of integers, and you are able to lookup the rank of number x,
 * rank is that number of integers less or equal to x but not include x itself.
 * 
 * To implement two methods:
 * 
 * tract(x): insert x into the data structure
 * getRankOfNumber(x) : returns a number
 * 
 * Example: 5, 1, 4, 4, 5, 9, 7, 13, 3
 * getRankOfNumber(1) = 0
 * getRankOfNumber(3) = 1
 * getRankOfNumber(4) = 3
 * 
 * 
 * solution 1: using an array to insert element in sorted order is not efficient, but binary search is 
 * easy.
 * 
 * solution 2: use binary search tree, 
 * 
 *    1/ if x equals to root, then return the left_size of root node
 *    2/ if x less than root, then getRankOfNode(root.left, x)
 *    3/ if x larger than root, then it is getRankOfNode(root,x) + 1 + getRankOfNode(root.right, x)
 * */

public class RankFromStream {
	
	public class RankNode {
		int data;
		int left_size = 0;
		RankNode left, right;
	    public RankNode(int d) {
	    	data = d;
	    }
	    
	    public void insert(int d) {
			if (d<= data) {
				if (left != null) left.insert(d);
				else {
					left = new RankNode(d);
				}
			    left_size++;	
			} else {
				if (right != null) {
					right.insert(d);
				} else {
					right = new RankNode(d);
				} 
			}
		}


		 public int getRank(int d) {
		    	if (d == data) {
		    		return left_size; 
		    	} else if (d < data) {
		    		if (left == null) return -1;
		    		else
		    		return left.getRank(d);
		    	} else {
		    		int right_rank = right == null ? -1 : right.getRank(d);
		    		if (right_rank == -1) return -1;
		    		else 
		    			return left_size+1 + right_rank;
		    	}
		 }
	}
	
	public static void main(String[] args) {
		RankFromStream obj = new RankFromStream();
		RankFromStream.RankNode node = obj.new RankNode(20);
		node.insert(15);
		node.insert(10);
		node.insert(5);
		node.insert(13);
		node.insert(25);
		node.insert(23);
		node.insert(24);
		System.out.println(node.getRank(24));
	}
}