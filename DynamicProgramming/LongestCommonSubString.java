package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubString {
    public static int lcs(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        for (int row[]: dp){
            Arrays.fill(row, -1);
        }
        for (int i = 0; i<= m ;i++){
            dp[i][0] = 0;
        }
        for (int j = 0; j<= n; j++){
            dp[0][j] = 0;
        }
        int ans = 0;
        for (int i = 1; i <= m; i++){
            for (int j = 1; j<= n; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";
        System.out.println(lcs(s1, s2));
    }
}
