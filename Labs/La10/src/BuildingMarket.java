import java.util.HashMap;

import base.*;
import goods.plumbing.*;
import goods.furniture.*;
import goods.electricity.*;
import goods.floor.*;
import goods.tool.*;
import goods.wall.*;
import goods.supplies.*;

public class BuildingMarket {

    String[] DepartmentsName = {"Plumbing", "Furniture", "Floor", "Wall", "Supplies", "Tool", "Electricity"};
    HashMap<String, Collection> departments = new HashMap<String, Collection>();

    public static void main(String[] args){

        BuildingMarket b = new BuildingMarket();
        System.out.println(b.getDepartments());
    }

    public BuildingMarket(){
        initDepartments();
    }

    public void initDepartments(){

        // plumbing
        Bath bath = new Bath("Bath1", 1);
        Boiler boiler = new Boiler("Boiler", 1);
        Drier drier = new Drier("Drier1", 1);
        Shower shower = new Shower("Shower1", 1);
        Tap tap = new Tap("Tap1", 1);
        Toilet toilets = new Toilet("Toilet1", 1);
        WashBasin washBasins = new WashBasin("WashBasin1", 1);
        Good[] plumbingGoods = {bath, boiler, drier, shower, tap, toilets, washBasins};
        Collection plumbingCollection = new Collection(plumbingGoods);

        departments.put("Plumbing", plumbingCollection);

        //Furniture
        Bed bed = new Bed("Bed1", 110);
        Chair chair = new Chair("Chair1", 5);
        Couch couch = new Couch("Couch", 9);
        Door door = new Door("Door1", 25);
        Kitchen kitchen = new Kitchen("Kitchen1", 29);
        Table table = new Table("Table1", 40);

        Good[] furnitureGoods = {bed, chair, couch, door, kitchen, table};
        Collection furnitureCollection = new Collection(furnitureGoods);

        departments.put("Furniture", furnitureCollection);

        //Floor
        FloorHeating floorHeating = new FloorHeating("FloorHeating1", 10);
        LaminateFlooring laminateFlooring = new LaminateFlooring("LaminateFlooring1", 112);
        Parquet parquet = new Parquet("Parquet", 91);
        Tile tile = new Tile("Tile1", 19);
        Good[] floorGoods = {floorHeating, laminateFlooring, parquet, tile};
        Collection floorCollection = new Collection(floorGoods);

        departments.put("Floor", floorCollection);

        //Wall
        Paint paint = new Paint("Paint", 4);
        Good[] wallGoods = {paint};
        Collection wallCollection = new Collection(wallGoods);

        departments.put("Wall", wallCollection);

        //Supplies
        Cross cross = new Cross("Cross", 1);
        Primer primer = new Primer("Primer", 2);
        Good[] suppliesGoods = {cross, primer};
        Collection suppliesCollection = new Collection(suppliesGoods);

        departments.put("Supplies", suppliesCollection);


        //Tool
        CircularSaw circularSaw = new CircularSaw("CircularSaw1", 55);
        GassKey gassKey = new GassKey("GassKey1", 23);
        Hammer hammer = new Hammer("Hammer", 10);
        Perforata perforata = new Perforata("Perforata1", 60);
        VaserVaga vaserVaga = new VaserVaga("VaserVaga1", 34);
        Good[] toolGoods = {circularSaw, gassKey, hammer, perforata, vaserVaga};
        Collection toolCollection = new Collection(toolGoods);

        departments.put("Tool", toolCollection);


        //Electricity
        Cabel cabel = new Cabel("Cabel1", 1);
        LightBuble lightBuble = new LightBuble("LightBuble1", 1);
        Rossete rossete = new Rossete("Rossete1", 1);
        Switch switchGood = new Switch("Switch1", 1);
        Good[] electricityGoods = {cabel, lightBuble, rossete, switchGood};
        Collection electricityCollection = new Collection(electricityGoods);

        departments.put("Electricity", plumbingCollection);

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

    public HashMap<String, Collection> getDepartments(){
        return departments;
    }

//    public HashMap<String, Collection> formDefaultPacakge(){
//      return departments;
//    }

}
