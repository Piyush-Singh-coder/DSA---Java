package Hashing;

import java.util.*;

public class linkedMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkedHMap = new LinkedHashMap<>();
        linkedHMap.put("India", 223);
        linkedHMap.put("US", 300);
        linkedHMap.put("UK", 180);
        linkedHMap.put("Australia", 120);
        linkedHMap.put("China", 999);

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("India", 223);
        treeMap.put("US", 300);
        treeMap.put("UK", 180);
        treeMap.put("Australia", 120);
        treeMap.put("China", 999);


        System.out.println(linkedHMap);
        System.out.println(treeMap);
        
    }
}
