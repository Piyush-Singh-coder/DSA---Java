package DP;

// Count number of ways in which coins are taken to form the given sum from a given set of coins. Each type of coins are unlimited.
public class CountChangeProblemI {
    public static int noOfWays(int coins[], int sum, int n){
        int dp[][] = new int[n+1][sum+1];
        for(int i = 0; i<= n; i++){
            dp[i][0] = 1;
        }
        for(int j = 1; j<= sum; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<= sum ; j++){
                if (coins[i-1] <= j){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int coins [] = {1,2,3};
        int sum = 5;
        int n = coins.length;
        int ans = noOfWays(coins, sum, n);
        System.out.println(ans);
    }
}
