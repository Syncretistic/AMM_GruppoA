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
public class Buyer extends User{
    
    ArrayList<Item> orderList = new ArrayList<Item>();
    
    public Buyer( int id, String fname, String lname, String username, String password ){
        super(id,fname,lname,username,password);
    }
    
    
    public ArrayList<Item> getOrderList(){
        return this.orderList;
    }
    
    public void setOrderList(ArrayList<Item> itemList){
        this.orderList = itemList;
    }
    
}