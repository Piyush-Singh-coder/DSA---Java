package Graph;

import java.util.*;

public class BipartiteGraph {
    public static boolean check(int i, int color[], ArrayList<ArrayList<Integer>> adj, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 0;

        while (!q.isEmpty()) {
            int node = q.remove();

            for (int val : adj.get(node)) {
                if (color[val] == -1) {
                    color[val] = 1 - color[node];
                    q.add(val);
                } else if (color[val] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int v) {
        int color[] = new int[v];
        for (int i = 0; i < v; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (check(i, color, adj, v) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        // Bipartite example: 0--1--2--3
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        System.out.println(isBipartite(adj, v)); // true

        // Add an odd cycle: 0--1--2--0
        adj.get(0).add(2);
        adj.get(2).add(0);

        System.out.println(isBipartite(adj, v));
    }
}
