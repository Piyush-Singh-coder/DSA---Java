package DP;

public class SubsetSum {
    public static boolean subsetSum(int arr[], int sum, int n) {
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; // sum 0 is always possible
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false; // non-zero sum is impossible with 0 items
        }

        // Fill table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 7, 8};
        int sum = 11;
        int n = arr.length;
        System.out.println(subsetSum(arr, sum, n)); // true (2 + 8 + 1 doesn't exist, but 3 + 8 etc)
    }
}
