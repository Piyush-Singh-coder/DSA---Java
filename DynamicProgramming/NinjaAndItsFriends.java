package DynamicProgramming;

import java.util.Arrays;

public class NinjaAndItsFriends {
    public static int maxChocolates(int matrix[][]){
        int m=matrix.length;
        int n = matrix[0].length;
        int i = 0, j1 = 0, j2 = n-1;
        int memo[][][] = new int[m][n][n];
        for(int[][] row: memo){
            for(int[] innerRow: row){
                Arrays.fill(innerRow, -1);
            }
        }
        return memoization(matrix, i, j1, j2, m, n, memo);
    }
    public static int memoization(int matrix[][], int i, int j1, int j2, int m, int n, int memo[][][]){
        if (j1>= n || j2 >= n || j1 < 0 || j2 < 0) return (int)-1e9;
        if (i == m-1){
            if (j1 == j2){
                return matrix[i][j1];
            }else{
                return matrix[i][j1]+ matrix[i][j2];
            }
        }
        if (memo[i][j1][j2] != -1) return memo[i][j1][j2];

        int max = Integer.MIN_VALUE;
        for(int di = -1 ; di<= 1 ; di++){
            for (int dj = -1; dj <= 1; dj++){
                int ans;
                if (j1 == j2){
                    ans = matrix[i][j1] + memoization(matrix, i+1, j1+di, j2+dj, m, n, memo);
                }else{
                    ans = matrix[i][j1] + matrix[i][j2] + memoization(matrix, i+1, j1+di, j2+dj, m, n, memo);
                }
                max = Math.max(ans, max);
            }
        }
        return memo[i][j1][j2] = max;
    }
    public static void main(String[] args) {
         int matrix[][] = {{2, 3, 1, 2},
                      {3, 4, 2, 2},
                      {5, 6, 3, 5}};
    int n = matrix.length;
    int m = matrix[0].length;

    // Call the maximumChocolates function and print the result
    System.out.println(maxChocolates(matrix));   
    }
}
