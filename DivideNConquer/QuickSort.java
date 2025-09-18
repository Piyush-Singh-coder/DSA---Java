package DivideNConquer;

public class QuickSort {
    public static void quickSort(int arr[], int low, int high){
        if (low >= high){
            return;
        }
        int partition = partition(arr, low, high);
        quickSort(arr, low, partition -1);
        quickSort(arr, partition +1, high);
    }
    public static int partition(int arr[], int low , int high){
        int pivot = low;
        int i = low;
        int j = high;
        while( i < j){
            while(arr[i] < arr[pivot] && i <= high){
                i++;
            }while(arr[j] > arr[pivot] && j >= low){
                j--;
            }
            if (i<j){
                swap(arr,i,j);
            }
        }
        swap(arr, j, pivot);
        return j;
    }
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        
        quickSort(arr, 0, arr.length -1);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }   
}
