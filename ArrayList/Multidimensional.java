package ArrayList;
import java.util.ArrayList;
public class Multidimensional {
    public static void main(String [] args){
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list1 = new ArrayList<>();
        // list1.add(4);
        // list1.add(5);
        // list1.add(6);
        // mainList.add(list1);
        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(7);
        // list2.add(8);
        // list2.add(9);
        // mainList.add(list2);
        // System.out.println(mainList);
        // for (int i = 0; i<mainList.size(); i++){
        //     ArrayList<Integer> currList = mainList.get(i);
        //     for(int j = 0; j<currList.size(); j++){
        //         System.out.print(currList.get(j)+" ");
        //     }
        //     System.out.println();
        // }


        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for(int i = 1; i<=5; i++){
            list1.add(i);
            list2.add(i*2);
            list3.add(i*3);
        }
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        System.out.println(mainList);
        for(int i = 0; i<mainList.size(); i++){
            ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j<currList.size(); j++){
                System.out.print(currList.get(j) + " ");
            } 
            System.out.println();
        }
    }
}
