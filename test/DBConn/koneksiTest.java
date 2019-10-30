/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConn;

import java.sql.Connection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nevwizurai
 */
public class koneksiTest {
    
    public koneksiTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setConnection method, of class koneksi.
     */
    @Test
    public void testSetConnection() {
        System.out.println("setConnection");
        koneksi instance = new koneksi();
        Connection expResult = null;
        Connection result = instance.setConnection();
        assertEquals(expResult, result);
    }
    
    @Test(expected = Exception.class)
    public void testSetException(){
        System.out.println("Bruh");
    }
    
}
