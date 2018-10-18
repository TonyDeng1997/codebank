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
    public static int coinChange(int[] coins, int amount) {
	        int[] dp = new int[amount + 1];
	        for (int i = 1; i <= amount; i++) {
	        	dp[i] = 0x7fff_fffe;
	        }
	        
	        for (int coin : coins) {
	            for (int i = coin; i <= amount; i++) {
	                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
	            }
	        }
	        return dp[amount] == 0x7fff_fffe ? -1 : dp[amount];
	 }
	 
	public static void main(String[] args) {
		System.out.println(coinChange(new int[] {1,2,5},11));
		System.out.println(coinChange2(new int[] {1,2,5},11));
	}
}