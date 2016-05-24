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
     
        try {
            Connection conn = DriverManager.getConnection(connectionString, "save", "1234");
            String sql = "select * from users";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
             while(set.next()) 
            {
                if(set.getBoolean("usertype")){
                    Vendor current = new Vendor(set.getInt("id"), set.getString("fname"), set.getString("lname"), set.getString("username"), set.getString("password"));
                    userList.add(current);
                } else {
                    Buyer current = new Buyer(set.getInt("id"), set.getString("fname"), set.getString("lname"), set.getString("username"), set.getString("password"));
                    userList.add(current);
                }
            }     
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }
    
    public User userLogin(String username, String password)throws SQLException {
        Connection conn = DriverManager.getConnection(connectionString, "save", "1234");
        String query = "SELECT * FROM users "
                    + "WHERE password = ? and username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            ResultSet set = stmt.executeQuery();
            if(set.next()){
                if(set.getBoolean("usertype")){
                   Vendor vendor = new Vendor(set.getInt("id"), set.getString("fname"), set.getString("lname"), set.getString("username"), set.getString("password"));
                   return vendor;
                } else {
                    Buyer buyer = new Buyer(set.getInt("id"), set.getString("fname"), set.getString("lname"), set.getString("username"), set.getString("password"));
                    return buyer;
                }
            }
            return null;
    }
    //da aggiornare con DB
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