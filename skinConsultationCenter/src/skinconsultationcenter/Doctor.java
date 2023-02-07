/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinconsultationcenter;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class Doctor extends Person{
    
    private String mediLicenceNum;
    private String specialisation;
    private String dname;
    private String date;
 
    public Doctor() {
        
    }

    public Doctor(String dname, String date) {
        this.dname = dname;
        this.date = date;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
   

    public Doctor(String name,String surname, String mediLicenceNum, String specialisation) {
        
        super(name, surname);
        this.mediLicenceNum = mediLicenceNum;
        this.specialisation = specialisation;
    }

    
    
    
    @Override
    public String toString(){
       return  getMediLicenceNum()+" "+getName()+" "+getSurname()+" "+getSpecialisation();
         
    }

    public String getMediLicenceNum() {
        return mediLicenceNum;
    }
    public String getName() {
        return name;
    }

    public void setMediLicenceNum(String mediLicenceNum) {
        this.mediLicenceNum = mediLicenceNum;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
    
    
    
    
}
