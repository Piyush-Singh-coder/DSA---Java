package DynamicProgramming;

import java.util.Arrays;

public class BuyNSellStockV4 {
    public static int maxCost(int stocks[], int k){
        int n = stocks.length;
        int memo[][][] = new int[n][2][k+1];
        for (int rows[][]: memo){
            for (int row[]: rows){
                Arrays.fill(row, -1);
            }
        }
        return memoization(stocks, n, 0,0,k, memo);
    }
    public static int memoization(int stocks[], int n, int idx, int buy, int k, int memo[][][]){
        if (idx == n || k == 0){
            return 0;
        }
        if (memo[idx][buy][k] != -1) return memo[idx][buy][k];
        int profit = 0;
        if (buy == 0){
            profit = Math.max(0 + memoization(stocks, n, idx + 1, 0, k, memo), -stocks[idx] + memoization(stocks, n, idx + 1, 1, k, memo));
        }
        if (buy == 1){
            profit = Math.max(0 + memoization(stocks, n, idx + 1 , 1, k, memo), stocks[idx] + memoization(stocks, n, idx + 1, 0, k-1, memo));
        }
        memo[idx][buy][k] = profit;
        return profit;
    }
    public static void main(String[] args) {
        int stocks[] = {3,3,5,0,0,3,1,4};
        System.out.println(maxCost(stocks, 2));
    }
}
