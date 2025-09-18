package DP;

public class MatrixChainMutltiplication {
    public static int recursive(int arr[], int i, int j){
        if (i+1 == j){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = i+1; k<j ; k++){
            int curr = recursive(arr, i, k) + recursive(arr, k, j) + arr[i] * arr[k] * arr[j];
            res = Math.min(curr, res);
        }
        return res;
    }

    public static int memoization(int arr[], int i , int j, int memo[][]){
        if( i +1 == j){
            return 0;
        }
        if (memo[i][j] != -1){
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for(int k = i+1; k<j; k++){
            int curr = memoization(arr, i, k, memo) +  memoization(arr, k, j, memo) + arr[i] * arr[k] * arr[j];
            res = Math.min(curr,res);
        }
        memo[i][j] = res;
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        int n = arr.length;
        int memo[][] = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                memo[i][j] = -1;
            }
        }
        int ans = memoization(arr, 0, n-1, memo);
        // int ans = recursive(arr, 0, arr.length-1);
        System.out.println(ans);
    }
}
