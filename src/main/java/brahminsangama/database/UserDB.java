package brahminsangama.database;

import brahminsangama.App;
import brahminsangama.beans.Status;
import brahminsangama.beans.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {
    private Connection conn;
    private PreparedStatement stmt;
    private String sql;
    Status status;

    public UserDB(DbConn db){
        conn = db.conn;
        status = new Status();
    }

    public static String doHashing(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(password.getBytes());

            byte[] resultByteArray = messageDigest.digest();

            StringBuilder sb = new StringBuilder();

            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return null;
    }

    public Status insertUser(User u1){
        try{
            sql = "INSERT INTO USERS (password,phone,access_level) "+
                    "VALUES (?,?,?);";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,doHashing(u1.getPassword()));
            stmt.setString(2,u1.getPhoneNumber());
            stmt.setInt(3,u1.getAccessLevel());
            stmt.executeUpdate();
            stmt.clearParameters();

            System.out.println("user addded");
        }
        catch(Exception e){
            status.setStatusCode(App.iStatusCode10);
            status.setStatusMessage(App.sStatusMsgInsertUserErr);
            System.out.println(e);
        }
        return status;
    }
    public Status updatePassWord(String sPhoneNumber, String sNewPassWord){
        try{
            sql = "UPDATE USERS SET password = (?)" +
                         "WHERE phone = (?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,doHashing(sNewPassWord));
            stmt.setString(2,sPhoneNumber);
            stmt.executeUpdate();
            stmt.clearParameters();

            System.out.println("password updated");
        }
        catch(Exception e){
            status.setStatusCode(App.iStatusCode9);
            status.setStatusMessage(App.sStatusMsgUpdatePassWordErr);
            System.out.println(e);
        }
        return status;
    }
    public Status grantAccess(int iLevel,String sPhoneNumber){
        try{
            sql = "UPDATE USERS SET access_level = (?)" +
                         "WHERE phone = (?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,iLevel);
            stmt.setString(2,sPhoneNumber);
            stmt.executeUpdate();
            stmt.clearParameters();

            System.out.println("Access Level updated");
        }
        catch(Exception e){
            status.setStatusCode(App.iStatusCode8);
            status.setStatusMessage(App.sStatusMsgAccessGrantErr);
            System.out.println(e);
        }
        return status;
    }

    public boolean loginVerification(String sPhoneNumber,String sPassWord){
        try{
            sql = "SELECT * FROM USERS WHERE phone = (?) AND password = (?); ";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,sPhoneNumber);
            stmt.setString(2,doHashing(sPassWord));
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return false;
    }

    public static void main(String[] args) {
        DbConn db = new DbConn();
        UserDB udb = new UserDB(db);
        User u1 = new User("abcd1234",5,"8861343874");
        //Status s = udb.insertUser(u1);
        //Status s = udb.updatePassWord("8861343874","78q64n387w3d&^%%&B#&^hu8shad67^&");
        //Status s = udb.grantAccess(15,"8861343874");\
        boolean validity = udb.loginVerification("8861343874","78q64n387w3d&^%%&B#&^hu8shad67^&");
//        if(s.getStatusCode() == 0){
//            db.commit();
//        }
//        else{
//            db.rollBack();
//            System.out.println(s.getStatusMessage());
//        }
        System.out.println(validity);
    }

}
