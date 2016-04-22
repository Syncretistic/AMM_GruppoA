/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tgpplate file, choose Tools | Tgpplates
 * and open the tgpplate in the editor.
 */
package amm.tonino.classes;

import java.util.ArrayList;

/**
 *
 * @author Saverio
 */
public class VendorFactory {
    
    private static VendorFactory singleton;

    public static VendorFactory getInstance() {
        if (singleton == null) {
            singleton = new VendorFactory();
        }
        return singleton;
    }
    
    private VendorFactory() {

    }
    
    public ArrayList<Vendor> getVendorList(){
        
        ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
        
        // Vendor_1
        Vendor vendor_1 = new Vendor();
        vendor_1.setId(0);
        vendor_1.setFname("Gino");
        vendor_1.setLname("Paoli");
        vendor_1.setUsername("gino.paoli");
        vendor_1.setPassword("gp");
        vendorList.add(vendor_1);
        
        // Vendor_2
        Vendor vendor_2 = new Vendor();
        vendor_2.setId(1);
        vendor_2.setFname("Paolo");
        vendor_2.setLname("Brosio");
        vendor_2.setUsername("paolo.brosio");
        vendor_2.setPassword("pb");
        vendorList.add(vendor_2);
        
        return vendorList;
    }
    
    public Vendor getVendorById(int id){
        ArrayList<Vendor> vendorList = this.getVendorList();
        for(Vendor vendor : vendorList){
            if(vendor.getId() == id){
                return vendor;
            }
        }
        return null;
    }
    
}