package DynamicProgramming;

import java.util.Arrays;

public class GridUniquePathV2 {
    public static int uniquePath(int grid[][], int m , int n){
        int memo [][] = new int[m][n];
        for (int[] row: memo){
            Arrays.fill(row, -1);
        }
        return memoization(grid, m-1, n-1, memo);
    }
    public static int memoization(int grid[][], int m , int n, int memo[][]){
        if (m >= 0 && n >= 0 && grid[m][n] == -1){
            return 0;
        }
        if (m == 0 && n == 0){
            return 1;
        }    
        if (m < 0 || n < 0) {
            return 0;
        }
        
        if (memo[m][n] != -1){
            return memo[m][n];
        }
        
        int up = memoization(grid, m-1, n, memo);
        int left = memoization(grid, m, n-1, memo);
        
        return memo[m][n] = left + up;
    }
    public static void main(String[] args) {
        int grid [][] = {
                        {0,0,0},
                        {0,-1,0},
                        {0,0,0}
        };
        int m = grid.length;
        int n = grid[0].length;
        System.out.println(uniquePath(grid, m, n));
    }
}
