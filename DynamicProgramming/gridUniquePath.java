package DynamicProgramming;

import java.util.*;
public class gridUniquePath {
    public static int uniquePath(int m , int n){
        return recursion(m-1, n-1);
    }
    public static int recursion(int m, int n){
        if (m == 0 && n == 0){
            return 1;
        }
        if (m < 0 || n < 0) return 0;

        int up = recursion(m-1, n);
        int left = recursion(m, n-1);
        return up + left;
    }
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println(uniquePath(m,n));
    }
}
