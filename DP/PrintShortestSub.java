package DP;

public class PrintShortestSub {
    public static String shortestCommonSubSeq(String a, String b, int m, int n){
        int dp[][] = new int [m+1][n+1];
        for (int i = 0; i<= m; i++){
            for(int j = 0; j<= n; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i = 1; i<= m; i++){
            for(int j = 1; j<= n; j++){
                if (a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        int i = m, j = n;
        StringBuilder sb = new StringBuilder("");
        while(i > 0 && j> 0){
            if (a.charAt(i-1) == b.charAt(j-1)){
                sb.append(a.charAt(i-1));
                i--;
                j--;
            }else{
                if (dp[i-1][j] < dp[i][j-1]){
                    sb.append(b.charAt(j-1));
                    j--;
                }else{
                    sb.append(a.charAt(i-1));
                    i--;
                }
            }
        }
        while(i > 0){
            sb.append(a.charAt(i-1));
            i--;
        }
        while(j > 0){
            sb.append(b.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        int m = a.length();
        int n = b.length();
        System.out.println(shortestCommonSubSeq(a, b, m, n));
    }
}
