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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author J8138
 */
public class StudentDAOTest {
    
     Connection conn;
    
    public StudentDAOTest() {
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
     * Test of getbyNIM method, of class StudentDAO.
     */
    @Test
    public void testGetbyNIM() {
        System.out.println("--------------Testing GetByNIM--------------");        
        StudentDAO instance = new StudentDAO();
        String nim = instance.getNim();     
        assertNotNull(instance.getbyNIM(nim));        
        System.out.println("--------------------------------------------------------");
    }

    /**
     * Test of getbyClass method, of class StudentDAO.
     */
    @Test
    public void testGetbyClass() {
        System.out.println("--------------Testing GetByClass Method--------------");        
        StudentDAO instance = new StudentDAO();
        String class_ = instance.getClass_();        
        assertNotNull(instance.getbyClass(class_));
        System.out.println("--------------------------------------------------------");
       
    }

    /**
     * Test of addStudent method, of class StudentDAO.
     */
    @Test
    public void testAddStudent() {
        System.out.println("--------------Testing AddStudent Method--------------");
        StudentDAO student = new StudentDAO();
        String nim = "1820010004";
        student.addStudent(nim, "Rizqi Ardian", "3SO7", "not updated");        
        assertNotNull(student);        
        assertEquals(nim, nim);
        assertEquals("Rizqi Ardian", "Rizqi Ardian");
        assertEquals("3SO7", "3SO7");
        assertEquals("not updated", "not updated");
        System.out.println("--------------------------------------------------------");
    }
    
}
