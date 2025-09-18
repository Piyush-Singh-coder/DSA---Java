package DP;

public class LongestSubsequence {
    public static int recursive(String str1, String str2, int m, int n){
        if (m == 0 || n== 0){
            return 0;
        }
        if (str1.charAt(m-1) == str2.charAt(n-1)){
            return 1 + recursive(str1, str2, m-1, n-1);
        }else{
            return Math.max(recursive(str1, str2, m-1, n) , recursive(str1, str2, m, n-1));
        }
    }

    public static int memoization(String str1, String str2, int m, int n){
        int memo[][] = new int [m+1][n+1];
        if (m == 0 || n == 0){
            return 0;
        }
        for(int i = 0; i<=m ; i++){
            for(int j = 0; j<= n; j++){
                memo[i][j] = -1;
            }
        }
        if (memo[m][n] != -1){
            return memo[m][n];
        }
        if (str1.charAt(m-1) == str2.charAt(n-1)){
            memo [m][n] = 1 + memoization(str1, str2, m-1, n-1);
        }else{
            memo [m][n] = Math.max(memoization(str1, str2, m-1, n), memoization(str1, str2, m, n-1));
        }
        return memo[m][n];
    }

    public static int bottomUp (String str1, String str2, int m, int n){
        int dp[][] = new int [m+1][n+1];
        for(int i = 0; i<= m; i++){
            for(int j = 0; j<= n; j++){
                if ( i== 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        
        for(int i = 1; i<= m; i++){
            for (int j = 1; j<= n ;j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp [i][ j] = 1 + dp [i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        int m = str1.length();
        int n = str2.length();
        int ans = bottomUp(str1, str2, m, n);
        System.out.println(ans);
    }
}
