package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class HouseRobberV2 {
    public static int houseRobber(int hval[], int n){
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        for (int i = 0; i< hval.length; i++){
            if (i != 0 ){
                temp1.add(hval[i]);
            }
        }
        for (int i = 0; i< n; i++){
            if (i != n-1){
                temp2.add(hval[i]);
            }
        }
        return Math.max(memoization(temp1, temp1.size()-1), memoization(temp2, temp2.size()-1));
    }
    public static int memoization (ArrayList<Integer> temp , int i){
        int memo [] = new int[temp.size()];
        Arrays.fill(memo, -1);
        if ( i == 0) return temp.get(0);
        if (i < 0) return 0;
        if(memo[i] != -1) return memo[i];
        int pick = temp.get(i) + memoization(temp, i-2);
        int notPick = memoization(temp, i-1);
        return Math.max(pick, notPick);
    }
    public static void main(String[] args) {
        int hval [] = {2,1,4,9};
        System.out.println(houseRobber(hval, hval.length));
    }
}
