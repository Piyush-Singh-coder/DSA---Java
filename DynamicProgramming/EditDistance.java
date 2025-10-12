package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    public static int minOperations(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        
        for (int i = 0; i<=m ; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j<= n; j++){
            dp[0][j] = j;
        }
        for (int i = 1; i<=m ; i++){
            for (int j = 1; j<= n; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 0 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(
                                            Math.min(
                                            dp[i-1][j], //Deletion
                                            dp[i][j-1]  // Insertion
                                            ),
                                        dp[i-1][j-1]
                    );
                }
            }
        }
        return dp[m][n];
    }
    public static int minNoOfOperations(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int memo[][] = new int[m][n];
        
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }
        return memoization(m-1, n-1, s1, s2, memo);
    }
    public static int memoization(int i, int j, String s1, String s2, int memo[][]){
        if (i<0){
            return j+1;
        }
        if (j<0){
            return i+1;
        }
        if (memo[i][j] != -1) return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j)){
            return memo[i][j] =  0 + memoization(i-1, j-1, s1, s2, memo);
        }
        return memo[i][j] = 1 + Math.min(Math.min(memoization(i-1, j, s1, s2, memo), memoization(i, j-1, s1, s2, memo)), memoization(i-1, j-1, s1, s2, memo));
    }
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(minNoOfOperations(s1, s2));
    }
}
