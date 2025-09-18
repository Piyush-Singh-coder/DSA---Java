package DP;

public class SequencePatternMatching {
    public static boolean seqPatternMatch(String a, String b, int m, int n){
        int dp[][] = new int[m+1][n+1];

        for(int i = 0; i<= m; i++){
            for(int j = 0; j<= n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i = 1; i<= m; i++){
            for(int j = 1; j<= n; j++){
                if (a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n] == m;
    }
    public static void main (String[] args){
        String a = "abc";
        String b = "ahbgdc";

        System.out.println(seqPatternMatch(a,b, a.length(),b.length()));
    }
}
