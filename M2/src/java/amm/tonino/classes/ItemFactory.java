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

    public static ItemFactory getInstance() {
        if (singleton == null) {
            singleton = new ItemFactory();
        }
        return singleton;
    }
    
    private ItemFactory() {

    }
    
    public ArrayList<Item> getItemList() {
    
        ArrayList<Item> itemList = new ArrayList<Item>();
        
        Item item_1 = new Item( 0, 0, "Apple Iphone 6", 699.99, 1, "smartphone", "Generic Iphone description", "M2/img/Iphone1.jpg");
        itemList.add(item_1);
        Item item_2 = new Item( 1, 0, "Samsung Galaxy s6", 599.99, 5, "smartphone", "Generic Samsung description", "M2/img/GalaxyS6.jpg");
        itemList.add(item_2);
        Item item_3 = new Item( 2, 1, "D510 MT Desktop Computer", 799.99, 10, "desktop", "Generic Desktop description", "M2/img/Desktop1.jpg");
        itemList.add(item_3);
        Item item_4 = new Item( 3, 1, "Western Digital Caviar Black 1 TB", 79.99, 15, "accessories", "Generic HDD description", "M2/img/HDD1.jpg");
        itemList.add(item_4);
        
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
    
    public Item getItemByCategory(String category){
        ArrayList<Item> itemList = this.getItemList();
        for(Item item : itemList){
            if(category.equals(item.getCategory())){
                return item;
            }
        }
        return null;
    }
    
    public Item getItemByPriceRange(double minPrice, double maxPrice){
        ArrayList<Item> itemList = this.getItemList();
        for(Item item : itemList){
            if(item.getPrice() >= minPrice && item.getPrice() <= maxPrice){
                return item;
            }
        }
        return null;
    }
}
