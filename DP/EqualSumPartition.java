public class EqualSumPartition {
    public static boolean equalSumPartition(int arr[], int sum, int n){
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i = 0; i<=n; i++){
            dp[i][0] = true;
        }
        for(int j = 1; j<= sum; j++){
            dp[0][j] = false;
        }
        for(int i=1; i<= n; i++){
            for (int j = 1 ;j<= sum ;j++){
                if (arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static boolean equalSum(int arr[]){
        int sum =0;
        int n = arr.length;
        for (int i = 0; i<arr.length; i++){
            sum += arr[i];
        }
        if (sum %2 != 0){
            return false;
        }else{
            int newSum = sum/2;
            return equalSumPartition(arr, newSum, n);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,7};
        boolean ans = equalSum(arr);
        System.out.println(ans);
    }
}
