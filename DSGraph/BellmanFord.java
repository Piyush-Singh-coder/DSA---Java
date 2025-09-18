package DSGraph;

import java.util.ArrayList;

public class BellmanFord {
    public static int [] shortestPath(ArrayList<ArrayList<Integer>> edges, int n, int s){
        int dis[] = new int[n];
        for(int i = 0; i<n; i++){
            dis[i] = (int) 1e8;
        }
        dis[s] = 0;
        for(int i = 0; i<n-1; i++){
            for(ArrayList<Integer> it: edges){
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (dis[u] != 1e8 && dis[u] + wt < dis[v]){
                    dis[v] = dis[u] + wt;
                }
            }
        }
        for(ArrayList<Integer> it: edges){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if (dis[u] != 1e8 && dis[u] + wt < dis[v]){
                int temp [] = new int[0];
                temp [0] = -1;
                return temp;
            }
        }
        return dis;
    }
    public static void main(String[] args) {
        int n = 5; // number of vertices
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        // Graph edges: u, v, wt
        edges.add(new ArrayList<>(java.util.Arrays.asList(0, 1, -1)));
        edges.add(new ArrayList<>(java.util.Arrays.asList(0, 2, 4)));
        edges.add(new ArrayList<>(java.util.Arrays.asList(1, 2, 3)));
        edges.add(new ArrayList<>(java.util.Arrays.asList(1, 3, 2)));
        edges.add(new ArrayList<>(java.util.Arrays.asList(1, 4, 2)));
        edges.add(new ArrayList<>(java.util.Arrays.asList(3, 2, 5)));
        edges.add(new ArrayList<>(java.util.Arrays.asList(3, 1, 1)));
        edges.add(new ArrayList<>(java.util.Arrays.asList(4, 3, -3)));

        int s = 0; // source
        int[] dist = shortestPath(edges, n, s);

        if (dist.length == 1 && dist[0] == -1) {
            System.out.println("Graph contains a negative weight cycle");
        } else {
            System.out.println("Shortest distances from source " + s + ":");
            for (int i = 0; i < n; i++) {
                System.out.print(dist[i] + " ");
            }
        }
    }
}
