package DSGraph;

public class FloydWarshall {
    public static void shortest_distance (int matrix[][]){
        int n = matrix.length;
        for(int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                if (matrix[i][j] == -1){
                    matrix[i][j] = (int)1e9;
                }
                if (i == j) matrix[i][j] = 0;
            }
        }

        for (int k = 0; k<n; k++){
            for (int i = 0; i<n; i++){
                for(int j = 0; j<n ; j++){
                    if (matrix[i][k] != 1e9 && matrix[k][j] != 1e9){
                        matrix[i][j] = Math.min(matrix[i][j], (matrix[i][k] + matrix[k][j]));
                    }
                    
                }
            }
        }

        for (int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if (matrix[i][j] == 1e9){
                    matrix[i][j] = -1;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] graph = {
            {0, 5, -1, 10},
            {-1, 0, 3, -1},
            {-1, -1, 0, 1},
            {-1, -1, -1, 0}
        };

        shortest_distance(graph);

        System.out.println("All-Pairs Shortest Path:");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
