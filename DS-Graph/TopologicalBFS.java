package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalBFS {
    public static int[] sort(ArrayList<ArrayList<Integer>> adj, int v){
        int inorder[] = new int[v];
        for(int i = 0; i<v; i++){
            for(int val : adj.get(i)){
                inorder[val]++;  //Indegree not inorder.
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<v; i++){
            if (inorder[i] == 0){
                q.add(i);
            }
        }

        int topo [] = new int[v];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            topo[i++] = node;
            for(int val: adj.get(node)){
                inorder[val]--;
                if(inorder[val] == 0){
                    q.add(val);
                }
            }
        }
        return topo;
    }
    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        // Example DAG:
        // 5 → 0, 5 → 2
        // 4 → 0, 4 → 1
        // 2 → 3, 3 → 1
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        int[] topoOrder = sort(adj, v);
        System.out.print("Topological Sort: ");
        for (int x : topoOrder) System.out.print(x + " ");
    }
}
