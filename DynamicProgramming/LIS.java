package DynamicProgramming;

import java.util.Arrays;

public class LIS{
    public static int maxLength(int arr[]){
        int n = arr.length;
        int memo[][] = new int[n][n+1];
        for (int row[]: memo){
            Arrays.fill(row, -1);
        }
        return memoization(arr, memo, n, 0, -1);
    }
    public static int memoization(int arr[], int memo[][], int n, int idx, int preIdx){
        if (idx == n) return 0;
        if (memo[idx][preIdx + 1] != -1) return memo[idx][preIdx + 1];
        int notTake = 0 + memoization(arr, memo, n, idx +1, preIdx);
        int take = Integer.MIN_VALUE;
        if (preIdx == -1 || arr[idx] > arr[preIdx]){
            take = 1 + memoization(arr, memo, n, idx + 1, idx);
        }
        return memo[idx][preIdx+1] = Math.max(take, notTake);
    }

    // Another method
    public static int maxCount(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i<n; i++){
            for (int j = 0; j<i; j++){
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(1+dp[j], dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {10,9,2,5,3,7,101,18};
        System.out.println(maxLength(arr));
    }
}