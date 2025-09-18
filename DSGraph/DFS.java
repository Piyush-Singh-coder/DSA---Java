package Graph;

import java.util.ArrayList;

public class DFS {
    public static void dfs(ArrayList<ArrayList<Integer>> list, int node, boolean visited[], ArrayList<Integer> ls){
        visited[node] = true;
        ls.add(node);
        for(int val : list.get(node)){
            if (visited[val] == false){
                dfs(list, val, visited, ls);
            }
        }
    }
    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> list, int v){
        boolean visited[] = new boolean[v];
        ArrayList<Integer> ls = new ArrayList<>();

        dfs(list, 0, visited, ls);
        return ls;
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
        System.out.println(dfsOfGraph(adj, v));
    }
}
