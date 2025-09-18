package Recursion;

import java.util.*;

public class subsetV2 {
    public static void subset(int arr[], List<List<Integer>> res, List<Integer> list, int idx){
        res.add(new ArrayList<>(list));
        for(int i = idx; i<arr.length; i++){
            if (i > idx && arr[i-1] == arr[i]) continue;

            list.add(arr[i]);
            subset(arr, res, list, i+1);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,2};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        subset(arr, res, list, 0);
        System.out.println(res);
    }
}
