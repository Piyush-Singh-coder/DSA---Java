package DynamicProgramming;

import java.util.Arrays;

import Hashing.linkedMap;

public class KnapSack01{
    public static int knapSack(int profit[], int weight[], int w){
        int n = profit.length;
        int memo[][] = new int[n][w+1];
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }
        return memoization(profit, weight, w, n-1, memo);

    }
    public static int memoization(int profit[], int weight[], int w, int idx, int memo[][]){
        if (idx == 0){
            if (w >= weight[idx]){
                return profit[idx];
            }else{
                return 0;
            }
        }
        if (memo[idx][w] != -1) return memo[idx][w];
        int notPick = 0 + memoization(profit, weight, w, idx-1, memo);
        int pick = Integer.MIN_VALUE;
        if (w >= weight[idx]){
            pick = profit[idx] + memoization(profit, weight, w-weight[idx], idx-1, memo);

        }
        return memo[idx][w] = Math.max(pick, notPick);
    }
    public static void main(String[] args) {
        int profit[] = {1,2,3};
        int weight[] = {4,5,1};
        int w = 4;
        System.out.println(knapSack(profit, weight, w));
    }
}