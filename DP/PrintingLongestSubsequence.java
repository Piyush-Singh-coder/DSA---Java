package DP;

public class PrintingLongestSubsequence {
    public static StringBuilder printLongestSequence(String str1, String str2, int m, int n){
        int dp[][] = new int[m+1][n+1];
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i<= m; i++){
            for(int j = 0; j<= n; j++){
                if (i == 0 || j== 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i<= m; i++){
            for(int j = 1; j<= n; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        int i = m, j = n;
        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if (dp[i-1][j] < dp[i][j-1]){
                    j--;
                }
                else{
                    i--;
                }
            }
        }
        return sb.reverse();
    }
    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "AXBCYD";
        int m = str1.length();
        int n = str2.length();
        System.out.println(printLongestSequence(str1, str2, m, n));
    }
}
