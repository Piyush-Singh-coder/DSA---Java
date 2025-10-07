package DynamicProgramming;

import java.util.Arrays;

public class targetSum {
    public static int targetSum(int arr[], int target){
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i<arr.length; i++){
            sum += arr[i];
        }
        if ((sum+target) %2 == 1) return 0;
        if (sum < target ) return 0;
        int s1 = (sum+target)/2;
        int memo[][] = new int[n][s1+1];
        for (int row[]: memo){
            Arrays.fill(row, -1);
        }
        return memoization(arr, memo, n-1, s1);
    }
    public static int memoization(int arr[], int memo[][], int idx, int target){
        if (idx == 0){
            if (arr[0] == 0) return 2;
            if (arr[0] == target || target == 0) return 1;
            return 0;
        }
        if (memo[idx][target] != -1) return memo[idx][target];

        int notTake = memoization(arr, memo, idx-1, target);
        int take = 0;
        if (target >= arr[idx]){
            take = memoization(arr, memo, idx-1, target-arr[idx]);
        }
        return memo[idx][target] = take + notTake;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,1};
        int target = 3;
        System.out.println(targetSum(arr, target));
    }
}
