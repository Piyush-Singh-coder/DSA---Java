package Graph;

import java.util.*; 

public class CycleInDirectedBFS {
    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int v){
        int indegree[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int it: adj.get(i)){
                indegree[it] ++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            cnt++;
            for(int val: adj.get(node)){
                indegree[val] --;
                if(indegree[val] == 0){
                    q.add(val);
                }
            }
        }
        return cnt == v ? false : true;
    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        // Example: 0 -> 1 -> 2 -> 0 (cycle), and 3 is isolated
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);

        System.out.println(isCycle(adj, v)); // true

        // Another graph without cycle
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < v; i++) adj2.add(new ArrayList<>());
        adj2.get(0).add(1);
        adj2.get(1).add(2);
        adj2.get(2).add(3);

        System.out.println(isCycle(adj2, v)); // false
    }
}
