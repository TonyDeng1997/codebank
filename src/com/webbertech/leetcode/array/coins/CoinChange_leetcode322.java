/*
 * Leetcode 322. Coin Change
 * 
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to 
 * make up that amount. If that amount of money cannot be made up by any combination 
 * of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1


Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
 * */
 
class Solution {
 
	  public int coinChange(int[] coins, int amount) {
	        if (coins.length == 0 || amount ==0) {
	            return -1;
	        }
	        
	        if (coins.length == 1 && coins[0] < amount) {
	            return -1;
	        }
	        
	        ArrayList<Integer> list = new ArrayList<>();
	        for (int i=0;i< coins.legnth;i++) {
	            list.add(coins[i]);
	        }
	        Collections.sort(list, Collections.reverseOrder());
	        int num = 0;
	        
	        //5, 2, 1
	        for (int i=0;i< list.size();i++) {
	            for (int j=0; j< list.)
	        }
	    }
	
	public static void main(String[] args) {
		
		System.out.println("hello");
	}
}