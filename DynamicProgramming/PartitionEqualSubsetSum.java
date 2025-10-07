package DynamicProgramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static boolean canEqualPartition(int arr[]){
        int totalSum = 0;
        for (int val: arr){
            totalSum += val;
        }
         
        if (totalSum %2 == 1){
            return false;
        }else{
            int n = arr.length;
            int memo[][] = new int[n][(totalSum /2)+1];
            for (int row[]: memo){
                Arrays.fill(row, -1);
            }
            return memoization(arr, totalSum/2, n-1, memo);
        }
    }
    public static boolean memoization(int arr[], int target, int idx, int memo[][]){
        if (target == 0) return true;
        if (idx ==  0) return (arr[0] == target);
        if (memo[idx][target] != -1) {
            return (memo[idx][target] == 0 ? false: true);
        }
        boolean notTake = memoization(arr, target, idx-1, memo);
        boolean take = false;
        if (target >= arr[idx]){
            take = memoization(arr, target - arr[idx], idx - 1, memo);
        }
        memo[idx][target] = notTake || take ? 1 : 0;
        return notTake || take;
    }
    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 3, 4, 5};
        System.out.println(canEqualPartition(arr));
    }
}
