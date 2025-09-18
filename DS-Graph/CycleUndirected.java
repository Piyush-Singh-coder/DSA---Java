package Graph;

import java.util.*;

public class CycleUndirected {
    static class Pair {
        int src, parent;
        public Pair(int src, int parent) {
            this.src = src;
            this.parent = parent;
        }
    }

    public static boolean isCycle(int i, boolean vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[i] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, -1));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int n = cur.src;
            int p = cur.parent;

            for (int adjNode : adj.get(n)) {
                if (!vis[adjNode]) {
                    vis[adjNode] = true;
                    q.add(new Pair(adjNode, n));
                } else if (p != adjNode) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean vis[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (isCycle(i, vis, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        // Example: 0--1--2 and 1--3--4 (cycle at 1-2-0)
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(0); adj.get(0).add(2);
        adj.get(1).add(3); adj.get(3).add(1);
        adj.get(3).add(4); adj.get(4).add(3);

        System.out.println(detectCycle(adj, v)); // true
    }
}
