package DynamicProgramming;

public class NinjaTraining {
    public static int ninjaTraining(int n, int points[][]){
        return recursion(n-1, points, 3);
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
