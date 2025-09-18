package Recursion;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class SumV2 {
    public static void sum (int arr[], int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int idx){
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i<arr.length; i++){
            if (i> idx && arr[i] == arr[i-1]) continue;
            if (arr[i] > target) break;

            list.add(arr[i]);
            sum(arr, target-arr[i], res, list, i+1);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        // int arr[] = {2,1,2,7,6,1,5};
        // int target = 8;
        // Arrays.sort(arr);
        // ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // ArrayList<Integer> list = new ArrayList<>();
        // sum(arr, target, res, list, 0);
        // System.out.println(res);

        // int arr[] = {1,2,3};
        // ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // permutations(arr, 0,res, new ArrayList<>());
        // System.out.println(res);
    }
}
