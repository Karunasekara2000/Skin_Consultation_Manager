/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinconsultationcenter;

import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author Acer
 */
public class SkinConsultationCenterNGTest {
    
    public SkinConsultationCenterNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void testMain() throws Exception {
        
        ArrayList<Doctor> doctor = new ArrayList<>(10);
        WestminsterSkinConsultationManager  manager = new WestminsterSkinConsultationManager();
       
        doctor =manager.addDoctor(doctor);
        assertEquals(doctor, doctor);
        manager.printListDoctors(doctor);
        manager.saveFile(doctor);
        doctor = manager.deleteDoctor(doctor);
        assertEquals(doctor, doctor);
    }
    
}
