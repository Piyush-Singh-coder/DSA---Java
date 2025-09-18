package DP;

public class LongestRepeatingSeq {
    public static String longestRepSeq(String a, int m){
        String b = new String(a);
        int n = b.length();
        int dp[][] = new int [m+1][n+1];

        for(int i = 0; i<= m; i++){
            for(int j = 0; j<= n; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i<= m; i++){
            for(int j = 1; j<= n; j++){
                if ((a.charAt(i-1) == b.charAt(j-1)) && i != j){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int i = n, j = n;
        StringBuilder sb = new StringBuilder("");
        while(i > 0 && j>0){
            if (dp[i][j] == dp[i-1][j-1] + 1){
                sb.append(a.charAt(i-1));
                i--;
                j--;
            }
            else if (dp[i][j] == dp[i-1][j]){
                i--;
            }else{
                j--;
            }
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String a = "aabb";
        System.out.println(longestRepSeq(a, a.length()));

    }
}
