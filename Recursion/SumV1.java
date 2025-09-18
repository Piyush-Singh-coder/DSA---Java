package Recursion;

import java.util.*;

public class SumV1 {
    public static void sum(int arr[], int target, int idx, List<List<Integer>> res, List<Integer> list){
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (idx == arr.length){
            return;
        }
        if (target >= arr[idx]){
            list.add(arr[idx]);
            sum(arr, target - arr[idx], idx+1, res, list);
            list.remove(list.size()-1);
        }
        sum(arr, target, idx +1, res, list);
    }
    public static void main(String[] args) {
        int arr[] = {2,1,2,7,6,1,5};
        int target = 8;
        // int ans = {{2,2,3},{3,4},{5,2}};
        C:\Users\pmiay\Downloads\mongosh-2.3.8-win32-x64\mongosh-2.3.8-win32-x64\bin
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        sum(arr, target, 0, res, list);
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i<res.size();i++){
            Collections.sort(res.get(i));
            set.add(res.get(i));
        }
        System.out.println(set);
     }
}
