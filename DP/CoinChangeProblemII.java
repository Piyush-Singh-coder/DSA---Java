package DP;

public class CoinChangeProblemII {
    public static int noOfCoins(int coins[], int sum, int n){
        int dp[][] = new int[n+1][sum+1];
        for(int i = 0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j<= sum ; j++){
            dp[0][j] = Integer.MAX_VALUE-1;
        }
        for(int j = 1; j<=sum; j++){
            if (j % coins[0] == 0){
                dp[1][j] = j / coins[0];
            }else{
                dp[1][j] = Integer.MAX_VALUE -1;
            }
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j<= sum ; j++){
                if (coins[i-1] <= j){
                    dp[i][j] = Math.min (dp[i][j-coins[i-1]] + 1 , dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int coins[] = {25,10,5};
        int sum = 30;
        int n = coins.length;
        int ans = noOfCoins(coins, sum, n);
        System.out.println(ans);
    }
}
