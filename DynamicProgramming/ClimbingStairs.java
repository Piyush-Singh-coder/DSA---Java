package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {
    public static int distinctWays(int n){
        if (n == 0) return 1;
        if (n == 1) return 1;

        return (distinctWays(n-1)+ distinctWays(n-2));
    }
    public static int memo (int n){
        if (n == 0) return 1;
        if (n == 1) return 1;
        int dp [] = new int[n+1];
        for (int i = 0; i<n+1; i++){
            dp[i] = -1;
        }
        if (dp[n] != -1){
            return dp[n];
        }
        dp [n] = memo(n-1) + memo(n-2);
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 2;
        System.out.println(distinctWays(n));
        System.out.println(memo(n));
    }
}
