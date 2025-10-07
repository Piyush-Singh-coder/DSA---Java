package DynamicProgramming;

import java.util.Arrays;

public class MaxPathFallingSum {
    public static int maxPath(int grid[][]){
        int m = grid.length;
        int n = grid[0].length;

        int memo[][] = new int[m][n];
        for (int[] row: memo){
            Arrays.fill(row, -1);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++){
            int ans = memoization(grid, m-1, i, n, memo);
            max = Math.max(ans, max);
        }
        return max;
    }
    public static int memoization(int grid[][], int i, int j, int n, int memo[][]){
        if (j < 0 || j >=n) return (int) (-1e9);
        if (i == 0) return grid[0][j];
        if (memo[i][j] != -1) return memo[i][j];

        int up = grid[i][j] + memoization(grid, i-1, j, n, memo);
        int leftDiagonal = grid[i][j] + memoization(grid, i-1, j-1, n, memo);
        int rightDiagonal = grid[i][j] + memoization(grid, i-1, j+1, n, memo);
        return memo[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 10, 4},
                          {100, 3, 2, 1},
                          {1, 1, 20, 2},
                          {1, 2, 2, 1}};

        // Call the getMaxPathSum function and print the result
        System.out.println(maxPath(matrix));
    }
}
