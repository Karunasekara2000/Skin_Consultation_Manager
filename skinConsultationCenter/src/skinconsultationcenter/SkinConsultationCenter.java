/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinconsultationcenter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class SkinConsultationCenter {


    public static void main(String[] args)throws Exception {
        
        
        Scanner input = new Scanner(System.in);
        ArrayList<Doctor> doctor = new ArrayList<>(10);
        
        //Initialise doctor array by loading data from text file.
        if(doctor.isEmpty()){
        
          doctor=loaddata(doctor);
        }
       
        
        do{
            
        WestminsterSkinConsultationManager  manager = new WestminsterSkinConsultationManager();
        //Prints the choice box
        manager.print();
        
        //Asking to choose an option
        System.out.print("\nEnter an option to continue :");
        String option = input.next();
     
        switch(option){
            
            case "1":
                
                do{
                    //Adding doctors to the system
                    doctor =manager.addDoctor(doctor);
                    
                    System.out.print("Doctor has been added successfully! Do you want to add new Doctor?(y/n): ");
                    String selection = input.next().toLowerCase();
                
                if(!(selection.equals("y")||selection.equals("n"))){
                   System.out.println("Invalid Input!");
                   break;
                }    
                if(selection.equals("y")){
                   continue;
                }
                if(selection.equals("n")){
                   break;
                }
                
                    
                }while(true);
                 break;
                
            case "2":
                
                do{
                    //Deleting doctors from the system
                doctor = manager.deleteDoctor(doctor);  
                System.out.print("Do you want to delete a Doctor Again?(y/n): ");
                String selection = input.next().toLowerCase();
                
                if(!(selection.equals("y")||selection.equals("n"))){
                   System.out.println("Invalid Input!");
                   break;
                }    
                if(selection.equals("y")){
                   continue;
                }    
                if(selection.equals("n")){
                   break;
                }
                
                }while(true);
                break;
                        
                
            case "3":
                //Print doctors in the system 
                manager.printListDoctors(doctor);
                break;
            
            case "4":
                //Save doctors in the system into a text file 
                manager.saveFile(doctor);
                break;
                
            case "5":
                //Opens GUI of Skin Consultation Center
                Consultation c1 = new Consultation();
                //passing doctor array to 
                c1.docInfo(doctor);
                break;
            //Inform user if user hit a number not in range(1-5) to input correct number
            default:
                System.out.println("Invalid option,Please try Again!");
                break;
                
        }
        
        
        //Exit from the System    
        System.out.println("Do you want to Quit(y/n)? ");
        String selection = input.next().toLowerCase();
        
        //If user inputs another letter other than "y" or "n"
        if(!(selection.equals("y")||selection.equals("n"))){
            System.out.println("Invalid Input!");
            continue;
        } 
        //If user hit "n" again process repeat
        if(selection.equals("n")){
            continue;
        }
        //If user hit "y" again proces stops
        if(selection.equals("y")){
         break;
        } 
        
        }while(true);
        
        
 

    }
    //Loading Doctor details in text file into Doctor array
    public static ArrayList<Doctor> loaddata(ArrayList<Doctor> doctor) throws FileNotFoundException {
        
        File file = new File("D:\\Doctor.txt");
        Scanner readFile = new Scanner(file);
        
        StringTokenizer  token= null;
        
        
        String mediLicenceNum ="";
        String name ="";
        String surName ="";    
        String specialisation ="";
        
        
        while(readFile.hasNextLine()){
        token = new StringTokenizer(readFile.nextLine()," ");
        
        mediLicenceNum =token.nextToken();
        name =token.nextToken();
        surName =token.nextToken();    
        specialisation =token.nextToken();
        
        //Loads data to array object Doctor when starts again
        doctor.add(new Doctor(name,surName,mediLicenceNum,specialisation));
        
        }
       return doctor;
    }    
}