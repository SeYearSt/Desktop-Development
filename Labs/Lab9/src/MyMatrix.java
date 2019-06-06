import java.util.Scanner;

public class MyMatrix {
    static private int defaultN = 3, defaultM = 3;
    private int n = defaultN, m = defaultM;
    private int min = 3, max = 5;
    private double[][] M;

    public MyMatrix(){
        this.M = this.initRandomMatrix(this.n, this.m);
    }

    public MyMatrix(double[][] M, int n, int m){
        this.n = n;
        this.m = m;
        this.M = M;

        try {
            if (n <= 0 || m <= 0) {
                throw new IllegalArgumentException("Matrix's dimensions cannot negative or zero");
            }
        }catch(IllegalArgumentException exception){
            System.out.println("Incorrect n or m");
            System.out.println("Using default values");
            System.out.println("Creating new random values");
            this.n = defaultN;
            this.m = defaultM;
            this.M = this.initRandomMatrix(n, m);

        }
    }

    public MyMatrix(int n, int m){
        try {
            if (n <= 0 || m <= 0) {
                throw new IllegalArgumentException("Matrix's dimensions cannot negative or zero");
            }
        }catch(IllegalArgumentException exception){
            System.out.println("Incorrect n or m");
            System.out.println("Using default values");
            System.out.println("Creating new random values");
            n = defaultN;
            m = defaultM;
        }finally {
            this.M = this.initRandomMatrix(n, m);
        }
    }

    public static MyMatrix initMatrix(int n, int m){
        try {
            if (n <= 0 || m <= 0) {
                throw new IllegalArgumentException("Matrix's dimensions cannot negative or zero");
            }
        }catch(IllegalArgumentException exception){
            System.out.println("Incorrect n or m");
            System.out.println("Using default values");
            System.out.println("Creating new random values");
            n = defaultN;
            m = defaultM;
        }

        double[][] M = new double[n][m];
        Scanner input = new Scanner(System.in);
        String val;

        System.out.println("Input matrix");
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j) {
                System.out.print(String.format("M[%d][%d]: ", i + 1, j + 1));
                val = input.next();
                try{
                    M[i][j] = Double.parseDouble(val);
                }catch (Exception e){
                    System.out.println("Fail to save value");
                    System.out.println("Set zezo value");
                    M[i][j] = 0;
                }
            }
        }
        return new MyMatrix(M, n, m);
    }

    public double[][] getArray(){
        return this.M;
    }

    public double getEl(int i, int j){
        try{
            return this.M[i][j];
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index");
            System.out.println("Zero will be returned");
            return 0;
        }
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
        return new MyMatrix(res, n, m);
    }

    public MyMatrix sub(MyMatrix a){
        // TODO: check M dimension
        double[][] res = new double[n][m];
        double[][] aArray = a.getArray();

        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                res[i][j] = this.M[i][j] - aArray[i][j];
            }
        }
        return new MyMatrix(res, n, m);
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < this.m; k++) {
                    res[i][j] += this.M[i][k] * aMatrix[k][j];
                }
            }
        }
        return new MyMatrix(res, n, m);
    }

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
    private double[][] initRandomMatrix(int n, int m){
        double[][] M = new double[n][m];

        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                M[i][j] = Math.round((Math.random() * ((max - min) + 1)) + min);
            }
        }
        return M;
    }
}
