package DSGraph;

import java.util.*;

import Hashing.linkedMap;

public class DijkistraAlgorithm {
    static class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static int[] shortestPath(ArrayList<ArrayList<ArrayList<Integer>>> adj, int n, int s){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.first - b.first);
        int dis [] = new int[n];
        for(int i = 0; i<n; i++){
            dis[i] = (int) 1e9;
        }
        dis[s] = 0;
        pq.add(new Pair(0, s));
        while (pq.size() != 0) {
            int dist = pq.peek().first;
            int node = pq.peek().second;
            pq.poll();
            for(int i = 0; i<adj.get(node).size(); i++){
                int adjWt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if(dist + adjWt < dis[adjNode]){
                    dis[adjNode] = dist + adjWt;
                    pq.add(new Pair(dis[adjNode], adjNode));
                }
            }
        }
        return dis;

    }
    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph
        // u -> v with weight w
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 7)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 3)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 1)));

        int s = 0;
        int[] dist = shortestPath(adj, n, s);
        System.out.println("Shortest distances from node " + s + ": " + Arrays.toString(dist));
    }
}
