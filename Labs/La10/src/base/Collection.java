package base;

public class Collection {

    public Good findUnderPrice(double price){
        return new Good("", price);
    }

    public Good findByPrice(double price){
        return new Good("", price);
    }

    public Good findByname(String goodName){
        return new Good(goodName, 0);
    }
}
