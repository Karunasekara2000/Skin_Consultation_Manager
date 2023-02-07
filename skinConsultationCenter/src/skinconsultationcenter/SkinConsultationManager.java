/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinconsultationcenter;

import java.util.ArrayList;

/**
 *
 * @author Acer
 */
interface SkinConsultationManager{ 
     //Menu Print Method
     public void print();
     //Add doctor method
     public ArrayList<Doctor> addDoctor(ArrayList<Doctor> doctor);
     //Delete doctor method
     public ArrayList<Doctor> deleteDoctor(ArrayList<Doctor> doctor);
     //Print list Doctor Method
     public void printListDoctors(ArrayList<Doctor> doctor);
     //Save File method
     public void saveFile(ArrayList<Doctor> doctor);    
}
