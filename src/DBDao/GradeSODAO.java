/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBDao;

import DBConn.koneksi;
import graderecords.GradeRecordsGUI;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author J8138
 */
public class GradeSODAO {
    private int id;
    private String nim;
    private float mat;
    private float ips;
    private float Bindo;
    private float Bing;
    private float Average;
    private char grade;
    private String status;

    private PreparedStatement ps;
    private Connection conn;
    private ResultSet rs;
    
    public GradeSODAO() {
         conn = new koneksi().setConnection();
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public float getMat() {
        return mat;
    }

    public void setMat(float mat) {
        this.mat = mat;
    }

    public float getIps() {
        return ips;
    }

    public void setIps(float ips) {
        this.ips = ips;
    }

    public float getBindo() {
        return Bindo;
    }

    public void setBindo(float Bindo) {
        this.Bindo = Bindo;
    }

    public float getBing() {
        return Bing;
    }

    public void setBing(float Bing) {
        this.Bing = Bing;
    }

    public float getAverage() {
        return Average;
    }

    public void setAverage(float Average) {
        this.Average = Average;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public float avg(float Bindo, float Bing, float ips, float mat, float Average){                        
        Average = (Bindo+Bing+ips+mat)/4;        
        return Average;
    }
    
    public char grds(float Bindo, float Bing, float ips, float mat, float Average, char grade){
         Average = (Bindo+Bing+ips+mat)/4;        
        if(Average>=90){
            grade = 'A';
            
        }else if(Average >=80){
            grade = 'B';
            
        }else if(Average >=70){
            grade='C';
            
        }else if(Average >=60){
            grade='D';
            
        }else if(Average <60){
            grade='E';
            
        }      
        return grade;
    }
    
    public String stats(float Bindo, float Bing, float ips, float mat, float Average, String status){
        Average = (Bindo+Bing+ips+mat)/4;
        if(Average >=90){
            status = "Pass";            
        }else if(Average >=80){
            status = "Pass";            
        }else if(Average >= 70){
            status = "Pass";           
        }else if(Average >=60){
            status = "Fail";
        }else if(Average <60){
            status = "Fail";            
        }      
        return status;
    }
    
    
    public int addGradesSoc(String nim, float Bindo, float mat, float Bing, float ips){
int inputted = 0;
int updatestats;
try{
    String sql = "insert into tbl_grade_social values (?,?,?,?,?,?,?,?,?)";
    ps = conn.prepareStatement(sql);
//    System.out.println(""+id);
//    System.out.println(""+nim);
//    System.out.println(""+Bindo);
//    System.out.println(""+mat);
//    System.out.println(""+Bing);
//    System.out.println(""+ips);
//    System.out.println(""+avg(Bindo, Bing, ips, mat, Average));
//    System.out.println(""+grds(Bindo, Bing, ips, mat, Average, grade));
//    System.out.println(""+stats(Bindo, Bing, ips, mat, Average, status));
    ps.setInt(1, id);
    ps.setString(2, nim);
    ps.setFloat(3, Bindo);
    ps.setFloat(4, mat);
    ps.setFloat(5, Bing);
    ps.setFloat(6, ips);
    ps.setFloat(7, avg(Bindo, Bing, ips, mat, Average));
    ps.setString(8, grds(Bindo, Bing, ips, mat, Average, grade)+"");
    ps.setString(9, stats(Bindo, Bing, ips, mat, Average, status));
    inputted = ps.executeUpdate();
    updatestats = updateStudentAfterInsert(nim);
}catch(Exception e){
    System.out.println("Error : "+e.getMessage());
}
return inputted;
    }
    
      public ResultSet getGradeByNim_soc(String nim){
        try{
            String sql = "select tbl_student.nim as 'st_nim', tbl_student.name as 'st_name', tbl_student.class as 'st_class', tbl_grade_social.score_indo, tbl_grade_social.score_mtk, tbl_grade_social.score_inggris, tbl_grade_social.score_ips from tbl_student join tbl_grade_social on tbl_student.nim = tbl_grade_social.student_nim where nim=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nim);
            rs = ps.executeQuery();
        }
        catch (SQLException ex) {
            Logger.getLogger(GradeSODAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
     public boolean deleteGradeByNim_soc(String nim){
        boolean success = false;
        int op1 = 0, op2 = 0;
        try{
            String sql1 = "delete from tbl_grade_social where student_nim=?";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, nim);
            op1 = ps.executeUpdate();
            op2 = updateStudentAfterDelete(nim);
            if(op1 == 1 && op2 == 1) success = true;
        }
        catch (SQLException ex) {
            Logger.getLogger(GradeSODAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
     
     private int updateStudentAfterDelete(String nim) throws SQLException{
        String sql = "update tbl_student set grade_status=? where nim=?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, "deleted");
        ps.setString(2, nim);
        return ps.executeUpdate();
    }
     
     private int updateStudentAfterInsert(String nim) throws SQLException{
         String sql = "update tbl_student set grade_status=? where nim=?";
         ps = conn.prepareStatement(sql);
         ps.setString(1, "updated");
         ps.setString(2, nim);
         return ps.executeUpdate();
     }
    
}
