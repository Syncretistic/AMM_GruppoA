/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.tonino.classes;

import java.util.ArrayList;

/**
 *
 * @author Saverio
 */
public class ItemFactory {
    
    private static ItemFactory singleton;
    private static String connectionString;
    
    public static ItemFactory getInstance() {
        if (singleton == null) {
            singleton = new ItemFactory();
        }
        return singleton;
    }
    
    private ItemFactory() {

    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
    
    public ArrayList<Item> getItemList() {
    
        ArrayList<Item> itemList = new ArrayList<Item>();
        
        Item item_1 = new Item( 0, 0, "Apple Iphone 6", 699.99, 1, "smartphone", "Generic Iphone description", "M2/img/Iphone1.jpg");
        itemList.add(item_1);
        Item item_2 = new Item( 1, 0, "Samsung Galaxy s6", 599.99, 5, "smartphone", "Generic Samsung description", "M2/img/GalaxyS6.jpg");
        itemList.add(item_2);
        Item item_3 = new Item( 2, 0, "D510 MT Desktop Computer", 799.99, 10, "desktop", "Generic Desktop description", "M2/img/Desktop1.jpg");
        itemList.add(item_3);
        Item item_4 = new Item( 3, 1, "Western Digital Caviar Black 1 TB", 79.99, 15, "accessories", "Generic HDD description", "M2/img/HDD1.jpg");
        itemList.add(item_4);
        Item item_5 = new Item( 4, 1, "ASUS - Notebook con Monitor 15,6\" Full HD", 2999.99, 125, "laptop", "Generic Laptop description", "M2/img/Laptop1.jpg");
        itemList.add(item_5);
        Item item_6 = new Item( 5, 1, "ASUS - VS228DE Monitor 21.5", 179.99, 15, "accessories", "Generic Monitor description", "M2/img/Monitor1.jpg");
        itemList.add(item_6);
        Item item_7 = new Item( 6, 1, "Hannspree Tablet PC 10,1\"", 479.99, 15, "tablet", "Generic Tablet description", "M2/img/HannspreeTablet1.jpg");
        itemList.add(item_7);
        
        
        return itemList;
    }
    
    public Item getItemById(int id){
        ArrayList<Item> itemList = this.getItemList();
        for(Item item : itemList){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }
    
    public ArrayList<Item> getItemByCategory(String category){
        ArrayList<Item> itemList = this.getItemList();
        ArrayList<Item> itemListByCat = new ArrayList<Item>();
        for(Item item : itemList){
            if(category.equals(item.getCategory())){
                itemListByCat.add(item);
            }
        }
        return itemListByCat;
    }
    
    public ArrayList<Item> getItemByPriceRange(double minPrice, double maxPrice){
        ArrayList<Item> itemList = this.getItemList();
        ArrayList<Item> itemListByPrice = new ArrayList<Item>();
        for(Item item : itemList){
            if(item.getPrice() >= minPrice && item.getPrice() <= maxPrice){
                itemListByPrice.add(item);
            }
        }
        return itemListByPrice;
    }
}
