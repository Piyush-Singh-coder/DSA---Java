package DSGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PrimAlgorithm {
    static class Pair{
        int distance;
        int node;

        public Pair(int distance, int node){
            this.distance = distance;
            this.node = node;
        }
    }
    public static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        int vis[] = new int[v];
        pq.add(new Pair(0, 0));
        int sum = 0;
        while(pq.size() != 0){
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();

            if (vis[node] == 1) continue;
            vis[node] = 1;
            sum += wt;

            for(int i= 0; i<adj.get(node).size(); i++){
                int pqWt = adj.get(node).get(i).get(1);
                int pqNode = adj.get(node).get(i).get(0);
                if (vis[pqNode] == 0){
                    pq.add(new Pair(pqWt, pqNode));
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new ArrayList<>(Arrays.asList(1,1)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(3,4)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(0,1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2,2)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1,2)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3,3)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(0,4)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(2,3)));
        
        System.out.println(spanningTree(v, adj));
    }
}
