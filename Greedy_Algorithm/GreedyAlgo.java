package Greedy_Algorithm;

import java.util.ArrayList;

public class GreedyAlgo {
    public static void acitivitySelection (int start[], int end[]){
        int maxAct = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        maxAct = 1;
        int lastEnd = end[0];
        for (int i = 1; i<end.length; i++){
            if (start[i] >= lastEnd){
                list.add(i);
                lastEnd = end[i];
                maxAct ++;
            }
        }
        System.out.println(maxAct);
        for (int i = 0; i<list.size(); i++){
            System.out.print("A"+list.get(i)+" ");
        }


    }
    public static void main(String[] args){
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        acitivitySelection(start, end);
    }
}
