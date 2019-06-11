package base;

import base.Good;

public class Collection {

    Good[] goods;

    public Collection(Good[] goods){
        this.goods = goods;
    }

    public int getLength(){
        return goods.length;
    }

    public Good getEl(int i){
        return goods[i];
    }

    public Good[] findUnderPrice(String name, double price){
        int countGoodsUnderPrice = 0;
        for(int i=0; i<goods.length; ++i) {
            if ((goods[i].name.contains(name)) && (goods[i].price <= price)) {
                countGoodsUnderPrice++;
            }
        }

        Good[] goodsSelected = new Good[countGoodsUnderPrice];

        if (countGoodsUnderPrice!= 0){
            int j = 0;
            for(int i=0; i<goods.length; ++i){
                if((goods[i].name.contains(name)) && (goods[i].price <= price)){
                    goodsSelected[j] = goods[i];
                    j++;
                }
            }
        }
        return goodsSelected;
    }

    public Good[] findByPrice(double price){
        int countGoodsUnderPrice = 0;
        for(int i=0; i<goods.length; ++i) {
            if (goods[i].price == price) {
                countGoodsUnderPrice++;
            }
        }

        Good[] goodsSelected = new Good[countGoodsUnderPrice];

        if (countGoodsUnderPrice!= 0){
            int j = 0;
            for(int i=0; i<goods.length; ++i){
                if(goods[i].price == price){
                    goodsSelected[j] = goods[i];
                    j++;
                }
            }
        }
        return goodsSelected;
    }

    public Good[] findByName(String name){
        int countGoodsUnderPrice = 0;
        for(int i=0; i<goods.length; ++i) {
            if (goods[i].name.contains(name)) {
                countGoodsUnderPrice++;
            }
        }

        Good[] goodsSelected = new Good[countGoodsUnderPrice];

        if (countGoodsUnderPrice!= 0){
            int j = 0;
            for(int i=0; i<goods.length; ++i){
                if(goods[i].name.contains(name)){
                    goodsSelected[j] = goods[i];
                    j++;
                }
            }
        }
        return goodsSelected;
    }
}
