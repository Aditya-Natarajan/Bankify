package bankify.database;

import bankify.App;
import bankify.beans.Customer;
import bankify.beans.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDB {
    private Connection conn;
    private String sql;
    private Status status;

    public CustomerDB(DbConn dbConn){
        this.conn = dbConn.conn;
        status = new Status();
    }

    public Status insertCustomer(Customer c1){
        try{
            sql = "INSERT INTO CUSTOMERS"+
                         "(first_name,last_name,aadhar_number,phone_number,email,"+
                         "address_line1,address_line2,city,state,pincode) VALUES(?,?,?,?,?,?,?,?,?,?); ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,c1.getFirstName());
            stmt.setString(2,c1.getLastName());
            stmt.setString(3,c1.getAadharNumber());
            stmt.setString(4,c1.getPhoneNumber());
            stmt.setString(5,c1.getEmail());
            stmt.setString(6,c1.getAddressLine1());
            stmt.setString(7,c1.getAddressLine2());
            stmt.setString(8,c1.getCity());
            stmt.setString(9,c1.getState());
            stmt.setString(10,c1.getPincode());
            stmt.executeUpdate();
            stmt.clearParameters();
            System.out.println("Added Customer");
        }
        catch(SQLException e){
            status.setStatusCode(App.iStatusCode1);
            status.setStatusMessage(App.sStatusMsgInsertError);
            System.out.println(e);
        }
        return status;
    }

    public Status updateAddress(String sPhone,String sAddress1,String sAddress2, String sCity,String sState,String sPincode){
        try{
            sql = "UPDATE CUSTOMERS SET address_line1 = (?), address_line2 = (?),"+
                         "city = (?), pincode = (?), state = (?)"+
                         "where phone_number = (?) ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,sAddress1);
            stmt.setString(2,sAddress2);
            stmt.setString(3,sCity);
            stmt.setString(4,sPincode);
            stmt.setString(5,sState);
            stmt.setString(6,sPhone);
            stmt.executeUpdate();
            stmt.clearParameters();
            System.out.println("Updated address");
        }
        catch(Exception e) {
            status.setStatusCode(App.iStatusCode2);
            status.setStatusMessage(App.sStatusMsgUpdateAddressError);
            System.out.println(e);
        }
        return status;
    }

    public Status updatePhoneNumber(String sOldPhone, String sNewPhone){
        try{
            String sql = "UPDATE CUSTOMERS SET phone_number = (?) where phone_number = (?) ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,sNewPhone);
            stmt.setString(2,sOldPhone);
            stmt.executeUpdate();
            stmt.clearParameters();
            System.out.println("Updated number");
        }
        catch(Exception e) {
            status.setStatusCode(App.iStatusCode3);
            status.setStatusMessage(App.sStatusMsgUpdatePhoneError);
            System.out.println(e);
        }
        return status;
    }

    public Status updateName(String sPhone,String sFirstName, String sLastNname){
        try{
            sql = "UPDATE CUSTOMERS SET first_name = (?),last_name = (?) where phone_number = (?) ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,sFirstName);
            stmt.setString(2,sLastNname);
            stmt.setString(3,sPhone);
            stmt.executeUpdate();
            stmt.clearParameters();
            System.out.println("Updated name");
        }
        catch(Exception e) {
            status.setStatusCode(App.iStatusCode4);
            status.setStatusMessage(App.sStatusMsgUpdateNameError);
            System.out.println(e);
        }
        return status;
    }

    public Status updateEmail(String sPhone, String sEmail){
        try{
            String sql = "UPDATE CUSTOMERS SET email = (?) where phone_number = (?) ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,sEmail);
            stmt.setString(2,sPhone);
            stmt.executeUpdate();
            stmt.clearParameters();
            System.out.println("Updated email");
        }
        catch(Exception e) {
            status.setStatusCode(App.iStatusCode5);
            status.setStatusMessage(App.sStatusMsgUpdateEmailError);
            System.out.println(e);
        }
        return status;
    }


    public static void main(String[] args) {
        Customer c1 = new Customer();
        DbConn db = new DbConn();
        c1.setFirstName("Aditya");
        c1.setLastName("Natarajan");
        c1.setAadharNumber("421025129535");
        c1.setPhoneNumber("8861343874");
        c1.setEmail("aditya.natarajan1@gmail.com");
        c1.setAddressLine1("2nd Main, ranganathpura");
        c1.setAddressLine2("kamakshipalya");
        c1.setCity("bangalore");
        c1.setState("karnataka");
        c1.setPincode("560079");
        CustomerDB cdb = new CustomerDB(db);
        Status s = cdb.insertCustomer(c1);
//        Status s = cdb.updateAddress("8861343874","2nd main","main road","thiruvananthapuram","kerala","560079");
//        Status s = cdb.updatePhoneNumber("8861343874","9443352565");
//        Status s = cdb.updatePhoneNumber("9443352565","8861343874");
//        Status s = cdb.updateName("8861343874","Aditya","Natarajan");
        if(s.getStatusCode() == 0){
            db.commit();
        }
        else{
            db.rollBack();
        }
    }

}
