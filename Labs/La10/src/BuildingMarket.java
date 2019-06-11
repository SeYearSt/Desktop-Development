import base.*;
import goods.*;

public class BuildingMarket {

//    TODO: use map
    String[] DepartmentsName = {"Plumbing", "Furniture", "Floor", "Wall", "Supplies", "Tool", "Electricity"};
    Collection[] departments = new Collection[DepartmentsName.length];

    public static void main(String[] args){
        System.out.println("asd");
        BuildingMarket b = new BuildingMarket();
    }

    public Good findUnderPrice(String departmentName, String goodName, double goodPrice){
        return new Good(goodName, goodPrice);
    }

    public Good findByPrice(String departmentName, String goodName, double goodPrice){
        return new Good(goodName, goodPrice);
    }

    public Good findByName(String departmentName, String goodName, double goodPrice){
        return new Good(goodName, goodPrice);
    }

}
