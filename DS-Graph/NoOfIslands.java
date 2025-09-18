package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {
    static class Pair{
        int first;
        int second; 
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void bfs(int row, int col, int [][] vis, char [][] grids){
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        int m = grids.length;
        int n = grids[0].length;

        while(!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();

            for(int delrow = -1; delrow<= 1; delrow++ ){
                for(int delcol = -1; delcol <= 1; delcol++){
                    int nrow = r + delrow;
                    int ncol = c + delcol;
                    if (nrow >= 0 && nrow<m && ncol>= 0 && ncol < n && (vis[nrow][ncol] == 0) && (grids[nrow][ncol] == 'l')){
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
            
        }
    }
    public static int islandsCount(char [][]grids){
        int m = grids.length;
        int n = grids[0].length;
        int vis[][] = new int[m][n];
        int cnt = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(vis[i][j] == 0 && grids[i][j] == 'l'){
                    cnt++;
                    bfs(i, j, vis, grids);
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        char grids[][] = {
                        {'0','l','l','0'},
                        {'0','l','l','0'},
                        {'0','0','l','0'},
                        {'0','0','0','0'},
                        {'l','l','0','l'}
        };
        System.out.println(islandsCount(grids));
    }
}
