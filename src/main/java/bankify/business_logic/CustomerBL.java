package bankify.business_logic;


import bankify.beans.Customer;
import bankify.database.CustomerDB;
import bankify.database.DbConn;

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
