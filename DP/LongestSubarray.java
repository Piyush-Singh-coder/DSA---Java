package DP;

public class LongestSubarray {
    public static int longestSubarray(String str1, String str2, int m, int n){
        int dp[][] = new int[m+1][n+1];
        for(int i = 0; i<= m; i++){
            for(int j = 0; j<= n; j++){
                if( i== 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i = 1; i<= m; i++){
            for(int j = 1; j<= n ; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        for (int i = 1; i<= m; i++){
            for(int j = 1; j<= n; j ++){
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "AGGTXAYB";
        int m = str1.length();
        int n = str2.length();
        int ans = longestSubarray(str1, str2, m, n);
        System.out.println(ans);
    }
}
