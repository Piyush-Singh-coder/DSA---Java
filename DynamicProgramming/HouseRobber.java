package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    public static int houseRobber(int hval[], int n){
        return tabulation(hval, n-1);
    }
    public static int recursion(int hval[], int i){
        if(i<0) return 0;
        if (i== 0) return hval[0];
        int pick = hval[i] + recursion(hval, i-2);
        int notPick = 0 + recursion(hval, i-1);
        return Math.max(pick, notPick);
    }
    public static int tabulation(int hval[], int idx){
        int n = hval.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = hval[0];   // prev = hval[0] , prev2 = 0
        for (int i = 1; i< n; i++){
            int pick = hval[i];     
            if (i-2 >= 0){
                pick = pick + dp[i-2];  // pick += prev2
            }
            int notPick = dp[i-1];   // notPick = prev
            dp[i] = Math.max(pick, notPick);     // curr = Math.max(pick, notPick) ;  prev2 = prev;  prev = curr
        }
        return dp[idx];      //  prev;
    }
    public static void main(String[] args) {
        int hval[] = {5,3,4,11,2};
        int n = hval.length;
        System.out.println(houseRobber(hval, n));
    }
}
