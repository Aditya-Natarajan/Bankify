package bankify.database;

import bankify.App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {

    public Connection conn = null;

    public DbConn(){
        String URL = App.sDbPath;
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(URL);
            conn.setAutoCommit(false);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void commit(){
        try{
            if(conn !=null){
                conn.commit();
                conn.close();
            }
            System.out.println("Successfully commited and closed");
        }
        catch(SQLException e){

            System.out.println(e);
        }
    }
    public void rollBack(){
        try{
            if(conn !=null){
                conn.rollback();
                conn.close();
            }
            System.out.println("Rollback successful and connection closed");
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
}
