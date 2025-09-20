package DSGraph;

import java.util.ArrayList;

public class DisjointSet {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0; i<=n; i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node){
        if (node == parent.get(node)){
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionByRank(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;

        if (rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }
        else if (rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
        }else{
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU+1);
        }
    }

    static class DisjointSetBySize{
        ArrayList<Integer> rank = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();
        
        public DisjointSetBySize(int n){
            for (int i = 0; i<=n; i++){
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        public int findUParent(int node){
            if (node == parent.get(node)){
                return node;
            }
            int uPar = findUParent(parent.get(node));
            parent.set(node, uPar);
            return parent.get(node);
        }
        public void unionByRank(int u, int v){
            int ulp_u = findUParent(u);
            int ulp_v = findUParent(v);
            if (ulp_u == ulp_v) return;

            if (rank.get(ulp_u) < rank.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
            }
            else if (rank.get(ulp_u) > rank.get(ulp_v)){
                parent.set(ulp_v,ulp_u);           
            }else{
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU+1);
        }
    }
    
    public void unionBySize(int u, int v){
            int ulp_u = findUParent(u);
            int ulp_v = findUParent(v);
            if (ulp_u == ulp_v) return;

            if (size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }else{
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
            }
    }
}
    public static void main(String[] args) {
        DisjointSetBySize ds = new DisjointSetBySize(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        if (ds.findUParent(3) == ds.findUParent(7)){
            System.out.println("Same");
        }else{
            System.out.println("Not same");
        }
        ds.unionByRank(3, 7);

        if (ds.findUParent(3) == ds.findUParent(7)){
            System.out.println("Same");
        }else{
            System.out.println("Not same");
        }
    }
}
