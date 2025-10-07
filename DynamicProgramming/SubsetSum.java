package DynamicProgramming;

import java.util.Arrays;

public class SubsetSum {
    public static boolean isSubsetSum(int arr[], int target){
        int n = arr.length;
        int memo[][] = new int[n][target+1];
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }
        return memoization(arr, target, n-1, memo);
    }
    public static boolean memoization(int arr[], int target, int n, int memo[][]){
        if (target == 0 ) return true;
        if (n == 0) return (arr[0] == target);
        if (memo[n][target] != -1) {
            return memo[n][target] == 0 ? false : true;
        }

        boolean notPick = memoization(arr, target, n-1, memo);
        boolean pick = false;
        if (target >= arr[n]){
            pick = memoization(arr, target - arr[n], n-1, memo);
        }
        memo[n][target] = pick || notPick ? 1 : 0;
        return pick || notPick;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int target = 6;
        System.out.println(isSubsetSum(arr, target));
    }
}
