package DynamicProgramming;

import java.util.Arrays;

public class MinimumPathSum {
    public static int minimumPathSum(int grid[][]){
        int m = grid.length;
        int n = grid[0].length;
        int memo[][] = new int[m][n];
        for (int[] row : memo){
            Arrays.fill(row, -1);
        }
        return memoization(grid, m-1, n-1, memo);
    }
    public static int memoization(int grid[][], int m, int n, int memo[][]){
        if (m == 0 && n == 0) return grid[0][0];
        if (m < 0 || n <0) return (int) (1e9);
        if (memo[m][n] != -1) return memo[m][n];
        int up = grid[m][n] + memoization(grid, m-1, n, memo);
        int left = grid[m][n] + memoization(grid, m, n-1, memo);
        return memo[m][n] = Math.min(up, left);
    }
    public static void main(String[] args) {
        int grid[][] = {
                        {5,9,6},
                        {11,5,2},
        };
        System.out.println(minimumPathSum(grid));
    }
}
