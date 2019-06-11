package base;

import base.Good;

public class Collection {

    Good[] goods;

    public Collection(Good[] goods){
        this.goods = new Good[goods.length];
    }

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
