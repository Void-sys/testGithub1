/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBDao;

import com.mysql.jdbc.Connection;
import DBConn.koneksi;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
        conn = (Connection) new koneksi().setConnection();
    }
    
    @After
    public void tearDown() throws SQLException {
        conn.close();
    }

    
    @Test
    public void testLoginTeacher() {
        System.out.println("===== Login =====");
        String username = "shycho1";
        String password = "shycho";
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);
        TeacherDAO instance = new TeacherDAO();
        boolean expResult = false;
        System.out.println("Expected : " + expResult);
        boolean result = instance.loginTeacher(username, password);
        System.out.println("Actual   : " + result);
        assertEquals(expResult, result);
    }
    
}
