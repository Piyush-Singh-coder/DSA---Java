package Graph;

import java.util.*;

public class CycleInDirectedGraph {
    public static boolean dfs(int vis[], int pathVis[], int i, ArrayList<ArrayList<Integer>> adj) {
        vis[i] = 1;
        pathVis[i] = 1;

        for (int val : adj.get(i)) {
            if (vis[val] == 0) {
                if (dfs(vis, pathVis, val, adj)) {
                    return true;
                }
            } else if (pathVis[val] == 1) {
                return true; // back edge found → cycle
            }
        }

        pathVis[i] = 0; // remove from recursion stack
        return false;
    }

    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int v) {
        int vis[] = new int[v];
        int pathVis[] = new int[v];

        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                if (dfs(vis, pathVis, i, adj)) {
                    return true;
                }
            }
        }
        return false;
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
