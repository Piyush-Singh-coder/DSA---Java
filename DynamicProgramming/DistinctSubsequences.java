package DynamicProgramming;

import java.util.Arrays;

public class DistinctSubsequences {
    static int prime = (int) (Math.pow(10, 9) + 7);
    public static int countDistinct(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        
        for(int i = 0; i<=m ; i++){
            dp[i][0] = 1;
        }
        for(int j = 1; j<= n; j++){
            dp[0][j] = 0;
        }
        for (int i = 1; i<=m; i++){
            for(int j = 1; j<= n; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % prime ;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";
        System.out.println(countDistinct(s1, s2));
    }
}
