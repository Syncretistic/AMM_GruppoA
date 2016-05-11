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
public class UserFactory {
    
    private static UserFactory singleton;
    private static String connectionString;
    
    public static UserFactory getInstance() {
        if (singleton == null) {
            singleton = new UserFactory();
        }
        return singleton;
    }
    
    private UserFactory() {

    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
    
    public ArrayList<User> getUserList(){
        
        ArrayList<User> userList = new ArrayList<User>();
        
        // Vendor_1
        Vendor vendor_1 = new Vendor();
        vendor_1.setId(0);
        vendor_1.setFname("Gino");
        vendor_1.setLname("Paoli");
        vendor_1.setUsername("gino.paoli");
        vendor_1.setPassword("gp");
        userList.add(vendor_1);
        
        // Vendor_2
        Vendor vendor_2 = new Vendor();
        vendor_2.setId(1);
        vendor_2.setFname("Paolo");
        vendor_2.setLname("Brosio");
        vendor_2.setUsername("paolo.brosio");
        vendor_2.setPassword("pb");
        userList.add(vendor_2);
        
        Buyer buyer_1 = new Buyer();
        buyer_1.setId(2);
        buyer_1.setFname("Elon");
        buyer_1.setLname("Musk");
        buyer_1.setUsername("elon.musk");
        buyer_1.setPassword("em");
        userList.add(buyer_1);
        
        // Buyer_2
        Buyer buyer_2 = new Buyer();
        buyer_2.setId(3);
        buyer_2.setFname("Bill");
        buyer_2.setLname("Gates");
        buyer_2.setUsername("bill.gates");
        buyer_2.setPassword("bg");
        userList.add(buyer_2);
        
        return userList;
    }
    
    public User getUserById(int id){
        ArrayList<User> userList = this.getUserList();
        for(User user : userList){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
    
}