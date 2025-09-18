package bitwise;

public class bitwise {
    //odd or even
    public static void oddEven(int num){
        int bitmask = 1;
        if((num & bitmask) == 0){
            System.out.println("even");
        }
        else{
            System.out.println("odd");
        }
    }
    // get ith bit
    public static int getithBit(int num, int i){
        int bitmask = 1<<i;
        if ((num & bitmask) != 0){
            return 1;
        }
        else{
            return 0;
        }
    }
    //set ith bit
    public static int setithBit(int num, int i){
        int bitmask = 1<<i;
        return (num|bitmask);
    }
    //clear ith bit
    public static int clearithBit(int num, int i){
        int bitmask = ~(1<<i);
        return (num & bitmask);
    }
    // update ith bit - Approach 1
    public static int updateithBit (int num, int i, int newBit){
        if(newBit == 0){
            return clearithBit(num, i);
        }
        else{
            return setithBit(num, i);
        }
    }
    //update ith bit - Approach 2
    public static int updateithbit2 (int num, int i, int newBit){
        num = clearithBit(num, i);
        int bitmask = newBit>>i;
        return (num | bitmask);
    }
    //clear last ith bit
    public static int clearLastIBit(int num, int i){
        int bitmask = (~0)<< i;
        return (num & bitmask);
    }
    // clear range bits
    public static int clearibits(int num, int i, int j){
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        int bitmask = a|b;
        return (num & bitmask);
    }
    //Number is in 2's power or not
    public static boolean isTwopower(int num) {
        return(((num & (num-1)) == 0));
    }
    // count no of set(1) bits
    public static int countSetBits(int num){
        int bitmask = 1;
        int count = 0;
        while (num != 0){
            if ((num & bitmask) == 1){
                count++;
            }
            num = num >>1 ;
        }
        return count;
    }
    // fast exponentiation a^n, a to the power n
    public static int fastExponentiation (int a, int n){
        int result = 1;
        while (n > 0){
            if ( (n&1) != 0){
                result = result * a;
            }
            a = a*a;
            n = n>>1;
        }
        return result;
    }
    //Assignment- 1
    public static void swapNumber(int a, int b){
        System.out.printf("Before swap - a = %d, b = %d\n", a,b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.printf("After swap - a = %d, b = %d", a,b);
    }
    // Assignment- 2 
    public static void addOneToNumber(int num){
        System.out.println(-~num); // ~num = -(num+1)
    } 
    // Assignment- 3
    public static void uppercaseToLowercase(){
        for (char ch = 'A'; ch<='Z'; ch++){
            System.out.print((char)(ch | ' '));
        }
    }
    public static void main(String args[]){
       uppercaseToLowercase();
    }
}
