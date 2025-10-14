package DynamicProgramming;

import java.util.*;

public class BuyNSellStockV2 {
    public static int maxProfit(int stocks[]){
        int n = stocks.length;
        ArrayList<ArrayList<Integer>> memo = new ArrayList<>(n);
        for(int i = 0; i<stocks.length; i++){
            memo.add(new ArrayList<>(Arrays.asList(-1,-1)));
        }
        return memoization(stocks, 0, 0,n, memo);
    }
    public static int memoization(int stocks[], int idx, int buy, int n, ArrayList<ArrayList<Integer>> memo ){
        if (idx == n){
            return 0;
        }
        if (memo.get(idx).get(buy) != -1) return memo.get(idx).get(buy);
        int profit = 0;
        if (buy == 0){
            profit = Math.max(0+ memoization(stocks, idx+1, 0, n, memo), -stocks[idx] + memoization(stocks, idx+1, 1, n, memo));
        }
        if (buy == 1){
            profit = Math.max( 0 + memoization(stocks, idx+1, 1, n, memo), stocks[idx] + memoization(stocks, idx+1, 0, n, memo));
        }
        memo.get(idx).set(buy,profit);
        return profit;
    }
    public static void main(String[] args) {
        int stocks[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(stocks));   
    }
}
