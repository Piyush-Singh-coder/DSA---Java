package Hashing;
import java.util.*;
public class ValidAnagram {
    public static void main(String[] args) {
        String str1 = "keen";
        String str2 = "knee";
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i<str1.length(); i++){
            char ch = str1.charAt(i);
            if (hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)+1);
            }else{
                hm.put(ch,1);
            }
        }
        System.out.println(hm);
        for(int i = 0; i<str2.length(); i++){
            char ch = str2.charAt(i);
            if (hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch) == 0){
                    hm.remove(ch);
                }
            }else{
                System.out.println(false);
                break;
            }
        }
        if(hm.isEmpty()){
            System.out.println(true);
        }
    }
}
