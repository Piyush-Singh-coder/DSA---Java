package ArrayList;
import java.util.ArrayList;
public class basic {
    public static void maxElement(ArrayList<Integer> list){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<list.size(); i++){
            if (list.get(i) > max){
                max = list.get(i);
            }
        }
        System.out.println(max);
    }
    public static void swap(ArrayList<Integer> list, int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(8);
        list.add(4);
        list.add(5);
        System.out.println(list);
        swap(list, 1,3);
        System.out.println(list);
    }
}
