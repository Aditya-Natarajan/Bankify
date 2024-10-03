package brahminsangama.database;


import brahminsangama.App;
import brahminsangama.beans.Status;

import java.sql.Connection;
import java.sql.Statement;

public class DbInitTables {
    Connection con;
    String sql;
    Statement stmt;
    Status status;

    public DbInitTables(DbConn db){
        this.con = db.conn;
        status = new Status();
    }
    public Status createCustomerTable(){
        try{
            stmt = con.createStatement();
            sql = "" +
                    "CREATE TABLE IF NOT EXISTS CUSTOMERS("+
                    "customer_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "first_name VARCHAR(20) NOT NULL,"+
                    "last_name VARCHAR(20) NOT NULL,"+
                    "aadhar_number CHAR(12) UNIQUE NOT NULL," +
                    "phone_number CHAR(10) UNIQUE NOT NULL," +
                    "email VARCHAR(30) UNIQUE NOT NULL," +
                    "address_line1 VARCHAR(50) NOT NULL," +
                    "address_line2 VARCHAR(50) NOT NULL," +
                    "city VARCHAR(20) NOT NULL," +
                    "state VARCHAR(20) NOT NULL," +
                    "pincode VARCHAR(10) NOT NULL" +
                    ");";
            stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("CREATED CUSTOEMR TABLE");
        }
        catch(Exception e){
            status.setStatusCode(App.iStatusCode6);
            status.setStatusMessage(App.sStatusMsgCreateCstmrTblErr);
            System.out.println(e);
        }
        return status;
    }
    public Status createUserTable(){
        try{
            stmt = con.createStatement();
            sql = ""+
                    "CREATE TABLE IF NOT EXISTS USERS("+
                    "user_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "phone CHAR(10) NOT NULL UNIQUE,"+
                    "password CHAR(32) NOT NULL,"+
                    "access_level INTEGER NOT NULL" +
                    ");";
            stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("CREATED USER TABLE");
        }
        catch(Exception e){

            status.setStatusCode(App.iStatusCode7);
            status.setStatusMessage(App.sStatusMsgCreateUserTblErr);
            System.out.println(e);
        }
        return status;
    }

    public static void main(String[] args) {
        DbConn db = new DbConn();
        DbInitTables dbt = new DbInitTables(db);
        Status s = dbt.createCustomerTable();
        //Status s = dbt.createUserTable();
        if(s.getStatusCode() == 0){
            db.commit();
        }
        else{
            System.out.println(s.getStatusMessage());
            db.rollBack();
        }
    }

}
