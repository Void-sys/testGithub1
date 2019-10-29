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
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author J8138
 */
public class GradeSODAOTest {
    
    Connection conn;
    
    public GradeSODAOTest() {        
    }
    
    @Before
    public void setUp() {
        System.out.println("Setting Connection to Database");
        conn = (Connection) new koneksi().setConnection();
        System.out.println("------------------------------");
    }
    
    @After
    public void tearDown() throws SQLException {
        System.out.println("Closing Connection to Database");
        conn.close();
        System.out.println("------------------------------");
    }

    /**
     * Test of getNim method, of class GradeSODAO.
     */
   

    /**
     * Test of avg method, of class GradeSODAO.
     */
    @Test
    public void testAvg() {
        System.out.println("----------Testing The Average Method----------");
        float Bindo = 80;
        float Bing = 80;
        float ips = 80;
        float mat = 80;        
        GradeSODAO instance = new GradeSODAO();
        float expResult = 80;
        float result = instance.avg(Bindo, Bing, ips, mat);
        assertEquals(expResult, result, 80);
        System.out.println("------------------------------");
    }

    /**
     * Test of grds method, of class GradeSODAO.
     */
    @Test
    public void testGrds() {
        System.out.println("----------Testing The Grades Method----------");
        float Bindo = 80;
        float Bing = 80;
        float ips = 80;
        float mat = 80;        
        char grade = 'B';
        GradeSODAO instance = new GradeSODAO();
        char expResult = 'B';
        char result = instance.grds(Bindo, Bing, ips, mat, grade);
        assertEquals(expResult, result);
        System.out.println("------------------------------");
    }

    /**
     * Test of stats method, of class GradeSODAO.
     */
    @Test
    public void testStats() {
        System.out.println("----------Testing The Status Method----------");
        float Bindo = 80;
        float Bing = 80;
        float ips = 80;
        float mat = 80;        
        String status = "Pass";
        GradeSODAO instance = new GradeSODAO();
        String expResult = "Pass";
        String result = instance.stats(Bindo, Bing, ips, mat, status);
        assertEquals(expResult, result);
        System.out.println("----------------------------------------");
    }

    /**
     * Test of addGradesSoc method, of class GradeSODAO.
     */
    @Test
    public void testAddGradesSoc() {  
        System.out.println("----------Testing AddGradesSoc Method----------");
       GradeSODAO social = new GradeSODAO();
       String nim = "1820010002";
       social.addGradesSoc(nim, 90, 90, 90, 90);
        assertNotNull(social);
        assertEquals(90, 90, social.getBindo());        
        assertEquals(90, 90, social.getBindo());        
        assertEquals(90, 90 , social.getBing());
        assertEquals(90, 90 , social.getIps());
        assertEquals(90, 90 , social.getMat());
        System.out.println("----------------------------------------");              
    }

    /**
     * Test of getGradeByNim_soc method, of class GradeSODAO.
     */
    @Test
    public void testGetGradeByNim_soc() {        
        System.out.println("----------Testing the GetGradeByNim_Soc Method----------");        
        GradeSODAO instance = new GradeSODAO();
        String nim = instance.getNim();        
        assertNotNull(instance.getGradeByNim_soc(nim));
        System.out.println("----------------------------------------");
    }

    /**
     * Test of getDatabyNim_soc method, of class GradeSODAO.
     */
    @Test
    public void testGetDatabyNim_soc() {
        System.out.println("----------Testing the GetDatabyNim_soc Method----------");        
        GradeSODAO instance = new GradeSODAO();       
        String nim = instance.getNim();
        assertNotNull(instance.getDatabyNim_soc(nim));
        
    }

    /**
     * Test of deleteGradeByNim_soc method, of class GradeSODAO.
     */
    @Test
    public void testDeleteGradeByNim_soc() {
        System.out.println("----------Testing The DeleteGradesByNim_soc Method----------");        
        GradeSODAO instance = new GradeSODAO();        
        String nim = instance.getNim();
        instance.deleteGradeByNim_soc(nim);
        assertNull(instance.getNim());
      
    }

    /**
     * Test of updateStudentScoresSoc method, of class GradeSODAO.
     */
    @Test
    public void testUpdateStudentScoresSoc() throws Exception {
        System.out.println("----------Testing The UpdateStudentScoreSoc Method----------");
        GradeSODAO social = new GradeSODAO();
       String nim = "1820010002";
       social.updateStudentScoresSoc(nim, 80, 80, 80, 80);
        assertNotNull(social);
        assertEquals(80, 80, social.getBindo());        
        assertEquals(80, 80, social.getBindo());        
        assertEquals(80, 80 , social.getBing());
        assertEquals(80, 80 , social.getIps());
        assertEquals(80, 80 , social.getMat());
       
    }
    
}
