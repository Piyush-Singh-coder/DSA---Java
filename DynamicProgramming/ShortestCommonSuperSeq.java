package DynamicProgramming;

import java.util.Arrays;

public class ShortestCommonSuperSeq {
    public static String shortest(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        String res = "";
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                res += s1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                res += s1.charAt(i - 1);
                i--;
            } else {
                res += s2.charAt(j - 1);
                j--;
            }
        }

        while(i>0){
            res += s1.charAt(i-1);
            i--;
        }
        while(j>0){
            res += s2.charAt(j-1);
            j--;
        }
        StringBuilder sb = new StringBuilder(res);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";
        System.out.println(shortest(s1, s2));
    }
}
