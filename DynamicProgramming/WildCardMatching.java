package DynamicProgramming;

import java.util.Arrays;

public class WildCardMatching {
    public static boolean isMatch (String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int memo[][] = new int[m][n];

        for (int row[]: memo){
            Arrays.fill(row, -1);
        }
        int ans =  memoization(m-1, n-1, s1, s2, memo);
        if (ans == 1){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isAllStars(String s, int idx){
        for (int i = idx; i>=0; i--){
            if (s.charAt(i) != '*'){
                return false;
            }
        }
        return true;
    }
    public static int memoization(int i, int j, String s1, String s2, int memo[][]){
        if (i<0 && j <0 ) return 1;
        if (i<0 && j>= 0) return 0;
        
        if (j< 0 && i>=0){
            return isAllStars(s1, i) ? 1 : 0;
        }

        if (memo[i][j] != -1) return memo[i][j];

        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?'){
            return memo[i][j] = memoization(i-1, j-1, s1, s2, memo);
        }
        if (s1.charAt(i) == '*'){
            return memo[i][j] = ((memoization(i-1, j, s1, s2, memo) == 1 ) || memoization(i, j-1, s1, s2, memo) == 1 ) ? 1 : 0;
        }
        return memo[i][j] = 0;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("**ay", "ray"));
    }
}
