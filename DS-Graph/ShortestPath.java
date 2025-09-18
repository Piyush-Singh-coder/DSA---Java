package Graph;

import java.util.*;
public class ShortestPath {
    static class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int vis[], Stack<Integer> st){
        vis[node] = 1;

        for(int i = 0; i<adj.get(node).size(); i++){
            int v = adj.get(node).get(i).first;
            if (vis[v] == 0){
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }
    public static int[] shortestPath (int n, int m , int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        for (int i = 0; i<m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        int vis[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            if (vis[i] == 0){
                topoSort(i, adj, vis, st);
            }
        }
        int dis[] = new int[n];
        for(int i = 0; i<n; i++){
            dis[i] = (int)(1e9);
        }
        dis[0] = 0;
        while(!st.isEmpty()){
            int val = st.pop();
            for(int i = 0; i<adj.get(val).size(); i++){
                int v = adj.get(val).get(i).first;
                int wt = adj.get(val).get(i).second;
                if (dis[val] + wt < dis[v]){
                    dis[v] = wt + dis[val];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dis[i] == (int) 1e9) dis[i] = -1;
        }
        return dis;
    }
    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        int [][] edges = {{0,1,2},{0,2,1}};
        System.out.println(Arrays.toString(shortestPath(n, m, edges)));
    }
}
