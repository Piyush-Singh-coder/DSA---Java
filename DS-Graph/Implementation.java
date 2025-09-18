package Graph;

import java.util.ArrayList;

public class Implementation {
    public static void main(String[] args) {
        // 1 - 2
        // 1 - 3
        // 2 - 4
        // 3 - 4
        // 2 - 5
        // 4 - 5
       int n = 3, m = 3;
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

       // n+1
       for(int i = 0; i<=n; i++){
        graph.add(new ArrayList<Integer>());
       }
       
       //edge 1 - 2
       graph.get(1).add(2);
       graph.get(2).add(1);

       //edge 2 - 3
       graph.get(2).add(3);
       graph.get(3).add(2);

       // graph.get(u).add(v);
       // graph.get(v).add(u);

       // Traversing
       for(int i = 1; i<=n; i++){
        for(int j = 0; j<graph.get(i).size(); j++){
            System.out.print(graph.get(i).get(j) + " ");
        }
        System.out.println();
       }

    }
}
