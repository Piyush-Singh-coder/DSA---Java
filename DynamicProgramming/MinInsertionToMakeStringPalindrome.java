package DynamicProgramming;

import java.util.Arrays;

public class MinInsertionToMakeStringPalindrome { // Min Insertions and deletions required to make it palindrome
    public static String reverse(String s1){
        String reversedString = "";
        for (int i = s1.length()-1; i>= 0; i--){
            reversedString += s1.charAt(i);
        }
        return reversedString;
    }
    public static int minInsertion(String s1, String s2){
        // String s2 = reverse(s1);
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i = 1; i<= m; i++){
            for(int j = 1; j<= n; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return (m - dp[m][n] + n - dp[m][n]);
    }
    public static void main(String[] args) {
        System.out.println(minInsertion("abcd", "anc"));
        // babbb
    }
}