package Strings;
import java.util.Arrays;
public class intermediate {
    // Shortest path 
    public static void getShortestPath(String path){
        int x = 0, y = 0;
        for (int i=0; i<path.length(); i++){
            char dir = path.charAt(i);
            //East
            if(dir == 'E'){
                x++;
            }
            //West 
            else if(dir =='W'){
                x--;
            }
            //North
            else if(dir =='N'){
                y++;
            }
            else if(dir =='S'){
                y--;
            }
        }
        int x1 = x*x;
        int y1 = y*y;
        double shortestPath = Math.sqrt((double)(x1+y1));
        System.out.println("The shortest path is: "+ shortestPath);
    }
    //Substring
    public static void substring(String str, int si, int ei){
        String substr = "";
        for (int i=si; i<ei; i++){
            substr += str.charAt(i);
        }
        System.out.println("The substring of entered string: "+substr);
    }
    //largest String
    public static void largestString(String str[]){
        String largest = str[0];
        for (int i=1; i<str.length; i++){
            if (largest.compareTo(str[i]) < 0 ){
                largest = str[i];
            }
        }
        System.out.println("The largest fruits, lexographically: "+ largest);
    }
    //Convert to title case
    public static void toUppercase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i=1; i<str.length(); i++){
            if(str.charAt(i) ==' '){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        System.out.println("The required string: "+ sb);
    }
    //compressed String
    public static void compressString(String str){
        char ch = str.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder("");
        sb.append(ch);
        for(int i=1; i<str.length();i++){
            if(ch == str.charAt(i)){
                count+= 1;
            }
            else{
                sb.append(count);
                ch = str.charAt(i);
                sb.append(ch);
                count = 1;
            }
        }
        sb.append(count);
        System.out.println("The compressed string of "+ str +" is " +sb);
    }
    // count of lowercase vowels
    public static void lowercaseVowels(String str){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if (ch == 'a' || ch =='e' || ch =='i' || ch =='o' || ch =='u'){
                count+=1;
            }
        }
        System.out.println("The count of lowercase vowels in the string, "+ str +" is "+ count);
    }
    // Anagrams 
    public static void anagrams(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if(str1.length() == str2.length()){
            char ch1 [] = str1.toCharArray();
            char ch2 [] = str2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            boolean result = Arrays.equals(ch1,ch2);
            if(result){
                System.out.println(str1 + " and " + str2 +" are anagrams.");
            }
            else{
                System.out.println(str1 + " and " + str2 +" are not anagrams.");
            } 
        }else{
            System.out.println(str1 + " and " + str2 +" are not anagrams.");
        }
    }
    public static void main(String[] args){
        // String path = "WNEENESENNN";
        // getShortestPath(path);
        // String str = "Hello World";
        // System.out.println(str.substring(0,7));
        // String fruits[] = {"apple", "banana", "mango","tomato","orange"};
        // largestString(fruits);
        // StringBuilder str = new StringBuilder("");
        // for (char ch = 'a'; ch<='z'; ch++){
        //     str.append(ch);
        // }
        // System.out.println(str);
        // toUppercase("hi, my name is piyush singh");
        // lowercaseVowels("Piyush");
        anagrams("race", "care");
    }
}
