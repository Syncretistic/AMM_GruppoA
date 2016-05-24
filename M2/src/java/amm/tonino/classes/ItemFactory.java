/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.tonino.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        try {
            Connection conn = DriverManager.getConnection(connectionString, "save", "1234");
            String sql = "select * from items";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
             while(set.next()) 
            {
                Item current = new Item( set.getInt("id"), set.getString("itemname"), set.getDouble("price"), set.getInt("quantity"), set.getString("category"), set.getString("description"), set.getString("img"), set.getInt("vendId"));
                itemList.add(current);
            }
            stmt.close();
            conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
           }
 
        return itemList;
    }
    
    public ArrayList<Item> getItemByVendId(int vendId) {
        ArrayList<Item> itemList = new ArrayList<Item>();
        try {
            Connection conn = DriverManager.getConnection(connectionString, "save", "1234");
            String sql = "select * from items "+"where vendid = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, vendId);
            ResultSet set = stmt.executeQuery();
             while(set.next()) 
            {
                Item current = new Item( set.getInt("id"), set.getString("itemname"), set.getDouble("price"), set.getInt("quantity"), set.getString("category"), set.getString("description"), set.getString("img"), set.getInt("vendId"));
                itemList.add(current);
            }
            stmt.close();
            conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
           }
 
        return itemList;
    }
    public Item getItemById(int id){
        try {
            Connection conn = DriverManager.getConnection(connectionString, "save", "1234");
            String sql = "select * from items "+"where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            Item item = new Item( set.getInt("id"), set.getString("itemname"), set.getDouble("price"), set.getInt("quantity"), set.getString("category"), set.getString("description"), set.getString("img"), set.getInt("vendId"));
            stmt.close();
            conn.close();
            return item;
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
        return null;     
    }
    //da aggiornare con DB
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
    //da aggiornare con DB
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
    
    public void addItem(String itemName, String description, int quantity, double price, String category, String img, int vendId){
        try {
            Connection conn = DriverManager.getConnection(connectionString, "save", "1234");
            String sql = "INSERT INTO Items" + "(id, itemName, description, quantity, price, category, img, vendId)" + "VALUES (default,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, itemName);
            stmt.setString(2, description);
            stmt.setInt(3, quantity);
            stmt.setDouble(4, price);
            stmt.setString(5, category);
            stmt.setString(6, img);
            stmt.setInt(7, vendId);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
           
    }
    
    public void deleteItem(int id){
        try {
            Connection conn = DriverManager.getConnection(connectionString, "save", "1234");
            String sql_1 = "DELETE FROM Items " + "WHERE id = ? ";
            PreparedStatement deleteItem = conn.prepareStatement(sql_1);
            deleteItem.setInt(1, id);
            deleteItem.executeUpdate();
            deleteItem.close();
            conn.close();
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
        
    }
    
    public void updateItem(int id, String itemName, String description, int quantity, double price, String category, String img){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "save", "1234");
            String sql = "UPDATE items SET " + "itemname = ?, description = ?, quantity = ?, price = ?, category = ?, img = ? WHERE id = ?";
            PreparedStatement updateItem = conn.prepareStatement(sql);
            updateItem.setString(1, itemName);
            updateItem.setString(2, description);
            updateItem.setInt(3, quantity);
            updateItem.setDouble(4, price);
            updateItem.setString(5, category);
            updateItem.setString(6, img);
            updateItem.setInt(7, id);
            updateItem.executeUpdate();
            updateItem.close();
            conn.close();
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
    }
}
