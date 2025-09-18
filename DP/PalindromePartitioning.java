package DP;

public class PalindromePartitioning {
    public static boolean ispalindrome(String s, int left, int right){
        while(left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static int recursive(String a, int i, int j){
        if (i>=j || ispalindrome(a, i, j)){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int curr = 1 + recursive(a, i, k)+recursive(a, k+1, j);
            min = Math.min(curr,min);
        }
        return min;
    }
    public static void main(String[] args) {
        String a = "geek";
        int i = 0;
        int j = a.length()-1;
        int ans = recursive(a, i, j);
        System.out.println(ans);
    }
}
