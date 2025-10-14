package DynamicProgramming;

import java.util.Arrays;

public class BuyNSellStockV3 {
    public static int maxCost(int stocks[]){
        int n = stocks.length;
        int memo[][][] = new int[n][2][3];

        for (int rows[][]: memo){
            for (int row[]: rows){
                Arrays.fill(row, -1);
            }
        }

        return memoization(stocks, 0, 0, 2, n, memo);
    }
    public static int memoization(int stocks[], int idx, int buy, int transactions, int n, int memo[][][]){
        if (idx == n || transactions == 0){
            return 0;
        }

        if (memo[idx][buy][transactions] != -1) return memo[idx][buy][transactions];
        int profit = 0;
        if (buy == 0){
            profit = Math.max(0 + memoization(stocks, idx + 1, 0, transactions, n, memo), -stocks[idx] + memoization(stocks, idx + 1, 1, transactions, n, memo) );
        }
        if (buy == 1){
            profit = Math.max(0 + memoization(stocks, idx + 1, 1, transactions, n, memo), stocks[idx] + memoization(stocks, idx + 1, 0, transactions - 1, n, memo));
        }
        memo[idx][buy][transactions] = profit;
        return profit;
    }
    public static void main(String[] args) {
        int stocks[] = {3,3,5,0,0,3,1,4};
        System.out.println(maxCost(stocks));
    }
}
