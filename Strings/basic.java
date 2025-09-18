package Strings;
import java.util.*;
public class basic {
    public static void traversing(String str){
        for (int i=0; i<str.length(); i++){
            System.out.print(str.charAt(i)+" ");
        }
    }
    // Palindrome - Approach 1 
    public static boolean palindrome1(String str){
        for(int i=0; i<str.length(); i++){
            int j = str.length()-i-1;
            if(str.charAt(i) == str.charAt(j)){
                return true;
            }
        }
        return false;
    }
    //Approach 2
    public static boolean palindrome2(String str){
        int start = 0;
        int end = str.length()-1;
        while(start<=end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end --;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // String str = "abc123";
        // String str2 = new String("Piyush Singh");
        // String name = sc.next(); // Give the output only before first whitespace
        // System.out.println("Enter your full name");
        // String fullName = sc.nextLine();
        // System.out.println("The length of the string: "+ fullName.length());
        // //concatenation
        // String firstName = "Piyush";
        // String lastName = "Singh";
        // String name = firstName + " " + lastName;
        // traversing(fullName);
        String str = new String("NitiN");
        System.out.println(palindrome2(str));;
    }
}
