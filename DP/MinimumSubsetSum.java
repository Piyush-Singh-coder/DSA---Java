package DP;

import java.util.*;
public class MinimumSubsetSum {
    public static ArrayList<Integer> subsetSum (int arr[], int sum, int n){
        boolean dp[][] = new boolean [n+1][sum+1];
        for(int i = 0; i<=n ; i++){
            dp[i][0] = true;
        }
        for(int j = 1; j<= sum ; j++){
            dp[0][j] = false;
        }
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<= sum ; j++){
                if (arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j<=sum/2; j++){
            if (dp[n][j]){
                list.add(j);
            }
        }
        return list;
     }
    public static int miniSubsetSum(int arr[], int n){
        int sum = 0;
        for (int i = 0; i<n; i++){
            sum += arr[i];
        }
        ArrayList<Integer> list = subsetSum(arr, sum, n);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<list.size(); i++){
            min = Math.min(min, sum - (2*list.get(i)));
        }
        return min;
    }
    public static void main(String[] args) {
        int arr[] = {1,6,11,5};
        int n = arr.length;
        System.out.println(miniSubsetSum(arr, n));
    }
}
