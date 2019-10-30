/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBDao;

import DBConn.koneksi;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author nevwizurai
 */
public class GradeSCDAOTest {
    
    Connection conn;
    
    public GradeSCDAOTest() {
    }
    
    @Before
    public void setUp() {
        System.out.println("-------------------");
        System.out.println("> Running setUp() method");
        conn = (Connection) new koneksi().setConnection();
    }
    
    @After
    public void tearDown() throws SQLException {
        System.out.println("> Running tearDown() method");
        conn.close();
        System.out.println("-------------------");
    }

    /**
     * Test of setNim method, of class GradeSCDAO.
     */
    @Test
    public void testSetNim() {
        System.out.println("> Running testSetNim() method");
        String nim = "";
        GradeSCDAO instance = new GradeSCDAO();
        instance.setNim(nim);
    }

    /**
     * Test of setIndo method, of class GradeSCDAO.
     */
    @Test
    public void testSetIndo() {
        System.out.println("> Running testSetIndo() method");
        float indo = 0.0F;
        GradeSCDAO instance = new GradeSCDAO();
        instance.setIndo(indo);
    }

    /**
     * Test of setMtk method, of class GradeSCDAO.
     */
    @Test
    public void testSetMtk() {
        System.out.println("> Running testSetMtk() method");
        float mtk = 0.0F;
        GradeSCDAO instance = new GradeSCDAO();
        instance.setMtk(mtk);
    }

    /**
     * Test of setInggris method, of class GradeSCDAO.
     */
    @Test
    public void testSetInggris() {
        System.out.println("> Running testSetInggris() method");
        float inggris = 0.0F;
        GradeSCDAO instance = new GradeSCDAO();
        instance.setInggris(inggris);
    }

    /**
     * Test of setIpa method, of class GradeSCDAO.
     */
    @Test
    public void testSetIpa() {
        System.out.println("> Running testSetIpa() method");
        float ipa = 0.0F;
        GradeSCDAO instance = new GradeSCDAO();
        instance.setIpa(ipa);
    }

    /**
     * Test of setAverage method, of class GradeSCDAO.
     */
    @Test
    public void testSetAverage() {
        System.out.println("> Running testSetAverage() method");
        float average = 0.0F;
        GradeSCDAO instance = new GradeSCDAO();
        instance.setAverage(average);
    }

    /**
     * Test of setGrade method, of class GradeSCDAO.
     */
    @Test
    public void testSetGrade() {
        System.out.println("> Running testSetGrade() method");
        char grade = ' ';
        GradeSCDAO instance = new GradeSCDAO();
        instance.setGrade(grade);
    }

    /**
     * Test of setStatus method, of class GradeSCDAO.
     */
    @Test
    public void testSetStatus() {
        System.out.println("> Running testSetStatus() method");
        String status = "";
        GradeSCDAO instance = new GradeSCDAO();
        instance.setStatus(status);
    }

    /**
     * Test of avg method, of class GradeSCDAO.
     */
    @Test
    public void testAvg() {
        System.out.println("> Running testAvg() method");
        float indo = 80.0F;
        float inggris = 80.0F;
        float ipa = 80.0F;
        float mtk = 80.0F;
        GradeSCDAO instance = new GradeSCDAO();
        float expResult = 80.0F;
        float result = instance.avg(indo, inggris, ipa, mtk);
        assertEquals(expResult, result, 0.0);
        System.out.println(">> Indo : " + indo);
        System.out.println(">> Inggris : " + inggris);
        System.out.println(">> Ipa : " + ipa);
        System.out.println(">> Mtk : " + mtk);
        System.out.println(">> Expected Average : " + expResult);
        System.out.println(">> Actual Average : " + result);
    }

    /**
     * Test of grds method, of class GradeSCDAO.
     */
    @Test
    public void testGrds() {
        System.out.println("> Running testGrds() method");
        float indo = 80.0F;
        float inggris = 80.0F;
        float ipa = 80.0F;
        float mtk = 80.0F;
        GradeSCDAO instance = new GradeSCDAO();
        char expResult = 'B';
        char result = instance.grds(indo, inggris, ipa, mtk);
        Assert.assertEquals(expResult, result);
        System.out.println(">> Indo : " + indo);
        System.out.println(">> Inggris : " + inggris);
        System.out.println(">> Ipa : " + ipa);
        System.out.println(">> Mtk : " + mtk);
        System.out.println(">> Expected Grade : " + expResult);
        System.out.println(">> Actual Grade : " + result);
    }

    /**
     * Test of stats method, of class GradeSCDAO.
     */
    @Test
    public void testStats() {
        System.out.println("> Running testStats() method");
        float indo = 80.0F;
        float inggris = 80.0F;
        float ipa = 80.0F;
        float mtk = 80.0F;
        GradeSCDAO instance = new GradeSCDAO();
        String expResult = "Pass";
        String result = instance.stats(indo, inggris, ipa, mtk);
        assertEquals(expResult, result);
        System.out.println(">> Indo : " + indo);
        System.out.println(">> Inggris : " + inggris);
        System.out.println(">> Ipa : " + ipa);
        System.out.println(">> Mtk : " + mtk);
        System.out.println(">> Expected Status : " + expResult);
        System.out.println(">> Actual Status : " + result);
    }

