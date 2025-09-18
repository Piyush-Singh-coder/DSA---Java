package Graph;

import java.util.*;

public class RottenOranges {
    static class Pair{
        int row;
        int col;
        int tm;

        public Pair(int row, int col, int tm){
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }

    public static int rottenOranges(int oranges[][]){
        Queue<Pair> q = new LinkedList<>();
        int m = oranges.length;
        int n = oranges[0].length;
        int vis [][] = new int[m][n];
        int freshCnt = 0;

        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n; j++){
                if (oranges[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }
                if (oranges[i][j] == 1){
                    freshCnt ++;
                }
            }
        }
        int tm = 0;
        int drow[] = { -1, 0, +1, 0};
        int dcol[] = { 0, 1, 0, -1};
        int cnt = 0;

        while (!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(tm, t);
            q.remove();
            for(int i = 0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if (nrow >= 0 && nrow< m && ncol >= 0 && ncol < n && (vis[nrow][ncol] == 0) && (oranges[nrow][ncol] == 1)){
                    q.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cnt ++;
                }
            }
        }
        return cnt != freshCnt ? -1 : tm;
    }
    public static void main(String[] args) {
        int oranges [][] = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(rottenOranges(oranges));
    }
}
