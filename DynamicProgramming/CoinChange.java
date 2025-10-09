package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public static int noOfWays(int coins[], int target){
        int n = coins.length;
        int memo[][] = new int[n][target+1];
        for (int row[]: memo){
            Arrays.fill(row, -1);
        }
        return memoization(coins,target, memo, n-1);
    }
    public static int memoization(int coins[], int target, int memo[][], int idx){
        if (idx == 0){
            if ((target % coins[0]) == 0){
                return 1;
            }else{
                return 0;
            }
        }
        if (memo[idx][target] != -1) return memo[idx][target];
        int notTake= memoization(coins, target, memo, idx -1);
        int take = 0;
        if (target >= coins[idx]){
            take = memoization(coins, target-coins[idx], memo, idx);
        }
        return memo[idx][target] = notTake + take;
    }
    public static void main(String[] args){
        int arr[] = {1,2,3};
        int target = 4;
        System.out.println(noOfWays(arr, target));
    }
}
