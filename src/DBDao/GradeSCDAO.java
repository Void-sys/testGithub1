package DBDao;

//Import Libraries Here  *-*)b
import DBConn.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//@author nevwizurai
public class GradeSCDAO {
    private int id;
    private String nim;
    private float indo;
    private float mtk;
    private float inggris;
    private float ipa;
    private float average;
    private char grade;
    private String status;
    Connection conn;
    ResultSet res;
    PreparedStatement prep;

    public GradeSCDAO() {
        conn = new koneksi().setConnection();
    }
    
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public float getIndo() {
        return indo;
    }

    public void setIndo(float indo) {
        this.indo = indo;
    }

    public float getMtk() {
        return mtk;
    }

    public void setMtk(float mtk) {
        this.mtk = mtk;
    }

    public float getInggris() {
        return inggris;
    }

    public void setInggris(float inggris) {
        this.inggris = inggris;
    }

    public float getIpa() {
        return ipa;
    }

    public void setIpa(float ipa) {
        this.ipa = ipa;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
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
    
    
     public float avg(float indo, float inggris, float ipa, float mtk, float average){                        
        average = (indo+inggris+ipa+mtk)/4;        
        return average;
    }
    
    public char grds(float indo, float ing, float ipa, float mtk, float Average, char grade){
         average = (indo+inggris+ipa+mtk)/4;        
        if(average>=90){
            grade = 'A';
            
        }else if(average >=80){
            grade = 'B';
            
        }else if(average >=70){
            grade='C';
            
        }else if(average >=60){
            grade='D';
            
        }else if(average <60){
            grade='E';
            
        }      
        return grade;
    }
    
    public String stats(float indo, float inggris, float ipa, float mtk, float average, String status){
        average = (indo+inggris+ipa+mtk)/4;
        if(average >=90){
            status = "Pass";            
        }else if(average >=80){
            status = "Pass";            
        }else if(average >= 70){
            status = "Pass";           
        }else if(average >=60){
            status = "Fail";
        }else if(average <60){
            status = "Fail";            
        }      
        return status;
    }
    
    
    public int addGradesSoc(String nim, float indo, float mtk, float inggris, float ipa){
int inputted = 0;
int updatestats;
try{
    String sql = "insert into tbl_grade values (?,?,?,?,?,?,?,?,?)";
    prep = conn.prepareStatement(sql);
//    System.out.println(""+id);
//    System.out.println(""+nim);
//    System.out.println(""+Bindo);
//    System.out.println(""+mat);
//    System.out.println(""+Bing);
//    System.out.println(""+iprep);
//    System.out.println(""+avg(Bindo, Bing, iprep, mat, Average));
//    System.out.println(""+grds(Bindo, Bing, iprep, mat, Average, grade));
//    System.out.println(""+stats(Bindo, Bing, iprep, mat, Average, status));
    prep.setInt(1, id);
    prep.setString(2, nim);
    prep.setFloat(3, indo);
    prep.setFloat(4, mtk);
    prep.setFloat(5, inggris);
    prep.setFloat(6, ipa);
    prep.setFloat(7, avg(indo, inggris, ipa, mtk, average));
    prep.setString(8, grds(indo, inggris, ipa, mtk, average, grade)+"");
    prep.setString(9, stats(indo, inggris, ipa, mtk, average, status));
    inputted = prep.executeUpdate();
    updatestats = updateStudentAfterInsert(nim);
}catch(Exception e){
    System.out.println("Error : "+e.getMessage());
}
return inputted;
    }
    
     private int updateStudentAfterInsert(String nim) throws SQLException{
         String sql = "update tbl_student set grade_status=? where nim=?";
         prep = conn.prepareStatement(sql);
         prep.setString(1, "updated");
         prep.setString(2, nim);
         return prep.executeUpdate();
     }
    
    
    public ResultSet getGradeByNim(String nim){
        try{
            String sql = "select tbl_student.nim as 'st_nim', tbl_student.name as 'st_name', tbl_student.class as 'st_class', tbl_grade.score_indo, tbl_grade.score_mtk, tbl_grade.score_inggris, tbl_grade.score_ipa from tbl_student join tbl_grade on tbl_student.nim = tbl_grade.student_nim where nim=?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, nim);
            res = prep.executeQuery();
        }
        catch (SQLException ex) {
            Logger.getLogger(GradeSCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
          
    public boolean deleteGradeByNim(String nim){
        boolean success = false;
        int op1 = 0, op2 = 0;
        try{
            String sql1 = "delete from tbl_grade where student_nim=?";
            prep = conn.prepareStatement(sql1);
            prep.setString(1, nim);
            op1 = prep.executeUpdate();
            op2 = updateStudentAfterDelete(nim);
            if(op1 == 1 && op2 == 1) success = true;
        }
        catch (SQLException ex) {
            Logger.getLogger(GradeSCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }        
    
    private int updateStudentAfterDelete(String nim) throws SQLException{
        String sql = "update tbl_student set grade_status=? where nim=?";
        prep = conn.prepareStatement(sql);
        prep.setString(1, "deleted");
        prep.setString(2, nim);
        return prep.executeUpdate();
    }
}
