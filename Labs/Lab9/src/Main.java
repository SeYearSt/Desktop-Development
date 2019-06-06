public class Main {
    public static void main(String[] args){
        MyMatrix a = new MyMatrix();
        MyMatrix b = new MyMatrix();
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
    }
}
