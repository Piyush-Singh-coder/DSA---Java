package DynamicProgramming;

import java.util.Arrays;

public class MinCoins {
    public static int minCount(int coins[], int target){
        int n = coins.length;
        int memo[][] = new int[n][target+1];
        for (int row[]: memo){
            Arrays.fill(row, -1);
        }
        return memoization(coins, target, n-1,memo);
    }
    public static int memoization(int coins[], int target, int idx, int memo[][]){
        if(idx == 0){
            if (target % coins[0] == 0){
                return target/coins[0];
            }else{
                return (int)(1e9);
            }
        }
        int notTake = 0 + memoization(coins, target, idx - 1, memo);
        int take = (int)(1e9);
        if (target >= coins[idx]){
            take = 1 + memoization(coins, target-coins[idx], idx, memo);
        }
        return memo[idx][target] = Math.min(take, notTake);
    }
    public static void main(String[] args) {
        int coins [] = {1,2,3};
        int target = 7;
        System.out.println(minCount(coins, target));
    }
}
