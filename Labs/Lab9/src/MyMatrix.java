public class MyMatrix {
    private int n = 3, m = 3;
    private int min = 3, max = 5;
    private double[][] M;

    public MyMatrix(){
        this.M = new double[n][m];

        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                this.M[i][j] = Math.round((Math.random() * ((max - min) + 1)) + min);
            }
        }
    }

    public MyMatrix(double[][] M){
        // TODO: check dimensions
        this.M = M;
    }

    public MyMatrix(int n, int m){
        // TODO: check numbers

    }

    public static MyMatrix initMatrix(int n, int m){
        // TODO: check numbers
        // TODO: check input values

        return null;
    }

    public double[][] getArray(){
        return this.M;
    }

    public int getDim(int d){
        if (d==0){
            return n;
        }else if (d==1) {
            return m;
        }else throw new IllegalArgumentException("There is no more dimensions");
    }

    public MyMatrix add(MyMatrix a){
        // TODO: check M dimension
        double[][] res = new double[n][m];
        double[][] aArray = a.getArray();

        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                res[i][j] = aArray[i][j] + this.M[i][j];
            }
        }
        return new MyMatrix(res);
    }

    public MyMatrix sub(MyMatrix a){
        double[][] res = new double[n][m];
        double[][] aArray = a.getArray();

        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                res[i][j] = this.M[i][j] - aArray[i][j];
            }
        }
        return new MyMatrix(res);
    }

    public MyMatrix mul(MyMatrix a) {
//        // TODO: check M dimension

        int n = this.n;
        int m = a.getDim(1);
        double[][] res = new double[n][m];
        double[][] aMatrix = a.getArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = 0.;
            }
        }

        for (int i = 0; i < n; i++) { // aRow
            for (int j = 0; j < m; j++) { // bColumn
                for (int k = 0; k < this.m; k++) { // aColumn
                    res[i][j] += this.M[i][k] * aMatrix[k][j];
                }
            }

        }
        return new MyMatrix(res);
    }

//    public static void outputMatrix(int[][] M){
//        for (int i = 0; i < M.length; i++) {
//            for (int j = 0; j < M[i].length; j++) {
//                System.out.print(String.format("M[%d][%d]: ", i+1, j+1) + M[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    // TODO: add check if number is negative

    @Override
    public String toString() {
        String resultString = "";

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                resultString += String.format("M[%d][%d]: %.1f ", i+1, j+1, M[i][j]);
            }
            resultString += "\n";
        }
        return resultString;
    }
}
