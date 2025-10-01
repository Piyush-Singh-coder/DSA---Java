package DynamicProgramming;

import java.util.Arrays;

public class FrogJump {
    public static int recursion(int n, int heights[]){
        int memo [] = new int[n];
        Arrays.fill(memo, -1);
        return memoization(memo,n-1, heights);
    }
    public static int frogJump(int i, int heights[]){
        if (i == 0){
            return 0;
        }
        int left = frogJump(i-1, heights) + Math.abs(heights[i] - heights[i-1]);
        int right = Integer.MAX_VALUE;
        if (i > 1){
            right = frogJump(i-2, heights) + Math.abs(heights[i] - heights[i-2]);
        }
        return Math.min(left, right);
    }
    public static int memoization(int memo[], int i, int heights[]){
        if (i == 0) return 0;
        if (memo[i] != -1) return memo[i];
        int left =  memoization(memo, i-1, heights) + Math.abs(heights[i] - heights[i-1]) ;
        int right = Integer.MAX_VALUE;
        if (i > 1 ){
            right =memoization(memo, i-2, heights)+ Math.abs(heights[i] - heights[i-2]) ;
        }
        memo[i] = Math.min(left, right);
        return memo[i];
    }
    public static int tabulation(int idx, int heights[], int dp[]){
        int n = dp.length;
        dp[0] = 0;
        for (int i = 1; i<n; i++){
            int right = Integer.MAX_VALUE;
            int left = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            if (i > 1){
                right = dp[i-2] +  Math.abs(heights[i] - heights[i-2]);
            }
            dp[i] = Math.min(right, left);
        }
        return dp[idx];
    }
    public static void main(String[] args) {
        int heights[] = {10,20,30,10};
        System.out.println(recursion(4, heights));
    }
}
