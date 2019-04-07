public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] M = Main.initMatrix(n);
        Main.outputMatrix(M, n, n);
        System.out.println();
        Main.swapByMinorDiagonal(M,n);
        Main.outputMatrix(M, n, n);

    }

    public static int[][] initMatrix(int n) {
        int M[][] = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                M[i][j] = k++;
            }
        }
        return M;
    }

    static public void outputMatrix(int[][] matrix, int n, int m) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(String.format("A[%d][{%d}]=%d ", i, j, matrix[i][j]));
            }
            System.out.println();
        }
    }

    static public void swapByMinorDiagonal(int [][] M, int n){

        for (int i=0; i<n; ++i) {
            for (int j = 0; j < i; ++j){
                Main.swap(M, i, j, j, i);
            }
        }

        for (int i=0; i<n/2; ++i){
            Main.swapRows(M, i, n-1-i, n);
        }

        for (int j=0; j<n/2; ++j){
            Main.swapColumns(M, j, n-1-j, n);
        }
    }

    static public void swap(int [][] M, int i1, int j1, int i2, int j2){
        int temp = M[i1][j1];
        M[i1][j1] = M[i2][j2];
        M[i2][j2] = temp;
    }

    static public void swapRows(int [][] M, int i1, int i2, int n){
        for (int j=0; j<n; ++j){
            int temp = M[i1][j];
            M[i1][j] = M[i2][j];
            M[i2][j] = temp;
        }
    }

    static public void swapColumns(int [][] M, int j1, int j2, int n){
        for (int i=0; i<n; ++i){
            int temp = M[i][j1];
            M[i][j1] = M[i][j2];
            M[i][j2] = temp;
        }
    }

}
