package Graph;

import java.util.*;

public class BFS {
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> list, int v){
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean visited[] = new boolean[v];
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);

            for(int val : list.get(node)){
                if (visited[val] == false){
                    q.add(val);
                    visited[val] = true;
                }
            }
        }
        return bfs;
        
    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj =  new ArrayList<>();
        for(int i = 0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(2).add(4);
        adj.get(3).add(1);
        System.out.println(bfs(adj, v));
    }    
}
