package DynamicProgramming;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class LongestChainString {
    public static boolean compare(String s1, String s2){
        if (s1.length() != s2.length() + 1){
            return false;
        }

        int i = 0;
        int j = 0;
        while(i < s1.length()){
            if (j < s2.length() && s1.charAt(i) == s2.charAt(j)){
                i ++;
                j++;
            }else{
                i++;
            }
        }
        return i == s1.length() && j == s2.length();
    }
    public static int longestChain(String[] arr){
        int n = arr.length;
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i<n; i++){
            for (int j = 0; j<i; j++){
                if (compare(arr[i], arr[j]) && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public static void main(String[] args) {
        String [] arr = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(longestChain(arr));
    }
}
