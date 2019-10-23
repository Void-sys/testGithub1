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

    private String nim;
    private int indo;
    private int mtk;
    private int inggris;
    private int ipa;
    private int average;
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

    public int getIndo() {
        return indo;
    }

    public void setIndo(int indo) {
        this.indo = indo;
    }

    public int getMtk() {
        return mtk;
    }

    public void setMtk(int mtk) {
        this.mtk = mtk;
    }

    public int getInggris() {
        return inggris;
    }

    public void setInggris(int inggris) {
        this.inggris = inggris;
    }

    public int getIpa() {
        return ipa;
    }

    public void setIpa(int ipa) {
        this.ipa = ipa;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
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
    
    public ResultSet getGradeByNim_soc(String nim){
        try{
            String sql = "select tbl_student.nim as 'st_nim', tbl_student.name as 'st_name', tbl_student.class as 'st_class', tbl_grade_social.score_indo, tbl_grade_social.score_mtk, tbl_grade_social.score_inggris, tbl_grade_social.score_ips from tbl_student join tbl_grade_social on tbl_student.nim = tbl_grade_social.student_nim where nim=?";
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
    
    public boolean deleteGradeByNim_soc(String nim){
        boolean success = false;
        int op1 = 0, op2 = 0;
        try{
            String sql1 = "delete from tbl_grade_social where student_nim=?";
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
