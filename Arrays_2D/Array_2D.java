package Arrays_2D;
import java.util.Scanner;

public class Array_2D {

    //Insertion
    public static void insertion(int matrix[][]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements");
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
    }
    //Display
    public static void display (int matrix[][]){
        System.out.println("The elements in the matrix include: ");
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }
    // Searching 
    public static boolean searching (int matrix[][], int key){
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] == key){
                    System.out.printf("The element is found at index (%d,%d)", i,j);
                    return true;
                }
            }
        }
        return false;
    }
    // Spiral matrix
    public static void spiralMatrix(int matrix[][]){
        int startrow = 0;
        int startcol = 0;
        int endrow = matrix.length-1;
        int endcol = matrix[0].length-1;
        while( startrow<= endrow && startcol<= endcol){
            //top 
            for (int j=startcol; j<=endcol; j++){
                System.out.print(matrix[startrow][j]+ " ");
            }
            //right
            for(int i= startrow+1; i<=endrow; i++){
                System.out.print(matrix[i][endcol]+ " ");
            }
            //bottom
            for(int j = endcol-1; j>=startcol; j--){
                if(startrow == endrow){
                    break;
                }
                System.out.print(matrix[endrow][j]+" ");
            }
            //left
            for(int i=endrow-1; i>=startrow+1;i--){
                if(startcol == endcol){
                    break;
                }
                System.out.print(matrix[i][startcol]+" ");
            }
            startrow++;
            startcol++;
            endrow--;
            endcol--;
        }
        System.out.println();
    }
    //Digonal sum
    public static void diagonalSum(int matrix[][]){
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<matrix.length; i++){
            int j = matrix.length-i-1;
            sum1 += matrix[i][i];
            if (i!=j){
                sum2+=matrix[i][j];
            }
        }
        int sum = sum1+sum2;
        System.out.println("The sum of diagonal elements in given matrix: "+ sum);
    }
    //Enhanced for loops
    public static void enhanced_loop(int matrix[][]){
        for(int[] row: matrix){
            for(int num: row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    //Question 1
    public static void question1 (int matrix[][]){
        int count = 0;
        for(int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 7){
                    count=count+1;
                }
            }
        }
        System.out.println("The number of 7 in a matrix: "+ count);
    }
    // Question 2
    public static void question2 (int matrix[][]){
        int sum = 0;
        int i = 1;
        for (int j =0; j< matrix[0].length; j++){
            sum += matrix[i][j];
        }
        System.out.println("The sum of second row elements: " + sum);
    }
    //Question 3
    public static void transpose (int matrix[][]){
        int transpose [][] = new int[matrix[0].length][matrix.length];
        for(int i=0; i<matrix.length; i++ ){
            for(int j =0; j<matrix[0].length; j++){
                transpose[j][i]= matrix[i][j];
            }
        }
        display(transpose);
    }
    //binary Search 
    public static boolean search(int matrix[][],int key){
        for (int i=0; i<matrix.length; i++){
            int start = 0;
            int end = matrix[0].length-1;
            while(start <= end){
                int mid = (start+end)/2;
                if(matrix[i][mid] == key){
                    System.out.println("("+ i + ","+ mid+")");
                    return true;
                }else if( matrix[i][mid] <key){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        System.out.println("didn't exist");
        return false;
    }
    //Staircase search
    public static boolean staircaseSearch(int matrix[][], int key){
        int row = 0, col = matrix[0].length-1;
        while (row< matrix.length && col>=0 ){
            if (matrix[row][col] == key){
                System.out.println("("+ row + ","+ col+")");
                    return true;
            }else if(matrix[row][col] > key){
                col--;
            }else{
                row++;
            }
        }
        System.out.println("element doesn't exist");
        return false;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int matrix[][] = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        int matrix2[][] = {{1,2,3},
                           {4,5,6},
                           {7,8,9}};
        int matrix3[][] = {{1,4,9},{11,4,3},{2,2,3}};
        int matrix4[][] = {{10,20,30,40},
                           {15,25,35,45},
                           {27,29,37,48},
                           {32,33,39,50}};
        // staircaseSearch(matrix4, 33);
        display(matrix4);
    }
}