    /**
     * Test of UpdateStudentScores method, of class GradeSCDAO.
     * @throws java.sql.SQLException
     */
    @Ignore
    @Test
    public void testUpdateStudentScores() throws SQLException{
        System.out.println("> Running testUpdateStudentScores() method");
        String nim = "";
        float indo = 0.0F;
        float mtk = 0.0F;
        float inggris = 0.0F;
        float ipa = 0.0F;
        GradeSCDAO instance = new GradeSCDAO();
        int expResult = 0;
        int result = instance.UpdateStudentScores(nim, indo, mtk, inggris, ipa);
        assertEquals(expResult, result);
    }

    /**
     * Test of getGradeByNim method, of class GradeSCDAO.
     */
    @Ignore
    @Test
    public void testGetGradeByNim() {
        System.out.println("> Running testGetGradeByNim() method");
        String nim = "";
        GradeSCDAO instance = new GradeSCDAO();
        ResultSet expResult = null;
        ResultSet result = instance.getGradeByNim(nim);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDatabyNIM method, of class GradeSCDAO.
     */
    @Ignore
    @Test
    public void testGetDatabyNIM() {
        System.out.println("> Running testGetDatabyNim() method");
        String nim = "";
        GradeSCDAO instance = new GradeSCDAO();
        ResultSet expResult = null;
        ResultSet result = instance.getDatabyNIM(nim);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteGradeByNim method, of class GradeSCDAO.
     */
    @Ignore
    @Test
    public void testDeleteGradeByNim() {
        System.out.println("> Running testDeleteGradeByNim() method");
        String nim = "";
        GradeSCDAO instance = new GradeSCDAO();
        boolean expResult = false;
        boolean result = instance.deleteGradeByNim(nim);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddGradeSC(){
        System.out.println("> Running testAddGradeSC() method");
         GradeSCDAO science = new GradeSCDAO();
       String nim = "1212212";
       science.addGradesSc(nim, 100, 90, 80, 80);
        assertNotNull(science);
        assertEquals(100, 100, science.getIndo());                
        assertEquals(90, 90 , science.getInggris());
        assertEquals(80, 80 , science.getIpa());
        assertEquals(80, 80 , science.getMtk());
    }
    
    //Test Grds Possibilities
    @Test
    public void grds90(){
        char expResult = 'A';
        GradeSCDAO bruh = new GradeSCDAO();
        char actual = bruh.grds(90, 90, 90, 90);
        assertEquals(expResult,actual);
    }
    @Test
    public void grds80(){
        char expResult = 'B';
        GradeSCDAO bruh = new GradeSCDAO();
        char actual = bruh.grds(80, 80, 80, 80);
        assertEquals(expResult,actual);
    }
    @Test
    public void grds70(){
        char expResult = 'C';
        GradeSCDAO bruh = new GradeSCDAO();
        char actual = bruh.grds(70, 70, 70, 70);
        assertEquals(expResult,actual);
    }
    @Test
    public void grds60(){
        char expResult = 'D';
        GradeSCDAO bruh = new GradeSCDAO();
        char actual = bruh.grds(60, 60, 60, 60);
        assertEquals(expResult,actual);
    }
    @Test
    public void grds50(){
        char expResult = 'E';
        GradeSCDAO bruh = new GradeSCDAO();
        char actual = bruh.grds(50, 50, 50, 50);
        assertEquals(expResult,actual);
    }
    
    @Test
    public void stats90(){
        String expResult = "Pass";
        GradeSCDAO bruh = new GradeSCDAO();
        String actual = bruh.stats(90, 90, 90, 90);
        assertEquals(expResult,actual);
    }
    @Test
    public void stats80(){
        String expResult = "Pass";
        GradeSCDAO bruh = new GradeSCDAO();
        String actual = bruh.stats(80, 80, 80, 80);
        assertEquals(expResult,actual);
    }
    @Test
    public void stats70(){
        String expResult = "Pass";
        GradeSCDAO bruh = new GradeSCDAO();
        String actual = bruh.stats(70, 70, 70, 70);
        assertEquals(expResult,actual);
    }
    @Test
    public void stats60(){
        String expResult = "Fail";
        GradeSCDAO bruh = new GradeSCDAO();
        String actual = bruh.stats(60, 60, 60, 60);
        assertEquals(expResult,actual);
    }
    @Test
    public void stats50(){
        String expResult = "Fail";
        GradeSCDAO bruh = new GradeSCDAO();
        String actual = bruh.stats(50, 50, 50, 50);
        assertEquals(expResult,actual);
    }
    
}
