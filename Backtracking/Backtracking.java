package Backtracking;

import Strings.basic;

public class Backtracking {
    public static void traverse(int arr[]){
        for (int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void backtrackArray (int arr[], int idx){
        if (idx == arr.length){
            traverse(arr);
            return;
        }
        arr[idx] = idx+1;
        backtrackArray(arr, idx+1);
        arr[idx] = arr[idx]-2;
    }
    public static void subset (String str, String newStr, int i){
        if (i == str.length()){
            if (newStr.length() == 0){
                System.err.println("null");
            }else{
                System.out.println(newStr);
            }
            return;
        }
        subset(str, newStr+str.charAt(i), i+1);  //yes
        subset(str, newStr, i+1); //No
    }
    public static boolean isSafe(char board[][], int rows, int cols){
        //vertical 
        for (int i = rows-1; i>= 0; i--){
            if (board[i][cols] == 'Q'){
                return false;
            }
        }
        //diagonal left
        for (int i= rows-1, j = cols-1; i >= 0 && j >= 0 ; i--, j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        // diagonal right
        for (int i = rows-1, j= cols+1; i>=0 && j<board.length; i--,j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueens (char board[][], int rows){
        if (rows == board.length){
            printChessBoard(board);
            return;
        }
        for (int j = 0; j<board.length; j++){
            if (isSafe(board,rows,j)){
                board[rows][j] = 'Q';
                nQueens(board, rows+1);
                board[rows][j] = 'X';
            }
        }
    }
    public static void printChessBoard (char board[][]){
        System.out.println("-------Chess Board-------");
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        // int arr[] = new int[5];
        // backtrackArray(arr, 0);
        // traverse(arr);
        // subset("abc", "", 0);
        int n = 4;
        char board [][] = new char [n][n];
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board.length; j++){
                board[i][j] = 'X';
            }
        }
        nQueens(board, 0 );
    }
}
