package com.webbertech.algorithm.tree;

//P??
//build a BST from a sorted array, 
//and it is most balanced and has the mininum depth

public class BuildMinDepthBST {

	static TreeNode createMininumBST(int[] array) {
		return createMininumBST(array, 0, array.length-1);
	}
	
	static TreeNode createMininumBST(int[] array, int start, int end) {
		if(end < start)
			 return null;
		
		//here is the trick, instead of substract
		int mid = (end+start)/2;
		TreeNode node = new TreeNode(array[mid]);
		node.left= createMininumBST(array, start,mid-1);
		
		node.right= createMininumBST(array,mid+1, end);
		return node;
	}
	
	public static void main(String[] args) {
		int[] array={1,2,3,4,5,6,7,8};
		TreeNode t = createMininumBST(array);
	    System.out.println(t.item);
	}
}
