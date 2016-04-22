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
public class Vendor extends User {
    
    ArrayList<Item> itemsForSale = new ArrayList<Item>();
    
    public Vendor(){
        super();
    }

    public ArrayList<Item> getItemsForSale(){
        return this.itemsForSale;
    }
    
    public void setItemsForSale(ArrayList<Item> itemList){
        this.itemsForSale = itemList;
    }
    
}
