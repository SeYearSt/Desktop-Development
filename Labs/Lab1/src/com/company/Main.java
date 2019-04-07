package com.company;

public class Main {
    static int k = 1;

    static double x_start = -1.83*k + 0.5;
    static double x_end = 2.38*k + 0.5;
    static double y_start = -0.74 + 1.0;
    static double y_end = 0.86*k + 1.0;
    static double Z = 1.3*k +1.5;

    static int Nx = 10;
    static int Ny = 15;
    static int Nz = 1;

    public static void main(String[] args) {

        double [] X = Main.createArray(Main.x_start, Main.x_end, Main.Nx);
        double [] Y = Main.createArray(Main.y_start, Main.y_end, Main.Ny);

        Main.outputTable(X, Y, Z);

    }

    private static double f1(double x, double y, double z){
        return (2*z+Math.cos(Math.pow(Math.abs(y-3*x), 1./3)))/(2.1+Math.pow(Math.sin(Math.pow(Math.abs(z*z*z - y), 0.2)), 2))+Math.pow(Math.log(Math.abs(z-x)), 2);
    }

    private static double f2(double x, double y, double z){
        return Math.pow(Math.abs(x), 0.43) + (Math.exp(y-x) + Math.sqrt(Math.pow(Math.abs(y*y + Main.f1(x,y,z)) ,0.22)))/(1.72 + x*x*Math.abs(y - Math.tan(z)* Math.tan(z)));
    }

    private static double[] createArray(double start, double end, int count){
        // TODO: add checking start < end
        double step = (end - start) / count;
        double tempEnd = start;
        double [] range;
        range = new double[count];

        int i = 0;
        while (tempEnd < end && i < count) {
            range[i] = tempEnd;
            tempEnd += step;
            ++i;
        }

        return range;
    }

    private static void outputArray(double [] A){
        for (int i = 0; i < A.length; ++i){
            System.out.print(A[i]);
            System.out.print(" ");
        }
    }

    private static void outputTable(double[] X, double[] Y, double Z){

        System.out.print(String.format("|%20s|", "X"));
        System.out.print(String.format("%20s|", "Y"));
        System.out.print(String.format("%20s|", "Z"));
        System.out.println(String.format("%20s|", "F"));
        System.out.println(String.format("|%84s", '|').replace(' ', '-'));


        for (int i = 0; i < X.length; ++i) {
            for (int j = 0; j < Y.length; ++j) {
                System.out.print(String.format("|%20f|", X[i]));
                System.out.print(String.format("%20f|", Y[i]));
                System.out.print(String.format("%20f|", Z));
                System.out.println(String.format("%20f|", Main.f2(X[i], Y[j], Main.Z)));
            }
        }
    }
}
