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
public class Person {
    
    public String name;
    public String surname;
    private int dateOfBirth;
    private int contactNumber;

    public Person() {
    }

    public Person(String name, String surname, int dateOfBirth, int contactNumber) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    
    
    
}
