import java.util.Random;

public class Main {
    public static void main(String[] args){
        int n = 3;
        int m = 3;
        int scale = 50;

        int [][] matrix = Main.initMatrix(n, m, scale, false);
        Main.outputMatrix(matrix, n, m);
        Main.reverseRowsWithEvenNumbers(matrix, n, m);
        System.out.println();
        Main.outputMatrix(matrix, n, m);

    }
    static private int [][] initMatrix(int n, int m, int scale, boolean odd){
        int[][] matrix = new int[n][m];

        Random randomGenerator = new Random();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int randNumber;
                do {
                    randNumber = randomGenerator.nextInt(scale) + 1;
                } while(randNumber % 2 == 0 && odd);
                matrix[i][j] = randNumber;
            }
        }

        return matrix;
    }

    static private void outputMatrix(int [][]matrix, int n, int m){
        for(int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                System.out.print(String.format("A[%d][{%d}]=%d ", i, j, matrix[i][j]));
            }
            System.out.println();
        }
    }

    static private boolean isOddArray(int [] arr){
        for(int i=0; i<arr.length; ++i){
            if (arr[i] % 2 == 0){
                return false;
            }
        }
        return true;
    }

    static private void reverseArray(int [] arr) {
        int n = arr.length;
        for (int i = 0; i < n/2; ++i) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }
    static private int [][] reverseRowsWithEvenNumbers( int[][] matrix, int n, int m){
        boolean reversed = false;

        for(int i=0; i<n; ++i) {
            if (Main.isOddArray(matrix[i])) {
                reversed = true;
                Main.reverseArray(matrix[i]);
            }
        }
        if (!reversed){
            System.out.println("Matrix doest have rows with only odd numbers");
        }
        return matrix;
    }
}
