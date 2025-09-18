package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class DistinctIslands {
    static class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void dfs (int row, int col, int vis[][], ArrayList<String> vec, int [][] grids, int row0, int col0){
        vis[row][col] = 1;
        vec.add(toString(row - row0, col-col0));
        int m = grids.length;
        int n = grids[0].length;
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,-1,0, 1};
        for(int i = 0; i<4; i++){
            int nrow = row - delrow[i];
            int ncol = col - delcol[i];

            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grids[nrow][ncol] == 1){
                dfs(nrow, ncol, vis, vec, grids, row0, col0);
            }
        }
    }
    public static int distinctIslandsCount(int [][]grids){
        int m = grids.length;
        int n = grids[0].length;
        int vis[][] = new int[m][n];
        HashSet<ArrayList<String>> st = new HashSet<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if (vis[i][j] == 0 && grids[i][j] == 1){
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i,j, vis, vec, grids, i, j);
                    st.add(vec);
                }
            }
        }
        return st.size();
    }
    private static String toString(int row, int col){
        return Integer.toString(row) + " " + Integer.toString(col);
    }
    public static void main(String[] args) {
        int grids[][] = {
                        {1,1,0,1,1},
                        {1,0,0,0,0},
                        {0,0,0,1,1},
                        {1,1,0,1,0}
        };
        System.out.println(distinctIslandsCount(grids));
    }
}
