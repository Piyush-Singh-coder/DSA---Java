package cp_questions;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
public class CP {
    public static int secondLargest(int arr[]){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
            for (int i=0; i<arr.length; i++){
                if (largest < arr[i]){
                    secondLargest = largest;
                    largest = arr[i];
                }else if(secondLargest < arr[i] && arr[i] != largest){
                    secondLargest = arr[i];
                }
            }
        if (secondLargest != Integer.MIN_VALUE){
            return secondLargest;
        }
        else{
            return -1;
        }
    }
    public static void traverse(int arr[]){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }
    }
    public static void zeroAtEnd (int arr[]){
        for (int i =0; i<arr.length; i++){
            int k = arr.length;
            if (arr[i] ==0){
                int j = i;
                while (j<k && j!= arr.length-1){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    j++;
                }
            }
            k--;
        }
        traverse(arr);
    }
    public static void reverseArray (int arr[]){
        for (int i = 0; i<arr.length/2; i++){
            int j = arr.length-i-1;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        traverse(arr);
    }
    public static void rotateArray(int arr[], int d){
        d = d % arr.length;
        int newArr[] = new int[d];
        for (int i=0; i<d; i++){
            newArr[i] = arr[i];
        }
        int index=0;
        for (int i=d; i<arr.length; i++){
            arr[index++] = arr[i];
        }
        int i =0;
        while(index < arr.length){
           arr[index++] = newArr[i++];
        }
    }
    //Aproach 2 - Rotate an Array
    public static void reverseArray2 (int arr[], int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotateArray2(int arr[], int d){
        d = d % arr.length;
        reverseArray2(arr, 0, d-1);
        reverseArray2(arr, d, arr.length-1);
        reverseArray2(arr, 0, arr.length-1);
        traverse(arr);
    }
    public static void nextPalindrome(int arr[]){
        int i = arr.length-2;
        while(i>=0 && arr[i] >= arr[i+1]){
            i--;
        }
        if ( i>=0){
            int j = arr.length -1;
            while (arr[i] >= arr[j]){
                j--;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        reverseArray2(arr, i+1, arr.length-1);
        traverse(arr);
    }
    // public static void majorityElement (int arr[]){
    //     int newArr[] = new int[2];
    //     int index = 0;
    //     for (int i = 0; i<arr.length; i++){
    //         int count = 0;
    //         for (int j = i; j< arr.length; j++){
    //             if (arr[i] == arr[j]){
    //                 count++;
    //             }
    //         }
    //         if ((count>(arr.length/3)) ){
    //             newArr[index++] = arr[i];
    //         }
    //     }
    //     traverse(newArr);
    // }
    public static void majorityElement (int arr[]){
        int newArr [] = new int [2];
        int index = 0;
        int count1 = 0, count2 = 0;
        int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE;
        // Finding possible candidates
        for (int num: arr){
            if (num == candidate1){
                count1 ++;
            }else if (num == candidate2){
                count2 ++;
            }else if (count1 == 0){
                candidate1 = num;
                count1 = 1;
            }else if (count2 == 0){
                candidate2 = num;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        // Actual count 
        count1 = count2 = 0;
        for (int num: arr){
            if (num == candidate1){
                count1 ++;
            }else if(num == candidate2){
                count2++;
            }
        }
        int threshold = arr.length /3;
        if (count1 > threshold){
            newArr[index++] = candidate1;
        }if (count2 >threshold){
            newArr[index++] = candidate2;
        }
        traverse(newArr);
    }
    public static int computeHIndex(Integer[] citations) {
        // Sort citations in descending order
        Arrays.sort(citations, Collections.reverseOrder());
        
        int hIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }
        return hIndex;
    }
    public static void mergeSortedArray(int nums1[], int nums2[], int m, int n){
        int temp[] = new int[m+n];
        int i = 0; 
        int j = 0; 
        int k = 0;
        while(i<m && j<n){
            if (nums1[i]<nums2[j]){
                temp[k++] = nums1[i++];
            }else{
                temp[k++] = nums2[j++];
            }
        }
        while(i<m){
            temp[k++] = nums1[i++];
        }
        while(j<n){
            temp[k++] = nums2[j++];
        }
        for (i = 0; i<temp.length; i++){
            nums1[i] = temp[i];
        }
        traverse(nums1);
    }
    public static void mergeSortedArray1(int nums1[], int m, int nums2[], int n){
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        while(j>=0){
            nums1[k--] = nums2[j--];
        }
        traverse(nums1);
    }
    public static boolean monotonic1(ArrayList<Integer> list){
        int n = list.size()-1;
        if (list.get(0) < list.get(n)){
            for (int i = 0; i<n; i++){
                if (list.get(i) > list.get(i+1)){
                    return false;
                }
            }
        }else if (list.get(0) > list.get(n)){
            for (int i = 0; i<n; i++){
                if (list.get(i) < list.get(i+1)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean monotonic(ArrayList<Integer> list){
        boolean increasing = true;
        boolean descending = true;
        //monotonic increasing
        for (int i = 0; i<list.size()-1; i++){
            if (list.get(i) > list.get(i+1)){
                increasing = false;
            }
        }
        for (int i = 0; i<list.size()-1; i++){
            if (list.get(i) < list.get(i+1)){
                descending = false;
            }
        }
        return increasing || descending;
    }
    public static String minimumSum(int arr[]){
        Arrays.sort(arr);
        int num1 = 0;
        int num2 = 0;
        // traverse(arr);
        for (int i = 0; i< arr.length; i+=2){
            num1 = num1*10 + arr[i];
        }
        for (int i = 1; i<arr.length; i+=2){
            num2 = num2*10 + arr[i];
        }
        String result = Integer.toString(num1+num2);
        return result;
    }
    public static int minPrimes(int m, int n){
        g
    }
    public static void main(String[] args) {
        // Integer[] citations = {5, 1, 2, 4, 1};
        // int hIndex = computeHIndex(citations);
        // System.out.println("H-Index is: " + hIndex);
        // mergeSortedArray1(new int[]{1}, 1, new int[]{},0);
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(3);
        // list.add(2);
        // // list.add(4);
        // System.out.println(monotonic(list));
        System.out.println(minimumSum(new int[]{5,3,0,7,4}));

        

    }
}
