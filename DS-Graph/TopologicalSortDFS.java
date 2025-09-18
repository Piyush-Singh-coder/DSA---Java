package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {
    public static void dfs(int vis[], int i, Stack<Integer> s, ArrayList<ArrayList<Integer>> adj){
        vis[i] = 1;
        for(int val: adj.get(i)){
            if (vis[val] == 0){
                dfs(vis, val, s, adj);
            }
        }
        s.push(i);
    }
    public static int[] sort(ArrayList<ArrayList<Integer>> adj, int v){
        int vis[] = new int[v];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<v; i++){
            if (vis[i] == 0){
                dfs(vis, i, s, adj);
            }
        }
        int ans[] = new int[v];
        int i = 0;
        while(!s.isEmpty()){
            ans[i++] = s.pop();
        }
        return ans;
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
