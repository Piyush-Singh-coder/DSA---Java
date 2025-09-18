package Hashing;
import java.util.*;
public class Set {
    public static void main(String[] args) {
        HashSet<Integer> hset = new HashSet<>();
        LinkedHashSet<Integer> hLset = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        hset.add(1);
        hset.add(32);
        hset.add(3);
        hset.add(52);
        hset.add(1);

        hLset.add(1);
        hLset.add(6);
        hLset.add(2);
        hLset.add(5);
        hLset.add(1);

        treeSet.add(1);
        treeSet.add(6);
        treeSet.add(9);
        treeSet.add(0);
        treeSet.add(1);

        System.out.println(hset);
        System.out.println(hLset);
        System.out.println(treeSet);

        for( int key : hset){
            System.out.println(key);
        }
        System.out.println(hset.contains(2));
    }
}
