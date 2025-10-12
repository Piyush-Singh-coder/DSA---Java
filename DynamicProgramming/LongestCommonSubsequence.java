package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    // public static int lcs(String s1, String s2){
    //     int m = s1.length();
    //     int n = s2.length();
    //     return recursion(s1,s2,m-1,n-1);
    // }
    // public static int recursion(String s1, String s2, int m, int n){
    //     if (m < 0 || n<0){
    //         return 0;
    //     }
    //     if (s1.charAt(m) == s2.charAt(n)){
    //         return 1 + recursion(s1, s2, m-1, n-1);
    //     }
    //     return 0 + Math.max(recursion(s1, s2, m-1, n), recursion(s1, s2, m, n-1));
    // }


    // public static int lcs(String s1, String s2){
    //     int m = s1.length();
    //     int n = s2.length();
    //     int memo[][] = new int[m][n];
    //     for (int row[]: memo){
    //         Arrays.fill(row, -1);
    //     }
    //     return memoization(s1, s2, m-1, n-1, memo);
    // }
    // public static int memoization(String s1, String s2, int m, int n, int memo[][]){
    //     if (m<0 || n<0) return 0;
    //     if (memo[m][n] != -1) return memo[m][n];
    //     if (s1.charAt(m) == s2.charAt(n)){
    //         return memo[m][n] = 1 + memoization(s1, s2, m-1, n-1, memo);
    //     }
    //     return memo[m][n] = 0 + Math.max(memoization(s1, s2, m-1, n, memo), memoization(s1, s2, m, n-1, memo));
    // }

    public static int lcs (String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        for (int row[]: dp){
            Arrays.fill(row, -1);
        }
        for (int i = 0; i<=m; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j<=n; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i<=m; i++){
            for (int j = 1; j<=n; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        for(int row[]: dp){
            System.out.println(Arrays.toString(row));
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String s1 = "adebc";
        String s2 = "dcadb";
        System.out.println(lcs(s1, s2));
    }
}
