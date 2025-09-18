package DivideNConquer;

import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;
import java.util.Arrays;

public class Basic {
    public static void traverseArray(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }
    public static void mergeSort(int arr[], int start, int end){
        if (start >= end){
            return;
        }

        int mid = start + (end - start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);

        merge(arr, start, mid, end);
    }
    public static void merge(int arr[], int start, int mid, int end){
        int temp [] = new int [end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;
        while(i<= mid && j<=end){
            if (arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=end){
            temp[k++] = arr[j++];
        }
        for(k = 0, i= start; k<temp.length;k++,i++){
            arr[i] = temp[k];
        }
    }
    public static void quickSort (int arr[], int start, int end){
        if (start > end){
            return;
        }
        int pvtIndex = pivot(arr, start,end);
        quickSort(arr, start, pvtIndex-1);
        quickSort(arr, pvtIndex+1, end);
    }
    public static int pivot(int arr[], int start, int end){
        int pivotElement = arr[end];
        int i = start-1;
        for (int j= start; j<end; j++){
            if (arr[j]<pivotElement){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end]= temp;
        return i;
    }
    //Searching in Sorted Rotated Array
    public static int search(int arr[], int key, int start, int end){
        if (start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if (key == arr[mid]){
            return mid;
        }
        // left array is sorted
        if (arr[start] <= arr[mid]){
            if (key >= arr[start] && key < arr[mid]){
                return search(arr, key, start, mid-1);
            }else{
                return search(arr, key, mid+1, end);
            }
        }else{
            if (key > arr[mid] &&  key <= arr[end]){
                return search(arr, key, mid+1, end);
            }else{
                return search(arr, key, start, mid-1);
            }
        }
    }
    public static void sortArray(int arr[]){
        int index = 0;
        for (int i = 0; i<arr.length; i++){
            if (arr[i] != 1){
                arr[index] = arr[i];
                index++;
            }
        }
        while(index < arr.length){
            arr[index ] = 1;
            index++;
        }
        index = 0;
        for (int i = 0; i<arr.length; i++){
            if (arr[i] != 2){
                arr[index] = arr[i];
                index++;
            }
        }
        while(index < arr.length){
            arr[index ] = 2;
            index++;
        }
        traverseArray(arr);
    }

        public static void main(String[] args) {
            String text = "ABABCABABCABABCABAB";
            String pattern = "ABABCABAB";
            KMPSearch(text, pattern);
    }
}
