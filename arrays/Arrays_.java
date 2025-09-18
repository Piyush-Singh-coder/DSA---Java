package arrays;
import java.text.CollationElementIterator;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Arrays_{
    // Insertion
    public static void insertion(int arr[], int n){
        System.out.println("Enter the elements");
        for (int i=0; i<n ;i++){
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            arr[i] = num;
        }
        System.out.println();
        
    }
    //Display
    public static void display(int arr[], int n){
        System.out.print("The array includes: ");
        for (int i=0; i<n ;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    } 
    // Linear Search
    public static int linear_search(int arr[], int n, int key){
        for (int i=0; i<n; i++){
            if(key == arr[i]){
                return i;
            }
        }
        return -1;
    }
    // Largest Number
    public static int largest(int arr[], int n){
        int big= -1;
        for (int i=0; i<n; i++){
            if(big<arr[i]){
                big = arr[i];
            }
        }
        return big;
    }
    //Binary Search
    public static int binary_search(int arr[], int n, int key){
        int start = 0, end = n-1;
        while(start<=end){
            int mid = (start+end)/2;
            if (arr[mid] == key){
                return mid;
            }else if(key > arr[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }

        }
        return -1;
    }
    //Reverse array
    public static void reversed_array(int arr[], int n){
        int start = 0, end = n-1;
        while (start <=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    //Pairs in an array
    public static void pairs_array(int arr[], int n){
        for (int i = 0; i<n; i++){
            for(int j= i+1; j<n; j++){
                System.out.printf("(%d,%d)", arr[i],arr[j]);
            }
            System.out.println();
        }
    }
    // Subarrays of an array
    public static void max_subarray(int arr[], int n){
        int ts = 0; //no. of subarrays n(n+1)/2
        int max = -1;
        for (int i=0; i<n; i++){
            for (int j=i; j<n; j++){
                int sum = 0;
                for (int k=i; k<=j; k++){
                    System.out.print(arr[k]+" ");
                    sum+=arr[k];
                }
                ts++;
                
                if (max<sum){
                    max = sum;
                }
                System.out.print("The sum of subarray is: "+ sum);
                System.out.println();
            }
            System.out.println();
            
        }
        System.out.println("The total number of subarrays are: " +ts);
        System.out.print(max);
        
    }
    // max subarray (kadane's Algorithm)
    public static void kadanes(int arr[], int n){
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            currSum += arr[i];
            if(currSum<0){
                currSum = 0;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        System.out.println("our max subarray sum is: " + maxSum);
    }
    //prefix Approach
    public static void prefix_maxSubarray(int arr[], int n){
        int currSum =0;
        int maxSum = Integer.MIN_VALUE;
        int prefix [] = new int [n];
        prefix[0] = arr[0];
        for (int i=1; i<n; i++){
            prefix[i]= prefix[i-1] + arr[i];
        }

        for (int i=0; i<n; i++){
            int start = i;
            for (int j=i; j<n; j++){
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];

                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println("max sum = " + maxSum);
    }
    // Buy and sell stocks 
    public static int buy_sell_stock(int arr[], int n){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i =0; i<n ; i++){
            if (buyPrice < arr[i]){
                int profit = arr[i] - buyPrice;
                maxProfit = Math.max(profit, maxProfit); 
            }else {
                buyPrice = arr[i];
            }
        }
        return maxProfit;
    }
    public static boolean question1(int arr[], int n){
        for (int i=0; i<n; i++){
            for(int j =i+1; j<n; j++){
                if (arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }
    // Bubble sorting
    public static void bubbleSort(int arr[], int n){
        for(int i=0; i<n-1; i++){
            for (int j=0; j<n-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    // Selection sort
    public static void selctionSort(int arr[], int n){
        for(int i=0; i<n-1; i++){
            int min = i;
            for (int j= i+1; j<n; j++){
                if(arr[min]> arr[j]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    // Insertion Sort
    public static void insertionSort(int arr[], int n){
        for (int i=1; i<n; i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev>=0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }
    // Counting sort
    public static void countingSort(int arr[], int n){
        int largest = Integer.MIN_VALUE;
        for (int i=0; i<n;i++){
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int [largest+1];
        for (int i =0; i<n; i++){
            count[arr[i]]++;
        }
        int j =0;
        for(int i=0; i<count.length; i++){
            while(count[i] >0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }
    //Enhanced loop 
    public static void enhanced_loop(int numbers[]){
        for(int num : numbers){
            System.out.println(num);
        }
    }
    public static int lastOccurence (int arr[], int key){
        int index = -1;
        for(int i = 0; i< arr.length; i++){
            if (key == arr[i]){
                index = i;
                break;
            }
        }
        if (index !=-1){
            for(int i = index; i<arr.length; i++){
                if (key == arr[i]){
                    index = i;
                }
            }
        }
        return index;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the number of elements in an array");
        // int n = sc.nextInt();
        // int arr[] = new int[n];
        // insertion(arr, n);
        // System.out.println("Enter the element to be searched");
        // int key = sc.nextInt();
        // // int pos = linear_search(arr, n, key);
        // int pos = binary_search(arr, n, key);
        // if (pos ==-1){
        //     System.out.println("Element doesn't exist in the array");
        // }else{
        //     System.out.println("key is at index: "+ pos );
        // }
        // System.out.println("array before reverse");
        // display(arr, n);
        // reversed_array(arr, n);
        // System.out.println("array after reversing");
        // display(arr, n);
        // int maxProfit = buy_sell_stock(arr, n);
        // System.out.println("max Profit = " + maxProfit);
        // boolean result1 = question1(arr, n);
        // System.out.println(result1);
        // System.out.print("Before sorting array = ");
        // display(arr, n);
        // countingSort(arr, n);
        // System.out.print("After sorting array = ");
        // display(arr, n);
        // Integer arr1[] = {5,4,1,3,2};
        // Arrays.sort(arr1,Collections.reverseOrder());
        // display(arr1, 5);
        // int numbers [] = {10, 20, 30, 40};
        // enhanced_loop(arr);
        int arr1 [] ={5,5,5,5};
        System.out.println(lastOccurence(arr1, 5));
    }
}