 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinconsultationcenter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author Acer
 */
public class WestminsterSkinConsultationManager extends Doctor implements SkinConsultationManager{

    Scanner input = new Scanner(System.in);
     //Prints the choice selction
     public void print(){
        System.out.println("\t\t-----------------------------------");
        System.out.println("\t\t   Westminster Skin Consultation");
        System.out.println("\t\t-----------------------------------");
        System.out.println("\t[1] Add a new Doctor      [2] Delete a doctor");
        System.out.println("\t[3] Print Doctors list    [4] Save in a file");
        System.out.println("\t[5]Open GUI");    
    }
     
     //Add doctors to the array gain by main class and returns back to the main class
     public ArrayList<Doctor> addDoctor(ArrayList<Doctor> doctor){
         //If Doctor array size is equalls to ten inform the manager that this system can add only 10 doctors
         if(doctor.size()==10){
           System.out.println("You can add Maximum 10 Doctors!");
         
         }//If doctor array size not equal to 10 add doctors
         else{
            System.out.println("\nEnter Doctors medical Licence Number: ");
            String medNum = input.next();
            
            
           //If medilicense contains, check until user inputs another medilicence number  
            while(isEqual(doctor,medNum)){
               System.out.println("\nMedical Licence Number already exists!");
               System.out.println("Enter Doctors medical Licence Number: ");
               medNum = input.next();
            }
           
            System.out.println("Enter Doctors First name: ");
            String fname = input.next();
            
            System.out.println("Enter Doctors Last name: ");
            String Sname = input.next();
              
            System.out.println("Enter Doctors Specialisation: ");
            String specialisation = input.next();
            //add doctor details to doctor array
            doctor.add(new Doctor(fname,Sname,medNum,specialisation));
         }
            return doctor;
     };
     public ArrayList<Doctor> deleteDoctor(ArrayList<Doctor> doctor){
         
        //If no doctors in the system displays no doctors available 
        if(doctor.isEmpty()){
         System.out.println("None of the doctors available");
        }//Ask for medilicence number to delete the doctor from the list and displays the the no of doctors in the system
        else{
         System.out.println("Enter Medical Licence Number of the Doctor: ");
         String delDoc = input.next();
         
         for (int i = 0; i < doctor.size(); i++) {
             
             if(doctor.get(i).getMediLicenceNum().equals(delDoc)){
                 System.out.println("Medical Licence number: "+doctor.get(i).getMediLicenceNum());
                 System.out.println("First Name: "+doctor.get(i).getName());
                 System.out.println("Surname: "+doctor.get(i).getSurname());
                 System.out.println("Specialisation: "+doctor.get(i).getSpecialisation());
                 System.out.println("Total no of Doctors: "+(doctor.size()-1));
                 
                 doctor.remove(i);
                 System.out.println("Doctor has been removed successfully!");
                 break;
             }            
        } 
        
        //If there's no medical number informs "Invalid Licence Number"
        if(isEqual(doctor, delDoc)){
            System.out.println("Invalid Licence Number. Try Again!");
        }
        }
         return doctor;
     
     }
     public void printListDoctors(ArrayList<Doctor> doctor){
          
         //Sort the doctor list in array by getting there surnames
         doctor.sort((o1, o2)
                  -> o1.getSurname().compareTo(
                      o2.getSurname()));
         
         for (Doctor printlist : doctor) {
             System.out.println(printlist.toString());
         }
  
         
     }//Save the doctor array details in doctor.txt file
     public void saveFile(ArrayList<Doctor> doctor){
     
      try {
        FileWriter myWriter = new FileWriter("D:\\Doctor.txt");
        
        
        for (Doctor printlist : doctor) {
             myWriter.write(printlist.toString()+"\n");
             
         }
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
     }
     //Checks the medi licence exsists in user input
     public boolean isEqual(ArrayList<Doctor> doctor,String num){
         
          for (int i = 0; i < doctor.size(); i++) {
             
            if(doctor.get(i).getMediLicenceNum().equals(num)){
               return true;
            }    
          }
          return false;
     }          
        
}
