package Hashing;
import java.util.*;
public class MajorityElement {
    public static void main(String[] args) {
        int arr[] = {1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i<arr.length; i++){
            int num = arr[i];
            if (!hashMap.containsKey(arr[i])){
                hashMap.put(arr[i],1);
            }else{
                hashMap.put(arr[i],hashMap.get(arr[i])+1);
            }
        }
        int n = arr.length/3 + 1;
        for(int key: hashMap.keySet()){
            if (hashMap.get(key) == n){
                System.out.println(key);
            }
        }
    }
}
