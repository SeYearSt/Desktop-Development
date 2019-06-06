public class Main {
    public static void main(String[] args){
        MyMatrix a = new MyMatrix();
//        MyMatrix b = new MyMatrix();
        MyMatrix b = MyMatrix.initMatrix(3, 3);
        System.out.println("A");
        System.out.println(a);
        System.out.println("B:");
        System.out.println(b);
        System.out.println("A + B");
        System.out.println(a.add(b));
        System.out.println("A - B");
        System.out.println(a.sub(b));
        System.out.println("A * B");
        System.out.println(a.mul(b));
        System.out.println("Catch exception IllegalArgumentException");
        System.out.println(a.getEl(-1, -1));
        System.out.println("\nCatch exception IllegalArgumentException");
        System.out.println(a.getEl(1, 50));
    }
}
