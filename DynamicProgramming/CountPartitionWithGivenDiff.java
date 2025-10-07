package DynamicProgramming;

import java.util.Arrays;

public class CountPartitionWithGivenDiff {
    public static int countPartition(int arr[], int diff){
        int totalSum = 0;
        for (int i = 0; i<arr.length; i++){
            totalSum += arr[i];
        }
        int n = arr.length;
        if (totalSum < diff ) return 0;
        if ((totalSum+diff) %2 == 1) return 0;
        int val = (totalSum + diff) / 2;
        int memo[][] = new int[n][val+1];
        for (int row[]: memo){
            Arrays.fill(row, -1);
        }
        return memoization(arr, memo,n-1,val);
    }
    public static int memoization(int arr[], int memo[][], int idx, int target){
        if (idx == 0){
            if (target == 0 && arr[0] == 0){ // if arr[0] == 0 then we can take it or not take it both cases are possible so return 2;
                return 2;
            }
            if (target == 0 || target == arr[0]){
                return 1;
            }
            return 0;
        }
        // if (idx == 0 ) return (target == arr[0] ? 1: 0);
        // if (target == 0) return 1;
        // if (memo [idx][target] != -1) return memo[idx][target];

        int notTake = memoization(arr, memo, idx - 1, target);
        int take = 0;
        if (target>= arr[idx]){
            take = memoization(arr, memo, idx-1, target - arr[idx]);
        }
        return memo[idx][target] = take + notTake;
    }
    public static void main(String[] args) {
        int arr[] = {5,2,6,4};
        int diff = 3;
        System.out.println(countPartition(arr, diff));
    }
}
