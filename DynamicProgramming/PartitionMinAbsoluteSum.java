package DynamicProgramming;

public class PartitionMinAbsoluteSum {
    public static int tabulation(int arr[]){
        int sum = 0; 
        for (int num: arr){
            sum += num;
        }
        int n = arr.length;
        boolean dp[][] = new boolean[n][sum+1];
        for (int i = 0; i<= sum ; i++){
            dp[0][i] = (i == arr[0]); 
        }
        for (int i = 1; i<n; i++){
            for (int j = 0; j<= sum ; j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if (arr[i] <= j){
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = notTake || take;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<=sum ; i++){
            if (dp[n-1][i]){
                int diff = Math.abs(i - (sum - i));
                min = Math.min(diff, min);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int arr[] = {8,6,5};
        System.out.println(tabulation(arr));
    }   
}
