package DynamicProgramming;

import java.util.Arrays;

public class BuyNSellStockV5 {
    public static int maxCost(int stocks[]){
        int n = stocks.length;
        int memo[][] = new int[n][2];
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }
        return memoization(stocks, n, 0,0,memo);
    }
    public static int memoization(int stocks[], int n, int idx, int buy, int memo[][]){
        if (idx >= n){
            return 0;
        }
        if (memo[idx][buy] != -1) return memo[idx][buy];
        int profit = 0;
        if (buy == 0){
            profit = Math.max(0 + memoization(stocks, n, idx + 1, 0, memo), -stocks[idx] + memoization(stocks, n, idx + 1, 1, memo));
        }
        if (buy == 1){
            profit = Math.max(0 + memoization(stocks, n, idx + 1, 1, memo), stocks[idx] + memoization(stocks, n, idx + 2, 0, memo));
        }
        memo[idx][buy] = profit;
        return profit;
    }
    public static void main(String[] args) {
        int stocks [] = {4,9,0,4,10};
        System.out.println(maxCost(stocks));
    }
}
