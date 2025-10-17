package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class PrintLIS {
    public static ArrayList maxCount(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        int max = 1;
        int prev[] = new int[n];
        Arrays.fill(prev, -1); 
        Arrays.fill(dp, 1);
        for (int i = 1; i<n; i++){
            for (int j = 0; j<i; j++){
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int maxIndex = 0;
        for (int i = 0; i<n; i++){
            if (dp[i] > max){
                max = dp[i];
                maxIndex = i;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        int i = maxIndex;
        while(i>-1){
            res.add(arr[i]);
            i = prev[i];
        }
        Collections.reverse(res);
        return res;
    }
   public static void main(String[] args) {
    int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
    System.out.println(maxCount(arr));
   } 
}
