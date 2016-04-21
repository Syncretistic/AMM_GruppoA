/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.tonino.shop;

import java.util.ArrayList;

/**
 *
 * @author Saverio
 */
public class BuyerFactory {
    
    private static BuyerFactory singleton;

    public static BuyerFactory getInstance() {
        if (singleton == null) {
            singleton = new BuyerFactory();
        }
        return singleton;
    }
    
    private BuyerFactory() {

    }
    
    public ArrayList<Buyer> getBuyerList(){
        
        ArrayList<Buyer> BuyerList = new ArrayList<Buyer>();
        
        // Buyer_1
        Buyer buyer_1 = new Buyer();
        buyer_1.setId(2);
        buyer_1.setFname("Elon");
        buyer_1.setLname("Musk");
        buyer_1.setUsername("elon.musk");
        buyer_1.setPassword("em");
        BuyerList.add(buyer_1);
        
        // Buyer_2
        Buyer buyer_2 = new Buyer();
        buyer_2.setId(3);
        buyer_2.setFname("Bill");
        buyer_2.setLname("Gates");
        buyer_2.setUsername("bill.gates");
        buyer_2.setPassword("bg");
        BuyerList.add(buyer_2);
        
        return BuyerList;
    }
    
    public Buyer getBuyerById(int id){
        ArrayList<Buyer> buyerList = this.getBuyerList();
        for(Buyer buyer : buyerList){
            if(buyer.getId() == id){
                return buyer;
            }
        }
        return null;
    }
}
