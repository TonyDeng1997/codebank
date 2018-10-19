package com.webbertech.leetcode.array.coin;
import java.util.Arrays;

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
 
public class CoinChange_leetcode322 {
	
	// Basic solution
	// 因为个数是无穷的，所以就是一个完全背包计数问题，dp[i]表示合到i所需要的最少个数，dp初始化为无穷大，dp[0] = 0
    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                int pre = j - coins[i];
                if(pre >= 0 && dp[pre] < Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[pre] + 1);
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE) {
        	return -1;
        }
        return dp[amount];
    }

    // A better solution
    /*
     * Explanation: Take the coins array as 5,2,1 in this order, amount = 1, 
     * so it can repeat, then the return should be 3, and the combination is 5,5,1.
     * 
     * */
    public static int coinChange(int[] coins, int amount) {
	        int[] dp = new int[amount + 1];
	        
	        /* Try to note that dp[0] is 0, this is the initial point,
	          	for every inner loop, for the first coin's index, dp[i-coin] is dp[0] which is 0. 
	           Preset the value to Integer.MAX_VALUE-1
	        */
	        for (int i = 1; i <= amount; i++) {
	        	dp[i] = 0x7fff_fffe;
	        }
	        
	        for (int coin : coins) {
	            for (int i = coin; i <= amount; i++) {
	            	/*
	            	 * Here is how it works, for array 5,2,1 with amount 11, for simplicity, I make 5 in the front
	            	 * 1/ when i is coin' value, dp[i] will be 0+1 =1 for the first one.
	            	 * 2/ when i is coin's value's multitude say i is 10, dp[10-5]+1, is like to increment
	            	 * dp[5] which is in the same index so it becomes 2.
	            	 * 3/ Since for every new coin, the dp[i] is 1 (because dp[0] is 0)
	            	 * 4/ Repeating, for multitude of coin, it will increment this coin's count 
	            	 * */
	                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
	                System.out.println("here: " + i + ' ' + dp[i]);
	            }
	        }
	        // There is a case where dp[amount] has no record meaning the amount can not be found by the combination of
	        // numbers in the array
	        return dp[amount] == 0x7fff_fffe ? -1 : dp[amount];
	 }
	 
	public static void main(String[] args) {
		/*System.out.println(coinChange(new int[] {1,2,5},11));*/
		int d = 0x7fff_fffe; 
		System.out.println(d);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(coinChange(new int[] {5,1,2},11));
	}
}
