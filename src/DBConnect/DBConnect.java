package DBConnect;

//Import Libraries Here  *-*)b
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//@author nevwizurai
public class DBConnect {
    static Connection conn;
    
    public static Connection doConnect() throws SQLException{
        final String database = "graderecord";
        final String username = "root";
        final String password = "";
        final String url      = "jdbc:mysql://localhost:3306/"+ database;
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        conn = (Connection) DriverManager.getConnection(url, username, password);
        return conn;
    }
}
