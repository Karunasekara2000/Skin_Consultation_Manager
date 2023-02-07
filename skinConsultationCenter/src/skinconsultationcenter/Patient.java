/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinconsultationcenter;

/**
 *
 * @author Acer
 */
public class Patient extends Person{
    
    private String patientID;

    
    private String dob;
    private String contactNum;
    private String cost;
    private String note;
    private String docChannel;
    private String date;
    
    
    
    
    public Patient(){}
    //patient Contructor use to create object oof array
    public Patient(String docChannel,String date,String name,String surname,String dob, String contactNum,String note,String cost) {
        super(name,surname);
        this.dob = dob;
        this.contactNum = contactNum;
        this.cost=cost;
        this.note=note;
        this.docChannel=docChannel;
        this.date=date;
    }

    
    public String toString(){
    
     return getDocChannel()+"||"+getDate()+"||"+getName()+"||"+getSurname()+"||"+getDob()+"||"+getContactNum()+"||"+getNote()+"||"+getCost();
    }
    
    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDocChannel() {
        return docChannel;
    }

    public void setDocChannel(String docChannel) {
        this.docChannel = docChannel;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
