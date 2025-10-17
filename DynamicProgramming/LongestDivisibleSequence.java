package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class LongestDivisibleSequence {
    public static int longest(int nums[]){
        int n = nums.length;
        Arrays.sort(nums);
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max =1 ;
        for (int i = 1; i<n; i++){
            for (int j = 0; j<i; j++){
                if ((nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static ArrayList printLongest(int nums[]){
        int n = nums.length;
        Arrays.sort(nums);
        int dp[] = new int[n];
        int prev[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxIndex = -1;
        for (int i = 1; i<n ; i++){
            for (int j = 0; j<i; j++){
                if ((nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) &&  1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                    prev[i] = j;
                }
            }
        }
        int max = 1;
        for (int i = 0; i<n; i++){
            if (dp[i] > max){
                max = dp[i];
                maxIndex = i;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        int i = maxIndex;
        while(i>-1){
            res.add(nums[i]);
            i = prev[i];
        }
        Collections.reverse(res);
        return res;
        
    }
    public static void main(String[] args) {
        int nums[] = {1, 16, 7, 8, 4};
        System.out.println(printLongest(nums));
    }
}
