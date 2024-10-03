package brahminsangama.business_logic;


import brahminsangama.beans.Customer;
import brahminsangama.database.CustomerDB;
import brahminsangama.database.DbConn;

import java.sql.Connection;

public class CustomerBL {
    public void addCustomer(Customer customer){
        DbConn db = new DbConn();
        CustomerDB  cdb = new CustomerDB(db);


    }
    public void changeAddress(){
        String customerPhoneNumber;
        String address;
        String pincode;
        String city;
    }
}
