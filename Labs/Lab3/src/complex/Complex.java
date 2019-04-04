package complex;

public class Complex {

    private  double a;
    private double b;

    public Complex(){
        this.a = 0;
        this.b = 0;
    }

    public Complex(double a, double b){
        this.a = a;
        this.b = b;

    }

    public double getRe(){
        return this.a;
    }

    public double getIm(){
        return this.b;
    }

    public Complex add(Complex B){
        double new_a = this.a + B.getRe();
        double new_b = this.b + B.getIm();

        return new Complex(new_a, new_b);
    }

    public Complex sub(Complex B){
        double new_a = this.a - B.getRe();
        double new_b = this.b - B.getIm();

        return new Complex(new_a, new_b);
    }

    public Complex mul(Complex B){
        double a = this.a;
        double b = this.b;
        double c = B.getRe();
        double d = B.getIm();

        return new Complex(a*c-b*d, a*d+b*c);
    }

    public Complex div(Complex B){
        double a = this.a;
        double b = this.b;
        double c = B.getRe();
        double d = B.getIm();

        double new_a = (a*c+b*d)/(c*c+d*d);
        double new_b = (b*c-a*d)/(c*c+d*d);
        return new Complex(new_a, new_b);
    }

    public boolean equ(Complex B){
        double a = this.a;
        double b = this.b;
        double c = B.getRe();
        double d = B.getIm();

        return (a==c) & (b==d);
    }

    @Override
    public String toString() {
        return String.format("%f%+fi", this.a, this.b);
    }
}