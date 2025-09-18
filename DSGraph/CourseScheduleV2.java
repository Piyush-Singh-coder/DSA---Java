package Graph;

import java.util.*;

public class CourseScheduleV2 {
    public static int[] findOrder(int n, ArrayList<ArrayList<Integer>> prerequesites){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequesites.size();
        for (int i = 0; i<m; i++){
            adj.get(prerequesites.get(i).get(1)).add(prerequesites.get(i).get(0));
        }

        int indegree[] = new int[n];
        for(int i = 0; i<n; i++){
            for(int it: adj.get(i)){
                indegree[it] ++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int topo[] = new int[n];
        int ind = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            topo[ind++] = node;
            for(int val: adj.get(node)){
                indegree[val]--;
                if(indegree[val] == 0){
                    q.add(val);
                }
            }
        }
        return ind == n ? topo : new int[]{};

    }
    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
        prerequisites.add(new ArrayList<>(Arrays.asList(1, 0)));
        prerequisites.add(new ArrayList<>(Arrays.asList(2, 0)));
        prerequisites.add(new ArrayList<>(Arrays.asList(3, 1)));
        prerequisites.add(new ArrayList<>(Arrays.asList(3, 2)));

        int[] order = findOrder(n, prerequisites);
        System.out.println(Arrays.toString(order)); // Example output: [0,1,2,3]
    }
}
