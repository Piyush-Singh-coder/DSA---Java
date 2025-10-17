package DynamicProgramming;

import java.util.Arrays;

public class CountLongestSubsequence {
    public static int countLongest(int nums[]){
        int n = nums.length;
        int count[] = new int[n];
        int dp[] = new int[n];
        Arrays.fill(count, 1);
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i< n ; i++){
            for (int j = 0; j<i ; j++){
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }else if (nums[i] > nums[j] && dp[j] + 1 == dp[i]){
                    count [i]  = count[j] + count[i];
                }
            }
            max = Math.max(dp[i] , max);
        }
        int cnt = 0;
        for (int i = 0; i<n; i++){
            if (dp[i] == max){
                cnt += count[i];
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 2, 6, 7, 2};
        System.out.println(countLongest(arr));
    }
}
