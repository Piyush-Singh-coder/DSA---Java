package Recursion;

public class Basic {
    public static void printDec(int n){
        if (n==1){
            System.out.println(1);
            return;
        }
        System.out.println(n);
        printDec(n-1);
    }
    public static void printInc (int n){
        if (n ==1){
            System.out.println(1);
            return;
        }
        printInc(n-1);
        System.out.println(n);
    }
    public static int factorial (int n){
        if (n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }
    public static int sum (int n){
        if (n == 1){
            return 1;
        }
        return n + sum(n-1);
    }
    public static int fib(int n){
        if (n == 0 || n == 1) return n;
        return fib(n-1) + fib(n-2);
    }
    public static boolean isSorted (int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if (arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static int firstOccurence(int arr[], int key, int i){
        if (i == arr.length){
            return -1;
        }
        if (key == arr[i]){
            return i;
        }
        return firstOccurence(arr, key, i+1);
    }
    // Last Occurence 
    public static int lastOccurence1(int arr[], int key, int i){
        if (i == 0){
            return -1;
        }
        if (key == arr[i]){
            return i;
        }
        return lastOccurence1(arr, key, i-1);
    }
    public static int lastOccurence(int arr[], int key, int i){
        if (i == arr.length){
            return -1;
        }
        int isFound = lastOccurence(arr, key, i+1);
        if (isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }
    public static int power(int x, int n){
        if (n == 0){
            return 1;
        }
        return x*power(x, n-1);
    }
    //optimized power code - log (n) 
    public static int pow(int x, int n){
        if (n == 0 ){
            return 1;
        }
        int halfPower = pow(x, n/2);
        int halfPowerSq = halfPower * halfPower;
        if (n % 2 != 0){
            halfPowerSq = halfPowerSq * x;
        }
        return halfPowerSq;
    }
    public static int tilingproblem(int n){
        if (n== 0 || n == 1){
            return 1;
        }
        // vertical choices
        int fnm1 = tilingproblem(n-1);
        //horizontal choices
        int fnm2 = tilingproblem(n-2);
        int total = fnm1 + fnm2;
        return total;
    }
    public static void removeDuplicates(String str, StringBuilder newStr, int idx, boolean map[]){
        if (idx == str.length()){
            System.out.print(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true){
            removeDuplicates(str, newStr, idx+1, map);
        }else{
            map[currChar - 'a'] = true;
            removeDuplicates(str, newStr.append(currChar), idx+1, map);
        }
    }
    public static int friendPairing(int num){
        if (num == 1 || num == 2){
            return num;
        }
        return friendPairing(num-1) + (num-1)*friendPairing(num-2);
    }
    // Assignment
    public static void occurence (int arr[], int key, int idx){
        if (idx == arr.length){
            return;
        }
        if (arr[idx] == key){
            System.out.println(idx);
        }
        occurence(arr, key, idx+1);
    }

    // Question 2
    public static void numToString (int num){
        String str[] = {"zero", "one", "two","three", "four","five","six","seven","eight","nine"};
        if (num == 0){
            return;
        }
        int lastDigit = num %10;
        numToString(num/10);
        System.out.print(str[lastDigit] + " ");
    }
    public static int countSubStrings(String str, int start, int end){
        if (end == str.length()){
            return 0;
        }if (start > end){
            return countSubStrings(str, 0, end+1);
        }
        int count = 0;
        if (str.charAt(start) == str.charAt(end)){
            count = 1;
        }
        return count + countSubStrings(str, start+1, end);
    }
    public static void main (String args []){
        String str = "abcab";
        System.out.println(countSubStrings(str, 0, 0));

    }
}
