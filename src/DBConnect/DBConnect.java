package DBConnect;

//Import Libraries Here  *-*)b
import graderecords.GradeRecordsGUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


//@author nevwizurai
public class DBConnect {
    private static Connection conn=null;
    
    public static Connection doConnect(){
        try{
             final String database = "graderecord";
        final String username = "root";
        final String password = "";
        final String url      = "jdbc:mysql://localhost:3306/"+ database;
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        conn = (Connection) DriverManager.getConnection(url, username, password);
       
        }catch(SQLException se){
            Logger.getLogger(GradeRecordsGUI.class.getName()).log(Level.SEVERE, null, se);
        }
        return conn;
    }
}
