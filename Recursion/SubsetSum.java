package Recursion;

import java.util.*;
public class SubsetSum {
    public static void subsetSum(int arr[], int sum, ArrayList<Integer> res, int idx){
        if (idx == arr.length){
            res.add(sum);
            return;
        }
        subsetSum(arr, sum+arr[idx], res, idx+1);
        subsetSum(arr, sum, res, idx+1);
    }
    public static void main(String[] args) {
        int arr[] = {2,3};
        ArrayList<Integer> res = new ArrayList<>();
        subsetSum(arr, 0, res, 0);
        System.out.println(res);
    }
}
