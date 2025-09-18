package DP;

public class MinDeletionPalindrome {
    public static int minDeletion(String a, String b, int m, int n){
        int dp[][] = new int [m+1][n+1];
        for(int i = 0; i<= m; i++){
            for(int j = 0; j<= n; j++){
                if (i == 0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i = 1; i<=m; i++){
            for(int j =1 ; j<= n; j++){
                if (a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return m-dp[m][n];
    }
    public static void main(String[] args) {
        String a = "aebcbda";
        String b = new StringBuilder(a).reverse().toString();
        int m = a.length();
        int n = b.length();
        int ans = minDeletion(a,b,m, n);
        System.out.println(ans);
    }
}
