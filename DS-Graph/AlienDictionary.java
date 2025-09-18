package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, int k){
        int indegree[] = new int[k];
        for(int i = 0; i<k; i++){
            for(int it: adj.get(i)){
                indegree[it] ++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<k ; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            topo.add(node);
            for(int val: adj.get(node)){
                indegree[val] --;
                if(indegree[val] ==0){
                    q.add(val);
                }
            }
        }
        return topo;
    }
    public static String findOrder (int k , int n, String dict[]){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<k; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i< n-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int j = 0; j<len; j++){
                if (s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        ArrayList<Integer> topo = topoSort(adj, k);
        String ans = "";
        for(int i= 0; i<topo.size(); i++){
            ans += (char)(topo.get(i) + (int)('a'));
        }
        return ans;
    }
    public static void main(String[] args) {
        String [] dict = {"baa","abcd","abca","cab","cad"};
        int k = 4;
        int n = 5;
        System.out.println(findOrder(k, n, dict));
    }
}
