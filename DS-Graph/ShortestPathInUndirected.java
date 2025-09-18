package Graph;

import java.util.*;

public class ShortestPathInUndirected {
    public static int [] shortestPath(int edges[][], int n, int m, int src){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<m; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int dis[] = new int[n];
        for(int i = 0; i<n; i++){
            dis[i] = (int)1e9;
        }
        dis[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node = q.remove();
            for(int it: adj.get(node)){
                if (dis[node] + 1 < dis[it]){
                    dis[it] = dis[node] + 1;
                    q.add(it);
                }
            }
        }
        for(int i = 0; i<n; i++){
            if (dis[i] == 1e9){
                dis[i] = -1;
            }
        }
        return dis;
    }
    public static void main(String[] args) {
        int edges[][] = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        int n = 9;
        int m = 10;
        System.out.println(Arrays.toString(shortestPath(edges, n, m, 0)));

    }
}
