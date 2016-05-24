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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saverio
 */
public class AccountFactory {
    
    private static AccountFactory singleton;
    private static String connectionString;
    public static AccountFactory getInstance() {
        if (singleton == null) {
            singleton = new AccountFactory();
        }
        return singleton;
    }
    
    private AccountFactory() {

    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
    
    public ArrayList<Account> getAccountList() {
    
        ArrayList<Account> accountList = new ArrayList<Account>();
        
        try {
            Connection conn = DriverManager.getConnection(connectionString, "save", "1234");
            String sql = "select * from accounts";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
             while(set.next()) 
            {
                Account current = new Account(set.getInt("userid"), set.getDouble("balance"));
                accountList.add(current);
            }     
            } catch (SQLException ex) {
                ex.printStackTrace();
           }
        return accountList;
    }
    //da aggiornare con DB
    public Account getAccountById(int id){
        ArrayList<Account> accountList = this.getAccountList();
        for(Account account : accountList){
            if(account.getUserId() == id){
                return account;
            }
        }
        return null;
    }
    
    public void itemPurchase(int buyerId, int itemId) throws SQLException {
        Connection conn = DriverManager.getConnection(connectionString, "save", "1234");
        PreparedStatement updateItem = null;
        PreparedStatement updateBalance = null;
        Account currAccount = AccountFactory.getInstance().getAccountById(buyerId);
        Item currItem = ItemFactory.getInstance().getItemById(itemId);
        int vendId = currItem.getVendId();
        double newVendBalance = AccountFactory.getInstance().getAccountById(vendId).getBalance() + currItem.getPrice();
        double newBuyerBalance = currAccount.getBalance() - currItem.getPrice();
        String sql_1 = null;
        
        String sql_2 = "UPDATE accounts SET " + "balance = ? WHERE userid = ?";
        try {
            conn.setAutoCommit(false);
            int c1 = 0;
            if(currItem.getQuantity() == 1){
                sql_1 = "DELETE FROM Items " + "WHERE id = ? ";
                updateItem = conn.prepareStatement(sql_1);
                updateItem.setInt(1, itemId);
                c1 = updateItem.executeUpdate();
            } else {
                sql_1 = "UPDATE items SET " + "quantity = ? WHERE id = ?";
                updateItem = conn.prepareStatement(sql_1);
                updateItem.setInt(1, currItem.getQuantity()-1);
                updateItem.setInt(2, itemId);
                c1 = updateItem.executeUpdate();
            }
            updateBalance = conn.prepareStatement(sql_2);
            updateBalance.setDouble(1, newVendBalance);
            updateBalance.setInt(2, vendId);
            int c2 = updateBalance.executeUpdate();
            updateBalance.setDouble(1, newBuyerBalance);
            updateBalance.setInt(2, buyerId);
            int c3 = updateBalance.executeUpdate();
            if(c1 != 1 || c2 != 1 || c3 != 1)
               conn.rollback();
            
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            try
            {
                conn.rollback();
            }catch(SQLException e2)
            {
                e2.printStackTrace();
            } finally {
            if(updateItem != null)
                updateItem.close();
            if(updateBalance != null)
                updateBalance.close();
            
            conn.setAutoCommit(true);
            conn.close();
        }    
        }
    }
}
