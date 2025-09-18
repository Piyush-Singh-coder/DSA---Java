package basics;

import java.util.*;
public class Test{
    public static void inv_half_pyramid(int rows, int cols){
        for (int i=1; i<=rows; i++){
            for(int j=1; j<= rows-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=(2*i-1); j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i=rows; i>=1; i--){
            for(int j=1; j<= rows-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=2*i-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns ");
        int cols = sc.nextInt();
        inv_half_pyramid(rows, cols);
        sc.close();
    }
}