package DynamicProgramming;

import java.util.Arrays;

public class NinjaTraining {
    public static int ninjaTraining(int n, int points[][]){
        int memo[][] = new int[n][4];  
        for (int[] it: memo){
            Arrays.fill(it , -1);
        }       
        return memoization(memo, n-1, 3, points);                                                          
    }
    public static int recursion(int day, int points[][], int last){
        if ( day == 0){
            int max = 0;
            for (int i = 0; i<points[0].length; i++){
                if (last != i){
                    max = Math.max(max, points[day][i]);
                }
            }
            return max;
        }
        int max = 0;
        for (int i = 0; i<points[0].length; i++){
            if (i != last){
                int activity = points[day][i] + recursion(day-1, points, i);
                max = Math.max(max, activity);
            }
        }
        return max;
    }
    // Memoization
    public static int memoization(int memo[][], int day, int last, int points[][]){
        if (day == 0){
            int max = 0;
            for (int i = 0; i<points[0].length; i++){
                if (i != last){
                    max = Math.max(max, points[day][i]);
                }
            }
            return memo[day][last] = max;
        }
        if (memo[day][last] != -1) return memo[day][last];
        int max = 0;
        for (int i = 0; i<points[0].length; i++){
            if (i != last){
                int activity = points[day][i] + memoization(memo, day-1, i, points);
                max = Math.max(max, activity);
            }
        }
        return memo[day][last] = max;
    }
    public static void main(String[] args) {
        int points[][] = {
                         {10,40,70},
                         {20,50,80},
                         {30,60,90}
        };
        int n = points.length;
        System.out.println(ninjaTraining(n, points));
    }
}
