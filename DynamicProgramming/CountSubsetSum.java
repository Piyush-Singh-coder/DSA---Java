package DynamicProgramming;

import java.util.Arrays;

public class CountSubsetSum {
    public static int countSubset(int arr[], int k){
        int n = arr.length;
        int memo[][] = new int[n][k+1];
        for (int[] row: memo){
            Arrays.fill(row, -1);
        }
        return memoization(arr,k,n-1,memo);
    }
    public static int memoization(int arr[], int k, int idx, int memo[][]){
        if (idx == 0){
            if (k == arr[0]){
                return 1;
            }else{
                return 0;
            }
        }
        if (k == 0){
            return 1;
        }
        if (memo[idx][k] != -1 ) return memo[idx][k];

        int notTake = memoization(arr, k, idx-1, memo);
        int take = 0;
        if (arr[idx] <= k){
            take = memoization(arr, k-arr[idx], idx-1, memo);
        }
        return memo[idx][k] = notTake + take;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,2,3};
        int k = 3;
        System.out.println(countSubset(arr, k));
    }
}
