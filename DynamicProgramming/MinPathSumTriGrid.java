package DynamicProgramming;

import java.util.Arrays;

public class MinPathSumTriGrid {
    public static int minimumPathSum(int grid[][], int n){
        int memo [][] = new int[n][n];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        return memoization(grid, memo, 0,0, n);
    }
    public static int memoization(int grid[][], int memo[][], int i, int j, int n){
        if (memo[i][j] != -1) return memo[i][j];
        if (i == n-1) return grid[i][j];
        
        int down = grid[i][j] + memoization(grid, memo, i+1, j, n);
        int bottomDown = grid[i][j] + memoization(grid, memo, i+1, j+1, n);
        return memo[i][j] = Math.min(down, bottomDown);
    }
    public static void main(String[] args) {
        int triangle[][] = {{1},
                            {2, 3},
                            {3, 6, 7},
                            {8, 9, 6, 10}};

        int n = triangle.length;
        System.out.println(minimumPathSum(triangle, n));

    }
}
