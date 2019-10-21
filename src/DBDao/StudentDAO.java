package DBDao;

//Import Libraries Here  *-*)b

import DBConn.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


//@author nevwizurai
public class StudentDAO {

    private String nim;
    private String name;
    private String class_;
    private String status;
    Connection conn;
    PreparedStatement prep;
    ResultSet res;

    public StudentDAO() {
        conn = new koneksi().setConnection();
    }
    
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public ResultSet getbyNIM(String nim){
        try{
            String sql = "select * from tbl_student where nim=?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, nim);
            res = prep.executeQuery();
        }catch(Exception ex){
            System.out.println("Error : " + ex.getMessage());
        }
        return res;
    }
    
    public ResultSet getbyClass(String class_){
        try{
            String sql = "select * from tbl_student where class=?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, class_);
            res = prep.executeQuery();
        }catch(Exception ex){
            System.out.println("Error : " + ex.getMessage());
        }
        return res;
    }
    
    public int addStudent(String nim, String name, String class_, String status){
        int success = 0;
        try{
            String sql = "insert into tbl_student values(?,?,?,?)";
            prep = conn.prepareStatement(sql);
            prep.setString(1, nim);
            prep.setString(2, name);
            prep.setString(3, class_);
            prep.setString(4, status);
            success = prep.executeUpdate();
        }catch(Exception ex){
            System.out.println("Error : " + ex.getMessage());
        }
        return success;
    }
    
}
