package Graph;

import java.util.*;

public class DijkistraAlgorithm {
    static class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int n, int s){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.first - y.first);

        int dist[] = new int[n];
        for(int i = 0; i<n; i++){
            dist[i] = (int)1e9;
        }
        dis[s] = 0;
        pq.add(new Pair(0, s));

        while (pq.size() != 0) {
            int dist = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            for(int i = 0; i<adj.get(node).size(); i++){
                int edgeWt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if(dis + edgeWt < dis[adjNode]){
                    dis[adjNode] = dis + edgeWt;
                    pq.add(new Pair(dis[adjNode], adjNode));
                }
            }
        }
        return dis;
        
    }
    public static void main(String[] args) {
        
    }
}
