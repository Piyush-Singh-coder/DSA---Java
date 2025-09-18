package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleV1 {
    public static boolean isPossible(int v, int[][] prerequisites){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for(int i = 0; i<m; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.remove();
            topo.add(node);
            for(int val: adj.get(node)){
                indegree[val] --;
                if(indegree[val] == 0){
                    q.add(val);
                }
            }
        }
        return topo.size() == v ? true : false;
    }
    public static void main(String[] args) {
        int n = 4;
        int prerequisites[][] = {{1,0},{2,1},{3,2}};
        System.out.println(isPossible(n, prerequisites));
    }
}
