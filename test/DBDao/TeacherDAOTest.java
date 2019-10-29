/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBDao;

import com.mysql.jdbc.Connection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import DBConn.koneksi;
import java.sql.SQLException;

/**
 *
 * @author nevwizurai
 */
public class TeacherDAOTest {
    
    Connection conn;
    
    public TeacherDAOTest() {
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
     * Test of setName method, of class TeacherDAO.
     */
    @Test
    public void testSetName() {
        System.out.println("> Running testSetName() method");
        String name = "";
        TeacherDAO instance = new TeacherDAO();
        instance.setName(name);
    }

    /**
     * Test of setClass_ method, of class TeacherDAO.
     */
    @Test
    public void testSetClass_() {
        System.out.println("> Running testSetClass() method");
        String class_ = "";
        TeacherDAO instance = new TeacherDAO();
        instance.setClass_(class_);
    }

    /**
     * Test of setUsername method, of class TeacherDAO.
     */
    @Test
    public void testSetUsername() {
        System.out.println("> Running testSetUsername() method");
        String username = "";
        TeacherDAO instance = new TeacherDAO();
        instance.setUsername(username);
    }

    /**
     * Test of setPassword method, of class TeacherDAO.
     */
    @Test
    public void testSetPassword() {
        System.out.println("> Running testSetPassword() method");
        String password = "";
        TeacherDAO instance = new TeacherDAO();
        instance.setPassword(password);
    }

    /**
     * Test of loginTeacher method, of class TeacherDAO.
     */
    @Test
    public void testLoginTeacher() {
        System.out.println("> Running testLoginTeacher() method");
        String username = "shycho";
        String password = "shycho";
        TeacherDAO instance = new TeacherDAO();
        boolean expResult = true;
        boolean result = instance.loginTeacher(username, password);
        System.out.println(">> Username : " + username);
        System.out.println(">> Password : " + password);
        assertEquals(expResult, result);
    }

    /**
     * Test of logoutTeacher method, of class TeacherDAO.
     */
    @Test
    public void testLogoutTeacher() {
        System.out.println("> Running testSetName() method");
        TeacherDAO instance = new TeacherDAO();
        instance.logoutTeacher();
    }
    
}
