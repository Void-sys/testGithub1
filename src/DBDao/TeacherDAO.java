package DBDao;

//Import Libraries Here  *-*)b

import DBConn.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


//@author nevwizurai
public class TeacherDAO {

    private String name;
    private String class_;
    private String username;
    private String password;
    Connection conn;
    ResultSet res;
    PreparedStatement prep;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_() {
        return class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean loginTeacher(String username, String password){
        boolean success = false;
        try{
            conn = new koneksi().setConnection();
            String sql = "select * from tbl_teacher where username=? and password=?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, username);
            prep.setString(2, password);
            res = prep.executeQuery();
            if(res.next()){
                this.name = res.getString("name");
                this.class_ = res.getString("class");
                this.username = res.getString("username");
                success = true;
            }
        }catch(Exception ex){
            System.out.println("Error : " + ex.getMessage());
        }
        return success;
    }
    
    public void logoutTeacher(){
        this.name = null;
        this.class_ = null;
        this.username = null;
        this.password = null;
    }
}
