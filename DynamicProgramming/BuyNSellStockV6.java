package DynamicProgramming;

import java.util.Arrays;

public class BuyNSellStockV6 {
    public static int maxCost(int stocks[], int fee){
        int n = stocks.length;
        int memo[][] = new int[n][2];
        for(int row[]: memo){
            Arrays.fill(row, -1);
        }
        return memoization(stocks, n, 0, 0, memo, fee);
    }
    public static int memoization(int stock[], int n, int idx, int buy, int memo[][], int fee){
        if (idx == n) return 0;
        if (memo[idx][buy] != -1) return memo[idx][buy];
        int profit = 0;
        if (buy == 0){
            profit = Math.max(0 + memoization(stock, n, idx+1, buy, memo, fee), -stock[idx] + memoization(stock, n, idx+1, 1, memo, fee));
        }
        if (buy == 1){
            profit = Math.max(0 + memoization(stock, n, idx + 1, buy, memo, fee), (stock[idx] - fee)+ memoization(stock, n, idx+1, 0, memo,fee));
        }
        memo[idx][buy]= profit;
        return profit;
    }
    public static void main(String[] args) {
        int stocks[] = {1,3,2,8,4,9};
        System.out.println(maxCost(stocks, 2));
    }
}
