/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.tonino.shop;

/**
 *
 * @author Saverio
 */
public class Item {
    
    private int id;
    private int vendorId;
    private String name;
    private double price;
    private int quantity;
    private String category;
    private String description;
    private String imgUrl;
    
    public Item(){
       //constructor 
    }
    
    public Item(int id, int vendorId, String name, double price, int quantity, String category, String description, String imgUrl){
       
        this.id = id;
        this.vendorId = vendorId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.description = description;
        this.imgUrl = imgUrl;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the vendorId
     */
    public int getVendorId() {
        return vendorId;
    }

    /**
     * @param vendorId the vendorId to set
     */
    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl the imgUrl to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
