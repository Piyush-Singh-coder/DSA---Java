package DynamicProgramming;

import java.util.Arrays;

public class RodCuttingProblem {
    public static int maxCost(int n, int [] price){
        int memo[][] = new int[n][n+1];
        for (int row[]: memo){
            Arrays.fill(row, -1);
        }
        return memoization(n-1,n, price, memo);
    }
    public static int memoization(int idx, int n, int price[], int memo[][]){
        if (idx == 0){
            return price[0] * n;
        }
        if (memo[idx][n] != -1) return memo[idx][n];

        int notTake = 0 + memoization(idx - 1, n, price, memo);
        int take = Integer.MIN_VALUE;
        int rodLength = idx +1;
        if (rodLength <= n){
            take = price[idx] + memoization(idx, n-rodLength, price, memo);
        }
        return memo[idx][n] = Math.max(notTake, take);
    }
    public static void main(String[] args) {
        int n = 5;
        int price[] = {2,5,7,8,10};
        System.out.println(maxCost(n, price));
    }
}
