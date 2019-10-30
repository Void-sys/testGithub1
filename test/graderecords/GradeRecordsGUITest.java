/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graderecords;

import DBDao.TeacherDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nevwizurai
 */
public class GradeRecordsGUITest {
    
    GradeRecordsGUI grad;
    TeacherDAO teach = new TeacherDAO();
    String username = "shycho", password = "shycho";
    
    public GradeRecordsGUITest() {
        
    }
    
    @Before
    public void setUp() {
        grad = new GradeRecordsGUI();
    }
    
    @After
    public void tearDown() {
        
    }
    
    @Test
    public void testInitialize(){
        grad = new GradeRecordsGUI();
    }
    
    @Test
    public void tloginButtonNotEmpty(){
        grad.txtName.setText("shycho");
        grad.txtPass.setText("shycho");
        grad.loginButton.doClick();
        teach.loginTeacher(username, password);
    }
    @Test
    public void tloginButtonEmpty(){
        grad.txtName.setText("");
        grad.txtPass.setText("");
        grad.loginButton.doClick();
        teach.loginTeacher("", "");
    }
    @Test
    public void tloginButtonEmptyUser(){
        grad.txtName.setText("");
        grad.txtPass.setText("shycho");
        grad.loginButton.doClick();
        teach.loginTeacher("", password);
    }
    @Test
    public void tloginButtonEmptyPass(){
        grad.txtName.setText("shycho");
        grad.txtPass.setText("");
        grad.loginButton.doClick();
        teach.loginTeacher(username, "");
    }

    
}
