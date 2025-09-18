package DP;

public class RodCuttingProblem {
    public static int rodCutting(int length[], int price[], int size, int n){
        int dp[][] = new int[n+1][size+1];
        for(int i = 1; i<= n; i++){
            for (int j = 1; j<= size; j++){
                if (length[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        } 
        return dp[n][size];
    }
    public static void main(String[] args) {
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int size = price.length;  // given length of rod
        int n = length.length;
        int ans = rodCutting(length, price, size, n);
        System.out.println(ans);
    }
}
