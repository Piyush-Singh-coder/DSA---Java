package ArrayList;
import java.util.ArrayList;
public class MostWater {
    public static void containerWithMostWater(ArrayList<Integer> height){
        int maxWater = Integer.MIN_VALUE;
        for (int i = 0; i<height.size(); i++){
            for (int j = i+1; j<height.size(); j++){
                int minHeight = Math.min(height.get(i), height.get(j));
                int width = j-i;
                int water = minHeight * width;
                maxWater = Math.max(water, maxWater);
            }
        }
        System.out.println(maxWater);
    }
    public static int containerWithMostWater2(ArrayList<Integer> height){
        int left = 0;
        int right = height.size()-1;
        int maxWater = 0;
        while(left<right){
            int minHeight = Math.min(height.get(left), height.get(right));
            int width = right-left;
            int water = minHeight * width;
            maxWater = Math.max(maxWater, water);
            if (height.get(left) < height.get(right)){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
    public static void pairSum (ArrayList<Integer> list , int target){
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0, end = list.size()-1;
        boolean flag = false;
        while(start <end){
            int sum = list.get(start) + list.get(end);
            if (sum == target){
                result.add(start);
                result.add(end);
                flag = true;
                break;
            }
            else if(sum > target){
                end --;
            }else{
                start ++;
            }
        }
        if (flag){
            System.out.println(result);
        }
        else{
            System.out.println("No pair exist");
        }
        
    }
    public static void pairSum2(ArrayList<Integer> list, int target){
        int pivot = -1;
        for (int i=0; i<list.size()-1; i++){
            if (list.get(i) > list.get(i+1)){
                pivot = i;
                break;
            }
        }
        if (pivot == -1){
            pivot = list.size()-1;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int start = pivot +1;
        int end = pivot;
        int n = list.size();
        boolean flag = false;
        while (start != end){
            int sum = list.get(start) + list.get(end);
            if (sum == target){
                result.add(start);
                result.add(end);
                flag = true;
                break;
            }else if (sum < target){
                start = (start +1)% n;
            }else{
                end = (end + n -1) % n;
            }
        }
        if (flag){
            System.out.println(result);
        }else{
            System.out.println("no pair exists");
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11); 
        list.add(15); 
        list.add(6); 
        list.add(8); 
        list.add(9);
        list.add(10);  
        pairSum2(list, 104); 
    }
}
